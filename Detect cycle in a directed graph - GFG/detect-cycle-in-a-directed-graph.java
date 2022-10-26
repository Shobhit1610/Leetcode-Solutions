//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] visited = new int[V];
        Arrays.fill(visited,-1);
        
        for(int i=0;i<V;i++)
        {
            if(visited[i] == -1)
            {
                if(DFS(adj,visited,i))
                {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean DFS(ArrayList<ArrayList<Integer>> adj, int[] visited, int start)
    {
        if(visited[start] == 0)
            return true;
        if(visited[start] == 1)
            return false;
        
        visited[start] = 0; //Visited in same path PREORDER
        for(Integer nbr : adj.get(start))
        {
            if(DFS(adj,visited,nbr))
            {
                return true;
            }
            
        }
        visited[start] = 1; //Visited in diff path POSTORDER
        
        return false;
    }
}