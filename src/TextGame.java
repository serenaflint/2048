
public class TextGame {
	
	//the grid boi
	static int[][] gameGrid = new int[4][4];
	
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
		
	}

}
