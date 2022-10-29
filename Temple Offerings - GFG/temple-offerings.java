//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.offerings(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int offerings(int N, int height[]){
        
        int[] left = new int[height.length];
        left[0] = 1;
        
        for(int i=1;i<height.length;i++)
        {
            if(height[i] > height[i-1])
                left[i] = left[i-1] +1;
            else
                left[i] = 1;
        }
        
        int[] right = new int[height.length];
        right[right.length-1] = 1;
        
        for(int i=right.length-2;i>=0;i--)
        {
            if(height[i] > height[i+1])
                right[i] = right[i+1] +1;
            else
                right[i] = 1;
        }
        
        int sum = 0;
        for(int i=0;i<height.length;i++)
            sum+=Math.max(left[i],right[i]);
            
        return sum;    
    }
}