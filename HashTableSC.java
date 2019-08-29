/**
This class represents a hash table using linear probing
whose elements are instances of the MyNode class.
*/
import java.io.PrintWriter;
import java.util.*; 

public class HashTableSC
{
   /*private MyNode[] MyNodeArray;
   private int numberOfElements;
   	
   private final double loadFactorBound = 0.5;
   */
   private ArrayList<LinkedList<MyNode>> MyNodeTable;
   public static final double LOAD_FACTOR_BOUND = 7;
   public static final int INITIAL_LENGTH = 11;
   private int numberOfElements;
   private int tableSize;
   public ArrayList<MyNode> list = new ArrayList<MyNode>();
   //private MyNode nonMyNode = new MyNode("","","","","",-1);
   // to mark a previously occupied cell as now being empty

   public HashTableSC()
   
   {
	  MyNodeTable = new ArrayList<LinkedList<MyNode>>();
	  tableSize = getPrime(INITIAL_LENGTH);
	  for(int i = 0; i< tableSize;i++)
	  {
		  MyNodeTable.add(new LinkedList<MyNode>());
	  }
	  numberOfElements = 0;
   }

   private int hashFunction(String key)
   {
      int hashIndex = 0;
	  for(int i = 0; i< key.length();i++)
	  {
		  hashIndex= 31*hashIndex +key.charAt(i);
	  }
	  hashIndex = Math.abs(hashIndex) % tableSize;
	  return hashIndex;
   }

   public boolean insert(MyNode newMyNode)
   {	//exception: wrap around!
	  
	  
      if(getLoadFactor() >= LOAD_FACTOR_BOUND)
	  {
		  rehash();
	  }
	  
	  
		String key = newMyNode.getKey();
		int location = hashFunction(key);
		MyNodeTable.get(location).addLast(newMyNode);
		numberOfElements++;
		return true;
	  
	 
   }

	public MyNode search(String key)
   {
   		int location = hashFunction(key);
		LinkedList<MyNode> bucket = MyNodeTable.get(location);
		int bucketSize = bucket.size();
		
		for(MyNode s: bucket)
		{
			if(s.getKey().equalsIgnoreCase(key))
			{
				return s;
			}
			
		}
		return null;
		
	}

   public boolean remove(String key)
   {
      int location = hashFunction(key);
	  LinkedList<MyNode> bucket = MyNodeTable.get(location);
	  int bucketSize = bucket.size();
	  
	  for(int i = 0; i< bucketSize;i++)
	  {
		  if(bucket.get(i).getKey().equalsIgnoreCase(key))
		  {
			  bucket.remove(i);
			  numberOfElements--;
			  return true;
		  }
	  }
	  return false;
	  
	  
	}
public ArrayList<MyNode> sortsc()
{   
	for(int i = 0; i< tableSize; i++)
	  {
		  LinkedList<MyNode> bucket = MyNodeTable.get(i);
		  if(bucket.size() != 0)
		  {
			  for(MyNode s: bucket)
			  {
				  list.add(s);
			  }
		  }
	  }
	  Sorter.quickSort(list);
	  return list;
}
   public void displayElements(PrintWriter p)
   { 
      
	  for(int i = 0; i< tableSize; i++)
	  {
		  LinkedList<MyNode> bucket = MyNodeTable.get(i);
		  if(bucket.size() != 0)
		  {
			  for(MyNode s: bucket)
			  {
				  p.println(s.toString());
			  }
		  }
	  }
   }


	public int gettableSize()
   {
      return tableSize;
   }
   public int getNumElements()
   {
      return numberOfElements;
   }

   public double getLoadFactor()
   {
      return numberOfElements/(double)tableSize;
	  
   }

   private void rehash()
   {
	  
	  ArrayList<LinkedList<MyNode>> oldMyNodeTable = MyNodeTable;
	  int oldTableSize = tableSize;
	  
	  tableSize = getPrime(oldTableSize*2);
	  MyNodeTable =new ArrayList<LinkedList<MyNode>>();
	  
	  
	  for(int i = 0; i<tableSize;i++)
	  {
		  
		  MyNodeTable.add(new LinkedList<MyNode>());
	  }
	  
	  for(int i = 0; i< oldTableSize;i++)
	  {
		 
		 LinkedList<MyNode> bucket = oldMyNodeTable.get(i);
		  for(MyNode s : bucket)
		  {
			  insert(s);
		  }
		  
	  }
     
   }

   private int getPrime(int integer)
   {
      while (!isPrime(integer))
      {
         integer++;
      }
      return integer;
   }

   private boolean isPrime(int integer)
   {
      for(int n = 2; n * n <= integer; n++)
      {
			if(integer % n == 0)
			{
				return false;
			}
		}

		return true;
	}
}

