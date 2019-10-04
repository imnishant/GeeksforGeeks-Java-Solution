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
	        for(int i=0 ; i<s.length ; i++)
	        {
	            if(!hm.containsKey(s[i]))
	                hm.put(s[i], 1);
	            else
	                hm.put(s[i], hm.get(s[i]) + 1);
	        }
	        
	        LinkedList<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(hm.entrySet());
	        
	        Comparator<Map.Entry<String,Integer>> comp = new Comparator<Map.Entry<String,Integer>>(){
	            
	            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2)
	            {
	                if(o1.getValue() == o2.getValue())
	                    return o1.getKey().compareTo(o2.getKey());
	                return o2.getValue() - o1.getValue();
	            }
	        };
	        Collections.sort(list, comp);
	        Map.Entry me = list.get(0);
	        System.out.println(me.getKey() + " " + me.getValue());
	        
	    }
	}
}
