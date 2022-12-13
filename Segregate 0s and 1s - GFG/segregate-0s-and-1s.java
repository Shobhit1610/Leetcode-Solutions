//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            new Solution().segregate0and1(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    void segregate0and1(int[] nums, int n) {
        int i = 0;
        int j = 0;
        

        // Apply Partition Algo of Quick Sort
        while(j<nums.length)
        {
            if(nums[j] == 0)
            {
                swap(nums,i,j);
                i++;
                j++;
            }
            else if(nums[j] == 1)
            {
                j++;
            }
            
        }
    }
    
    void swap(int[] ar,int i,int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}
