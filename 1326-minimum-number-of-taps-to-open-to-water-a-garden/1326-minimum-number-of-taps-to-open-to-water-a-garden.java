// Leetcode 1326
class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] newJumpArray = getNewJumpArray(ranges);
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // int ans = fnMem(newJumpArray,dp,0);
        int ans = fnTab(newJumpArray);
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
    
    public int[] getNewJumpArray(int[] ranges)
    {
        int[] newJump = new int[ranges.length];
        
        for(int i=0 ;i<ranges.length;i++)
        {
            int jump = ranges[i];
            newJump[i] = Math.max(newJump[i],jump);
            for(int j=1;j<=jump;j++)
            {
                if(i+j <newJump.length) newJump[i+j] = Math.max(newJump[i+j],jump-j);
            }
            for(int j=-1;j>=-1*jump;j--)
            {
                if(i+j >=0) newJump[i+j] = Math.max(newJump[i+j],jump-j);
            }
        }
        
        return newJump;
    }
    
    public int fnMem(int[] newJumpArray,int[] dp,int start)
    {
        if(start >= newJumpArray.length-1)
            return 0;
        else if(dp[start] != -1)
            return dp[start];
        
        dp[start] = Integer.MAX_VALUE;
        for(int i=1;i<=newJumpArray[start];i++)
        {
            dp[start] = Math.min(dp[start],fnMem(newJumpArray,dp,start+i));    
        }
        if(dp[start] != Integer.MAX_VALUE) dp[start] +=1;
        
        return dp[start];
        
    }
    
    public int fnTab(int[] newJumpArray)
    {
        int[] dp = new int[newJumpArray.length+1];
        
        for(int i=dp.length-3;i>=0;i--)
        {
            int jump = newJumpArray[i];
            dp[i] = Integer.MAX_VALUE;
            
            for(int j=1;j<=jump;j++)
            {
                if(i+j < dp.length) dp[i] = Math.min(dp[i],dp[i+j]);
            }
            
            if(dp[i] != Integer.MAX_VALUE) dp[i] += 1;
            
        }
        
        return dp[0];
    }
}