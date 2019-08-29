import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Helper <T extends Comparable<T>>
{
	public static void findNeighbours(MyNode s1,HashTableSC sc)
	{
		String word = s1.getKey();// word = "CAT" 
		StringBuilder sb = new StringBuilder(word);
		int length = word.length();
		
		
		for(int i=0;i<length;i++) // from 0-2 length
		{
			//System.out.println("i= "+i);
			for(char c = 'a'; c<='z';c++) //25*5000
			{	sb = new StringBuilder(word);
				String n=String.valueOf(c); 
				String temp = sb.replace(i,i+1,n).toString(); 
				//System.out.println(temp);
				
				if(sc.search(temp) != null)
				{
					MyNode s = sc.search(temp);
					s1.addNeighbours(s.getKey());
				    s.addNeighbours(s1.getKey());
				}
			}
		}
		
		/*int counter = 0;
		//retrieve the word list
		for(MyNode s:lists)
		{
			if(s1.getSize() == s.getSize())// length of two word are same
			{
				counter = 0;				
				//find differences
				for(int i = 0; i<s1.getSize();i++)
				{				
					if(s1.getWord().charAt(i) != s.getWord().charAt(i))
					{
						counter++;						
					}
				}
				if(counter ==1)//add neighbour for each two word
				{						
					s1.addNeighbours(s.getWord());
				    s.addNeighbours(s1.getWord());
				}
			}
		}
		*/
	}
	
	public static void match(String pattern,ArrayList<MyNode> lists,PrintWriter writer)
	{	
		ArrayList<MyNode> result = new ArrayList<MyNode>();
		String p = StrBuilder(pattern);
		//sort the list
		Sorter.quickSort(lists);			
		boolean found =false;
		Pattern p1 = Pattern.compile(p); 
		// pattern, matcher,and find
		for(MyNode s:lists)
		{			
			Matcher m1 = p1.matcher(s.getKey());
			if(m1.find())
			{
				found = true;
				result.add(s);
			}
		}
		System.out.println("The pattern:\n"
						+"    "+pattern);
		writer.println("The pattern:\n"
						+"    "+pattern);
		if(found)
		{
			System.out.println("    "+"may result in the output:");
			writer.println("    "+"may result in the output:");
			for(MyNode e : result)
			{
				System.out.println("    "+e.getKey() +" "+ e.getCounter());
				writer.println("    "+e.getKey() +" "+ e.getCounter());
			}
		}
		if(found ==false)
		{
			System.out.println("No words in the lexicon match the pattern");
			writer.println("No words in the lexicon match the pattern");
		}				
	}
	public static String StrBuilder(String pattern)
	{
		pattern = pattern.toLowerCase();
		StringBuilder sb = new StringBuilder(pattern);				
		char first = pattern.charAt(0);
		char last = pattern.charAt(pattern.length()-1);
		//add ^ at the start
		if(first == '?' || Character.isLetter(first))
		{
			sb.insert(0,'^');			
		}
		//add * at the end
		if(last == '?' || Character.isLetter(last))
		{
			sb.append('$');
		}
		//rebulid the input pattern
		String p1 = sb.toString().replaceAll("\\?",".");
		p1 = p1.replaceAll("\\*","[a-z]{0,}");		
		
		return p1;		
	}		
}
