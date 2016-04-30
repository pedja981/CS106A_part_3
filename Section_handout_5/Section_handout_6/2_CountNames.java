/** 
 * @file CountNames.java
 * 
 * Program for counting the number of each name
 * from the list which user enters
 * */

import acm.program.*;
//import acm.util.*;
import java.util.*;

public class CountNames extends ConsoleProgram {
	
	/* In this program we are going to use Hash Map,
	 * which will greatly simplify the program */
	
	public void run() {
		setFont("Courier-18");

	// We are creating a new HashMap which maps string and corresponding integer
		HashMap<String, Integer> nameMap =
				new HashMap<String, Integer>();
	
		readUsersNames(nameMap);
		printHashMap(nameMap);
	}
	
	/* 
	 * Method which reads the list of names which user types in, 
	 * and save the names and number of times that each name has been typed.
	 * 
	 * @param Map - method takes the Map as the parameter, and
	 * fills it with appropriate data (String and Integer - name and number
	 * of times it has appeared)
	 * 
	 *  */
	private void readUsersNames(Map<String, Integer> map) {
		while (true) {
			String name = readLine("Enter the name: ");
			if (name.equals("")) break;
			
			/* Now we check is the particular name already present
			 * in the Map map. If it isn't present - we create new 
			 * item, and count it to 1; If it is present - we
			 * increase the corresponding counter for that
			 * particular name by 1. */
			Integer counter = map.get(name);
			if (counter == null) {
				counter = new Integer(1);
			} else {
				counter = new Integer(counter + 1);
			}		
			
			map.put(name, counter);
		}
	}
	
	/* 
	 * Method for printing the desired output - list of
	 * the names, and corresponding counter values for each name.
	 * 
	 * @param Map<String,Integer> map - the method takes the previously
	 * filled map (from the previous method) as a parameter. 
	 * 
	 */
	private void printHashMap(Map<String,Integer> map) {
		// Setting the iterator
		Iterator<String> iterator = map.keySet().iterator();
		
		// Now we iterate through the map
		while (iterator.hasNext()) {
			String key = iterator.next();
			int counter = map.get(key);
			println("Entry [" + key + "] has count " + counter);
		}
	}
	
}

