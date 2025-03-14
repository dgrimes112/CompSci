/* David Grimes
   Dr. Steinberg
   COP3503 Spring 2025
   Programming Assignment 3
*/

public class Tomatoes
{

    int minTomatoMoves(int[] arr) 
    {

        int total = 0;


        for (int i = 0; i < arr.length; i++) 
        {
            total += arr[i];  //find total number of tomatoes
        }

        if (total % arr.length != 0)  //check if total tomatoes is divisible by pots
        {
            return -1;
        }

        int avg = total / arr.length; //find average val

        int moves = 0;
        int maxDebt = 0;
        int maxSurp = 0;
        int diff = 0;


        for (int i = 0; i < arr.length; i++) //find max debt and surplus
        {
            diff += avg - arr[i];

            if(avg - arr[i] > maxDebt)
            {
                maxDebt = avg - arr[i];
            }
            if(avg - arr[i] < maxSurp)
            {
                maxSurp = avg - arr[i];
            }
            if(diff > maxDebt)
            {
                maxDebt = diff;
            }
            else if(diff < maxSurp)
            {
                maxSurp = diff;
            }
        }

        moves = Math.max(maxDebt, -maxSurp); //find max between debt and surplus

        return moves;
    }

}