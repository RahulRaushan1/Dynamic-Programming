//          Method 1 -----> Recursion (TLE error)
// class Solution {
//     public int amount (int[] nums, int i){
//         if(i>=nums.length) return 0;
//         int take = nums[i] + amount(nums,i+2);
//         int skip = amount(nums,i+1);
//         return Math.max(take,skip);
//     }
//     public int rob(int[] nums) {
//         return amount (nums,0);
//     }
// }



class Solution {
    public int amount (int[] nums, int i ,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + amount(nums,i+2,dp);
        int skip = amount(nums,i+1,dp);
        return dp[i] = Math.max(take,skip);
     }
     public int rob(int[] nums) {
        //   'i' varies from 0 to n-1
        int [] dp = new int[nums.length]; Arrays.fill(dp,-1);
        return amount(nums,0,dp);
     }
}