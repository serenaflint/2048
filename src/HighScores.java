import java.io.*;
import java.util.*;
import java.awt.*;

public class HighScores {

	public static Write write;
	public static Display display;
	ArrayList<String> arrScores = new ArrayList<>(); //TODO use maps so name & score
	
	public void getScores() {
		String line = null;
		try {
			FileReader file = new FileReader("highscores.txt");
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(file);
			while((line = bufferedReader.readLine()) != null ) {
				arrScores.add(line);
				//System.out.println(line); //used for debugging
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void saveScores(String score) {
		
		try {
			Write info = new Write("highscores.txt", true);
			info.writeToFile(score);
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}