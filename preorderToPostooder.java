import java.util.*;
import java.lang.*;
import java.io.*;
class Node
{
    int data;
    Node left;
    Node right;
    Node(int d)
    {
        data = d;
    }
}
class Index
{
    int index;
    Index(int i)
    {
        index = i;
    }
}
class GFG
{
    static int index = 0;
    static void postorder(int arr[], int min, int max, Index index)
    {
        if(index.index == arr.length)
            return;
        if(arr[index.index] < min || arr[index.index] > max)
            return;
        
        int val = arr[index.index];
        index.index++;
        postorder(arr, min, val, index);
        postorder(arr, val, max, index);
        System.out.print(val + " ");
    }
	public static void main (String[] args) throws Exception
	{
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(bf.readLine());
	    while(t-- > 0)
	    {
	        int n = Integer.parseInt(bf.readLine());
	        String s[] = bf.readLine().trim().split(" ");
	        int arr[] = new int[n];
	        for(int i=0 ; i<n ; i++)
	            arr[i] = Integer.parseInt(s[i]);
	        
	        postorder(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, new Index(0));
	        System.out.println();
	    }
	}
}
