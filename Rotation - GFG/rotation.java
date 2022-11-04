//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // No of Rotations. = Number of Elements before Min value = Index of Min Value
    
    int findKRotation(int arr[], int n) {
        
        //If Array is not rotated
        if(arr[0] < arr[arr.length-1])
            return 0;
        //Only one element in array    
        else if(arr.length == 1)
            return 0;
        
        int l = 0;
        int r = arr.length-1;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if(isMaximum(arr,mid))
                return mid+1;
            else if(isMinimum(arr,mid))
                return mid;
            else if(arr[mid] > arr[l])
                l = mid+1;
            else if(arr[mid] < arr[r])
                r = mid -1;
        }
        
        return -1;
    }
    
    
    boolean isMinimum(int[] ar,int mid)
    {
        int leftValue = mid-1 >=0 ? ar[mid-1] : Integer.MAX_VALUE;
        int rightValue = mid+1 < ar.length ? ar[mid+1] : Integer.MAX_VALUE;
        
        if(ar[mid] < leftValue && ar[mid] < rightValue)
            return true;
        return false;    
    }
    
    boolean isMaximum(int[] ar,int mid)
    {
        int leftValue = mid-1 >=0 ? ar[mid-1] : Integer.MIN_VALUE;
        int rightValue = mid+1 < ar.length ? ar[mid+1] : Integer.MIN_VALUE;
        
        if(ar[mid] > leftValue && ar[mid] > rightValue)
            return true;
        return false;    
    }
    
    
}