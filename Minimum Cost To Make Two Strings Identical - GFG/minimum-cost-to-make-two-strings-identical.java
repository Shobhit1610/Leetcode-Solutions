//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int findMinCost(String X, String Y, int costX, int costY)
	{
	    int lcsLength = LCS(X,Y);
	    
        return (X.length() - lcsLength)*costX + (Y.length() - lcsLength)*costY; 
	}
	
	public int LCS(String x,String y)
	{
	    int[][] dp = new int[x.length()+1][y.length()+1];
	    
	    for(int i=x.length()-1;i>=0;i--)
	    {
	        for(int j=y.length()-1;j>=0;j--)
	        {
	            if(x.charAt(i) == y.charAt(j))
	            {
	                dp[i][j] = 1 + dp[i+1][j+1];
	            }
	            else
	            {
	                dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
	            }
	        }
	    }
	    
	    return dp[0][0];
	}
}
