import java.util.Random;

public class TextGame {
	
	//the grid boi
	static int[][] gameGrid = new int[4][4];
	
	public static void startingTiles() {
		boolean blank = false;
		int randRow = 0;
		int randCol = 0;
		for(int i = 0; i < 2; i ++) {
			while(blank == false) {
				// create instance of Random class and finds random tile
				Random rand = new Random(); 
				randRow = rand.nextInt(4);	
				randCol = rand.nextInt(4);
				if(gameGrid[randRow][randCol] == 0) {
					gameGrid[randRow][randCol] = 2;
					blank = true;
				}
			}
			blank = false;
		}
		
	}
	public static void runGame() {
		
	}
	
	//Prints game in grid format
	public static void printGame() {
		for (int i = 0; i < gameGrid.length; i++) {
	        for(int j = 0; j < gameGrid[i].length; j++) {
	           System.out.print(gameGrid[i][j] + " ");
	        }
	        System.out.println("");
	     }
	}

	public static void main(String[] args) {
		// Alright sluts, we're making this textbased first
		printGame();
		startingTiles();
		printGame();
	}

}
