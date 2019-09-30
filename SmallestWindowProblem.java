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
	        String str = bf.readLine().trim();
	        String patr = bf.readLine().trim();
	        
	        if(patr.length() > str.length())
	        {
	            System.out.println(-1);
	            continue;
	        }
	        
	        HashMap<Character, Integer> windowMap = new HashMap<Character, Integer>();
	        HashMap<Character, Integer> requiredMap = new HashMap<Character, Integer>();
	        
	        for(int i=0 ; i<patr.length() ; i++)
	        {
	            if(!requiredMap.containsKey(patr.charAt(i)))
	                requiredMap.put(patr.charAt(i), 1);
	            else
	                requiredMap.put(patr.charAt(i), requiredMap.get(patr.charAt(i)) + 1);
	        }
	        
	        int left = 0, right = 0;
	        int toMatch = requiredMap.size();
	        int matched = 0;
	        int min = Integer.MAX_VALUE;
	        String res = "";
	        
	        while(right < str.length())
	        {
	            char rightChar = str.charAt(right);
	            if(!windowMap.containsKey(rightChar))
	                windowMap.put(rightChar, 1);
	            else
	                windowMap.put(rightChar, windowMap.get(rightChar) + 1);
	            
	            if(requiredMap.containsKey(rightChar))
	                if(requiredMap.get(rightChar) == windowMap.get(rightChar))
	                    matched++;
	            
	            while(toMatch == matched && left <= right)
	            {
	                char leftChar = str.charAt(left);
	                int windowSize = right - left + 1;
	                
	                if(windowSize < min)
	                {
	                    min = windowSize;
	                    res = str.substring(left, right + 1);
	                }
	                
	                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
	                if(requiredMap.containsKey(leftChar))
	                    if(windowMap.get(leftChar) < requiredMap.get(leftChar))
	                        matched--;
	                left++;
	                
	            }
	            right++;
	        }
	        if(min == Integer.MAX_VALUE)
	            System.out.println(-1);
	        else
	            System.out.println(res);
	    }
	}
}
