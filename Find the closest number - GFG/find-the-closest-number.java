//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int target = Integer.parseInt(element[1]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.findClosest(arr, n, target));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    
    // Closest value can lie between (floor,target,ceil)    
    public static int findClosest(int arr[], int n, int target) 
    { 
        int floor = findFloor(arr,target);
        int ceil = findCeil(arr,target);
        int ans = 0;
        
        // System.out.println(floor);
        // System.out.println(ceil);
        
        if(floor == target)
            ans = floor; 
        else if(ceil == target)
            ans = ceil;     
        else if(target - floor == ceil - target)
            ans = ceil;
        else if(target - floor < ceil - target)    
            ans = floor;
        else if(target - floor > ceil - target)
            ans = ceil;
            
        return ans;    
    } 
    
    public static int findFloor(int[] arr, int target)
    {
        int l=0;
        int r=arr.length-1;
        
         int res = 0;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if(arr[mid] == target)
                return arr[mid];
            
            else if(arr[mid] < target)
            {
                res = arr[mid];
                l = mid +1;
            }
            
            else if(arr[mid] > target)
            {
                r = mid -1;
            }
        }
        
        if( l > arr.length-1 ) res = arr[arr.length-1];
        if( r < 0 ) res = arr[0];
        
        return res;
    }
    
    public static int findCeil(int[] arr, int target)
    {
        int l=0;
        int r=arr.length-1;
        
        int res = 0;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
           
            
            if(arr[mid] == target)
                return arr[mid];
            
            else if(arr[mid] < target)
            {
                
                l = mid +1;
            }
            
            else if(arr[mid] > target)
            {
                res = arr[mid];
                r = mid -1;
            }
        }
        
        if( l > arr.length-1 ) res = arr[arr.length-1];
        if( r < 0 ) res = arr[0];
        
        
        return res;
    }
    
}

