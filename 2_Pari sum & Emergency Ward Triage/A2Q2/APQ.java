package A2Q2;

import java.util.*;

/**
 * Adaptible priority queue using location-aware entries in a min-heap, based on
 * an extendable array.  The order in which equal entries were added is preserved.
 *
 * @param <E> The entry type.
 */
public class APQ<E> {

    private final ArrayList<E> apq; //will store the min heap
    private final Comparator<E> comparator; //to compare the entries
    private final Locator<E> locator;  //to locate the entries within the queue

    /**
     * Constructor
     * @param comparator used to compare the entries
     * @param locator used to locate the entries in the queue
     * @throws NullPointerException if comparator or locator parameters are null
     */
    public APQ(Comparator<E> comparator, Locator<E> locator) throws NullPointerException {
        if (comparator == null || locator == null) {
            throw new NullPointerException();
        }
        apq = new ArrayList<>();
        apq.add(null); //dummy value at index = 0
        this.comparator = comparator;
        this.locator = locator;
    }

    /**
     * Inserts the specified entry into this priority queue.
     *
     * @param e the entry to insert
     * @throws NullPointerException if parameter e is null
     */
    public void offer(E e) throws NullPointerException {
    		//implement this method    
    	 	if (e == null) {
             throw new NullPointerException();
         }
    	 	
    	 	apq.add(e);
    	 	locator.set(e, size());
    	 	
        if (size() / 2 > 0) {
        	 	upheap(size());
        } 
        
    }

   /**
     * Removes the entry at the specified location.
     *
     * @param pos the location of the entry to remove
     * @throws BoundaryViolationException if pos is out of range
     */
    public void remove(int pos) throws BoundaryViolationException {
    		//implement this method
    	 	if (pos < 1 || pos > size()) {
             throw new BoundaryViolationException();
        }
    	 	
    	 	if (pos == size()) {
    	 		apq.remove(pos);
    	 	} else {
    	 		swap(size(), pos);
    	        apq.remove(size());
    	 	}
    	 	
    		if (pos / 2 > 0 && pos < size() && comparator.compare(apq.get(pos), apq.get(pos/2)) < 0) {
        		upheap(pos);
        	}
    	 	
        	if (pos * 2 <= size()) {
        		downheap(pos);
        	}
        	//System.out.println(apq.toString());
    }

   /**
     * Removes the first entry in the priority queue.
     */
    public E poll() {
        //implement this method
    		if (isEmpty()) {
    			return null;
    		}
    		
    		E first = apq.get(1);
    		swap(1, size());
    		apq.remove(size());
    		if (size() > 1) {
    			downheap(1);
    		}
    		//System.out.println(apq.toString());
    		return first;
    }

  /**
     * Returns but does not remove the first entry in the priority queue.
     */
     public E peek() {
        if (isEmpty()) {
            return null;
        }
        return apq.get(1);
    }

   public boolean isEmpty() {
        return (size() == 0); 
    }

    public int size() {
        return apq.size() - 1; //dummy node at location 0
    }


    /**
     * Shift the entry at pos upward in the heap to restore the minheap property
     * @param pos the location of the entry to move
     */
    private void upheap(int pos) {
        //implement this method
    	 	if (comparator.compare(apq.get(pos), apq.get(pos / 2)) < 0) {
    	 		swap(pos, pos / 2);
    	 	} 
    	 	
    	 	if (pos / 4 > 0) {
    	 		upheap(pos / 2);
    	 	}
    }

    /**
     * Shift the entry at pos downward in the heap to restore the minheap property
     * @param pos the location of the entry to move
     */
    private void downheap(int pos) {
        //implement this method
    		if (pos * 2 + 1 > size()) {
    			if (comparator.compare(apq.get(pos), apq.get(pos * 2)) > 0) {
    				swap(pos, pos * 2);
    			}
    		}
    		else{
    			int posMin = comparator.compare(apq.get(pos*2), apq.get(pos*2+1)) > 0 ? (pos*2+1) : pos*2;
    			swap(pos, posMin);
    			if (posMin * 2 <= size()) {
    				downheap(posMin);
    			}
    		}
    		
    }

    /**
     * Swaps the entries at the specified locations.
     *
     * @param pos1 the location of the first entry 
     * @param pos2 the location of the second entry 
     */
    private void swap(int pos1, int pos2) {
        //implement this method
    		E p1 = apq.get(pos1);

        apq.set(pos1, apq.get(pos2));
        locator.set(apq.get(pos2), pos1);
        apq.set(pos2, p1);
        locator.set(p1, pos2);
    }
}