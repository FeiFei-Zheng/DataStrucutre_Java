package A2Q1;
import java.util.*;

public class testSIA {

    public static void main(String[] args) {
        int k;
        int[] arr;
        SortedIntegerArray ary;
        long startTime = System.nanoTime();
        int[] marks = new int[12];
        int nCorrect = 0;

        //test case 1
        System.out.println("test case 1:");
        try {
            arr = new int[0];
            ary = new SortedIntegerArray(arr);
            k = 8;
            if (ary.kPairSum(k) == false) {
                marks[1] = 1;
                System.out.println("correct: " + Arrays.toString(arr) + " not contain " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch(ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 2
        System.out.println("test case 2:");
        try {
            arr = new int[1];
            arr[0] = 5;
            ary = new SortedIntegerArray(arr);
            k = 13;
            if (ary.kPairSum(k) == false) {
                marks[2] = 1;
                System.out.println("correct: " + Arrays.toString(arr) + " not contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 3
        System.out.println("test case 3:");
        try {
            arr = new int[2];
            arr[0] = 1;
            arr[1] = 3;
            k = 5;
            ary = new SortedIntegerArray(arr);
            if (ary.kPairSum(k) == false) {
                marks[3] = 1;
                System.out.println("correct: " + Arrays.toString(arr) + " not contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 4
        System.out.println("test case 4:");
        try {
            int[] testArray = {22,10,3,2,8,6,9,11,3,1,0,-8,-11};
            ary = new SortedIntegerArray(testArray);
            k = 11;
            if (ary.kPairSum(k) == true) {
                marks[4] = 1;
                System.out.println("correct: " + Arrays.toString(testArray) + " contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 5
        System.out.println("test case 5:");
        try {
            int[] testArray = {90,45,5,2,8,63,1,77,7,83,10,21,44};
            ary = new SortedIntegerArray(testArray);
            k = 4;
            if (ary.kPairSum(k) == false) {
                marks[5] = 1;
                System.out.println("correct: " + Arrays.toString(testArray) + " not contain sum " + k);
            } else {
                System.out.println("incorrect");
                System.out.println(Arrays.toString(testArray) + " not contain sum " + k);
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 


        //test case 6
        System.out.println("test case 6:");
        try {
            int[] testArray = {-1,-2,99,Integer.MAX_VALUE, Integer.MAX_VALUE,2,11,7,0};
            ary = new SortedIntegerArray(testArray);
            k = 8;
            if (ary.kPairSum(k) == false) {
                marks[6] = 1;
                System.out.println("correct: " + Arrays.toString(testArray) + " not contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 7
        System.out.println("test case 7:");
        try {
            arr = new int[2];
            arr[0] = 3;
            arr[1] = -14;
            k = -11;
            ary = new SortedIntegerArray(arr);
            if (ary.kPairSum(k) == true) {
                marks[7] = 1;
                System.out.println("correct: " + Arrays.toString(arr) + " contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 8
        System.out.println("test case 8:");
        try {
            int[] testArray = {-1,-2,99,1,4,33,32,Integer.MAX_VALUE,5,9,11,Integer.MIN_VALUE,11,7};
            ary = new SortedIntegerArray(testArray);
            k = 0;
            if (ary.kPairSum(k) == true) {
                marks[8] = 1;
                System.out.println("correct: " + Arrays.toString(testArray) + " contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 9
        System.out.println("test case 9:");
        try {
            int[] testArray = {1,1,1,1,3,3,3,3,3,3};
            ary = new SortedIntegerArray(testArray);
            k = 2;
            if (ary.kPairSum(k) == true) {
                marks[9] = 1;
                System.out.println("correct: " + Arrays.toString(testArray) + " contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 
        
        //test case 10
        System.out.println("test case 10:");
        try {
            arr = new int[2];
            arr[0] = Integer.MAX_VALUE;
            arr[1] = Integer.MAX_VALUE;
            k = 5;
            ary = new SortedIntegerArray(arr);
            if (ary.kPairSum(k) == false) {
                marks[10] = 1;
                System.out.println("correct: " + Arrays.toString(arr) + " not contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        } 

        //test case 10
        System.out.println("test case 10:");
        try {
            arr = new int[2];
            arr[0] = Integer.MIN_VALUE;
            arr[1] = Integer.MIN_VALUE;
            k = 13;
            ary = new SortedIntegerArray(arr);
            if (ary.kPairSum(k) == false) {
                marks[11] = 1;
                System.out.println("correct: " + Arrays.toString(arr) + " not contain sum " + k);
            } else {
                System.out.println("incorrect");
            }
        } catch (ArrayIndexOutOfBoundsException aio) {
            System.out.println("incorrect: index out of range exception.");
        }

        //all test result
        System.out.println();
        long stopTime = System.nanoTime();
        double elapsedTime = (double) (stopTime - startTime) / 1000000; //in msec
        System.out.println("Execution time: " + elapsedTime);

        for (int i = 1; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
            nCorrect += marks[i];
        }

        System.out.println();
        System.out.println("Test case grade: " + (double) nCorrect / (marks.length - 1));
    }
    
}