import java.util.Random;

public class TextGame {
	
	//the grid boi
	static int[][] gameGrid = new int[4][4];
	
	//method for setting the game at the start
	public static void startingTiles() {
		boolean blank = false;
		int randRow = 0;
		int randCol = 0;
		//finds 2 blank spaces
		for(int i = 0; i < 2; i ++) {
			while(blank == false) {
				// create instance of Random class and finds random tile
				Random rand = new Random(); 
				randRow = rand.nextInt(4);	
				randCol = rand.nextInt(4);
				//If the random indices are blank, sets it to 2
				if(gameGrid[randRow][randCol] == 0) {
					gameGrid[randRow][randCol] = 2;
					blank = true;
				}
			}
			// blank is set back to false so it can go through the loop to find a second blank space
			blank = false;
		}
		
	}
	
	//method for placing a new tile
	public static void onClickTiles() {
		boolean blank = false;
		int randRow = 0;
		int randCol = 0;
		while(blank == false) {
			// create instance of Random class and finds random tile
			Random rand = new Random(); 
			randRow = rand.nextInt(4);	
			randCol = rand.nextInt(4);
			//If the random indices are blank, sets it to 2 or 4
			if(gameGrid[randRow][randCol] == 0) {
				// Finds a random int 0 or 1, then adds 1 and multiplies by 2 to get either 2 or 4
				gameGrid[randRow][randCol] = (rand.nextInt(2)+1)*2;
				blank = true;
			}
		}
	}
	
	public static void moveDown() {
		int val = 0;
		//for each col, for each row, starting at gameGrid[3][0], check for a first digit, then for a second, compare, add
		for (int col = 0; col < gameGrid.length; col++) {// i loop
			for (int row = 0; row < gameGrid.length-1; row++) {// j loop
				if (gameGrid[row + 1][col] == 0) {
					gameGrid[row + 1][col] = gameGrid[row][col];
					gameGrid[row][col] = 0;
				}// end of if
				else if (gameGrid[row + 1][col] == gameGrid[row][col]) {
					val = gameGrid[row + 1][col] * 2;
					gameGrid[row][col] = 0;
					gameGrid[row + 1][col] = val;
					val = 0;
				}// end of else
			}// end of j loop
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
		System.out.println("");
	}

	public static void main(String[] args) {
		// Alright sluts, we're making this textbased first
		startingTiles();
		printGame();
		onClickTiles();
		printGame();
		onClickTiles();
		printGame();
	}

}
