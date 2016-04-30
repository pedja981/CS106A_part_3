/** 
 * @file WordCount.java -class for counting the words, lines and characters
 * from a given file
 *  
 * */

import acm.program.*;
import java.io.*;  // for exceptions handling

public class WordCount extends ConsoleProgram {
	
	
	/* We create the method for reading from a file.  */
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(
						new FileReader(filename));
			} catch (IOException ex) {
				println ("Nice try, punk. That " +
						"file doesn't exist.");
			}
		}
		return rd;
	}

	/* Main method */ 
	public void run() {
		setFont("Courier-18");
		
		/* variables counters for lines, words and characters */
		int lines_in_file = 0;
		int words_in_file = 0;
		int ch_in_file = 0;
		
		/* Opening file */
		BufferedReader rd = openFile("Give us the name of the file: ");
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lines_in_file ++;
				words_in_file = +countWordsInLine(line);
				ch_in_file += line.length();
			} rd.close();
		} catch (IOException ex) {
			print ("An I/O exception has occured.");
		} 

		println("Number of lines in file:" + lines_in_file);
		println("Number of words in file:" + words_in_file);
		println("Number of characters in file:" + ch_in_file);

	}
	
	
	/* We need a method for counting the words per line */
	private int countWordsInLine(String line) {
	/* We use this tactics - we have a method for bufferedReader when
	 * we read a line, we can pas through a line and see if the specific 
	 * character is letter or digit. And if it is not - we conclude that it
	 * is some kind of a word or line separator. So - we conclude and count:
	 * count the number of separators => you have number of words */
		
		int number_of_words_in_line = 0;
		boolean char_is_delimiter = false;
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				char_is_delimiter = false;
			} else {
				char_is_delimiter = true;
				number_of_words_in_line ++;
			}
		}
		// last step, for the last character
		if (!char_is_delimiter) number_of_words_in_line ++;
		return number_of_words_in_line;
	}
	
}



