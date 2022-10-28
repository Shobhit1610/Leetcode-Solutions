//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
           //Make interval array
           Interval[] intervals = new Interval[n];
           for(int i=0;i<n;i++)
           {
               intervals[i] = new Interval(start[i],end[i]);
           }
           
           //Sort 
           Arrays.sort(intervals,(x,y) -> {
               return x.end==y.end ? x.start - y.start : x.end-y.end;
           });
           
           int limitEndTime = 0;
           int cnt = 0;
           
           for(int i=0;i<intervals.length;i++)
           {
               if(limitEndTime < intervals[i].start)
               {
                   cnt++;
                   limitEndTime = intervals[i].end;
               }
           }
           
           return cnt;
           
           
    }
    
    
}

class Interval
{
    int start;
    int end;
    
    public Interval(int s,int e)
    {
        start = s;
        end =e;
    }
}
