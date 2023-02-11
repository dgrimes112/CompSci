#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node {
    char letter;
    struct node* next;
} node;


// Returns number of nodes in the linkedList.
 int length(node* head){
  
    int count = 0;
    node* current = head;
    while(current!=NULL){
        count++;
        current = current->next;
    }

return count;

}
// parses the string in the linkedList
//  if the linked list is head -> |a|->|b|->|c|
//  then toCString function wil return "abc"
char* toCString(node* head){

    int len = length(head);
    char* str = (char*)malloc(sizeof(char)*(len+1));
    node* current = head;
    for(int i=0; i<len;i++){
        str[i] = current->letter;
        current = current->next;
    }
    
    str[len] = '\0';

    return str;

}
// inserts character to the linkedlist
// f the linked list is head -> |a|->|b|->|c|
// then insertChar(&head, 'x') will update the linked list as follows:
// head -> |a|->|b|->|c|->|x|
void insertChar(node** pHead, char c){
    node* current = *pHead;
    node* temp = (node*)malloc(sizeof(node));
    temp->next = NULL;
    temp->letter = c;
    if(current == NULL){
        *pHead = temp;
    }
    else{
        while(current->next!=NULL){
        current = current->next;
         }
        current->next = temp;
    }
}

// deletes all nodes in the linkedList.
void deleteList(node** pHead){
    
        node* current = *pHead;
        node* next;
        current = current->next;
        while(current!=NULL){
            next = current->next;
            free(current);
            current = next;
        }
        *pHead = NULL;
}


int main(void)
{
    int i, strLen, numInputs;
    node* head = NULL;
    char* str;
    char c;
    FILE* inFile = fopen("input.txt","r");
    fscanf(inFile, " %d\n", &numInputs);
    while (numInputs-- > 0){
        fscanf(inFile, " %d\n", &strLen);
    for (i = 0; i < strLen; i++){
        fscanf(inFile," %c", &c);
        insertChar(&head, c);
}
    str = toCString(head);
    printf("String is : %s\n", str);
    free(str);
    deleteList(&head);
    if (head != NULL){
        printf("deleteList is not correct!");
        break;
}
}
fclose(inFile);
}

