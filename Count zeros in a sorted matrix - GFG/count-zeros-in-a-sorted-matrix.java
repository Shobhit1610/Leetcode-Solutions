//{ Driver Code Starts
import java.util.*;



class Count_0_In_Sorted_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new GfG().countZeros(arr, n));
		t--;
		}
	}
}
// } Driver Code Ends


class GfG
{
    /*you are required to complete this method*/
    int countZeros(int ar[][], int N)
    {
        int countOfZeroes = 0;
        
        int previousRowTransitionPoint = ar[0].length-1;
        for(int i=0;i<ar.length;i++)
        {
            if(previousRowTransitionPoint < 0)
                break;
            
            // Here transition point returns last index of 0    
            int transitionPoint = findTransitionPoint(ar,i,0,previousRowTransitionPoint);
            
            if(transitionPoint == -1)
            {
                countOfZeroes += previousRowTransitionPoint + 1;
            }
            else
            {
                countOfZeroes += transitionPoint;
                previousRowTransitionPoint = transitionPoint - 1;
            }
        }
        
        return countOfZeroes;
    }
    
    int findTransitionPoint(int[][] ar,int row,int l, int r)
    {
        int res = -1;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if(ar[row][mid] == 0)
            {
                l = mid + 1;
            }
            else if(ar[row][mid] == 1)
            {
                res = mid ;
                r = mid - 1;
            }
        }
        
        return res;
    }
}