import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Engine implements KeyListener, MouseListener{

	//enum to control game states
	public enum GameState{
		MENU, RUN, END, OPTIONS, HS, RESTART
	}
	
	public GameState state;
	
	//create instances of other classes
	public static Display display;
	public static Write write;
	public static Colors colors;
	public static HighScores hs;
	public static TextGame txg;
	public static Sound sound;
	
	//used for styling
	static Font h1 = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	static Font h2 = new Font(Font.SANS_SERIF, Font.BOLD, 50);
	static Font tile = new Font(Font.SANS_SERIF, Font.BOLD, 75);
	static Font text = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	static Font stext = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	Color a, b, c, d, e;
	
	//booleans to control certain conditions
	static boolean pause = false;
	static boolean won = false;
	static boolean useSound = true;
	static boolean useMusic = true;
	static boolean r = false;
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
		Sound.preload();
		state = GameState.MENU;
		colors.setScheme("WARM");
		txg.test(); //used to test text game
		Sound.BACKGROUND.loop();
	}
	
	//Draws the beginning start menu
	public void drawMenu(Graphics g) {
		
		//determines what colors to used based on the scheme
		colors.setCurrentColors();
		
		//title
		g.setFont(h1);
		g.setColor(colors.dgrey);
		g.drawString("2048", display.getWidth()/2-110, display.getHeight()/2-120);
		
		//boxes
		g.setColor(colors.getB());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+80, 280, 60, 20, 15);
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+160, 280, 60, 20, 15);
		g.setColor(colors.getD());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+240, 280, 60, 20, 15);
		
		//text in the boxes
		g.setColor(colors.offwhite);
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
		g.setColor(colors.dgrey);
		g.drawString("Options", display.getWidth()/2-180, 200);
		
		g.setFont(h2);
		g.drawString("Color Scheme", 75, 340);
		
		//boxes, used definite colors
		g.setColor(colors.cW);
		g.fillRoundRect(100, 380, 280, 60, 20, 15);
		g.setColor(colors.bC);
		g.fillRoundRect(100, 460, 280, 60, 20, 15);
		g.setColor(colors.cP);
		g.fillRoundRect(100, 540, 280, 60, 20, 15);
		g.setColor(colors.eR);
		g.fillRoundRect(100, 620, 280, 60, 20, 15);
		g.setColor(colors.cG);
		g.fillRoundRect(100, 700, 280, 60, 20, 15);
		
		//text in the boxes
		g.setColor(colors.offwhite);
		g.setFont(text);
		g.drawString("Warm", 195, 420);
		g.drawString("Cool", 205, 500);
		g.drawString("Pastel", 190, 580);
		g.drawString("Retro", 195, 660);
		g.drawString("Grey", 200, 740);
		
		//Main Menu (return to)
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+360, 280, 60, 20, 15);
		g.setColor(colors.offwhite);
		g.setFont(text);
		if(!pause) {
			g.drawString("Main Menu", display.getWidth()/2-80, display.getHeight()/2+400);
		} else if(pause) {
			g.drawString("Return", display.getWidth()/2-50, display.getHeight()/2+400);
		}
		
		//Sound and Music Options
		g.setColor(colors.dgrey);
		g.setFont(h2);
		g.drawString("Sound", 680, 340);
		g.drawString("Music", 684, 510);
		if(useSound) {
			g.setColor(colors.oOff);
			g.fillRoundRect(620, 380, 280, 60, 20, 15);
			g.setFont(text);
			g.setColor(colors.offwhite);
			g.drawString("Turn Off", 704, 420);
		} else if (!useSound){
			g.setColor(colors.dW);
			g.fillRoundRect(620, 380, 280, 60, 20, 15);
			g.setFont(text);
			g.setColor(colors.offwhite);
			g.drawString("Turn On", 704, 420);
		}
		
		if(useMusic) {
			g.setColor(colors.oOff);
			g.fillRoundRect(620, 540, 280, 60, 20, 15);
			g.setFont(text);
			g.setColor(colors.offwhite);
			g.drawString("Turn Off", 704, 580);
		} else if(!useMusic){
			g.setColor(colors.dW);
			g.fillRoundRect(620, 540, 280, 60, 20, 15);
			g.setFont(text);
			g.setColor(colors.offwhite);
			g.drawString("Turn On", 704, 580);
		}
	}
	
	//Draws High Scores Menu
	public void drawHS(Graphics g) {
		//Main Menu (return to)
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+360, 280, 60, 20, 15);
		g.setColor(colors.offwhite);
		g.setFont(text);
		g.drawString("Main Menu", display.getWidth()/2-80, display.getHeight()/2+400);
		
		hs.checkScores();
		hs.getScores();
		Collections.sort(hs.arrScores, Collections.reverseOrder()); //re-sorts the list from highest to lowest
		 
		//title
		g.setColor(colors.dgrey);
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
		g.setColor(colors.dgrey);
		g.drawString("2048", display.getWidth()/2-300, display.getHeight()/2-350);
	
		//Current Score box
		g.setColor(new Color(169, 157, 143)); //soft grey-brown
		g.fillRoundRect(display.getWidth()/2+100, display.getHeight()/2-425, 200, 80, 15, 15);
		g.setFont(stext);
		g.setColor(colors.offwhite);
		g.drawString("Score", display.getWidth()/2+175, display.getHeight()/2-400);
		g.setFont(text);
		g.drawString(formattedScore(), display.getWidth()/2+158, display.getHeight()/2-360);
		
		//Restart Button
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2, display.getHeight()/2-425, 80, 80, 15, 15);
		g.setFont(tile);
		g.setColor(colors.offwhite);
		char symbolC = 0x27F2;
		String symbolS = String.valueOf(symbolC);
		g.drawString(symbolS, display.getWidth()/2+6, display.getHeight()/2-363);
		
		//Main Menu box
		colors.setCurrentColors();
		g.setFont(text);
		g.setColor(colors.getC());
		g.fillRoundRect(display.getWidth()/2-300, display.getHeight()/2+340, 260, 60, 15, 15);
		g.setColor(colors.offwhite);
		g.drawString("Main Menu", display.getWidth()/2-250, display.getHeight()/2+380);
		
		//Options box
		g.setColor(colors.getD());
		g.fillRoundRect(display.getWidth()/2+40, display.getHeight()/2+340, 260, 60, 15, 15);
		g.setColor(colors.offwhite);
		g.drawString("Options", display.getWidth()/2+115, display.getHeight()/2+380);
	}
	
	//creates the grid of tiles
	public void drawTileGrid(Graphics g) {
		for(int row = 0; row < TextGame.gameGrid.length; row++) {
			for(int col = 0; col < TextGame.gameGrid[row].length; col++) {
				if(TextGame.gameGrid[row][col] == 0) {
					g.setColor(colors.emptyA);
					g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
				
				} else {
					formatTile(g, TextGame.gameGrid[row][col], row, col);
				}
			}
		}
	}
	
	//Draws the end screen
	public void drawEnd(Graphics g) {
		drawRShell(g);
		drawTileGrid(g);
		g.setColor(colors.trans);
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		g.setColor(colors.dgrey);
		g.setFont(h1);
		if(txg.win() && !won) {
			g.drawString("You Win!", display.getWidth()/2-220, display.getHeight()/2+40);
		} else {
			g.drawString("Game Over", display.getWidth()/2-265, display.getHeight()/2+40);
		}
	}
	
	public void verify(Graphics g) {
		drawRShell(g);
		drawTileGrid(g);
		g.setColor(colors.trans);
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		g.setColor(colors.dgrey);
		g.setFont(h1);
		g.drawString("Are you sure?", display.getWidth()/2-285, display.getHeight()/2-30);
		g.setColor(new Color(169, 157, 143)); //soft grey-brown
		g.fillRoundRect(display.getWidth()/2-120, display.getHeight()/2+40, 80, 80, 20, 15); //Y
		g.fillRoundRect(display.getWidth()/2+40, display.getHeight()/2+40, 80, 80, 20, 15); //N
		g.setColor(colors.offwhite);
		g.setFont(h2);
		g.drawString("Y", display.getWidth()/2-95, display.getHeight()/2+100); //Y
		g.drawString("N", display.getWidth()/2+65 , display.getHeight()/2+100); //Y
	}
	
	//determines how each type of tile appears
	public void formatTile(Graphics g, int val, int row, int col) {
		switch (val) {
		case 2:
			g.setColor(colors.getA());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			if(colors.getA() == colors.aP) {
				g.setColor(colors.lyGrey);
			} else {
				g.setColor(colors.offwhite);
			}
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-244+148*col, display.getHeight()/2-197+148*row);
			break;
		case 4:
			g.setColor(colors.getB());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			if(colors.getB() == colors.bP) {
				g.setColor(colors.lcGrey);
			} else {
				g.setColor(colors.offwhite);
			}
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-244+148*col, display.getHeight()/2-197+148*row);
			break;
		case 8:
			g.setColor(colors.getC());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-244+148*col, display.getHeight()/2-197+148*row);
			break;
		case 16:
			g.setColor(colors.getD());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		case 32:
			g.setColor(colors.getE());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		case 64:
			g.setColor(colors.getB());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			if(colors.getB() == colors.bP) {
				g.setColor(colors.lcGrey);
			} else {
				g.setColor(colors.offwhite);
			}
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		case 128:
			g.setColor(colors.getC());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-286+148*col, display.getHeight()/2-197+148*row);
			break;
		case 256:
			g.setColor(colors.getD());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-284+148*col, display.getHeight()/2-197+148*row);
			break;
		case 512:
			g.setColor(colors.getE());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(tile);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-284+148*col, display.getHeight()/2-197+148*row);
			break;
		case 1024:
			g.setColor(colors.getC());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(h2);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-278+148*col, display.getHeight()/2-204+148*row);
			break;
		case 2048:
			g.setColor(colors.getD());
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(h2);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
		default:
			g.setColor(colors.defaultA);
			g.fillRoundRect(display.getWidth()/2-292+148*col, display.getHeight()/2-292+148*row, 140, 140, 15, 15);
			g.setColor(colors.offwhite);
			g.setFont(h2);
			g.drawString("" + TextGame.gameGrid[row][col], display.getWidth()/2-266+148*col, display.getHeight()/2-197+148*row);
			break;
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
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			display.repaint();
			txg.moveUp();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			break;
			
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			display.repaint();
			txg.moveDown();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			
			break;
			
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			display.repaint();
			txg.moveLeft();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			break;
			
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			display.repaint();
			txg.moveRight();
			txg.printGame();
			if(!txg.checkMoves() || (txg.win() && won == false)) {
				System.out.println("GAME OVER");
				state = GameState.END;
			}
			break;
		case KeyEvent.VK_R:
			if(useSound) {
				Sound.CLICK.play();
			}
			state = GameState.RESTART;
			display.repaint();
			System.out.print("Are you sure you want to restart? Y/N\n");
			
			break;
		case KeyEvent.VK_Y:
			if(useSound) {
				Sound.CLICK.play();
			}
			if(state == GameState.RESTART) {
				System.out.println("Restarting...");
				won = false;
				txg.clearGrid();
				cscore = 0;
				txg.test();
				TextGame.moveCount = 0;
				state = GameState.RUN;
				display.repaint();
			}
			
			display.repaint();
			break;
		case KeyEvent.VK_N:
			if(useSound) {
				Sound.CLICK.play();
			}
			state = GameState.RUN;
			display.repaint();
			break;
		default:
			System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
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
				if(useSound) {
					Sound.CLICK.play();
				}
				state = GameState.RUN;
				display.repaint();
			} else if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+160 && ypos <= display.getHeight()/2+220)) {
				//If mouse is within High Scores box...
				if(useSound) {
					Sound.CLICK.play();
				}
				state = GameState.HS;
				display.repaint();
			} else if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+240 && ypos <= display.getHeight()/2+300)) {
				//If mouse is within Options box...
				if(useSound) {
					Sound.CLICK.play();
				}
				state = GameState.OPTIONS;
				display.repaint();
			}
			break;
		
		case OPTIONS:
			if((xpos >= 100 && xpos <= 380) && (ypos >= 380 && ypos <= 440)) {
				//If mouse is within Warm box...
				if(useSound) {
					Sound.CLICK.play();
				}
				colors.setScheme("WARM");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 460 && ypos <= 520)) {
				//If mouse is within Cool box...
				if(useSound) {
					Sound.CLICK.play();
				}
				colors.setScheme("COOL");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 540 && ypos <= 600)) {
				//If mouse is within Pastel box...
				if(useSound) {
					Sound.CLICK.play();
				}
				colors.setScheme("PASTEL");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 620 && ypos <= 680)) {
				//If mouse is within Retro box...
				if(useSound) {
					Sound.CLICK.play();
				}
				colors.setScheme("RETRO");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= 100 && xpos <= 380) && (ypos >= 700 && ypos <= 760)) {
				//If mouse is within Grey box...
				if(useSound) {
					Sound.CLICK.play();
				}
				colors.setScheme("GREY");
				colors.setCurrentColors();
				display.repaint();
			} else if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+360 && ypos <= display.getHeight()/2+420)) {
				//If mouse is within Main Menu/Return box...
				if(useSound) {
					Sound.CLICK.play();
				}
				if(!pause) {
					state = GameState.MENU;
				} else if(pause) {
					state = GameState.RUN;
					pause = false;
				}
				display.repaint();
			} else if((xpos >= 620 && xpos <= 900) && (ypos >= 380 && ypos <= 440)) {
				//If mouse in within Sound box
				if(useSound) {
					useSound = false;
					display.repaint();
				} else if (!useSound){
					useSound = true;
					Sound.CLICK.play();
					display.repaint();
				}
			} else if((xpos >= 620 && xpos <= 900) && (ypos >= 540 && ypos <= 600)) {
				//If mouse is within Music box
				if(useSound) {
					Sound.CLICK.play();
					display.repaint();
				}
				if(useMusic) {
					useMusic = false;
					display.repaint();
					Sound.BACKGROUND.stop();
				} else if (!useMusic){
					useMusic = true;
					display.repaint();
					Sound.BACKGROUND.loop();
				}
			}
			break;
			
		case HS:
			if((xpos >= display.getWidth()/2-140 && xpos <= display.getWidth()/2+140) && (ypos >= display.getHeight()/2+360 && ypos <= display.getHeight()/2+420)) {
				//If mouse is within Main Menu box...
				if(useSound) {
					Sound.CLICK.play();
				}
				state = GameState.MENU;
				display.repaint();
			}
			break;
		
		case RUN:
			if((xpos >= display.getWidth()/2-300 && xpos <= display.getWidth()/2-40) && (ypos >= display.getHeight()/2+340 && ypos <= display.getHeight()/2+400)) {
				//If mouse is within Main Menu box...
				if(useSound) {
					Sound.CLICK.play();
				}
				state = GameState.MENU;
				display.repaint();
			} else if((xpos >= display.getWidth()/2+40 && xpos <= display.getWidth()/2+300) && (ypos >= display.getHeight()/2+340 && ypos <= display.getHeight()/2+400)) {
				//If mouse is within Options box...
				if(useSound) {
					Sound.CLICK.play();
				}
				pause = true;
				state = GameState.OPTIONS;
				display.repaint();
			} else if((xpos >= display.getWidth()/2 && xpos <= display.getWidth()/2+80) && (ypos >= display.getHeight()/2-425 && ypos <= display.getHeight()/2-425+80)) {
				//If mouse is within Restart button...
				if(useSound) {
					Sound.CLICK.play();
				}
				state = GameState.RESTART;
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
		case RESTART:
			if((xpos >= display.getWidth()/2-120 && xpos <= display.getWidth()/2-40) && (ypos >= display.getHeight()/2+40 && ypos <= display.getHeight()/2+120)) {
				System.out.println("RESTART\n"); //Used for debugging
				won = false;
				txg.clearGrid();
				cscore = 0;
				txg.test();
				TextGame.moveCount = 0;
				state = GameState.RUN;
				display.repaint();
			} else if((xpos >= display.getWidth()/2+40 && xpos <= display.getWidth()/2+120) && (ypos >= display.getHeight()/2+40 && ypos <= display.getHeight()/2+120)){
				state = GameState.RUN;
				display.repaint();
			}
			break;
		default:
			//This case should never be reached
			System.out.println("DEFAULT"); //Used for debugging
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
