package A1Q2;

/**
 * Tests the IntegralImage class.
 */
public class testIntegralImage {

    public static void main(String[] args) {
        int[][] image1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int top,bottom,left,right;
        double mean;

        IntegralImage integralImage1;
        IntegralImage integralImage2;
        top = 1;
        bottom = 2;
        left = 1;
        right = 2;
//        
        int[][] image2 = {{31,2,4,33,5,36}, {12,26,9,10,29,25}, {13,17,21,22,20,18}, {24,23,15,16,14,19}, {30,8,28,27,11,7}, {1,35,34,3,32,6}};
//        top = 3;
//        bottom = 4;
//        left = 2;
//        right = 4;
                
//        System.out.println("top-left: "+ integralImage[top-1][left-1]);
//   		System.out.println("bottom-right: " +integralImage[bottom][right]);
//   		System.out.println("top-right: " +integralImage[top-1][right]);
//   		System.out.println("bottom-left: " + integralImage[bottom][left-1]);
   		
        try {
            integralImage1 = new IntegralImage(image1);
            integralImage2 = new IntegralImage(image2);
        } catch (InvalidImageException iix) {
            System.out.println("Invalid Image Exception");
            return;
        }
       
        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should be 7.0
            System.out.println("The mean of the subimage from ("
                    + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
        } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }

    }
}
