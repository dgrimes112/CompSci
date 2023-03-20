#include <stdio.h>
#include <stdlib.h>


void bubbleSortCount(int* array,int n);

int main(){

int array[] = {97,16,45,63,13,22,7,58,72};
bubbleSortCount(array,9);


return 0;
}

void bubbleSortCount(int* array, int n){

    int i,j,temp;
    int countArray[9] = {0};
	for(i = 0; i < n-1; i++){
		for(j = 0; j < n-1-i; j++){
			if(array[j]>array[j+1]){
				temp = array[j+1];
				array[j + 1] = array[j];
				array[j] = temp;
                countArray[j]++;
				countArray[j+1]++;
			}
		}
	} 
    for(int i = 0; i < n; i++){
        printf("index %d took %d swaps\n", i , countArray[i]);
}
}