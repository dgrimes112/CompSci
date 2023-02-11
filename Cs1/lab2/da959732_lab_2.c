#include <string.h> 
#include <stdio.h> 
#include <stdlib.h> 
 
typedef struct StringType {  
    char* string;  
    int length;  
} StringType;  
 
typedef struct Employee {  
    StringType* name;  
    double salary;  
} Employee;  
 
Employee* createEmployees(char names[][50], double *salaries, int empCount) { 

    Employee* pEmployees = (Employee*)malloc(sizeof(Employee) * empCount);
    Employee* pEmployee = pEmployees;
    int i = 0;
    for (i = 0; i < empCount; ++i) {
        pEmployee->name = (StringType*)malloc(sizeof(StringType));
        pEmployee->name->length = strlen(names[i]);
        pEmployee->name->string = (char*)malloc(sizeof(char*) * (pEmployee->name->length + 1));
        strcpy(pEmployee->name->string, names[i]);
        pEmployee->salary = salaries[i];
        pEmployee++;
    }
    return pEmployees;

} 
 
int main() {  
 const int EMPLOYEE_COUNT = 4; 
 //array of employees’ names  
 char nameList[][50] = {"Bill", "Mary", "Kevin", "Denise"};  
 //array of salaries, where 15.80 is the salary of Bill, 13.50 is  
 // the salary of Mary, etc.  
 double salaries[] = {15.80, 13.5, 20.9, 12.99};  
 Employee* pEmployees = createEmployees(nameList, salaries, EMPLOYEE_COUNT);  
 // Print Employees 
 int e = 0; 
 Employee* pEmployee = pEmployees; 
 printf("\tEMPLOYEE NAME\t\tSALARY\n"); 
 for (e=0;e<EMPLOYEE_COUNT;++e) { 
  printf("\t%s\t\t\t%.2lf\n",pEmployee->name->string,pEmployee->salary); 
  pEmployee++; 
 } 
  
 // Deallocate memory 
 pEmployee = pEmployees; 
 for (e=0;e<EMPLOYEE_COUNT;++e) { 
 
 
  free(pEmployee->name->string); 
  pEmployee->name->string = NULL; 
  free(pEmployee->name); 
  pEmployee->name = NULL; 
  pEmployee++; 
 } 
 free(pEmployees); 
 pEmployees = NULL; 
  
 return 0;  
}   

