/**  
 * @file UniqueNames.java
 * Program for reading a list of names from user's input, and
 * then put out unique entrances - unique names
 * 
 * */

import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram {
	/* We are going to use ArrayList, which enables us more
	 * flexibility than default Java arrays. In fact, this type is like 
	 * ordinary array in most of other programming languages (PHP, Python)
	 * e.g. we can append, prepend, get new member into particular position
	 * of the array, etc... Ordinary Java array doesn't enable us that
	 */
	public void run() {
		setFont("Courier-18");

		ArrayList<String> names = new ArrayList<String>();
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
		
		/* Here comes the magic of ArrayList. 
		 * We  have nice and useful methods from the book: 
		 * (ArrayList).contains(), (ArrayList).add() etc.
		 * It can't be done with "simple" arrays. Nice! :-) */
			if (!names.contains(name)) {
				names.add(name);
			}
		}
		
		println("Unique name list contains: ");
		printList(names);
		}
	
	/* Method for printing elements of the list, one per every line */
	private void printList(ArrayList list) {
		for (int i=0; i<list.size(); i++) {
			println(list.get(i));
		}
	}
}




