/**  
 * @class FlipHorizontalImage - class for flipping the image
 * horizontally - like the picure in a mirror, using
 * representation of the picture as a 2-dimensional array
 * of pixels
 */

import acm.graphics.*;
import acm.program.*;


public class FlipHorizontalImage extends GraphicsProgram {
	
	private GImage flipHorizontal (GImage image) {
		/* picture_array is 2-dimenzional array of all 
		 * pixels in the picture */ 
		int[][] picture_array = image.getPixelArray();
		// we take one row to measue width, all rows have the same
		int width = picture_array[0].length;
		/* the length of 2-dimenzional array is the number of pixels in column
		e.g. the number of rows */
		int height = picture_array.length;
		
		// Excanging two elements in every row of the picture_array
		for (int row=0; row<height; row++) {
			for (int p1=0; p1<width; p1++) {
				
				/* 
				 * Here we use the receipe from the book for
				 * EXCHANGING TWO ELEMENTS IN THE ARRAY - using p1, p2, and temp
				 * (temp is temperory value), we change the the places of
				 * elements p1 and p2.
				 * Here, we change the places of 2 elements in the 1- dimenzional 
				 * array which represents the pixels in one horizontal row of the
				 * picture_array 
				 */
				int p2 = width - p1 - 1;
				int temp = picture_array[row][p1];
				picture_array[row][p1] = picture_array[row][p2];
				picture_array[row][p2] = temp;
			}
		}
		return new GImage(array);
	}
}



