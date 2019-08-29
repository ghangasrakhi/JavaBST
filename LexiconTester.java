import java.io.*;
import java.util.*;

public class LexiconTester
{
	private BinarySearchTree<MyNode> bst;
	private ArrayList<MyNode> lists;
	 
	
	public static void main(String[] args) throws Exception
	{
		LexiconTester lt = new LexiconTester();
		lt.run();
	}
	public void run( ) throws Exception
	{
		bst = new BinarySearchTree<MyNode>();
		lists = new ArrayList<MyNode>();

		loadData("sample1-pp.txt");
		loadData("sample2-zoo.txt");
		
		//add words to Binary search tree
		for(MyNode s: lists)
		{
			bst.insertElement(s);
		}
		
		//write results to txt 
		PrintWriter out = new PrintWriter("sample3-wordlist.txt");
		bst.displayElements(out);
		out.close();						
	}
	// read two files
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
			line = line.replaceAll("[(0-9)\".,?]",""); // remove symbols
			String[] words = line.split(" ");
			for(String s:words)
			{	if(s.length() !=0)
				{
				node = new MyNode(s);
				int index = -1;
				for(int i = 0; i<lists.size(); i++)
				{
					if((lists.get(i).getWord()).equals(node.getWord()))
					{
						index =i;
					}
				}
				//it is a new word, add it to list.
				if(index == -1)
				{
					Helper.findNeighbours(node, lists);
					lists.add(node);
				}
				else// not new word, add counter.
				{
					lists.get(index).addCounter();
				}
				}
			}
		}
		br.close();
	}
}
