import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Run extends JFrame{
	
	public Engine engine;
	
	public static void main(String[] args) {
		new Run().setVisible(true);

	}
	
	public Run() {
		setTitle("2048 Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(254,253,251));
		setResizable(false);
		
		engine = new Engine();
		add(engine.getDisplay(), BorderLayout.CENTER);
		
		pack();
		
		engine.initializeGame();
		
	}

}

/* TODO
 * Make sure everything is readable
 * Algorithm to search for a 2048 tile to win (yay)
 * Animations :( (In KeyPressed cases? tiles slide from value + value*i to value + value*(1+i)
 * 		Error handles for edges and blah
 * Sound!
 * Fix generating tiles issue
 * Fix false GAME OVER
 */
