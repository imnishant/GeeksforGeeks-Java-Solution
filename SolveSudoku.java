import java.util.*;
import java.io.*;
class DataStructure
{
    static boolean check(int mat[][], int i, int j, int num)
    {
        for(int t=0 ; t<9 ; t++)
        {
            if(mat[i][t] == num || mat[t][j] == num)
            	return false;
            
        }
        int row = i - i % 3;
        int col = j - j % 3;
        for(int m=0 ; m<3 ; m++)
        	for(int n=0 ; n<3 ; n++)
        		if(mat[m+row][n+col] == num)
        			return false;
        return true;
    }
    static boolean solve(int mat[][], Stack<ArrayList<Integer>> st)
    {
    	if(st.size() == 0)
    		return true;
        ArrayList<Integer> al = st.pop();
        int i = al.get(0);
        int j = al.get(1);
        int num = 1;
        while(num < 10)
        {
        	if(check(mat, i, j, num))
        	{
        		mat[i][j] = num;
        		if(solve(mat, st))
        			return true;
        		mat[i][j] = 0;
        		
        	}	
        	num++;
        }
        st.push(al);
        return false;
    }
	public static void main (String[] args) throws IOException
	{
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(bf.readLine());
	    while(t-- > 0)
	    {
	        Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
	        String s[] = bf.readLine().trim().split(" ");
	        int mat[][] = new int[9][9];
	        for(int i=0 ; i<9 ; i++)
	        {
	        	
	            for(int j=0 ; j<9 ; j++)
	            {
	                mat[i][j] = Integer.parseInt(s[i*9+j]);
	                if(mat[i][j] == 0)
	                {
	                    ArrayList<Integer> al = new ArrayList<Integer>();
	                    al.add(i);
	                    al.add(j);
	                    st.push(al);
	                }
	            }
	        }
	        if(!solve(mat, st))
	        	System.exit(0);
	        for(int i=0 ; i<9 ; i++)
	        {
	            for(int j=0 ; j<9 ; j++)
	            	System.out.print(mat[i][j] + " ");
	            System.out.println();
	        }
	    }
	}
}
