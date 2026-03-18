package A22_DynamicProgramming;

public class MatrixChainMultiplicationForm1 {
   public static void main(String[] args) {
       int [][] arr = {{1,2},{2,3},{3,4}};
       int n = arr.length;
       System.out.println(mcm(0,n-1,arr));
   }
   private static int mcm(int i, int j, int[][]arr){
       if(i==j) return 0;
       int minCost = Integer.MAX_VALUE;
       for(int k=i;k<j;k++){
           int x = arr[i][0] * arr[k][1] * arr[j][1];
           int totalCost = mcm(i,k,arr) + mcm(k+1,j,arr) + x;
           minCost = Math.min(minCost,totalCost);
       }
       return minCost;
   }
}


