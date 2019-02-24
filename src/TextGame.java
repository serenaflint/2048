import java.util.ArrayList;
import java.util.Random;

public class TextGame {
	
	//the grid boi
	static int[][] gameGrid = new int[4][4];
	
	static int moveCount = 0;
	static int highestTile = 0;
	
	public void test() {
		onClickTiles();
		onClickTiles();
		printGame();
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
				ArrayList<Integer> twosFours = new ArrayList<Integer>();
				for(int i = 0; i < 10; i++) {
					if(i < 8) {
						twosFours.add(2);
					}
					else {
						twosFours.add(4);
					}
				}
				//If the random indices are blank, sets it to 2 or 4
				if(gameGrid[randRow][randCol] == 0) {
					// Finds a random index in twosFours array and sets it to that value
					gameGrid[randRow][randCol] = twosFours.get(rand.nextInt(10));
					blank = true;
				}
			}
		}
	
	public void moveDown() {
		int val = 0;
		boolean tileMoved = false;
		//for each col, for each row, starting at gameGrid[3][0], compares it to each digit in the col
		for (int col = 0; col < gameGrid.length; col++) {// col loop
			for (int row = gameGrid.length-1; row >= 0; row--) {// row loop
				for(int compare = row-1; compare>=0; compare--) {
					
					if (gameGrid[row][col] == 0) {
						if(gameGrid[compare][col] != 0)
							tileMoved = true;
						gameGrid[row][col] = gameGrid[compare][col];
						gameGrid[compare][col] = 0;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
					}// end of if
					else if (gameGrid[row][col] == gameGrid[compare][col]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[compare][col] = 0;
						gameGrid[row][col] = val;
						val = 0;
						tileMoved = true;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[compare][col] && gameGrid[row][col]!=0 && gameGrid[compare][col]!=0) {
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
				}// end of compare loop
			}//end of row loop
		}// end of col loop 
		if(tileMoved) {
			onClickTiles();
			moveCount++;
			System.out.println("Valid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		} else if(!tileMoved) {
			System.out.println("Invalid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		}
	}
	
	public void moveUp() {
		int val = 0;
		boolean tileMoved = false;
		//for each col, for each row, starting at gameGrid[0][0], compares it to each digit in the col
		for (int col = 0; col < gameGrid.length; col++) {// col loop
			for (int row = 0; row < gameGrid.length; row++) {// row loop
				for(int compare = row+1; compare<gameGrid.length; compare++) {
					if (gameGrid[row][col] == 0) {
						if(gameGrid[compare][col] != 0)
							tileMoved = true;
						gameGrid[row][col] = gameGrid[compare][col];
						gameGrid[compare][col] = 0;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
					}// end of if
					else if (gameGrid[row][col] == gameGrid[compare][col]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[compare][col] = 0;
						gameGrid[row][col] = val;
						val = 0;
						tileMoved = true;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[compare][col] && gameGrid[row][col]!=0 && gameGrid[compare][col]!=0) {
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
				}// end of compare loop
			}//end of row loop
		}// end of col loop
		if(tileMoved) {
			onClickTiles();
			moveCount++;
			System.out.println("Valid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		} else if(!tileMoved) {
			System.out.println("Invalid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		}
	}
	
	public void moveLeft() {
		int val = 0;
		boolean tileMoved = false;
		//for each row, for each col, starting at gameGrid[0][0], compares it to each digit in the col
		for (int row = 0; row < gameGrid.length; row++) {// col loop
			for (int col = 0; col < gameGrid.length; col++) {// row loop
				for(int compare = col+1; compare<gameGrid.length; compare++) {
					
					if (gameGrid[row][col] == 0) {
						if(gameGrid[row][compare] != 0)
							tileMoved = true;
						gameGrid[row][col] = gameGrid[row][compare];
						gameGrid[row][compare] = 0;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
					}// end of if
					else if (gameGrid[row][col] == gameGrid[row][compare]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[row][compare] = 0;
						gameGrid[row][col] = val;
						val = 0;
						tileMoved = true;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[row][compare] && gameGrid[row][col]!=0 && gameGrid[row][compare]!=0) {
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
				}// end of compare loop
			}//end of row loop
		}// end of col loop
		if(tileMoved) {
			onClickTiles();
			moveCount++;
			System.out.println("Valid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		} else if(!tileMoved) {
			System.out.println("Invalid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		}
	}
	
	public void moveRight() {
		int val = 0;
		boolean tileMoved = false;
		//for each row, for each col, starting at gameGrid[0][3], compares each digit to each digit in the col, then changes rows
		for (int row = 0; row < gameGrid.length; row++) {// row loop
			for (int col = gameGrid.length-1; col >= 0; col--) {// col loop
				for(int compare = col-1; compare>= 0; compare--) {
					
					if (gameGrid[row][col] == 0) {
						if(gameGrid[row][compare] != 0)
							tileMoved = true;
						gameGrid[row][col] = gameGrid[row][compare];
						gameGrid[row][compare] = 0;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						
					}// end of if
					else if (gameGrid[row][col] == gameGrid[row][compare]) {
						val = (gameGrid[row][col]) * 2;
						gameGrid[row][compare] = 0;
						gameGrid[row][col] = val;
						val = 0;
						tileMoved = true;
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
					else if (gameGrid[row][col] != gameGrid[row][compare] && gameGrid[row][col]!=0 && gameGrid[row][compare]!=0) {
						if(gameGrid[row][col] > highestTile)
							highestTile = gameGrid[row][col];
						break;
					} // end of else
				}// end of compare loop
			}//end of col loop
		}// end of row loop
		if(tileMoved) {
			onClickTiles();
			moveCount++;
			System.out.println("Valid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		} else if(!tileMoved) {
			System.out.println("Invalid Move! Total Moves: " + moveCount + " Max on board tile: " + highestTile);
			System.out.println();
		}
	}
	
	// Checks to see 1. If any tiles are blank or 2. if there are any moves left to make. Returns false if it's time for the game to end
	public boolean checkMoves() {
		for (int row = 0; row < gameGrid.length; row++) {// row loop
			for (int col = 0; col < gameGrid.length; col++) {// col loop
				if(gameGrid[row][col] == 0)
					return true;
				else if(col == gameGrid.length-1 && row != gameGrid.length-1) {
					if(gameGrid[row][col] == gameGrid[row+1][col])
						return true;
				}
				else if(col != gameGrid.length-1 && row == gameGrid.length-1) {
					if(gameGrid[row][col] == gameGrid[row][col+1])
						return true;
				}
				else if(col != gameGrid.length-1 && row != gameGrid.length-1){
					if(gameGrid[row][col] == gameGrid[row][col+1] || gameGrid[row][col] == gameGrid[row+1][col])
						return true;
				}
			}//end of col loop
		}// end of row loop
		return false;
	}
	
	//Checks to see if there is a 2048 tile
	public boolean win() {
		for (int row = 0; row < gameGrid.length; row++) 
			for (int col = 0; col < gameGrid.length; col++)
				if(gameGrid[row][col] == 2048)
					return true;
		return false;
	}
	
	//Prints game in grid format
	public void printGame() {
		for (int i = 0; i < gameGrid.length; i++) {
	        for(int j = 0; j < gameGrid[i].length; j++) {
	           System.out.print(gameGrid[i][j] + " ");
	        }
	        System.out.println("");
	     }
		System.out.println("");
	}
	
	//Clears the game grid
	public void clearGrid() {
		for (int i = 0; i < gameGrid.length; i++) {
	        for(int j = 0; j < gameGrid[i].length; j++) {
	          gameGrid[i][j] = 0;
	        }
	     }
		moveCount = 0;
	}
	
}
