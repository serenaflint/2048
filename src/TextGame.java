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
		//for each col, for each row, starting at gameGrid[3][0], compares it to each digit in the col
		for (int col = 0; col < gameGrid.length; col++) {// col loop
			for (int row = gameGrid.length-1; row >= 0; row--) {// row loop
				for(int compare = row-1; compare>=0; compare--) {
					
					if (gameGrid[row][col] == 0) {
						gameGrid[row][col] = gameGrid[compare][col];
						gameGrid[compare][col] = 0;
					}// end of if
					else if (gameGrid[row][col] == gameGrid[compare][col]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[compare][col] = 0;
						gameGrid[row][col] = val;
						val = 0;
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[compare][col] && gameGrid[row][col]!=0 && gameGrid[compare][col]!=0) {
						break;
					} // end of else
				}// end of compare loop
			}//end of row loop
		}// end of col loop 
		onClickTiles();
	}
	
	public static void moveUp() {
		int val = 0;
		//for each col, for each row, starting at gameGrid[0][0], compares it to each digit in the col
		for (int col = 0; col < gameGrid.length; col++) {// col loop
			for (int row = 0; row < gameGrid.length; row++) {// row loop
				for(int compare = row+1; compare<gameGrid.length; compare++) {
					
					if (gameGrid[row][col] == 0) {
						gameGrid[row][col] = gameGrid[compare][col];
						gameGrid[compare][col] = 0;
					}// end of if
					else if (gameGrid[row][col] == gameGrid[compare][col]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[compare][col] = 0;
						gameGrid[row][col] = val;
						val = 0;
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[compare][col] && gameGrid[row][col]!=0 && gameGrid[compare][col]!=0) {
						break;
					} // end of else
				}// end of compare loop
			}//end of row loop
		}// end of col loop
		onClickTiles();
	}
	
	public static void moveLeft() {
		int val = 0;
		//for each row, for each col, starting at gameGrid[0][0], compares it to each digit in the col
		for (int row = 0; row < gameGrid.length; row++) {// col loop
			for (int col = 0; col < gameGrid.length; col++) {// row loop
				for(int compare = col+1; compare<gameGrid.length; compare++) {
					
					if (gameGrid[row][col] == 0) {
						gameGrid[row][col] = gameGrid[row][compare];
						gameGrid[row][compare] = 0;
					}// end of if
					else if (gameGrid[row][col] == gameGrid[row][compare]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[row][compare] = 0;
						gameGrid[row][col] = val;
						val = 0;
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[row][compare] && gameGrid[row][col]!=0 && gameGrid[row][compare]!=0) {
						break;
					} // end of else
				}// end of compare loop
			}//end of row loop
		}// end of col loop
	}// Problems so far! If theres a 0 between two numbers tha should combine, they don't combine, they just go next to each other
	// ex: 2, 4, 0, 4 turns into 2, 4, 4, 0 instead of 2, 8, 0, 0
	
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
		onClickTiles();
		onClickTiles();
		onClickTiles();
		onClickTiles();
		onClickTiles();
		onClickTiles();
		onClickTiles();
		onClickTiles();
		onClickTiles();
		printGame();
		moveLeft();
		printGame();
	}

}
