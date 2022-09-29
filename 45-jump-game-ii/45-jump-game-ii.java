class Solution {
    public int jump(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        
        return fnMem(nums,dp,0);
        // return fnTab(nums);
    }
    
    public int fnMem(int[] nums,int[] dp,int start)
    {
        if(start == nums.length -1)
            return 0;
        else if(start > nums.length-1)
            return Integer.MAX_VALUE;
        else if(dp[start] != -1)
            return dp[start];
        
        dp[start] = Integer.MAX_VALUE;
        for(int i=1;i<=nums[start];i++)
        {
            dp[start] = Math.min( dp[start] , fnMem(nums,dp,start+i));
        }
        
        if(dp[start] != Integer.MAX_VALUE)   dp[start]+=1 ;
        return dp[start];
    }
    
    public int fnTab(int[] nums)
    {
        int[] dp = new int[nums.length];
        
        
        for(int i=dp.length-2;i>=0;i--)
        {
            dp[i] = Integer.MAX_VALUE;
            int jump = nums[i];
            
            for(int j=1;j<=jump;j++)
            {
                if(i+j < dp.length) dp[i] = Math.min(dp[i],dp[i+j]);
            }
            
            if(dp[i] != Integer.MAX_VALUE) dp[i] +=1;
        }
        
        return dp[0];
    }
}