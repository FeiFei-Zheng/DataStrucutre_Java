package A1Q3;
import java.util.*;

/**
 * Specializes the stack data structure for comparable elements, and provides
 * a method for determining the maximum element on the stack in O(1) time.
 */
public class MaxStack<E extends Comparable<E>> extends Stack<E> {

    private Stack<E> maxStack;
    private E max; 
    
    public MaxStack() {
    		super();
        maxStack = new Stack<>();
    }

    /* must run in O(1) time */
    public E push(E element) {
    		super.push(element);
    		if (maxStack.empty() || element.compareTo(maxStack.peek()) >= 0) {
            maxStack.push(element); //element is a maximum - push on maxStack
        }
        return element;
    }

    /* @exception  EmptyStackException  if this stack is empty. */
    /* must run in O(1) time */
   public synchronized E pop() {
	   if (super.isEmpty()) {
		   throw new EmptyStackException();
	   }
	   
	   if (super.peek().equals(maxStack.peek()))
           maxStack.pop(); 
	   
       return super.pop(); //Dummy return to satisfy compiler.  Remove once coded.
    }

    /* Returns the maximum value currenctly on the stack. */
    /* @exception  EmptyStackException  if this stack is empty. */
    /* must run in O(1) time */
    public synchronized E max() {
    		if (super.isEmpty()) {
    			throw new EmptyStackException();
    		}
    		
        return maxStack.peek(); //Dummy return to satisfy compiler.  Remove once coded.
    }
}
