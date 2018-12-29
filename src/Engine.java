import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.Timer;

//please for the love of god work


public class Engine implements KeyListener, MouseListener{

	public enum GameState{
		MENU, RUN, END, OPTIONS, HS
	}
	
	public GameState state;
	
	public static Display display;
	public static Write write;
	public static Colors colors;
	
	static Font h1 = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	static Font h2 = new Font(Font.SANS_SERIF, Font.BOLD, 50);
	static Font text = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	Color a, b, c, d, e;
	static Color dgrey = new Color(82, 82, 82);
	static Color offwhite = new Color(254, 253, 251);
	
	//Constructor
	public Engine() {
		display = new Display(this);
		colors = new Colors(a, b, c, d, e);
	}
	
	Display getDisplay() {
		return display;
	}
	
	//Initializes certain variables in the game
	public void initializeGame() {
		state = GameState.MENU;
		colors.setScheme("WARM");
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
	
	public void drawOptions(Graphics g) {
		colors.setCurrentColors();
		
		//titles
		g.setFont(h1);
		g.setColor(dgrey);
		g.drawString("Options", display.getWidth()/2-180, 200);
		
		g.setFont(h2);
		g.drawString("Color Scheme", 75, 340);
		
		//boxes
		g.setColor(colors.dW);
		g.fillRoundRect(100, 380, 280, 60, 20, 15);
		g.setColor(colors.dC);
		g.fillRoundRect(100, 460, 280, 60, 20, 15);
		
		//text in the boxes
		g.setColor(offwhite);
		g.setFont(text);
		g.drawString("Warm", 190, 420);
		g.drawString("Cool", 200, 500);
		
	}
	
	
	@Override
 	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
