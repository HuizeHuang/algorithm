//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// Note: Given n will be a positive integer.
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//

class Solution {

     /* Solution 1 -- Direct recursion */
     /* 单个testcase可以运行通过, 但是Time Limit Exceeded -- O(2^n) */
     public int climbStairs(int n) {
         if(n <= 2) return n;
         return climbStairs(n-1) + climbStairs(n-2);
     }


     /* Solution 2 -- Recursion DP with Memoization */
     /* faster than 100%, -- time and space: O(n) */
     public int climbStairs(int n){
         // added a memo recording whether or not this step has been covered before
         int memo[] = new int[n + 1];
         return helpFunction(n, memo);
     }
     public int helpFunction(int n, int memo[]){
         if (n <= 2) return n;
         if (memo[n] > 0) return memo[n];
         memo[n] = helpFunction(n - 1, memo) + helpFunction(n - 2, memo);
         return memo[n];
     }

     /* Solution 3 -- Iterative DP with a dp array */
     /* faster than 100% -- time and space: O(n)*/
     public int climbStairs(int n){
         if (n <= 1) return n;
         int dp[] = new int[n + 1];
         dp[1] = 1;
         dp[2] = 2;
         for (int i = 3; i <= n; i++){
             dp[i] = dp[i - 1] + dp[i - 2];
         }
         return dp[n];
     }

    /* Solution 4 -- Fibonacci constant number */
    /* Reduce the space complexity to a constant level, time - O(n), space - O(1) */
    public int climbStairs(int n){
        if (n <= 1) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}