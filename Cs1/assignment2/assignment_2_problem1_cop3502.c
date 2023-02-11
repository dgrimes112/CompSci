#include <stdio.h>
#include <stdlib.h>


typedef struct node {  
int data;  
struct node* next;  
} node;  
 

void insertAfterN(node* head, int M, int N){

    node* curr = head;

    while(curr!=NULL){

        if(curr->data == M){

            node* temp = (node*)malloc(sizeof(node));
            temp->data = N;
            temp->next = curr->next;
            curr->next = temp;

        }

    curr = curr->next;

    }



 }

int insertList(node** head, int data){ 
    node* newNode = (node*) malloc(sizeof(node)); 
    
    if (newNode == NULL){
    return -1; 
    }
    newNode->data = data; 
    newNode->next = NULL; 
    
    newNode->next = *head; 
    *head = newNode; 
    
    return 1;


} 

void deallocateList(node** head){ 
 node* tmp = *head; 
  
 while (tmp != NULL) 
 { 
  *head = tmp->next; 
  free(tmp); 
  tmp = *head; 
 } 
  
 *head = NULL; 
} 

void printList(node* head){ 
 node* temp = head; 
  
 while (temp != NULL) 
 { 
  printf("%d",temp->data); 
  if (temp->next != NULL) 
  { 
   printf(", "); 
  } 
  else 
  { 
   printf(".\n"); 
  } 
  temp = temp->next; 
 } 
} 

 

int main(void) { 
 node* head = NULL;
  
printf("Enter the number of elements in the list: \n");
int n;
while(scanf("%d", &n) != 1){
    printf("Invalid input. Please enter an integer: \n");
    fflush(stdin);
}
printf("Enter the elements of the list: \n");
for(int i = 0; i < n; i++){
    int x;
    while(scanf("%d", &x) != 1){
        printf("Invalid input. Please enter an integer: \n");
        fflush(stdin);
    }
    insertList(&head, x);
}
printf("Enter the number you want to insert: \n");
int N;
while(scanf("%d", &N) != 1){
    printf("Invalid input. Please enter an integer: \n");
    fflush(stdin);
}
printf("What number would you like to insert after? \n");
int M;
while(scanf("%d", &M) != 1){
    printf("Invalid input. Please enter an integer: \n");
    fflush(stdin);
}
printf("Initial List:\n"); 
printList(head); 
insertAfterN(head, M, N); 
printf("Marked List:\n"); 
printList(head); 
  
deallocateList(&head); 
}
