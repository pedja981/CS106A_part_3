/**  
 * @file HangmanLexicon.java
 * gives the utilization of the lexicon file with words 
 */

import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

 
public class HangmanLexicon {
 
    private ArrayList  wordList = new ArrayList  ();
 
    public HangmanLexicon() {
    //adds the individual words in the file to the array list
        try {
            BufferedReader hangmanWords = new BufferedReader(new FileReader("HangmanLexicon.txt"));
            while(true) {
                String line = hangmanWords.readLine();
                if(line == null) break;
                wordList.add(line);
            }
            hangmanWords.close();
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }
 
/** Returns the word at the specified index. */
    public String getWord(int index) {
        return wordList.get(index);
    }
 
    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
        return wordList.size();
    }
}








