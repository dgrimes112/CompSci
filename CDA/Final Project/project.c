#include "spimcore.h"


unsigned add(unsigned a, unsigned b)
{
    return a + b;
}

unsigned subtract(unsigned a, unsigned b)
{
    return a - b;
}

unsigned slts(unsigned a, unsigned b)
{
    return (int)a < (int)b;
}

unsigned sltu(unsigned a, unsigned b)
{
    return a < b;
}

unsigned and (unsigned a, unsigned b)
{
    return a & b;
}

unsigned or (unsigned a, unsigned b)
{
    return a | b;
}

unsigned shift(unsigned a, unsigned b)
{
    return b << 16;
}

unsigned not(unsigned a, unsigned b)
{
    return ~a;
}

/* ALU */
/* 10 Points */
void ALU(unsigned A, unsigned B, char ALUControl, unsigned *ALUresult, char *Zero)
{
    unsigned (*aluOps[])(unsigned, unsigned) = {add, subtract, slts, sltu, and, or, shift, not};
    *ALUresult = aluOps[ALUControl](A, B);
    *Zero = (*ALUresult == 0);
}

/* instruction fetch */
/* 10 Points */
int instruction_fetch(unsigned PC, unsigned *Mem, unsigned *instruction)
{
    if (PC & 3) { // Check if pc is word aligned or outside of mem bounds
        return 1; 
    }
    if (PC >> 2 < 0) {
        return 1;
    }
    *instruction = Mem[PC >> 2];
    return 0;
}

/* instruction partition */
/* 10 Points */
void instruction_partition(unsigned instruction, unsigned *op, unsigned *r1, unsigned *r2, unsigned *r3, unsigned *funct, unsigned *offset, unsigned *jsec)
{
    *op = (instruction & 0xFC000000) >> 26; 
    *r1 = (instruction & 0x03E00000) >> 21;
    *r2 = (instruction & 0x001F0000) >> 16;
    *r3 = (instruction & 0x0000F800) >> 11;
    *funct = (instruction & 0x0000003F);
    *offset = (instruction & 0x0000FFFF);
    *jsec = (instruction & 0x03FFFFFF);
}

int decodeR(unsigned op, struct_controls *controls) 
{
    controls->RegDst = 1;
    controls->Jump = 0;
    controls->Branch = 0;
    controls->MemRead = 0;
    controls->MemtoReg = 0;
    controls->ALUOp = 7;
    controls->MemWrite = 0;
    controls->ALUSrc = 0;
    controls->RegWrite = 1;
    return 0;
}

int decodeJ(unsigned op, struct_controls *controls)
{
    controls->RegDst = 2;
    controls->Jump = 1;
    controls->Branch = 0;
    controls->MemRead = 0;
    controls->MemtoReg = 0;
    controls->ALUOp = 2;
    controls->MemWrite = 0;
    controls->ALUSrc = 0;
    controls->RegWrite = 0;
    return 0;
}

int decodeI(unsigned op, struct_controls *controls)
{
    switch (op)
    {
    case (4): // beq
        controls->RegDst = 2;
        controls->Jump = 0;
        controls->Branch = 1;
        controls->MemRead = 0;
        controls->MemtoReg = 2;
        controls->ALUOp = 1;
        controls->MemWrite = 0;
        controls->ALUSrc = 0;
        controls->RegWrite = 0;
        break;
    case (8): // addi
        controls->RegDst = 0;
        controls->Jump = 0;
        controls->Branch = 0;
        controls->MemRead = 0;
        controls->MemtoReg = 0;
        controls->ALUOp = 0;
        controls->MemWrite = 0;
        controls->ALUSrc = 1;
        controls->RegWrite = 1;
        break;
    case (10): // slti
        controls->RegDst = 0;
        controls->Jump = 0;
        controls->Branch = 0;
        controls->MemRead = 0;
        controls->MemtoReg = 0;
        controls->ALUOp = 2;
        controls->MemWrite = 0;
        controls->ALUSrc = 1;
        controls->RegWrite = 1;
        break;
    case (11): // sltiu
        controls->RegDst = 0;
        controls->Jump = 0;
        controls->Branch = 0;
        controls->MemRead = 0;
        controls->MemtoReg = 0;
        controls->ALUOp = 3;
        controls->MemWrite = 0;
        controls->ALUSrc = 1;
        controls->RegWrite = 1;
        break;
    case (15): // lui
        controls->RegDst = 0;
        controls->Jump = 0;
        controls->Branch = 0;
        controls->MemRead = 0;
        controls->ALUOp = 6;
        controls->MemWrite = 0;
        controls->ALUSrc = 1;
        controls->RegWrite = 1;
        break;
    case (35): // lw
        controls->RegDst = 0;
        controls->Jump = 0;
        controls->Branch = 0;
        controls->MemRead = 1;
        controls->MemtoReg = 1;
        controls->ALUOp = 0;
        controls->MemWrite = 0;
        controls->ALUSrc = 1;
        controls->RegWrite = 1;
        break;
    case (43): // sw
        controls->RegDst = 2;
        controls->Jump = 0;
        controls->Branch = 0;
        controls->MemRead = 0;
        controls->MemtoReg = 2;
        controls->ALUOp = 0;
        controls->MemWrite = 1;
        controls->ALUSrc = 1;
        controls->RegWrite = 0;
        break;
    default:
        return 1; // bad op code
    }
    return 0;
}

