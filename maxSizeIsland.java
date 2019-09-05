import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    static int check(int arr[][], int i, int j, int n, int m)
    {
        if(i < 0 || i >=n || j < 0 || j >= m)
            return 0;
        if(arr[i][j] == 1)
        {
            arr[i][j] = 0;
            
            return check(arr, i, j+1, n, m) + check(arr, i, j-1, n, m) + check(arr, i+1, j, n, m) + check(arr, i-1, j, n, m) + check(arr, i+1, j+1, n, m) + check(arr, i+1, j-1, n, m) + check(arr, i-1, j+1, n, m) + check(arr, i-1, j-1, n, m) + 1;
        }
        return 0;
    }
	public static void main (String[] args) throws Exception
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int arr[][] = new int[n][m];
	        for(int i=0 ; i<n ; i++)
	            for(int j=0 ; j<m ; j++)
	                arr[i][j] = sc.nextInt();
	                
	        int maxCount = Integer.MIN_VALUE;
	        int count = 0;
	        for(int i=0 ; i<n ; i++)
	        {
	            for(int j=0 ; j<m ; j++)
	            {
	                count = check(arr, i, j, n, m);
	                if(count > maxCount)
	                    maxCount = count;
	            }
	        }
	        System.out.println(maxCount);
	    }
	}
}
