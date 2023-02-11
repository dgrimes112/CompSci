#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct stack {
  int data;
  struct stack *next;
}stack;

void init(struct stack **front) {
  *front = NULL;
}

int push(struct stack **front, int num) {
  struct stack *temp;

  temp = (struct stack *)malloc(sizeof(struct stack));
  
  if (temp != NULL) {
    temp->data = num;
    temp->next = *front;
    *front = temp;
    return 1;
  }
  else
    return 0;
}

struct stack* pop(struct stack **front) {
  struct stack *temp;    
  temp = NULL;
  if (*front != NULL) {  
    temp = (*front);
    *front = (*front)->next;
    temp -> next = NULL;
  }
  return temp;  
}

int empty(struct stack *front) {
  if (front == NULL)
    return 1;
  else
    return 0;
}

int top(struct stack *front) {
  if (front != NULL) {
    return front->data;
  }
  else
    return -1;
}
int isPalindrome(char *str) {  
     stack* s;  
     init(&s);  
     int len = strlen(str); 
     if(str == NULL) {  
          return 0;  
     }
     if(len % 2 == 0) {  
          for(int i = 0; i < len/2; i++) {  
               push(&s, str[i]);  
          }
          for(int i = len/2; i < len; i++) {  
               if(str[i] != pop(&s)->data) {  
                    return 0;  
               }  
          }
          return 1; 
     }
     if(len % 2 != 0) {  
          for(int i = 0; i < len/2; i++) {  
               push(&s, str[i]);  
          }
          for(int i = len/2 + 1; i < len; i++) {  
               if(str[i] != pop(&s)->data) {  
                    return 0;  
               }  
          }
          return 1;  
     }
     else{
          return 0;
     }
}

int main(void){


while(1){
     printf("Enter a string: \n");
     char str[100];
     fgets(str, 100, stdin);
     str[strcspn(str,"\n")] = '\0';
     if(isPalindrome(str)) {  
          printf("The string is a palindrome.\n");  
     }
     else {  
          printf("The string is not a palindrome.\n");  
     }
     printf("Want to go again? (y/n)\n");
     char c;
     while(1){

          scanf("%c", &c);
          if(c == 'y'){
              fflush(stdin);
               break;
          }
          else if(c == 'n'){
               return 0;
          }
          else{
               fflush(stdin);
               printf("Invalid input. Please enter y or n.\n");
          }
}
}
}