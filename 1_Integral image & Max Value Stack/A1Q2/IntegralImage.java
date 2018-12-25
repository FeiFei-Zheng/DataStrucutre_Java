package A1Q2;

/**
 * Represents an integer integral image, which allows the user to query the mean
 * value of an arbitrary rectangular subimage in O(1) time.  Uses O(n) memory,
 * where n is the number of pixels in the image.
 *
 */
public class IntegralImage {

    private final int[][] integralImage;
    private final int imageHeight; // height of image (first index)
    private final int imageWidth; // width of image (second index)

    /**
     * Constructs an integral image from the given input image.  
     *
     * @author jameselder
     * @param image The image represented
     * @throws InvalidImageException Thrown if input array is not rectangular
     */
    public IntegralImage(int[][] image) throws InvalidImageException {
        //implement this method.
    		int compare = image[0].length;
    		int i;
    		for (i = 1; i < image.length; i++) {
    			if (image[i].length != compare) {
    				throw new InvalidImageException();
    			}
    			compare = image[i].length;
    		}
    		
    		this.imageHeight = image.length;
    		this.imageWidth = image[0].length;
    		this.integralImage = new int[this.imageHeight][this.imageWidth];
    		
    		integralImage[0][0] = image[0][0];
    		for (i = 1; i < image[0].length; i++) {
    			integralImage[0][i] = integralImage[0][i-1] + image[0][i];
    		}
    		
    		for (i = 1; i < image.length; i++) {
    			integralImage[i][0] = integralImage[i-1][0] + image[i][0];
    		}
    		
    		i = 1;
    		int j = 1;
    		while (i < this.imageHeight && j < this.imageWidth) {
    			integralImage[i][j] = image[i][j] + integralImage[i-1][j] + integralImage[i][j-1] - integralImage[i-1][j-1];
    			if (j == this.imageWidth - 1) {
    				j = 1;
    				i++;
    			} else {
        			j++;
    			}
    		}
    }

    /**
     * Returns the mean value of the rectangular sub-image specified by the
     * top, bottom, left and right parameters. The sub-image should include
     * pixels in rows top and bottom and columns left and right.  For example,
     * top = 1, bottom = 2, left = 1, right = 2 specifies a 2 x 2 sub-image starting
     * at (top, left) coordinate (1, 1).  
     *
     * @author jameselder
     * @param top top row of sub-image
     * @param bottom bottom row of sub-image
     * @param left left column of sub-image
     * @param right right column of sub-image
     * @return 
     * @throws BoundaryViolationException if image indices are out of range
     * @throws NullSubImageException if top > bottom or left > right
     */
    public double meanSubImage(int top, int bottom, int left, int right) throws BoundaryViolationException, NullSubImageException {
        //implement this method
    		if (top > this.imageHeight || bottom < 0 || left < 0 || right > this.imageWidth) {
    			throw new BoundaryViolationException();
    		}
    		
    		if (top > bottom || left > right) {
    			throw new NullSubImageException();
    		}

    		double area = (bottom - top + 1) * (right - left + 1);
    		
    		if (top == 0 && left == 0) {
    			return integralImage[bottom][right] / area;
    		}
    		
    		if (top == 0) {
    			return (integralImage[bottom][right] - integralImage[bottom][left-1]) / area;
    		}
    		
    		if (left == 0) {
    			return (integralImage[bottom][right] - integralImage[top-1][right]) / area;
    		}
    		
    		return (integralImage[bottom][right] - integralImage[top-1][right] - integralImage[bottom][left-1] + integralImage[top-1][left-1]) / area; 
    }
}
