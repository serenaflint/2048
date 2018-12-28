import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.Timer;


public class Engine implements KeyListener{

	public enum GameState{
		MENU, RUN, END, OPTIONS, HS
	}
	
	public static Display display;
	public static Write write;
	
	public GameState state;
	
	static Font h1 = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	static Font h2 = new Font(Font.SANS_SERIF, Font.BOLD, 60);
	static Font text = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	static Color dgrey = new Color(82, 82, 82);
	static Color offwhite = new Color(254, 253, 251);
	static Color lorange = new Color(240, 197, 144);
	static Color lred = new Color(240, 149, 144);
	static Color lyellow = new Color(240, 229, 144);
	
	//Constructor
	public Engine() {
		display = new Display(this);
	}
	
	Display getDisplay() {
		return display;
	}
	
	public void initializeGame() {
		state = GameState.MENU;
	}
	
	public void drawMenu(Graphics g) {
		g.setFont(h1);
		g.setColor(dgrey);
		g.drawString("2048", display.getWidth()/2-110, display.getHeight()/2-120);
		
		g.setColor(lyellow);
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+80, 280, 60, 20, 15);
		g.setColor(lorange);
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+160, 280, 60, 20, 15);
		g.setColor(lred);
		g.fillRoundRect(display.getWidth()/2-140, display.getHeight()/2+240, 280, 60, 20, 15);
		
		g.setColor(offwhite);
		g.setFont(text);
		g.drawString("Play Game", display.getWidth()/2-70, display.getHeight()/2+120);
		g.drawString("High Scores", display.getWidth()/2-80, display.getHeight()/2+200);
		g.drawString("Options", display.getWidth()/2-60, display.getHeight()/2+280);
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

}
