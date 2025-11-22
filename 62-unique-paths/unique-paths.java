// class Solution {
//     public int uniquePaths(int m, int n) {
//         return paths(0,0,m,n);
//     }
//     private int paths(int row, int col, int m ,int n){
//         if(row>=m || col>=n) return 0;
//         if(row==m-1 && col==n-1) return 1;
//         int rightWays = paths(row,col+1, m,n);
//         int downWays = paths(row+1,col,m,n);
//         return rightWays + downWays;
//     }
// }


class Solution {
    public int uniquePaths(int m, int n) {
        //row : 0 to m-1 | col : 0 to n-1 
        int [][] dp = new int [m] [n];
        for ( int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            dp[i][j] = -1;
         }
        }
        return paths(0,0,m,n,dp);
    }
    private int paths(int row,int col, Integer m,Integer n,int[][]dp){
        if(row>=m || col>=n) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int rightWays = paths(row,col+1,m,n,dp);
        int downWays = paths(row+1,col,m,n,dp);
        return dp[row][col] = rightWays + downWays;
    }
}