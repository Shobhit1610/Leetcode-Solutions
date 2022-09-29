// Leetcode 55

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(i>maxReach) 
                return false;
            
            int maxJump = i+nums[i];
            maxReach = Math.max(maxReach,maxJump);
        }
        
        return true;
    }
}