/* instruction decode */
/* 15 Points */
int instruction_decode(unsigned op, struct_controls *controls)
{
    switch (op)
    {
    case (0):
        return decodeR(op, controls);
    case (2):
        return decodeJ(op, controls);
    default:
        return decodeI(op, controls);
    }
}

/* Read Register */
/* 5 Points */
void read_register(unsigned r1, unsigned r2, unsigned *Reg, unsigned *data1, unsigned *data2)
{
    *data1 = Reg[r1];
    *data2 = Reg[r2];
}

/* Sign Extend */
/* 10 Points */
void sign_extend(unsigned offset, unsigned *extended_value)
{
    if (offset & 0x8000) //if negative sign extend
    {
        *extended_value = offset + 0xFFFF0000;
    }
    else
    {
        *extended_value = offset;
    }
}

/* ALU operations */
/* 10 Points */
int ALU_operations(unsigned data1, unsigned data2, unsigned extended_value, unsigned funct, char ALUOp, char ALUSrc, unsigned *ALUresult, char *Zero)
{
    unsigned temp;

    if (ALUSrc)  //if ALUSrc is 1 use extended_value else use data2
    {
        temp = extended_value;
    }
    else
    {
        temp = data2;
    }

    if (ALUOp == 7) // R type instructions 
    {
        switch (funct)
        {
        case 32:
            ALU(data1, temp, 0, ALUresult, Zero); // add
            break;
        case 34:
            ALU(data1, temp, 1, ALUresult, Zero); // sub
            break;
        case 36:
            ALU(data1, temp, 4, ALUresult, Zero); // and
            break;
        case 37:
            ALU(data1, temp, 5, ALUresult, Zero); // or
            break;
        case 42:
            ALU(data1, temp, 2, ALUresult, Zero); // slt
            break;
        case 43:
            ALU(data1, temp, 3, ALUresult, Zero); // sltu
            break;
        default:
            return 1;
        }
    }
    else
    {
        ALU(data1, temp, ALUOp, ALUresult, Zero);
    }

    return 0;
}

/* Read / Write Memory */
/* 10 Points */
int rw_memory(unsigned ALUresult, unsigned data2, char MemWrite, char MemRead, unsigned *memdata, unsigned *Mem)
{
    

    if (MemRead) // if MemRead is 1 read memory
    {
        if (ALUresult & 3) { // Check if pc is word aligned or outside of mem bounds
            return 1; 
        }
        if (ALUresult >> 2 < 0) {
            return 1;
        }

        *memdata = Mem[ALUresult >> 2];

    }
    if (MemWrite) // if MemWrite is 1 write memory
    {
        if (ALUresult & 3) { // Check if pc is word aligned or outside of mem bounds
            return 1; 
        }
        if (ALUresult >> 2 < 0) {
            return 1;
        }

        Mem[ALUresult >> 2] = data2;

    }
    return 0;
}

/* Write Register */
/* 10 Points */
void write_register(unsigned r2, unsigned r3, unsigned memdata, unsigned ALUresult, char RegWrite, char RegDst, char MemtoReg, unsigned *Reg)
{
    if (RegWrite) 
    {
        if (MemtoReg) // if RegWrite and MemtoReg are 1 write memdata
        {
            Reg[r2] = memdata;
        }
        else
        {

            if (RegDst) // else write ALUresult to r3 if RegDst is 1 else write to r2
            {
                Reg[r3] = ALUresult;
            }
            else
            {
                Reg[r2] = ALUresult;
            }
        }
    }
}

/* PC update */
/* 10 Points */
void PC_update(unsigned jsec, unsigned extended_value, char Branch, char Jump, char Zero, unsigned *PC)
{

    *PC += 4; // increment PC

    if (Branch && Zero) 
    {
        *PC += (extended_value << 2);
    }
    if (Jump) 
    {
        *PC = (*PC & 0xF0000000) + (jsec << 2);
    }
}
