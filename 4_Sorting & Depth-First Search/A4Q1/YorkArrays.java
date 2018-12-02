package A4Q1;
import java.util.*;

/**
 *
 * Provides two static methods for sorting Integer arrays (heapSort and mergeSort)
 */
public class YorkArrays {

    /* Sorts the input array of Integers a using HeapSort.  Result is returned in a.
     * Makes use of java.util.PriorityQueue.  
       Sorting is NOT in place - PriorityQueue allocates a separate heap-based priority queue. 
       Not a stable sort, in general.  
       Throws a null pointer exception if the input array is null.  */
    public static void heapSort(Integer[] a) throws NullPointerException {
       //implement this method.
    		int len = a.length;
    		if (len == 0) {
    			throw new NullPointerException();
    		}
    		PriorityQueue<Integer> queue = new PriorityQueue<>(len);
    		for (int i = 0; i < len; i++) {
    			queue.add(a[i]);
    		}
    		
    		for (int i = 0; i < len; i++) {
    			a[i] = queue.poll();
    		}
    }
    
    /* Sorts the input array of Integers a using mergeSort and returns result.
     * Sorting is stable.
     * Throws a null pointer exception if the input array is null. 
     */
    public static Integer[] mergeSort(Integer[] a)  throws NullPointerException {
    		if (a.length == 0) {
    			throw new NullPointerException();
    		}
    		
        return(mergeSort(a, 0, a.length-1));
    }
    
    /* Sorts the input subarray of Integers a[p...q] using MergeSort and returns result.
     * Sorting is stable.
     */
    private static Integer[] mergeSort(Integer[] a, int p, int q) {
        //implement this method.
    		if (a.length == 1) {
    			return a;
    		}
    		int m = (q - p + 1) / 2;
    		Integer[] part1 = Arrays.copyOfRange(a, p, m);
    		Integer[] part2 = Arrays.copyOfRange(a, m, q + 1);
    		
    		part1 = mergeSort(part1);
    		part2 = mergeSort(part2);
    		
    		return merge(part1, part2);
    }
    
    /* Merges two sorted arrays of Integers into a single sorted array.  Given two
     * equal elements, one in a and one in b, the element in a precedes the element in b.
     */
    private static Integer[] merge(Integer[] a, Integer[] b) {
        //implement this method.
    		int al = a.length, bl = b.length;
    		Integer[] r = new Integer[al + bl];
    		int i = 0, j = 0, k = 0;
    		
    		while(i < al || j < bl) {
    			if (i < al && j < bl) {
    				if (a[i] < b[j]) {
    					r[k] = a[i];
    					i++;
    				} else {
    					r[k] = b[j];
    					j++;
    				}
    			}
    			else if (i < al) {
    				r[k] = a[i];
    				i++;
    			}
    			else{
    				r[k] = b[j];
    				j++;
    			}
    			k++;
    		}
    		return r;
    }
    
}
