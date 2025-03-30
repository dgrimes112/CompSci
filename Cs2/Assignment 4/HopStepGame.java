/* Name:
 * David Grimes
 * COP3503 Spring 2025
 * Programming Assignment 4
 */

public class HopStepGame 
{

    private int max = Integer.MAX_VALUE; //max value for impossible paths

    public int minCost(int[] cost, int i) 
    {
        if (i == 0)   
        {
            return cost[0];
        }

        if (i == 1) 
        {
            if (cost.length < 2) //catch 1 element array
            {
                return cost[0];
            }
            return cost[1];
        }

        if (i < 0) //catch negative index
        {
            return max;
        }

        int cost1 = minCost(cost, i - 1); //recursion 
        int cost2 = minCost(cost, i - 2);

        int minPrevCost;

        if (cost1 == max && cost2 == max) //if both paths are impossible sets max value
        {
            minPrevCost = max;
        } 
        else 
        {
            minPrevCost = Math.min(cost1, cost2);  //finds min cost
        }

        if (minPrevCost == max) //propagates max value
        {
            return max;
        }

        long totalCost = (long) cost[i] + minPrevCost; //checks for overflow

        if (totalCost > max) 
        {
            return max;  //propagates max value
        }

        return cost[i] + minPrevCost; //returns min cost 
    }

    public int minCostMemoization(int[] cost, int i, int[] memo) 
    {
        if (i < 0) //catch negative index
        {
            return max;
        }

        if (i == 0)
        {
            return cost[0];
        }

        if (i == 1) 
        {
            if (cost.length < 2) 
            {
                return cost[0];
            }
            return cost[1];
        }

        if (memo[i] != 0)   //check if value already calculated
        {
            return memo[i];
        }

        int cost1 = minCostMemoization(cost, i - 1, memo); //recursion
        int cost2 = minCostMemoization(cost, i - 2, memo);

        int minPrevCost;

        if (cost1 == max && cost2 == max)  //if both paths are impossible sets max value
        {
            minPrevCost = max;
        } 
        else 
        {
            minPrevCost = Math.min(cost1, cost2);  //finds min cost
        }

        if (minPrevCost == max)  //propagates max value
        {
            return max;
        }

        long totalCost = (long) cost[i] + minPrevCost; //checks for overflow

        if (totalCost > max)  //checks for overflow
        {
            memo[i] = max;
            return max;
        }

        memo[i] = cost[i] + minPrevCost; //puts calculated value in memo array
        return memo[i]; //returns min cost
    }

    public int minCostTabulation(int[] cost) 
    {
        int n = cost.length;  //length of the array

        if (n == 0) 
        {
            return 0;
        }

        if (n == 1) 
        {
            return cost[0];
        }

        int[] dp = new int[n];

        dp[0] = cost[0];  //base case 1
        dp[1] = cost[1];  //base case 2

        for (int i = 2; i < n; i++)  //loop through the array
        {
            int minPrevCost = Math.min(dp[i - 1], dp[i - 2]);   //find min cost

            long currentTotalCost = (long) cost[i] + minPrevCost; //checks for overflow

            if (currentTotalCost > max)  //propagates max value
            {
                dp[i] = max;
            } 
            else 
            {
                dp[i] = cost[i] + minPrevCost; //sets dp value to min cost
            }
        }

        return Math.min(dp[n - 1], dp[n - 2]);  //returns min cost of the last two squares
    }
}