/* David Grimes
 * Dr. Steinberg
 * COP3503 Spring 2025
 * Programming Assignment 1
 */

import java.util.*;


class Game 
{
    //initialize variables
    private char[]  Moves = new char[] {'d', 'r', 'b'};
    private char[][]  Board;
    private Random Seed;
    private int currRow = 0;
    private int currCol = 0;

    public Game(Random rand)
    {
        //set seed and set up board
       this.Seed = rand;
       Board = new char[8][8];
       for (int i = 0; i < Board.length; i++)
       {
            Arrays.fill(Board[i], ' ');
       }
       Board[0][0] = 'K';
    }

    //check parity of the position of the knight
    private int checkParity()
    {
        for (int i = 0; i < Board.length; i++)
        {
            for (int j = 0; j < Board[i].length; j++)
            {
                if (Board[i][j] == 'K')
                {
                    return i - j;
                }
            }
        }
        return 0;
    }


    private char selectPlayerOneMove()
    {   
        int success = 0;
        char move = ' ';
        int parity = checkParity();
        while(success == 0)
        {

            if(parity == 0) //always go diagonal when in the diagonal
            {
                
                move = Moves[0];
                success = 1;
                return move;
            }

            if(parity < 0) //if parity is negative, ensure the knight moves to winning square
            {
                if(currCol % 2 == 0 && currRow % 2 == 1)
                {
                    move = Moves[1];
                    success = 1;
                    return move;
                }
                else if(currCol % 2 == 1 && currRow % 2 == 0)
                {
                    move = Moves[2];
                    success = 1;
                    return move;
                }
                else if(currCol % 2 == 0 && currRow % 2 == 0)
                {
                    move = Moves[0];
                    success = 1;
                    return move;
                }
                else    
                {
                    move = Moves[2];
                    success = 1;
                    return move;
                }

            }

            if(parity > 0) //if parity is positive, ensure the knight moves to winning square
            {
                if(currCol % 2 == 0 && currRow % 2 == 1)
                {
                    move = Moves[1];
                    success = 1;
                    return move;
                }
                else if(currCol % 2 == 1 && currRow % 2 == 0)
                {
                    move = Moves[2];
                    success = 1;
                    return move;
                }
                else if(currCol % 2 == 0 && currRow % 2 == 0)
                {
                    move = Moves[0];
                    success = 1;
                    return move;
                }
                else    
                {
                    move = Moves[2];
                    success = 1;
                    return move;
                }
            }

            
        }
        return move;
    }

    //select a random move for player two
    private char selectPlayerTwoMove()
    {   
        int success = 0;
        char move = ' ';

        while (success == 0)
        {
            move = Moves[Seed.nextInt(Moves.length)];
            if (checkValidMove(move) == true)
            {
                success = 1;
            }
            
        }
        return move;
    }

    //check if the move is valid
    private boolean checkValidMove(char move)
    {
        if (move == Moves[0])
        {
            if (currRow + 1 < 8 && currCol + 1 < 8)
            {
                return true;
            }
        }
        else if (move == Moves[1])
        {
            if (currCol + 1 < 8)
            {
                return true;
            }
        }
        else if (move == Moves[2])
        {
            if (currRow + 1 < 8)
            {
                return true;
            }
        }
        return false;
    }
    
    //perform the move
    private void performMove(char move)
    {
        if (move == Moves[0])
        {
            Board[currRow][currCol] = ' ';
            currRow++;
            currCol++;
            Board[currRow][currCol] = 'K';
        }
        else if (move == Moves[1])
        {
            Board[currRow][currCol] = ' ';
            currCol++;
            Board[currRow][currCol] = 'K';
        }
        else if (move == Moves[2])
        {
            Board[currRow][currCol] = ' ';
            currRow++;
            Board[currRow][currCol] = 'K';
        }
    }

    //print the board for testing purposes 
    private void printBoard()
    {
        System.out.println("---------------------------------");
        for (int i = 0; i < Board.length; i++)
        {
            for (int j = 0; j < Board[i].length; j++)
            {
                System.out.print("| " + Board[i][j] + " ");
                if(j == 7)
                {
                    System.out.print("|");
                }
            }
            System.out.println("\n---------------------------------");
        }
        System.out.println("\n\n");
    }

    //play the game
    public int play()
    { 
        char playerOneMove = ' ';
        char playerTwoMove = ' ';    
        int winner = 0;
        while (winner == 0)
        {
            playerOneMove = selectPlayerOneMove();
            performMove(playerOneMove);
            //System.out.println("Player One Move: " + playerOneMove);   //uncomment if you wanna see the games played out
            //printBoard();
            if (Board[7][7] == 'K') //check if p1 wins
            {
                winner = 1;
                break;
            }
            playerTwoMove = selectPlayerTwoMove();
            performMove(playerTwoMove);
            //System.out.println("Player Two Move: " + playerTwoMove);
            //printBoard();
            if (Board[7][7] == 'K') //check if p2 wins
            {
                winner = 2;
                break;
            }
        }
     
        return winner;
    }
}
