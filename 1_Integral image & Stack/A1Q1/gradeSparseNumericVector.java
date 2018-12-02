package A1Q1;

public class gradeSparseNumericVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double projection = 0;
        long startTime = System.nanoTime();

        int[] marks = new int[6];
        int nCorrect = 0;

        //Test case 1
        SparseNumericVector X1 = new SparseNumericVector();
        SparseNumericVector Y1 = new SparseNumericVector();
        try {
            System.out.print("Test Case 1: ");
            X1.add(new SparseNumericElement(150000, 3.1415));
            X1.add(new SparseNumericElement(15, 3));
            X1.add(new SparseNumericElement(1500, 3.14));
            X1.add(new SparseNumericElement(150, 3.1));
            X1.add(new SparseNumericElement(15000, 3.141));
            Y1.add(new SparseNumericElement(150000, 1));
            Y1.add(new SparseNumericElement(15, 1));
            X1.remove((long) 150);

            projection = X1.dot(Y1);
            if (projection == 3 * 1 + 3.1415 * 1) { //answer should be 6.1415
                System.out.println("Correct");
                marks[1] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The inner product of");
            System.out.print(X1);
            System.out.println("and");
            System.out.print(Y1);
            System.out.println("is ");
            System.out.printf("%.5f\n\n", projection); //answer should be 3*1 + 3.1415*1 = 6.1415
        } catch (Exception ex) {
            System.out.println("Incorrect - an exception was thrown.\n");
        }

        //Test case 2
        SparseNumericVector X2 = new SparseNumericVector();
        SparseNumericVector Y2 = new SparseNumericVector();
        System.out.print("Test Case 2: ");
        try {
            X2.add(new SparseNumericElement(1, 1));
            X2.add(new SparseNumericElement(7, -3));
            X2.add(new SparseNumericElement(3, 5));
            Y2.add(new SparseNumericElement(1, 1));
            Y2.add(new SparseNumericElement(3, 2));
            Y2.add(new SparseNumericElement(7, 17));

            X2.remove((long) 7);

            projection = X2.dot(Y2);
            if (projection == 1 * 1 + 5 * 2) { //answer should be 11
                System.out.println("Correct");
                marks[2] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The inner product of");
            System.out.print(X2);
            System.out.println("and");
            System.out.print(Y2);
            System.out.println("is ");
            System.out.printf("%.5f\n\n", projection); //answer should be 11
        } catch (Exception ex) {
            System.out.println("Incorrect - an exception was thrown.\n");
        }

        //Test case 3
        SparseNumericVector X3 = new SparseNumericVector();
        SparseNumericVector Y3 = new SparseNumericVector();
        System.out.print("Test Case 3: ");
        try {
            X3.add(new SparseNumericElement(1, 1));
            Y3.add(new SparseNumericElement(1, 1));
            X3.add(new SparseNumericElement(Long.MAX_VALUE, 2));
            Y3.add(new SparseNumericElement(Long.MAX_VALUE, -2));
            projection = X3.dot(Y3);
            if (projection == 1 * 1 + 2 * -2) { //answer should be -3
                System.out.println("Correct");
                marks[3] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The inner product of");
            System.out.print(X3);
            System.out.println("and");
            System.out.print(Y3);
            System.out.println("is ");
            System.out.printf("%.5f\n\n", projection); //answer should be -3
        } catch (Exception ex) {
            System.out.println("Incorrect - an exception was thrown.\n");
        }

        //Test case 4
        SparseNumericVector X4 = new SparseNumericVector();
        System.out.print("Test Case 4: ");
        try {
            X4.add(new SparseNumericElement(150000, 3.1415));
            X4.add(new SparseNumericElement(15, 3));
            X4.add(new SparseNumericElement(1500, 3.14));
            X4.add(new SparseNumericElement(150, 3.1));
            X4.add(new SparseNumericElement(2, 0)); //0 value - should throw exception
        } catch (UnsupportedOperationException ex) {
            System.out.println("Correct - an Unsupported Operation Exception was thrown.\n");
            marks[4] = 1;
        }

        //Test case 5
        SparseNumericVector X5 = new SparseNumericVector();
        System.out.print("Test Case 5: ");
        try {
            X5.add(new SparseNumericElement(150000, 3.1415));
            X5.add(new SparseNumericElement(15, 3));
            X5.add(new SparseNumericElement(1500, 3.14));
            X5.add(new SparseNumericElement(150, 3.1));
            X5.add(new SparseNumericElement(15, 2)); //Index already exists - should throw exception
        } catch (UnsupportedOperationException ex) {
            System.out.println("Correct - an Unsupported Operation Exception was thrown.\n");
            marks[5] = 1;
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
