import java.util.*;

public class Sorter
{
   // Generic method to perform gnome sort
   //
   public static <E extends Comparable<E>>
      void gnomeSort(List<E> list)
      {
         int first = 0;
         int last = list.size()-1;

         int pos = first + 1;
         while (true)
         {
            if (pos > last)
            {
               return;					// done
            }
            else if (pos == first)
            {
               pos = first + 1;		// move right
            }
            else if (list.get(pos).compareTo(list.get(pos-1)) >= 0)
            {
               pos++; 					// move right

            }
            else // list.get(pos).compareTo(list.get(pos-1)) < 0
            {
               swap(list, pos, pos-1);
               pos--;					// swap and move left
            }
         }
      }

   // Swap elments at positions i and j
   //
   private static<E extends Comparable<E>>
      void swap(List<E> list, int i, int j)
      {
         E temp = list.get(i);
         list.set(i, list.get(j));
         list.set(j, temp);
      }
   public static void StringBubbleSort(List<String> list)
   {
      int left = 0;
      int right = list.size() - 1;

      for(int i = right; i>= left +1 ;i--)
      {
         for(int j = left; j<=i-1 ; j++)
         {
            if(list.get(j).compareTo (list.get(j+1))>0)
            {
               swap(list, j ,j+1);
            }
         }
      }
   }

   // Generic method to perform bubble sort
   public static <E extends Comparable<E>> void bubbleSort(List<E> list)
   {
      int left  = 0;
      int right = list.size() - 1;

      for(int i = right; i >= left+1;i--)
      {
         for(int j = left ; j<= i-1;i++)
         {
            if(list.get(j).compareTo(list.get(j+1)) > 0)
            {
               swap(list, j,j+1);
            }
         }
      }
   }

   //insertion sort

   public static <T extends Comparable<T>> void insertElement(List<T> list,int next)
   {
      T value = list.get(next);
      int i = next;
      while(true)
      {
         if(i == 0)
         {
            list.set(0,value);
            return;
         }
         else if (list.get(i-1).compareTo(value)<=0)
         {
            list.set(i , value);
            return;
         }
         else
         {
            list.set(i,list.get(i-1));
            i--;
         }
      }
   }
   public static <T extends Comparable<T>> void insertionSort(List<T> list)
   {
      for(int i = 0; i< list.size();i++)
      {
         insertElement(list, i);
      }
   }

   // Shell Sort
   //Apply insertion sort to one sub-array of gap h, starting from first
   public static <T extends Comparable<T>> void sortGappedSubarray(List<T> list, int h,int first)
   {
      for(int i = first+h; i< list.size(); i++)
      {
         insertElement(list, h);
      }
   }
   // H-Sort the array. That is, sort all sub-arrays of gap h
 /*  public static <T extends Comparable<T>> void hsort(List<T> list,int h)
   {
      for(int i = 0; i< list.size(); i++)
      {
         sortGappedSubarray();
      }
   }
  */ 
   // Generic method to perform selection sort

   // TEST
   public static void main(String[] args)
   {
      List<String> list = new ArrayList<String>();
      list.add("b");
      list.add("a");
      list.add("c");

      quickSort(list);
      System.out.println(list);

   }

   // Merge Sort

   public static <T extends Comparable<T>> void mergeSort(List<T> list, int first,int last)
   {
      if(last - first < 10)
      {
        insertionSort(list);
         return;
      }
      else
      {
         int mid = (first + last )/2;
         mergeSort(list, first ,mid);
         mergeSort(list,mid+1,last);
         merge(list,first,mid,last);
      }
   }
   public static <T extends Comparable<T>> void merge(List<T> list, int firstleft, int lastleft,int lastright)
   {
      int firstright = lastleft +1;

      List<T> temp = new ArrayList<T>(lastright - lastleft + 1);
      int leftindex = firstleft;
      int rightindex = firstright;
      int index = 0;

      // copy the smaller elements from the left and right segment
      // // to the temp list until one segment is exhausted
      while(leftindex <= lastleft && rightindex <= lastright)
      {
         if(list.get(leftindex).compareTo(list.get(rightindex))<0)
         {
            temp.add(list.get(leftindex++));
            index++;
         }
         else
         {
            temp.add(list.get(rightindex++));
            index++;
         }
      }
      // copy the remaining elements to the temp list
      while(leftindex <= lastleft)
      {
         temp.add(index, list.get(leftindex++));
         index++;
      }
      while(rightindex <= lastright)
      {
         temp.add(index, list.get(rightindex++));
         index++;
      }
      //copy the elements in the temp list to the original list
      //not always from index 0!
      for(index = 0; index <= list.size(); index++)
      {
         list.set(firstleft + index, temp.get(index));
      }
   }
   
   public static <T extends Comparable<T>> void quickSort(List<T> list)
   {
      quickSort(list, 0 , list.size()-1);
   }
   public static <T extends Comparable<T>> void quickSort(List<T> list,int left,int right)
   {

      if(left<right)
      {
       int pivotIndex = partition(list,left,right);
       quickSort(list, left, pivotIndex -1);
       quickSort(list, pivotIndex+1, right);  
      }
   }
   public static <T extends Comparable<T>> int partition(List<T> list,int left, int right)
   {
      int mid = (left+right)/2;
      T pivot = list.get(mid);
      swap(list,mid,right);

      while(left<right)
      {
         while (left<right && list.get(left).compareTo(pivot)<=0)
         {
            left++;
         }
         if(left<right)
         {
            swap(list,left,right);
            right--;
         }
         while(right > left && list.get(right).compareTo( pivot) >=0)
         {
            right--;
         }
         if(right > left)
         {
            swap (list, right, left);
            left++;
         }
      }
      return left;

   }

}

