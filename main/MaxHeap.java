package project4;

import java.util.Arrays;

/**
 * A class that implements the ADT maxheap by using an array.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class MaxHeap<T extends Comparable<? super T>>
      implements MaxHeapInterface<T> {
   private T[] heap; // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;

   public MaxHeap() {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor

   public MaxHeap(int initialCapacity) {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);

      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor

   /**
    * @author Frank M. Carrano, Timothy M. Henry
    * @version 5.0
    */
   public MaxHeap(T[] entries) {
      this(entries.length); // Call other constructor
      lastIndex = entries.length;
      // Assertion: integrityOK = true

      // Copy given array to data field
      for (int index = 0; index < entries.length; index++)
         heap[index + 1] = entries[index];

      // Create heap
      for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
         reheap(rootIndex);
   } // end constructor

      /**
     * checks boolean private field, throws IllegalStateException if false
     */
    public void checkIntegrity()
    {
        if (!integrityOK)
            throw new IllegalStateException("Heap not initialized");
    }

   public void add(T newEntry) {
      checkIntegrity(); // Ensure initialization of data fields
      int newIndex = lastIndex + 1;
      int parentIndex = newIndex / 2;
      while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)) {
         heap[newIndex] = heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
      } // end while

      heap[newIndex] = newEntry;
      lastIndex++;
      ensureCapacity();
   } // end add

       /**
     * Ensures capacity for next addition by doubling heap capacity 
     * if next last index is greater than capacity
     */
    private void ensureCapacity()
    {
        // If the next index we use will be out of bounds for the array, expand:
        if ((lastIndex + 1) > (heap.length - 1))
        {
            checkCapacity(2 * lastIndex);
            heap = Arrays.copyOf(heap, 2 * lastIndex + 1); 
        }
    }

    private void checkCapacity(int index) throws IndexOutOfBoundsException
    {
        if(index > MAX_CAPACITY)
            throw new IndexOutOfBoundsException("Requested capacity " + index + " exceeds MAX_CAPACITY of " + MAX_CAPACITY);
    }

   public T removeMax() {
      checkIntegrity(); // Ensure initialization of data fields
      T root = null;

      if (!isEmpty()) {
         root = heap[1]; // Return value
         heap[1] = heap[lastIndex]; // Form a semiheap
         lastIndex--; // Decrease size
         reheap(1); // Transform to a heap
      } // end if

      return root;
   } // end removeMax

   public T getMax() {
      checkIntegrity();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   public boolean isEmpty() {
      return lastIndex < 1;
   } // end isEmpty

   public int getSize() {
      return lastIndex;
   } // end getSize

   public void clear() {
      checkIntegrity();
      while (lastIndex > -1) {
         heap[lastIndex] = null;
         lastIndex--;
      } // end while
      lastIndex = 0;
   } // end clear

   // Private methods
   // . . .

   // @author Frank M. Carrano, Timothy M. Henry
   // @version 5.0
   // Precondition: checkIntegrity has been called.
   private void reheap(int rootIndex) {
      boolean done = false;
      T orphan = heap[rootIndex];
      int leftChildIndex = 2 * rootIndex;

      while (!done && (leftChildIndex <= lastIndex)) {
         int largerChildIndex = leftChildIndex; // Assume larger
         int rightChildIndex = leftChildIndex + 1;

         if ((rightChildIndex <= lastIndex) &&
               heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
            largerChildIndex = rightChildIndex;
         } // end if

         if (orphan.compareTo(heap[largerChildIndex]) < 0) {
            heap[rootIndex] = heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex;
         } else
            done = true;
      } // end while

      heap[rootIndex] = orphan;
   } // end reheap
   
   /**
    * Creates a heap using the optimal method
    * @param entries
    * @return numberOfSwaps
    */
   public int Optimal(T[] entries){
      // optimal = true;
      this(entries.length);
      assert initialized = true;
      
      // copy given array to data field
      for(int index = 0; index < entries.length; index++){
         heap[index + 1] = entries[index];
      }
      
      // Create heap
      for(int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--){
         reheap(rootIndex);
      }
   } // end Optimal

   /**
    * Creates a heap using sequential insertion
    * @param entries
    * @return numberOfSwaps
    */
   public int sequentialInsertion(T[] entries){
      int numberOfSwaps = 0;
      for(int i = 0; i < entries.length; i++){
         this.add(entries[i]);
         numberOfSwaps += 1;
      }
      return numberOfSwaps;
   } // end sequentialInsertions

} // end MaxHeap