//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
// Example 1:
//
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//
// Example 2:
//
//
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
//
//

class Solution {

     /* Solution 1 - Iterative DP with dp array */
     /* time and space - O(n) */
     public int rob(int[] nums) {
         if (nums == null || nums.length == 0) return 0;

         int dp[] = new int[nums.length + 1];
         // dp[0] = nums[0];
         // dp[1] = nums[1];  这样写不对，如果出现nums =[0]的情况则出错，
         //所以要dp.length = nums.length + 1

         dp[0] = 0;
         dp[1] = nums[0];

         for (int i = 1; i < nums.length; i++){
             dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
         }
         return dp[nums.length];
     }

     /* Solution 2 - Iterative DP with constant space */
     public int rob(int[] nums){
         if (nums == null || nums.length == 0) return 0;
         int first = 0;
         int second = nums[0];
         for (int i = 1; i < nums.length; i++){
             int third = Math.max(first + nums[i], second);
             first = second;
             second = third;
         }
         return second;
     }

    /* Solution 3 - Recursion with Memoization */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int memo[] = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return helper(nums, memo, nums.length - 1);
    }
    public int helper(int[] nums, int[] memo, int n){
        if(n < 0) return 0;
        if(memo[n] >= 0) return memo[n];
        memo[n] = Math.max(nums[n] + helper(nums, memo, n-2), helper(nums, memo, n-1));
        return memo[n];
    }
}