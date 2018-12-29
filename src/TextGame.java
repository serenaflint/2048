import java.util.Random;

public class TextGame {
	
	//the grid boi
	static int[][] gameGrid = new int[4][4];
	
	
	public static void blankTile(int row, int col) {
		boolean blank = false;
		int randRow = 0;
		int randCol = 0;
		while(blank == false) {
			// create instance of Random class and finds random tile
			Random rand = new Random(); 
			randRow = rand.nextInt(4);	
			randCol = rand.nextInt(4);
			if(gameGrid[randRow][randCol] == 0) {
				blank = true;
			}
		}
		row = randRow;
		col = randCol;
	}
	public static void startingTiles() {
		int row = 1;
		int col = 1;
		blankTile(row, col);
		System.out.println(row + " " + col);
		gameGrid[row][col] = 2;
		blankTile(row, col);
		gameGrid[row][col] = 2;
		
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
