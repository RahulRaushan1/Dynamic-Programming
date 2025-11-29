package A22_DynamicProgramming;

public class A7_KnapsackTabulationMethod {
    public static void main(String[] args) {
        int[] val = {5,3,3,6};
        int [] wt = {1,2,8,10};
        int C = 8;
        int n = wt.length;
        // i = n-1 to 0  | C = C to 0
        int[][] dp = new int[n][C+1];
        for(int i =0;i<n;i++){
            for(int j=0;j<C+1;j++){
                int skip = (i>0) ? dp [i-1][j] : 0;
                if(wt[i]>j) dp [i][j] = skip;
                else {
                    int pick = val[i];
                    pick += ((i>0) ? dp[i-1][j-wt[i]] : 0);
                    dp[i][j] = Math.max(pick,skip);
                }
            }
        }
        System.out.println(dp[n-1][C]);
    }
}
