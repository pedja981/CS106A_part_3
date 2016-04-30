/** 
 * @file: Histogram.java 
 * This is the program for getting a list of exam scores from the file,
 * and put them in the histogram-type showing, with stars as markers.
 * There are 11 scopes/ranges. 0-9, 10-11, .., 89-99, and 100, as a separate range
 * */

import java.io.*;

import acm.program.*;
import acm.util.*;

public class Histogram extends ConsoleProgram {
	/* private instance variables */
	private int[] arrayHistogram;
	private static final String fileName = "Scores.txt";
	
	public void run() {
		createHistogramArray();
		importData();
		printHistogram();
	}
	
	/* Setup of the array for the ranges */
	private void createHistogramArray() {
		arrayHistogram = new int[11];
		for (int i=0; i<=10; i++) {
			arrayHistogram[i] = 0; // initial value - 0 stars for every range
		}
	}
	
	/* read the exam results data from the file,
	 * and putting appropriate data into our histogram */ 
	private void importData() {
		try {
			BufferedReader rd = new BufferedReader (
					new FileReader(fileName));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				int score = Integer.parseInt(line);
				if (score<0 || score>100) {
					throw new ErrorException
						("Score from the file is out of the apropriate range");
				} else {
					int range = score/10;
					arrayHistogram[range]++;
				}
			}
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	/* Method for showing the results in histogram */
	private void printHistogram() {
		/* We need the stars as the string, which corelates to 
		 * every type of range (11 of them).  */
		
		/* This would be the concept 
		 * String stars = printStars(arrayHistogram[range]);
		 * println(label + ": " + number_of_stars);
		 * 
		 *  So, we have to create little method for printing
		 *  the n number of stars, and a loop which will tell
		 *  every range with corresponding label to print
		 *  corresponding number of stars
		 *  
		 *  @printStars - method for printing the n stars
		 * */
		for (int range = 0; range<=10; range++) {
			String label;
			switch (range) {
			case 0: label = "00-09"; break;
			case 10: label = "100"; break;
			default: label = (10*range)+"-"+(10*range+9); break;
			}
			String stars = printStars(arrayHistogram[range]);
			println(label + ": " + stars);
		}
		
		/* Wrong way, as it appeares, but maybe can be done this way also
		 * IF instead of CASE/DEFAULT  */
		/*for (int range = 0; range<=10; range++) {
			String label;
			if (range == 0) { label = "00-09"; break;}
			if (range>0 && range<10) {label = (10*range)+"-"+(10*range+9); break;}
			if (range == 10) {label = "100"; break;}
			String stars = printStars(arrayHistogram[range]);
			println(label+": "+stars);
		} */
		
	}
	
	/* Method for printing n number of stars */
	private String printStars (int n) {
		String number_of_stars = "";
		for (int i=0; i<n; i++) {
			number_of_stars += "*";
		}
		return number_of_stars;
	}
	
}



