//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sorting arr in descending order on basis of profit
        Arrays.sort(arr,(x,y) -> y.profit - x.profit); 
        
        //Time until all jobs become invalid
        int maxDeadline = 0;
        for(int i=0;i<arr.length;i++)
        {
            maxDeadline = Math.max(maxDeadline,arr[i].deadline);
        }
        
        //Slot of one unit in timeline
        boolean[] slots = new boolean[maxDeadline];
        int jobsCompleted = 0;
        int maxProfit = 0;
        
        //Take job one by one
        for(int i=0;i<arr.length;i++)
        {
            //Find a place to keep it starting from its deadline
            for(int j=arr[i].deadline-1;j>=0;j--)
            {
                // if got empty slot then put the job here and iterate
                if(slots[j] == false)
                {
                    jobsCompleted++;
                    maxProfit = maxProfit + arr[i].profit;
                    slots[j] = true;
                    
                    break;
                }
            }
            
        }
        
        return new int[]{jobsCompleted,maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/