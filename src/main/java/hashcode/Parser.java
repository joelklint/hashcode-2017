package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	
	/*
	 * DEFINE RELEVANT ATTRIBUTES DESCRIBING THE PROBLEM HERE
	 */
	
	Scanner scan;
	
	public Parser(String inputPath) {
		File file = new File(inputPath);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("COULD NOT FIND FILE TO READ FROM!");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void parse() {
		// Scanner already initiated. Example use below
		String firstLine = scan.nextLine();
		
		/*
		 * IMPLEMENT PARSER HERE.
		 * STORE ALL RELEVANT DATA IN CLASS ATTRIBUTES.
		 */
	}
	
	/*
	 * IMPLEMENT GETTERS FOR ALL RELEVANT ATTRIBUTES FOR PROBLEM.
	 * 
	 * ALL GETTERS MUST RETURN A DEEP CLONED COPY.
	 * THIS MEANS EVERYTHING MUST BE CLONED, DOWN TO ITS PRIMITIVE TYPES
	 */

}
