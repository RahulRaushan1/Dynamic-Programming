class Solution {
    public String LCS(String s1, String s2){
        int m = s1.length(); int n = s2.length();
        StringBuilder sb = new StringBuilder("");
        int [][]dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1 + dp[i-1][j-1];
                else dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int i = m; int j=n;
        while(i>0 && j>0){
          if(s1.charAt(i-1)==s2.charAt(j-1)) {
             sb.append(s1.charAt(i-1));
             i--;
             j--;
          }
          else if(dp[i][j-1]> dp[i-1][j]) j--;
          else i--;

        }
        sb.reverse();
        String s = sb.toString();
        return s;
        

    }
    public String shortestCommonSupersequence(String s1, String s2) {
       String lcs = LCS(s1,s2); 
       String scs="";
       int i=0,j=0,k=0;
       while(k<lcs.length()){
          while(s1.charAt(i)!=lcs.charAt(k))
          scs = scs + s1.charAt(i++);

          while(s2.charAt(j)!=lcs.charAt(k))
          scs = scs + s2.charAt(j++);

           scs= scs + lcs.charAt(k);
          i++;j++;k++;
        }

       while(i<s1.length()){
        scs += s1.charAt(i++);
       }

       while(j<s2.length()){
        scs += s2.charAt(j++);
       }

       
       return scs;
       
    }
}