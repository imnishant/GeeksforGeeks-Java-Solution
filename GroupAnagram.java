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
	        int n = Integer.parseInt(bf.readLine());
	        String s[] = bf.readLine().trim().split(" ");
	        HashMap<String, Integer> hm = new HashMap<String, Integer>();
	        for(int i=0 ; i<n ; i++)
	        {
	            int arr[] = new int[26];
	            for(int j=0 ; j<s[i].length() ; j++)
	                arr[s[i].charAt(j) - 'a']++;
	            
	            String res = "";
	            for(int j=0 ; j<26 ; j++)
	                res += arr[j];
	            if(!hm.containsKey(res))
	                hm.put(res, 1);
	            else
	            {
	                int count = hm.get(res);
	                hm.remove(res);
	                hm.put(res, count+1);
	            }
	        }
	        String s1 = "";
	        Set set = hm.entrySet();
	        Iterator it = set.iterator();
	        while(it.hasNext())
	        {
	            Map.Entry me = (Map.Entry) it.next();
	            s1 = me.getValue() + " " + s1;
	        }
	        System.out.println(s1);
	    }
	}
}
