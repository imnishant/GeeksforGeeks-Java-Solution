import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    static int i = 0;
    static boolean printLeaf(int arr[], int min, int max, StringBuffer sb)
    {
        if(i >= arr.length)
            return false;
        if(arr[i] > min && arr[i] < max)
        {
            i++;
            boolean left = printLeaf(arr, min, arr[i-1], sb);
            boolean right = printLeaf(arr, arr[i-1], max, sb);
            if(!left && !right)
                sb.append(arr[i-1] + " ");
            return true;
        }
        return false;
    }
	public static void main (String[] args) throws Exception
	{
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(bf.readLine());
	    while(t-- > 0)
	    {
	        i = 0;
	        int n = Integer.parseInt(bf.readLine());
	        int arr[] = new int[n];
	        String s[] = bf.readLine().trim().split(" ");
	        for(int i=0 ; i<n ; i++)
	            arr[i] = Integer.parseInt(s[i]);
	        StringBuffer sb = new StringBuffer();
	        printLeaf(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, sb);
	        System.out.print(sb + "\n");
	    }
	}
}
