import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Engine implements KeyListener, MouseListener{

	public enum GameState{
		MENU, RUN, END, OPTIONS, HS
	}
	
	public GameState state;
	
	public static Display display;
	public static Write write;
	public static Colors colors;
	public static HighScores hs;
	public static TextGame txg;
	
	static Font h1 = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	static Font h2 = new Font(Font.SANS_SERIF, Font.BOLD, 50);
	static Font tile = new Font(Font.SANS_SERIF, Font.BOLD, 75);
	static Font text = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	static Font stext = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	Color a, b, c, d, e;
	static Color dgrey = new Color(82, 82, 82);
	static Color offwhite = new Color(254, 253, 251);
	
	static boolean pause = false;
	static boolean won = false;
	static int cscore = 0;
	
	//Constructor
	public Engine() {
		display = new Display(this);
		colors = new Colors(a, b, c, d, e);
		hs = new HighScores();
		txg = new TextGame();
	}
	
	//Returns current display
	Display getDisplay() {
		return display;
	}
	
	//Initializes certain variables in the game
	public void initializeGame() {
		state = GameState.MENU;
		colors.setScheme("WARM");
		txg.test(); //used to test text game
	}
	
	//Draws the beginning start menu
	public void drawMenu(Graphics g) {
		
		//determines what colors to used based on the scheme
		colors.setCurrentColors();
		
		//title
		g.setFont(h1);
		g.setColor(dgrey);
		g.drawString("2048", display.getWidth()/2-110, display.getHeight()/2-120);
		
		//boxes
		g.setColor(colors.getB());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+80, 280, 60, 20, 15);
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+160, 280, 60, 20, 15);
		g.setColor(colors.getD());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+240, 280, 60, 20, 15);
		
		//text in the boxes
		g.setColor(offwhite);
		g.setFont(text);
		g.drawString("Play Game", display.getWidth()/2-70, display.getHeight()/2+120);
		g.drawString("High Scores", display.getWidth()/2-80, display.getHeight()/2+200);
		g.drawString("Options", display.getWidth()/2-60, display.getHeight()/2+280);
	}
	
	//Draws Options Menu
	public void drawOptions(Graphics g) {
		colors.setCurrentColors();
		
		//titles
		g.setFont(h1);
		g.setColor(dgrey);
		g.drawString("Options", display.getWidth()/2-180, 200);
		
		g.setFont(h2);
		g.drawString("Color Scheme", 75, 340);
		
		//boxes
		g.setColor(colors.cW);
		g.fillRoundRect(100, 380, 280, 60, 20, 15);
		g.setColor(colors.bC);
		g.fillRoundRect(100, 460, 280, 60, 20, 15);
		g.setColor(colors.cP);
		g.fillRoundRect(100, 540, 280, 60, 20, 15);
		g.setColor(colors.bN);
		g.fillRoundRect(100, 620, 280, 60, 20, 15);
		g.setColor(colors.cG);
		g.fillRoundRect(100, 700, 280, 60, 20, 15);
		
		//text in the boxes
		g.setColor(offwhite);
		g.setFont(text);
		g.drawString("Warm", 195, 420);
		g.drawString("Cool", 205, 500);
		g.drawString("Pastel", 190, 580);
		g.drawString("Natural", 185, 660);
		g.drawString("Grey", 200, 740);
		
		//Main Menu (return to)
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+360, 280, 60, 20, 15);
		g.setColor(offwhite);
		g.setFont(text);
		if(!pause) {
			g.drawString("Main Menu", display.getWidth()/2-80, display.getHeight()/2+400);
		} else if(pause) {
			g.drawString("Return", display.getWidth()/2-50, display.getHeight()/2+400);
		}
	}
	
	//Draws High Scores Menu
	public void drawHS(Graphics g) {
		//Main Menu (return to)
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+360, 280, 60, 20, 15);
		g.setColor(offwhite);
		g.setFont(text);
		g.drawString("Main Menu", display.getWidth()/2-80, display.getHeight()/2+400);
		
		hs.checkScores();
		hs.getScores();
		Collections.sort(hs.arrScores, Collections.reverseOrder()); //re-sorts the list from highest to lowest
		 
		//title
		g.setColor(dgrey);
		g.setFont(h1);
		g.drawString("High Scores", display.getWidth()/2-300, 200);
		
		//scores
		g.setFont(h2);
		 for (int i=0; i<10; i++) {
	         //System.out.println(hs.arrScores.get(i)); //used for debugging
	         g.drawString(hs.arrScores.get(i), display.getWidth()/2-70, 310+50*i);
	    }	
	}

	//Draws basic elements of the running game
	public void drawRShell(Graphics g) {
		
		//Board background
		g.setColor(new Color(169, 157, 143)); //soft grey-brown
		g.fillRoundRect(display.getWidth()/2-300, display.getHeight()/2-300, 600 , 600, 20, 20);
		
		//Title
		g.setFont(h1);
		g.setColor(dgrey);
		g.drawString("2048", display.getWidth()/2-300, display.getHeight()/2-350);
	
		//Current Score box
		g.setColor(new Color(169, 157, 143)); //soft grey-brown
		g.fillRoundRect(display.getWidth()/2+100, display.getHeight()/2-425, 200, 80, 15, 15);
		g.setFont(stext);
		g.setColor(offwhite);
		g.drawString("Score", display.getWidth()/2+175, display.getHeight()/2-400);
		g.setFont(text);
		g.drawString(formattedScore(), display.getWidth()/2+158, display.getHeight()/2-360);
		
		//Restart Button
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2, display.getHeight()/2-425, 80, 80, 15, 15);
		g.setFont(tile);
		g.setColor(offwhite);
		char symbolC = 0x27F2;
		String symbolS = String.valueOf(symbolC);
		g.drawString(symbolS, display.getWidth()/2+6, display.getHeight()/2-363);
		
		//Main Menu box
		colors.setCurrentColors();
		g.setFont(text);
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-300, display.getHeight()/2+340, 260, 60, 15, 15);
		g.setColor(offwhite);
		g.drawString("Main Menu", display.getWidth()/2-250, display.getHeight()/2+380);
		
		//Options box
		g.setColor(colors.getD());
		g.fillRoundRect(display.getWidth()/2+40, display.getHeight()/2+340, 260, 60, 15, 15);
		g.setColor(offwhite);
		g.drawString("Options", display.getWidth()/2+115, display.getHeight()/2+380);
	}
	
	public void drawTileGrid(Graphics g) {
		for(int row = 0; row < txg.gameGrid.length; row++) {
			for(int col = 0; col < txg.gameGrid[row].length; col++) {
				if(txg.gameGrid[row][col] == 0) {
					g.setColor(colors.emptyA);
					g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
				
				} else {
					formatTile(g, txg.gameGrid[row][col], row, col);
				}
			}
		}
	}
	
	public void drawEnd(Graphics g) {
		drawRShell(g);
		drawTileGrid(g);
		g.setColor(colors.trans);
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		g.setColor(dgrey);
		g.setFont(h1);
		if(txg.win() && !won) {
			g.drawString("You Win!", display.getWidth()/2-220, display.getHeight()/2+40);
		} else {
			g.drawString("Game Over", display.getWidth()/2-265, display.getHeight()/2+40);
		}

	}
	
	public void formatTile(Graphics g, int val, int row, int col) {
		switch (val) {
		case 2:
			g.setColor(colors.getA());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-244+148*col, display.getHeight()/2-197+148*row);
			break;
		case 4:
			g.setColor(colors.getB());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-244+148*col, display.getHeight()/2-197+148*row);
			break;
		case 8:
			g.setColor(colors.getC());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-244+148*col, display.getHeight()/2-197+148*row);
			break;
		case 16:
			g.setColor(colors.getD());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		case 32:
			g.setColor(colors.getE());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		case 64:
			g.setColor(colors.getB());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		case 128:
			g.setColor(colors.getC());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-286+148*col, display.getHeight()/2-197+148*row);
			break;
		case 256:
			g.setColor(colors.getD());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-284+148*col, display.getHeight()/2-197+148*row);
			break;
		case 512:
			g.setColor(colors.getE());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(tile);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-284+148*col, display.getHeight()/2-197+148*row);
			break;
		case 1024:
			g.setColor(colors.getC());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(h2);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-278+148*col, display.getHeight()/2-204+148*row);
			break;
		case 2048:
			g.setColor(colors.getD());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(h2);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		default:
			g.setColor(colors.defaultA);
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(offwhite);
			g.setFont(h2);
			g.drawString("" + txg.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			
		}
	}
	
	//Formats score to look more populated
	public String formattedScore() {
		if(cscore < 10) {
			return "0000" + cscore;
		} else if(cscore < 100) {
			return "000" + cscore;
		} else if(cscore < 1000) {
			return "00" + cscore;
		} else if(cscore < 10000) {
			return "0" + cscore;
		} else {
			return "" + cscore;
		}
	}
	
	@Override
 	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			display.repaint();
			txg.moveUp();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			break;
		case KeyEvent.VK_DOWN:
			display.repaint();
			txg.moveDown();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			
			break;
		case KeyEvent.VK_LEFT:
			display.repaint();
			txg.moveLeft();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			break;
		case KeyEvent.VK_RIGHT:
			display.repaint();
			txg.moveRight();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xpos = e.getX();
		int ypos = e.getY();
		//System.out.println(xpos + ", " + ypos); //used to debug mouse position
		
		switch(state) {
		
		case MENU:
			if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+80 && ypos <= display.getHeight()/2+140)) {
				//If mouse is within Play Game box...
				state = GameState.RUN;
				display.repaint();
			} else if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+160 && ypos <= display.getHeight()/2+220)) {
				//If mouse is within High Scores box...
				state = GameState.HS;
				display.repaint();
			} else if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+240 && ypos <= display.getHeight()/2+300)) {
				//If mouse is within Options box...
				state = GameState.OPTIONS;
				display.repaint();
			}
			break;
		
		case OPTIONS:
			if((xpos >= 100 && xpos <= 380) && (ypos >= 380 && ypos <= 440)) {
				//If mouse is within Warm box...
				colors.setScheme("WARM");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 460 && ypos <= 520)) {
				//If mouse is within Cool box...
				colors.setScheme("COOL");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 540 && ypos <= 600)) {
				//If mouse is within Pastel box...
				colors.setScheme("PASTEL");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 620 && ypos <= 680)) {
				//If mouse is within Natural box...
				colors.setScheme("NATURAL");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 700 && ypos <= 760)) {
				//If mouse is within Grey box...
				colors.setScheme("GREY");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+360 && ypos <= display.getHeight()/2+420)) {
				//If mouse is within Main Menu/Return box...
				if(!pause) {
					state = GameState.MENU;
				} else if(pause) {
					state = GameState.RUN;
					pause = false;
				}
				display.repaint();
			}
			break;
			
		case HS:
			if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+360 && ypos <= display.getHeight()/2+420)) {
				//If mouse is within Main Menu box...
				state = GameState.MENU;
				display.repaint();
			}
			break;
		
		case RUN:
			if((xpos >= display.getWidth()/2-300 && xpos <= display.getWidth()/2-40) && (ypos >= display.getHeight()/2+340 && ypos <= display.getHeight()/2+400)) {
				//If mouse is within Main Menu box...
				state = GameState.MENU;
				display.repaint();
			} else if((xpos >= display.getWidth()/2+40 && xpos <= display.getWidth()/2+300) && (ypos >= display.getHeight()/2+340 && ypos <= display.getHeight()/2+400)) {
				//If mouse is within Options box...
				pause = true;
				state = GameState.OPTIONS;
				display.repaint();
			} else if((xpos >= display.getWidth()/2 && xpos <= display.getWidth()/2+80) && (ypos >= display.getHeight()/2-425 && ypos <= display.getHeight()/2-425+80)) {
				//If mouse is within Restart button...g
				System.out.println("RESTART");
				won = false;
				txg.clearGrid();
				cscore = 0;
				txg.test();
				display.repaint();
			}
			break;
		case END:
			if(txg.win() && !won) {
				won = true;
				state = GameState.RUN;
				display.repaint();
			} else {
				won = false;
				txg.clearGrid();
				txg.test();
				state = GameState.RUN;
				display.repaint();
			}
			break;
		default:
			System.out.println("DEFAULT");
			break;
		}
	}

	//Unused listener methods
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {	
	}
}
