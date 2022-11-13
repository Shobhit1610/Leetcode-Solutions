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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

// Deletion = Len(s1) - LCS
// Insertion = len(s2) - LCS
// Ans = Ins +Del
class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    return str1.length() + str2.length() - 2* LCS(str1,str2);
	} 
	
	public int LCS(String str1,String str2)
	{
	    int[][] dp = new int[str1.length()+1][str2.length()+1];
	    
	    for(int i=str1.length()-1;i>=0;i--)
	    {
	        for(int j=str2.length()-1;j>=0;j--)
	        {
	            if(str1.charAt(i) == str2.charAt(j))
	                dp[i][j] = 1+ dp[i+1][j+1];
	            else
	                dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
	        }
	    }
	    
	    return dp[0][0];
	}
}