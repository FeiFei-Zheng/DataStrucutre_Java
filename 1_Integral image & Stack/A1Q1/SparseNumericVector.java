package A1Q1;
import java.util.*;

/**
 * Represents a sparse numeric vector. Elements are comprised of a (long)
 * location index an a (double) value.  The vector is maintained in increasing
 * order of location index, which facilitates numeric operations like
 * inner products (projections).  Note that location indices can be any integer
 * from 1 to Long.MAX_VALUE.  The representation is based upon a
 * singly-linked list.
 * The following methods are supported:  iterator, getSize, getFirst,
 * add, remove, and dot, which takes the dot product of the with a second vector
 * passed as a parameter.
 */
public class SparseNumericVector implements Iterable<SparseNumericElement> {

    protected SparseNumericNode head = null;
    protected SparseNumericNode tail = null;
    protected long size;

  /**
     * Iterator
     */
    @Override
    public Iterator<SparseNumericElement> iterator() { //iterator
        return new SparseNumericIterator(this);
    }

    /**
     * @return number of non-zero elements in vector
     */
   public long getSize() {
        return size;
    }

     /**
     * @return the first node in the list.
     */
    public SparseNumericNode getFirst() {
        return head;
    }
    
    /**
     * Add the element to the vector.  It is inserted to maintain the
     * vector in increasing order of index.  If the element has zero value, or if 
     * an element with the same index already exists, an UnsupportedOperationException is thrown. 
     * @param e element to add
     */
    public void add(SparseNumericElement e) throws UnsupportedOperationException {
       //implement this method
    		if (e.getValue() == 0) {
    			throw new UnsupportedOperationException();
    		}
    		
    		long idx = e.getIndex();
    		Iterator<SparseNumericElement> iter = this.iterator();
    		while (iter.hasNext()) {
    			if (iter.next().getIndex() == idx) {
    				throw new UnsupportedOperationException();
    			}
    		}
    		
    		SparseNumericNode node = new SparseNumericNode(e, null);
    		if (this.size == 0) {
    			this.head = node; 
    			this.tail = node; 
    		}
    		
    		else if (idx > this.tail.getElement().getIndex()) {
    			this.tail.setNext(node);
    			this.tail = node; 
    		} 
    		
    		else if (idx < this.head.getElement().getIndex()) {
    			node.setNext(this.head);
    			this.head = node;
    		} 
    		
    		else {
        		SparseNumericNode pre = this.head;
        		for (int i = 0; i < this.size - 1; i++) {
	    			SparseNumericNode nex = pre.getNext();
	    			if (nex.getElement().getIndex() > idx) {
	    				pre.setNext(node);
	    				node.setNext(nex);
	    			}
	    			pre = pre.getNext();
        		}
    		}
    		this.size++;
    }

    /**
     * If an element with the specified index exists, it is removed and the
     * method returns true.  If not, it returns false.
     *
     * @param index of element to remove
     * @return true if removed, false if does not exist
     */
    public boolean remove(Long index) {
        //implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
    		if (this.size == 0) {
    			return false;
    		}
    		
    		long headIdx = this.head.getElement().getIndex();
    		long tailIdx = this.tail.getElement().getIndex();
    		
    		if (this.size == 1 && headIdx == index) {
    			this.head = null;
    			this.tail = null;
    			this.size--;
    			return true;
    		}
    		
    		if (this.size == 2) {
    			if (index == headIdx) {
        			SparseNumericNode newHead = this.head.getNext();
        			this.head = newHead;
        			this.size--;
        			return true;
        		}
    			if (index == tailIdx) {
    				this.tail = this.head;
    				this.size--;
    				return true;
    			}
    			return false;
    		}
    		
    		if (headIdx == index) {
    			SparseNumericNode nex = this.head.getNext();
    			this.head = nex;
    			this.size--;
    			return true;
    		}
    		
    		SparseNumericNode pre = this.head;
    		for (int i = 0; i < this.size - 1; i++) {
        		SparseNumericNode current = pre.getNext();
    			SparseNumericNode nex = current.getNext();
    			if (current.getElement().getIndex() == index) {
    				pre.setNext(nex);
    				this.size--;
    				return true;
    			}
    			pre = pre.getNext();
    		}
    		
    		return false;
    }

    /**
     * Returns the inner product of the vector with a second vector passed as a
     * parameter.  The vectors are assumed to reside in the same space.
     * Runs in O(m+n) time, where m and n are the number of non-zero elements in
     * each vector.
     * @param Y Second vector with which to take inner product
     * @return result of inner product
     */

    public double dot (SparseNumericVector Y) {
        //implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
    		if (this.size == 0 || Y.size == 0) {
    			return 0.0;
    		}
    		
    		SparseNumericNode shortNode = this.head;
    		SparseNumericNode longNode = Y.head;
    		
    		long shortRng = this.size;
    		long longRng = Y.size;
    		if (this.size > Y.size) {
    			shortRng = Y.size;
    			longRng = this.size;
    			shortNode = Y.head;
    			longNode = this.head;
    		}
    		
    		double result = 0;
    		long s = 0;
    		long l = 0; 
    		
    		System.out.println("this size: " + this.size + "; Y-size: " + Y.size);
    		while (s < shortRng && l < longRng) {
    			
    			if (shortNode.getElement().getIndex() < longNode.getElement().getIndex()) {
    				shortNode = shortNode.getNext();
    				s++;
    			}
    			else if (shortNode.getElement().getIndex() > longNode.getElement().getIndex()) {
    				longNode = longNode.getNext();
    				l++;
    			}
    			else {
    				result = result + shortNode.getElement().getValue() * longNode.getElement().getValue();
    				shortNode = shortNode.getNext();
    				longNode = longNode.getNext();
    				s++;
    				l++;
    			}
    		}
    		return result;
   }

       /**
     * returns string representation of sparse vector
     */

    @Override
    public String toString() {
        String sparseVectorString = "";
        Iterator<SparseNumericElement> it = iterator();
        SparseNumericElement x;
        while (it.hasNext()) {
            x = it.next();
            sparseVectorString += "(index " + x.getIndex() + ", value " + x.getValue() + ")\n";
        }
        return sparseVectorString;
    }
    
}


