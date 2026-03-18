//TTE , o(n^2) , hard
class Solution {
    public class Envelop implements Comparable<Envelop> {
        int w;
        int h;
        Envelop(int w , int h){
            this.w = w;
            this.h = h;
        }
        public int compareTo (Envelop e){
            if(this.w==e.w) return e.h - this.h; // descending order h  when same w
            return this.w - e.w;   // ascending order
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelop[] arr = new Envelop[n];
        for(int i=0;i<n;i++){
            int w = envelopes[i][0];
            int h = envelopes[i][1];
            arr[i]= new Envelop(w,h);
        }
        Arrays.sort(arr);
        // LIS on this arr.h
        int[] dp = new int[n];
        int max =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(arr[j].h<arr[i].h)
                  dp[i] = Math.max(dp[i],dp[j]);
            }
            dp[i] += 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
