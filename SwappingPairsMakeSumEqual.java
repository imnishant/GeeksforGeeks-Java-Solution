import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main (String[] args) throws Exception
	{
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(bf.readLine());
	    while(t-- > 0)
	    {
	        String s[] = bf.readLine().trim().split(" ");
	        int n = Integer.parseInt(s[0]);
	        int m = Integer.parseInt(s[1]);
	        
	        int sum1 = 0, sum2 = 0;
	        
	        s = bf.readLine().trim().split(" ");
	        int arr1[] = new int[n];
	        for(int i=0 ; i<n ; i++)
	        {
	            arr1[i] = Integer.parseInt(s[i]);
	            sum1 += arr1[i];
	        }
	        
	        s = bf.readLine().trim().split(" ");
	        int arr2[] = new int[m];
	        for(int i=0 ; i<m ; i++)
	        {
	            arr2[i] = Integer.parseInt(s[i]);
	            sum2 += arr2[i];   
	        }
	        
	        int diff = Math.abs(sum1 - sum2);
	        if(diff == 0)
	        {
	            System.out.println(1);
	            continue;
	        }   
	        if(diff % 2 != 0)
	        {
	            System.out.println(-1);
	            continue;
	        }
	        int arr[] = sum1 > sum2 ? arr1 : arr2;
	        HashSet<Integer> hs = new HashSet<Integer>();
	        for(int i=0 ; i< arr.length ; i++)
	           hs.add(arr[i]);
	        
	        arr = sum1 < sum2 ? arr1 : arr2;
	        
	        int flag = 0;
	        for(int i=0 ; i<arr.length ; i++)
	        {
	            if(hs.contains(arr[i] + diff/2))
	            {
	                System.out.println(1);
	                flag = 1;
	                break;
	            }
	        }
	        if(flag == 0)
	            System.out.println(-1);
	    }
	}
}
