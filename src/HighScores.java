import java.io.*;
import java.util.*;

public class HighScores {

	public static Write write;
	public static Display display;
	ArrayList<String> arrScores = new ArrayList<>();
	public static int numScores = 0;
	public static boolean hasEnough = false;
	
	//Pulls scores from text document and adds them to arrScores
	public void getScores() {
		String line = null;
		numScores = 0;
		try {
			FileReader file = new FileReader("highscores.txt");
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(file);
			while((line = bufferedReader.readLine()) != null ) {
				numScores++;
				if(hasEnough) { //prevents double counting lines
					arrScores.add(line);
					//System.out.println(line); //used for debugging		
				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	//Saves scores to text document
	public void saveScores(String score) {
		try {
			Write info = new Write("highscores.txt", true);
			info.writeToFile(score);
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	//Checks to see if there are 10 scores, adds scores if necessary
	public void checkScores() {
		hasEnough = false;
		while(!hasEnough) {
			getScores();
			if(numScores < 10) {
				saveScores("00000");
				hasEnough = false;
			} else if(numScores >= 10) {
				hasEnough = true;
			}
		}
	}
	
}