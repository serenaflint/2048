/**
 * Write.java
 * Collaboration between partners; Jayda Medina and Serena Flint
 * This class has all of the methods that control writing and reading files.
 */

import java.io.*;

public class Write {
	
	static String pathname;
	static boolean appendfile = false;
	
	//constructor
	public Write(String filepath) {
		pathname = filepath;
	}
	
	//constructor, handles appending text
	public Write(String filepath, boolean append) {
		pathname = filepath;
		appendfile = append;
	}

	public void writeToFile(String text) throws IOException {
		FileWriter write = new FileWriter(pathname, appendfile);
		PrintWriter printline = new PrintWriter(write);
	
		printline.printf("%s" + "%n", text);
		printline.close();
	}
	
}
