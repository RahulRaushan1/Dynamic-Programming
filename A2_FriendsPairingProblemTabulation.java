package A22_DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;
public class A2_FriendsPairingProblemTabulation {
    static int[] dp;
       public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            dp = new int[n+1];
            Arrays.fill(dp,-1);
            System.out.println(Friends(n));
       }
        private static int Friends(int n){
            int[] dp = new int [n+1];
            dp[1] = 1;
            if(n>1) dp[2] = 2;
            for(int i=3;i<=n;i++){
                dp[i] = dp[i-1] + (i-1)*dp[i-2];
            }
            return dp[n];
       }
}
