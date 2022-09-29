class Solution {
    public int minCostClimbingStairs(int[] cost) {
       
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        
        // return fnMem(cost.length,cost,dp);
        // return fnTab(cost.length,cost);
         return fnTabOpt(cost.length,cost);
    }
    
    public int fnMem(int n ,int[] cost,int[] dp)
    {
        if(n == 0 || n == 1)
            return cost[n];
        else if(n<0)
            return Integer.MAX_VALUE;
        else if(dp[n] != -1)
            return dp[n];
        
        dp[n] = Math.min(fnMem(n-1,cost,dp) , fnMem(n-2,cost,dp));
        
        if(dp[n] != Integer.MAX_VALUE && n<cost.length) dp[n] += cost[n];
        return dp[n];
    }
    
    public int fnTab(int n,int[] cost)
    {
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i=2;i<n+1;i++)
        {
            dp[i] = Math.min(dp[i-1],dp[i-2]);
            
            if(i<n) dp[i] += cost[i];
        }
        
        return dp[n];
    }
    
    public int fnTabOpt(int n,int[] cost)
    {
        int curr = 0;
        int prev = 0;
        int secondPrev = 0;
        
        secondPrev = cost[0];
        prev = cost[1];
        for(int i=2;i<n+1;i++)
        {
            curr = Math.min(prev,secondPrev);
            if(i<n) curr += cost[i];
            
            secondPrev = prev;
            prev = curr;
            
        }
        
        return curr;
    }
}