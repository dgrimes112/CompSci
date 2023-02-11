#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct present {  
char *present_name;  
float price;  
}present;  
 
present* delete_present_list(present* presents_list, int num) {

if(presents_list == NULL){
    return presents_list;
}

present *pres = presents_list;

for(int j = 0; j < num; j++){

free(pres->present_name);
pres->present_name = NULL;
pres++;

}
free(presents_list);
presents_list = NULL;

return presents_list;
}




int main(){

int numPres = 0;
printf("how many presents?\n");
scanf("%d", &numPres);

present* presents_list = (present*)malloc((sizeof(present)) * numPres);
present* presents = presents_list;

for(int i = 0; i < numPres; ++i){

char tempName[50];
printf("enter the name of the present:\n");
fflush(stdin);
fgets(tempName, 50, stdin);
tempName[strcspn(tempName,"\n")] = '\0';
presents->present_name = (char*)malloc(sizeof(char) * (strlen(tempName) + 1));
strcpy(presents->present_name, tempName);


printf("how much does this present cost?\n");
while(scanf("%f", &presents->price) != 1){
    printf("invalid input, try again\n");
    fflush(stdin);
}

printf("ptr location for present %d: %p\n", i, presents);

printf("press enter to continue...\n");
fflush(stdin);
char enter;
scanf("%c", &enter);

presents++;

system("cls");

}
presents = presents_list;

printf("\tPRESENT NAME\tCOST\tLOCATION\n");
for(int i = 0; i < numPres; i++){

  printf("\t%-12s\t%-5.2f\t%-8p\n", presents->present_name,presents->price, presents);
  presents++;
}
printf("\tpresent_list location: %p\n", presents_list);
printf("=======after calling delete_presents_list=======\n");

presents = delete_present_list(presents_list, numPres);

printf("\tPRESENT NAME\tCOST\tLOCATION\n");

for(int i = 0; i < numPres; i++){

if(presents == NULL){
    printf("\tNULL\t\tNAN\tNULL\n");
}
printf("\tpresent_list location: NULL\n");
}
}