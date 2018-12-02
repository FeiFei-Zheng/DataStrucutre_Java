package A1Q3;

import java.util.*;

/**
 * Tests class MaxStack
 */
public class gradeMaxStack {

    public static void main(String[] args) {
        MaxStack<Integer> myMaxStack = new MaxStack<>();
        int val;
        long startTime = System.nanoTime();        
        int[] marks = new int[12];
        int nCorrect = 0;

        try {
            myMaxStack.push(5); // 5
            myMaxStack.push(3); // 3 5
            myMaxStack.push(12);// 12 3 5
            myMaxStack.push(13);// 13 12 3 5
            myMaxStack.push(2);//  2 13 12 3 5
            myMaxStack.push(11);// 11 2 13 12 3 5
        } catch (EmptyStackException esx) {
            System.out.println("Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Exception.");
        }

        //test case 1//
        System.out.println("Test case 1:");
        try {
            val = myMaxStack.max();
            if (val == 13) { //answer should be 13
                System.out.println("Correct");
                marks[1] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The maximum value currently on the stack is " + val); // should be 13
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect:  Exception.");
        }

        //test case 2//
        System.out.println("Test case 2:");
        try {
            val = myMaxStack.pop(); // 11, leaving 2 13 12 3 5
            if (val == 11) { //answer should be 11
                System.out.println("Correct");
                marks[2] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 11
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect:  Exception.");
        }

         //test case 3//
        System.out.println("Test case 3:");
        try {
            val = myMaxStack.pop(); // 2, leaving 13 12 3 5
            if (val == 2) { //answer should be 2
                System.out.println("Correct");
                marks[3] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 2
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect:  Exception.");
        }

         //test case 4//
        System.out.println("Test case 4:");
        try {
            val = myMaxStack.pop(); // 13, leaving 12 3 5
            if (val == 13) { //answer should be 13
                System.out.println("Correct");
                marks[4] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 13
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

        // test case 5//
      System.out.println("Test case 5:");
        try {
            val = myMaxStack.max();
            if (val == 12) { //answer should be 12
                System.out.println("Correct");
                marks[5] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The maximum value currently on the stack is " + val); // should be 12
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

          //test case 6//
        System.out.println("Test case 6:");
        try {
            val = myMaxStack.pop(); // 12, leaving 3 5
            if (val == 12) { //answer should be 12
                System.out.println("Correct");
                marks[6] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 12
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

         //test case 7//
        System.out.println("Test case 7:");
        try {
            val = myMaxStack.pop(); // 3, leaving 5
            if (val == 3) { //answer should be 3
                System.out.println("Correct");
                marks[7] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 3
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

        // test case 8//
      System.out.println("Test case 8:");
        try {
            val = myMaxStack.max();
            if (val == 5) { //answer should be 5
                System.out.println("Correct");
                marks[8] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The maximum value currently on the stack is " + val); // should be 5
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

         //test case 9//
        System.out.println("Test case 9:");
        try {
            val = myMaxStack.pop(); // 5, leaving null
            if (val == 5) { //answer should be 5
                System.out.println("Correct");
                marks[9] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 5
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

        // test case 10//
        System.out.println("Test case 10:");
        try {
            myMaxStack.max(); //should throw exception
            System.out.println("Incorrect:  should throw empty stack exception.");
        } catch (EmptyStackException esx) {
            System.out.println("Correct:  Empty Stack Exception");
            marks[10] = 1;
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

        // test case 11//
        System.out.println("Test case 11:");
        try {
            myMaxStack.pop(); //should throw exception
            System.out.println("Incorrect:  should throw empty stack exception.");
        } catch (EmptyStackException esx) {
            System.out.println("Correct:  Empty Stack Exception");
            marks[11] = 1;
        } catch (Exception ex) {
            System.out.println("Incorrect: Exception.");
        }

        long stopTime = System.nanoTime();
        double elapsedTime = (double) (stopTime - startTime) / 1000000; //in msec
        System.out.println("Execution Time (msec): " + elapsedTime);

        System.out.print("Test Case Summary: ");
        for (int i = 1; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
            nCorrect += marks[i];
        }
        System.out.println();
        System.out.println("Test Case Grade: " + (double) nCorrect / (marks.length - 1));


    }
}
