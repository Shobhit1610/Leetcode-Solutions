//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

// GFG
// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
class Solution
{
    // Have to select M values such that (Max(m) - Min(m) should me minimum 
    // Sort the array and check diff of Max and Min in sliding window pf M
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long res = Long.MAX_VALUE;
        
        for(int i=0;i<=n-m;i++)
        {
            int minValue = a.get(i);
            int maxValue = a.get(i+m-1);
            
            res = Math.min(res, maxValue-minValue);
        }
        
        return res;
    }
}