//               Method 1-----> Recusion (String pass by value)
// class Solution {
//     public int longestCommonSubsequence(String a, String b) {
//         int m = a.length(), n=b.length();
//         if(m==0 || n==0) return 0;
//         String a2 = a.substring(0,m-1);  // does not include m-1 idx
//         String b2 = b.substring(0,n-1);  // does not include n-1 idx
//         if(a.charAt(m-1)==b.charAt(n-1))
//            return  1 + longestCommonSubsequence(a2,b2);
//         else {
//             return Math.max(longestCommonSubsequence(a,b2),longestCommonSubsequence(a2,b));
//         }   

//     }
// }

//             Mehtod 2 ---> Pass by reference

// class Solution {
//     public int lcs(int i, int j, StringBuilder a, StringBuilder b) {
//         if(i<0 || j<0) return 0;
//         if(a.charAt(i) == b.charAt(j))
//             return 1 + lcs (i-1,j-1,a,b);
//         else{
//             return Math.max(lcs(i-1,j,a,b),lcs(i,j-1,a,b));
//         }    
//     }
//     public int longestCommonSubsequence(String text1,String text2){
//         StringBuilder a = new StringBuilder(text1);
//         StringBuilder b = new StringBuilder(text2);
//         int m= a.length(), n = b.length();
//         return lcs (m-1,n-1,a,b);
//     }
// }


//           Recursion + Memoization
// class Solution {
//     static int[][] dp;
//     public int lcs(int i, int j, StringBuilder a, StringBuilder b) {
//         if(i<0 || j<0) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(a.charAt(i) == b.charAt(j))
//             return dp[i][j] = 1 + lcs (i-1,j-1,a,b);
//         else{
//             return dp[i][j] = Math.max(lcs(i-1,j,a,b),lcs(i,j-1,a,b));
//         }    
//     }
//     public int longestCommonSubsequence(String text1,String text2){
//         StringBuilder a = new StringBuilder(text1);
//         StringBuilder b = new StringBuilder(text2);
//         int m= a.length(), n = b.length();
//         // i = m-1 to 0 | j = n-1 to 0
//         dp = new int [m][n];
//         for(int i=0;i<dp.length;i++)
//           for(int j=0;j<dp[0].length;j++) dp[i][j] =-1;
//         return lcs (m-1,n-1,a,b);
//     }
// }


//               Method -----> 3

class Solution {
    public int longestCommonSubsequence(String text1,String text2){
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m= a.length(), n = b.length();
        // i = m-1 to 0 | j = n-1 to 0
        int [][] dp = new int [m][n];
        for(int i=0;i<dp.length;i++){
          for(int j=0;j<dp[0].length;j++) {
           int p = (i>=1 && j>=1) ? dp[i-1][j-1] : 0;
           int q = (j>=1) ? dp[i][j-1] : 0;
           int r = (i>=1) ? dp[i-1][j] : 0;
            if(a.charAt(i)==b.charAt(j))
               dp[i][j] = 1 + p;
            else  
              dp[i][j] = Math.max(q,r); 
        }
             }
        return dp[m-1][n-1];
    }

}                     