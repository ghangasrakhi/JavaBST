import java.util.*;
import java.io.*;
public class test
{
	public static void main(String[] args)
	{
		HashTableSC sc = new HashTableSC();
		MyNode n1 = new MyNode("aa");
		MyNode n2 = new MyNode("aba");
		MyNode n3 = new MyNode("dsa");
		MyNode n4 = new MyNode("ab");
		MyNode n5 = new MyNode("w");
		sc.insert(n1);
		sc.insert(n3);
		sc.insert(n2);
		sc.insert(n4);
		sc.insert(n5);
		Helper.findNeighbours(n1,sc);
		PrintWriter p = new PrintWriter(System.out,true);
		System.out.println(sc.getNumElements());
		sc.displayElements(p);
	}
}
