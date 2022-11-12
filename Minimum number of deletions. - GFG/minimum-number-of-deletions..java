//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String s, int n)
    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return s.length() - LCS(s,sb.toString());
    }
    
    public int LCS(String s1,String s2)
    {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=s1.length()-1;i>=0;i--)
        {
            for(int j=s2.length()-1;j>=0;j--)
            {
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 +dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);    
            }
        }

        return dp[0][0];
    }
} 