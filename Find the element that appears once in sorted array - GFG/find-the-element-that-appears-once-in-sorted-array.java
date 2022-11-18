//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        int ans = -1;
        
        for(int i = 0;i<n;i++)
        {
            if(i-1 >=0 && arr[i-1] == arr[i])
                continue;
            if(i+1 <arr.length && arr[i+1] == arr[i])
                continue;
            
            ans = arr[i];    
        }
        
        return ans;
    }
}