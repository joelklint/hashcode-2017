package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	
	Scanner scan;
	
	public Parser(String inputPath) {
		File file = new File(inputPath);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("COULD NOT FIND FILE TO READ FROM!");
			e.printStackTrace();
		}
		
	}
	
	public void parse() {
		
	}

}
