class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        
       int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n+1;i++)
        {
            dp[2] =dp[1]+dp[0];
            dp[0]=dp[1];
            dp[1]=dp[2];
        }
        return dp[2];
    }
}