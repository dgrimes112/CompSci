#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int search(int numbers[], int low, int high, int value) {

	int mid = (low + high) / 2;
 	if (low > high) {
 		return -1;
 }
 	if (numbers[mid] == value) {
  		return mid;
 }
 	if (numbers[mid] > value) {
  		return search(numbers, low, mid - 1, value);
 }
 	if (numbers[mid] < value) {
  		return search(numbers, mid + 1, high, value);
 }

}

void printArray(int numbers[], int sz)
{
	int i;
	printf("Number array : ");
	for (i = 0;i<sz;++i)
	{
		printf("%d ",numbers[i]);
	}
	printf("\n");
}

int main(void)
{
	int start, end;
	start = clock();
	int i, numInputs;
	char* str;
	float average;
	int value;
	int index;
	int* numArray = NULL;
	int countOfNums;
	FILE* inFile = fopen("input.txt","r");

	fscanf(inFile, " %d\n", &numInputs);
	
	while (numInputs-- > 0)
	{
		fscanf(inFile, " %d\n", &countOfNums);
		numArray = (int *) malloc(countOfNums * sizeof(int));
		average = 0;
		for (i = 0; i < countOfNums; i++)
		{
			fscanf(inFile," %d", &value);
			numArray[i] = value;
			average += numArray[i];
		}

		printArray(numArray, countOfNums);
		value = average / countOfNums;
		index = search(numArray, 0, countOfNums - 1, value);
		if (index >= 0)
		{
			printf("Item %d exists in the number array at index %d!\n",value, index);
		}
		else
		{
			printf("Item %d does not exist in the number array!\n", value);
		}

		free(numArray);
	}

	fclose(inFile);
	end = clock();
	printf("Time taken: %f seconds\n", (double)(end - start) / CLOCKS_PER_SEC);
}