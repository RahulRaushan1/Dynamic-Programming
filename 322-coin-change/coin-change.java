//           Recursive code
// class Solution {
//     public long coinCount(int i,int[] coins,int amount) {
//         if(i==coins.length){
//             if(amount==0) return 0;  // no more coins needed
//             else return Integer.MAX_VALUE;  // not a valid combination
//         }
//         long skip = coinCount(i+1,coins,amount);
//         if(amount-coins[i]<0) return skip;
//         long pick =1 + coinCount (i,coins,amount-coins[i]);
//         return Math.min(skip,pick);
//     }
//     public int coinChange(int[] coins, int amount) {
//         int ans = (int)coinCount(0,coins,amount);
//         if(ans==Integer.MAX_VALUE) return -1;
//         return ans;
//     }
// }

//            Method 2 ---> Memoization

// class Solution {
//     public long coinCount(int i,int[] coins,int amount,long[][]dp) {
//         if(i==coins.length){
//             if(amount==0) return 0;  // no more coins needed
//             else return Integer.MAX_VALUE;  // not a valid combination
//         }
//         if(dp[i][amount]!=-1) return dp[i][amount];
//         long skip = coinCount(i+1,coins,amount,dp);
//         if(amount-coins[i]<0) return dp[i][amount] = skip;
//         long pick =1 + coinCount (i,coins,amount-coins[i],dp);
//         return dp[i][amount] = Math.min(skip,pick);
//     }
//     public int coinChange(int[] coins, int amount) {
//         // i = 0 to n-1 | amount = amount to 0
//         long[][] dp = new long [coins.length][amount+1];
//         for(int i=0;i<dp.length;i++)
//           for(int j=0;j<dp[0].length;j++) dp[i][j] = -1;
//         int ans = (int)coinCount(0,coins,amount,dp);
//         if(ans==Integer.MAX_VALUE) return -1;
//         return ans;
//     }
// }



//      Method ----->3 

class Solution{
    public int coinChange(int[] coins, int amount) {
        // i = n-1 to 0 | amount = amount to 0
        int n = coins.length;
        long[][] dp = new long[n][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                long skip = (i>0) ? dp[i-1][j] : ((j==0) ? 0 : Integer.MAX_VALUE);
                if(j-coins[i]<0) dp[i][j] =skip;
                else{
                    long pick = 1 + dp[i][j-coins[i]];
                    dp[i][j] = Math.min(skip,pick);
                }
            }
           
        }
        int ans = (int) dp[n-1][amount];
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}    