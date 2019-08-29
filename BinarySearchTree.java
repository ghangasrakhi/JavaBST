import java.io.*;

public class BinarySearchTree<T extends Comparable<T> > 
{
   private BSTNode<T> root;

   public BinarySearchTree()
   {
	   root = null;
   }
	
	
   public void displayElements(PrintWriter p) throws IOException
   {
      displaySubtreeInOrder(root, p);
   }

   private void displaySubtreeInOrder(BSTNode<T> localRoot, PrintWriter p) throws IOException
   {
	   if(localRoot != null)
	   {
		   displaySubtreeInOrder(localRoot.getLeftChild(), p);
		   
		   p.println(localRoot.getData());

		   displaySubtreeInOrder(localRoot.getRightChild(), p);
		}
   }

   public void insertElement(T data)
   {
	   BSTNode<T> temp = new BSTNode<T>(data);
	   
	   if(root == null)
	   {
		   root = temp;
		   return;
	   }
	   
	   BSTNode<T> p = root;
	   while(true)
	   {
		   if(data.compareTo(p.getData()) <= 0 && p.getLeftChild() == null)
		   {
			   p.setLeftChild(temp);
			   
			   return;
		   }
		   else if (data.compareTo(p.getData()) > 0 && p.getRightChild() == null)
		   {
			   p.setRightChild(temp);

			   return;
		   }
		   else if (data.compareTo(p.getData()) <= 0)
		   {
			   p = p.getLeftChild();
		   }
		   else
		   {
			   p = p.getRightChild();
		   }
	   }
   }
   
   public T search(T data)
   {
	   
	   
	   if(root == null)
	   {
		   return null;
	   }
	   else
	   {
	   BSTNode<T> p = root;
	   
	   while(true)
	   {
		   
		   if(p == null)
		   {
			   return null;
		   }
		   else if(data.compareTo(p.getData()) ==0)
		   {
			   
			   return data;
		   }
		   else if (data.compareTo(p.getData()) < 0)
		   {
			   p = p.getLeftChild();
		   }
		   else
		   {
			   p = p.getRightChild();
		   }
	   }
	   
	   
	   }
	   
   }
   public T contains(T data)
   {
	  return search(data);
	   
      // This can be implemented iteratively or recursively.  You will
      // need to add a private helper method if using a recursive
      // approach.
   }
   
   public boolean removeElement(T data)
   {
	   
	   return false;
   }
   
}

