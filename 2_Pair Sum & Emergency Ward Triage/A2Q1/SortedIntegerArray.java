package A2Q1;
import java.util.*;
/**
 * Represents a sorted integer array.  Provides a method, kpairSum, that
 * determines whether the array contains two elements that sum to a given
 * integer k.  Runs in O(n) time, where n is the length of the array.
 */
public class SortedIntegerArray {

    protected int[] sortedIntegerArray;

    public SortedIntegerArray(int[] integerArray) {
        sortedIntegerArray = integerArray.clone();
        Arrays.sort(sortedIntegerArray);
    }

/**
 * Determines whether the array contains two elements that sum to a given
 * integer k. Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
    public boolean kPairSum(Integer k) {
        //implement this method
           if (sortedIntegerArray.length < 2) {
               return false;
           }

           return kPairSumInterval(k, 0, sortedIntegerArray.length - 1);
       }

       //recursive method will be called from kPairSum
       private boolean kPairSumInterval(Integer k, int i, int j) {
           //solves the problem for the subinterval of the array from index i to j.
           int n = sortedIntegerArray[i];
           int m = sortedIntegerArray[j];
           long sum = (long) n + m;

           if (i == j) {
               return false;
           }
           //if k = square of n or m, it will return true!!
           if (sum == k) {
               return true;
           }

           if (n + m > k) {
               return kPairSumInterval(k, i, j - 1);
           }

           if (n + m < k) {
               return kPairSumInterval(k, i + 1, j); 
           }
           return false;
       }

}
