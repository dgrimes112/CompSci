/* David Grimes
   Dr. Steinberg
   COP3503 Spring 2025
   Programming Assignment 3
*/

public class TomatoesDriver
{
	public static void main(String [] args)
	{
		//Test Case 1
		System.out.println("**************************************");
		System.out.println("Test Case 1 with two stoves.");
		
		Tomatoes scenario = new Tomatoes();
		
		int arr1 [] = new int [] {2,8};
		
		int result = scenario.minTomatoMoves(arr1);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
		
		//Test Case 2
		System.out.println("**************************************");
		System.out.println("Test Case 2 with three stoves.");
		
		int arr2 [] = new int [] {0,3,0};
		
		result = scenario.minTomatoMoves(arr2);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
		
		//Test Case 3
		System.out.println("**************************************");
		System.out.println("Test Case 3 with five stoves.");
		
		int arr3 [] = new int [] {0,2,0,3,2};
		
		result = scenario.minTomatoMoves(arr3);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
		
		//Test Case 4
		System.out.println("**************************************");
		System.out.println("Test Case 4 with ten stoves.");
		
		int arr4 [] = new int [] {1,6,3,9,1,8,10,5,5,2};
		
		result = scenario.minTomatoMoves(arr4);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");

		
		//Test Case 5
		System.out.println("**************************************");
		System.out.println("Test Case 5 with fifteen stoves.");
		
		int arr5 [] = new int [] {0,2,3,2,0,5,6,9,6,6,6,8,2,1,4};
		
		result = scenario.minTomatoMoves(arr5);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
		
		
		//Test Case 6
		System.out.println("**************************************");
		System.out.println("Test Case 6 with twenty stoves.");
		
		int arr6 [] = new int [] {8,8,5,4,9,6,9,4,9,7,9,3,8,0,4,4,7,3,4,9};
		
		result = scenario.minTomatoMoves(arr6);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
		
		//Test Case 7
		System.out.println("**************************************");
		System.out.println("Test Case 7 with fifty stoves.");
		
		int arr7 [] = new int [] {7,9,3,5,5,0,9,3,3,10,6,6,6,9,8,5,6,3,7,7,1,9,4,8,10,6,1,9,6,4,1,2,3,2,4,8,10,3,4,1,3,7,4,6,2,2,0,1,10,2};
		
		result = scenario.minTomatoMoves(arr7);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
		
		
		//Test Case 8
		System.out.println("**************************************");
		System.out.println("Test Case 8 with one hundred stoves.");
		
		int arr8 [] = new int [] {6,10,9,10,3,8,0,1,1,6,6,9,0,6,8,2,4,8,8,10,10,8,2,7,1,9,4,1,6,7,2,6,9,0,1,5,0,6,7,6,5,3,2,9,5,10,5,5,1,6,0,9,6,0,2,7,1,10,7,8,7,0,10,3,7,0,7,9,2,0,1,3,2,7,6,7,8,8,6,3,1,10,5,3,3,4,1,0,5,6,4,4,8,4,4,7,10,9,2,1};
		
		result = scenario.minTomatoMoves(arr8);
		
		if(result > 0)
			System.out.println("Number of moves is " + result);
		else
			System.out.println("Not possible to solve since distribution is uneven.");
	}		
}