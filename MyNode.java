import java.util.*;

public class MyNode implements Comparable<MyNode>
{
   private String word;
   private int counter;
   private ArrayList<String> neighbours;
   

   public MyNode(String word)
   {
      this.word = word;
      counter = 1;
	  neighbours = new ArrayList<String>(); 
   }
   
   public int compareTo(MyNode p)
   {
		int difference = this.word.compareToIgnoreCase(p.word);
		if(difference != 0)
		{
			return difference;
		}
		else
		{
			return 0;
		}					
   }
   public void addCounter()
   {
      counter = counter+1;
   }
   public String getKey()
   {
    return word;  
   }
   public int getCounter()
   {
      return counter;
   }
   public int getSize()
   {
	   return word.length();
   }
   public ArrayList<String> getNeighbours()
   {
	   return neighbours;
   }
   public void addNeighbours(String word)
   {
	   neighbours.add(word);
   }
   public String toString()
   {
	   Sorter.quickSort(neighbours);
	  
	   String infor = "";
	   for(String s:neighbours)
	   {
		   infor += s+ " ";
	   }
	   return word + " "+ counter +" [" + infor +  "]";
   }
   
}
