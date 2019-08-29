public class BSTNode<T extends Comparable<T> >
{
   private BSTNode<T> leftChild;
   private BSTNode<T> rightChild;
   private T data;

   public BSTNode(T data)
   {
	   this.data = data;
	   leftChild = null;
	   rightChild = null;
   }

   public void setLeftChild(BSTNode<T> leftChild)
   {
		this.leftChild = leftChild;   
   }

   public void setRightChild(BSTNode<T> rightChild)
   {
	   this.rightChild = rightChild;
   }

   public BSTNode<T> getLeftChild()
   {
	   return leftChild;
   }
   
   public BSTNode<T> getRightChild()
   {
	   return rightChild;
   }

   public void setData(T data)
   {
	   this.data = data;
   }

   public T getData()
   {
	   return data;
   }
}
