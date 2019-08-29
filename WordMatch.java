import java.io.*;
import java.util.*;

public class WordMatch
{	
	private ArrayList<MyNode>  list = new ArrayList<MyNode>();
	
	private HashTableSC WordList;
	int numbers;
	
	public static void main(String[] args) throws Exception
	{
		WordMatch wm = new WordMatch();
		wm.run();
	}	
	public void run( ) throws Exception
	{
		WordList = new HashTableSC();
		//read files
		loadData("t1-pp.txt");
		loadData("t2-dic.txt");
		loadData("t3-BigWordList.txt");
		loadData("t5-wp.txt");
		loadData("t4-bb.txt");
		//System.out.println("here");
		
		PrintWriter p = new PrintWriter("results.txt");
		//System.out.println(numbers);
		list = WordList.sortsc();
		for(MyNode s:list)
		{
			p.println(s);
		}
		//WordList.displayElements(p);
		
		
			System.out.println(WordList.search("conversations"));
			System.out.println(WordList.getNumElements());
			System.out.println(WordList.gettableSize());
			System.out.println(WordList.getLoadFactor());
		/*Tests
		// ma? : ? is the last letter
		Helper.match("ma?",lists,p);	
		
		// ?ee : ? is the first letter
		Helper.match("?ee",lists,p); 	
		
		//m?p : ? is in the middle.
		Helper.match("m?p",lists,p);
		
		//?o? : more than one ? in the word
		Helper.match("?o?",lists,p); 
		
		//mr*: * is the last letter
		Helper.match("mr*",lists,p); 
		
		//Mr*: M is a capital letter
		Helper.match("Mr*",lists,p); 
		
		//*t : * is the first letter
		Helper.match("*t",lists,p);
		
		//*hi* : 2 * in the word
		Helper.match("*hi*",lists,p);
		
		//?ear* : ? and * in the word
		Helper.match("?ear*",lists,p);
		
		//??a : no match pattern
		Helper.match("??a",lists,p);
		*/
		//p.close();
	}
	public void loadData(String fileName) throws IOException
	{
		MyNode node = new MyNode("");
		FileReader file = new FileReader(fileName);
		BufferedReader br = new BufferedReader(file);
		String line;
		//read file line by line
		while((line = br.readLine()) != null)
		{   
			line = line.toLowerCase();
			line = line.replaceAll("[(0-9)\".,?!;*-:\\[\\]'~%#$=]","");// remove symbols
			//System.out.println(line);
			String[] words = line.split(" ");
			//numbers += words.length;
			for(String s:words)
			{	if(s.length() !=0)
				{
				node = new MyNode(s);
				
				boolean found = (WordList.search(s))!= null;
				if(found == false)//it is a new word, add it to list.
				{
					Helper.findNeighbours(node, WordList);
					WordList.insert(node);	
				}
				else// not new word, add counter.
				{
					WordList.search(s).addCounter();
				}
				}
			}
		}
		br.close();
	}
	
}
