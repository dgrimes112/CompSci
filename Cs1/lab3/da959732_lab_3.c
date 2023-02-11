#include <stdio.h> 
#include <stdlib.h>
 
typedef struct node {  
 int data;  
 struct node* next;  
} node;  
 
void markEven(node* head) { 
node* temp = head;

 while(temp != NULL){

    if(temp->data % 2 == 0){

        node* new_node = (node*) malloc(sizeof(node));
        new_node -> data = -1;
        new_node -> next = temp -> next;
        temp -> next = new_node;

    }

    temp = temp->next;
 }

return;
} 
 
void deallocateList(node** head) 
{ 
 node* tmp = *head; 
  
 while (tmp != NULL) 
 { 
  *head = tmp->next; 
  free(tmp); 
  tmp = *head; 
 } 
  
 *head = NULL; 
} 
 
int insertList(node** head, int data) 
{ 
 node* newNode = (node*) malloc(sizeof(node)); 
  
 if (newNode == NULL) 
  return -1; 
  
 newNode->data = data; 
 newNode->next = NULL; 
  
 newNode->next = *head; 
 *head = newNode; 
  
 return 1; 
} 
 
 
void printList(node* head) 
{ 
 node* tmp = head; 
  
 while (tmp != NULL) 
 { 
  printf("%d",tmp->data); 
  if (tmp->next != NULL) 
  { 
   printf(", "); 
  } 
  else 
  { 
   printf(".\n"); 
  } 
  tmp = tmp->next; 
 } 
} 
 
int main(void) 
{ 
 node* head = NULL; 
  
 insertList(&head, 8); 
 insertList(&head, 3); 
 insertList(&head, 1); 
 insertList(&head, 7); 
 insertList(&head, 6); 
 insertList(&head, 2); 
  
 printf("Initial List:\n"); 
 printList(head); 
 markEven(head); 
 printf("Marked List:\n"); 
 printList(head); 
  
 deallocateList(&head); 
}

