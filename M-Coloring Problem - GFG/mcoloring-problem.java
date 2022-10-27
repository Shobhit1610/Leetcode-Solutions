//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    
    public boolean graphColoring(boolean adjMat[][], int totalColours, int n) {
        
        int[] colorOfNode = new int[n];
        Arrays.fill(colorOfNode,-1);
        
        return DFS(adjMat,totalColours,0,colorOfNode,0);
        
    }
    
    public boolean DFS(boolean adjMat[][],int totalColours,int start,int[] colorOfNode,int index)
    {
        if(index == adjMat.length)
            return true;
            
        for(int i=0;i<totalColours;i++)
        {
            if(canColor(start,i,adjMat,colorOfNode))
            {
                colorOfNode[start] = i;
                if(DFS(adjMat,totalColours,start+1,colorOfNode,index+1))
                {
                    return true;
                }
                colorOfNode[start] = -1;
            }
        }
        return false;
    }
    
    public boolean canColor(int start, int currentColor, boolean[][] adjMat, int[] colorOfNode)
    {
        for(int i=0;i<adjMat[start].length;i++)
        {
            if(adjMat[start][i])
            {
                if(colorOfNode[i] == currentColor)
                    return false;
            }
        }
        
        return true;
    }
    
}