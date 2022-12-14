//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        
        int maxSum = Integer.MIN_VALUE;
        
        int[] prefixSum = new int[C];
        
        for(int startRow=0;startRow<R;startRow++)
        {
            Arrays.fill(prefixSum,0);
            
            for(int rowIndex=startRow;rowIndex<R;rowIndex++)
            {
                for(int colIndex = 0;colIndex<C;colIndex++)
                {
                    prefixSum[colIndex] = prefixSum[colIndex] + M[rowIndex][colIndex];    
                }
                
                maxSum = Math.max(maxSum,kadane(prefixSum));
            }
            
        }
        
        return maxSum;
    }
    
    int kadane(int[] nums)
    {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] + currentSum >= nums[i])
                currentSum += nums[i];
            else
                currentSum = nums[i];
            
            maxSum = Math.max(maxSum,currentSum);    
        }
        
        return maxSum;
    }
};