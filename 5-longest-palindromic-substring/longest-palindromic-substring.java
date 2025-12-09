class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
       int dp[][] = new int[n][n];
       
       int maxlength =1;
       int start =0;

       for(int k=0;k<n;k++){
        int i=0, j=k;
         while(j<n){
            if(i==j){
                dp[i][j]=1;
                
            }
            else if(j==i+1){
                if(s.charAt(i)==s.charAt(j)){
                     dp[i][j]=1;
                     
                    if(maxlength<2){
                    maxlength=2;
                    start=i;
                }
                     
                }
                
               
            }
            else {
                if((s.charAt(i)==s.charAt(j))){
                    if(dp[i+1][j-1]==1){
                        dp[i][j]=1;

                    if(maxlength< j-i+1){
                    start=i;
                    maxlength = j-i+1;
                }
                       
                    }
                }
                
            }
            i++; j++;
         }
       }
       return s.substring(start, maxlength + start);
       
    }
}