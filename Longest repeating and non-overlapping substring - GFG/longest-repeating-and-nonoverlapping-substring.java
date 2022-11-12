//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int N) {
    
        int max = 0;
        int idx = 0;
        //Find longest repeating subarray
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j = s.length()-1;j>=0;j--)
            {
                if( i!=j && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                    
                //To remove overlapping substring    
                if(Math.min(i,j) + dp[i][j] >= Math.max(i,j))
                    dp[i][j] = 0;
                    
                //Only to pass the code    
                if(dp[i][j] >= max)
                {
                    max = dp[i][j];
                    idx =i;
                }    
            }
        }
        
       
        // for(int i =0;i<dp.length;i++)
        // {
        //     for(int j=0;j<dp[0].length;j++)
        //     {
                
        //     }
        // }
        
        return max==0 ? "-1" : s.substring(idx,idx+max); 
    }
};