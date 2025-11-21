package A22_DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;
public class A1_FriendsPairingProblem {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(pair(n));
    }
    private static int pair(int n){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=pair(n-1) + (n-1)*pair(n-2);
    }
}
