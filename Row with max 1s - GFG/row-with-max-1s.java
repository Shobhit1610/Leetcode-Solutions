//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int ar[][], int n, int m) {
        
        int noOfOnes = 0;
        int rowWithMaxOnes = -1;
        
        //Find Transition point in every row
        //Searchable space should be reduced to r-1 for the next row
        
        int previousRowTransitionPoint = ar[0].length-1;
        for(int i=0;i<ar.length;i++)
        {
            if(previousRowTransitionPoint < 0)
                break;
                
            int transitionPoint = findTransitionPoint(ar,i,0,previousRowTransitionPoint);
            
            if(transitionPoint == -1)
            {
                
            }
            else
            {
                noOfOnes = ar[i].length - transitionPoint;
                rowWithMaxOnes = i;
                previousRowTransitionPoint = transitionPoint -1 ;
            }
        }
        
        return rowWithMaxOnes;
    }
    
    int findTransitionPoint(int[][] ar,int row,int l,int r)
    {
        int res = -1;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if(ar[row][mid] == 0)
            {
                l = mid +1;
            }
            else if(ar[row][mid] == 1)
            {
                res = mid;
                r = mid -1;
            }
        }
        
        return res;
    }
}