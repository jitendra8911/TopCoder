import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Yahtzee
{
  public int maxPoints(int[] toss)
  {
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    
    //initialize hashmap
    for(int i=0;i<toss.length;i++)
    {
     int total;
     if(map.containsKey(toss[i]))
     {
       total=(Integer)map.get(toss[i])+toss[i];
     }
     else
     {
       total=toss[i];
     }
     map.put(toss[i],total);
    }
    
    //check for max points
    
    Set set=map.entrySet();
    Iterator iterator=set.iterator();
    Map.Entry entry;
    int max=Integer.MIN_VALUE;
    while(iterator.hasNext())
    {
    	entry=(Map.Entry) iterator.next();
    	int val=(Integer)entry.getValue();
    	if(max<val)
    	{
    		max=val;
    	}
    }
    return max;
  }
}