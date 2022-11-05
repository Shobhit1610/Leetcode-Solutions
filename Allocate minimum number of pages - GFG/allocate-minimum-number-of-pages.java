//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

// BINARY SEARCH ON ANSWER
// Suppose books are 12,34,67,90 and students are 2
// Distribution permutations can be
// (12)(34 67 90) Max = 34+67+90
// (12 34)(67 90) Max = 67 + 90
// (12 34 67)(90) Max = 12 + 34 + 67 (ANS AS MIN VAL of Max)
// Apply Binary Search from l =MaxInArray to r=SumOfArray to find min value of max

class Solution 
{
    public static int findPages(int[]pages,int books,int students)
    {
        if(ifBoundaryConditionsFail(pages,books,students)) return -1;
        
        int l = maxInArray(pages);
        int r = sumOfArray(pages);
        int res = -1;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if( isDistributionPossible(pages,students,mid) ) //Right Side
            {
                res = mid;
                r = mid - 1;
            }
            else  // Left Side
            {
                l = mid + 1;
            }
        }
        
        return res;
    }
    
    public static int maxInArray(int[] pages)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<pages.length;i++)
            max = Math.max(max,pages[i]);
        
        return max;    
    }
    public static int sumOfArray(int[] pages)
    {
        int sum = 0;
        for(int i=0;i<pages.length;i++)
            sum += pages[i];
        
        return sum;    
    }
    public static boolean ifBoundaryConditionsFail(int[]pages,int books,int students)
    {
        if(pages.length < students) return true;
        
        return false;
    }
    public static boolean isDistributionPossible(int[] pages,int totalStudents,int minOfMaxLoad)
    {
        int currentStudents = 0;
        int currentLoad = 0;
        
        int i = 0;
        while(i < pages.length)
        {
            while(i < pages.length && currentLoad + pages[i] <= minOfMaxLoad )
            {
                currentLoad += pages[i];
                i++;
            }
            
            currentLoad = 0;
            currentStudents++;
        }
        
        return currentStudents > totalStudents ? false : true;
    }
};