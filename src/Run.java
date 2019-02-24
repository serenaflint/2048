import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Run extends JFrame{
	
	public Engine engine;
	
	public static void main(String[] args) {
		new Run().setVisible(true);

	}
	
	//method to create window and call initialization method
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
 * Animations :( (In KeyPressed cases? tiles slide from value + value*i to value + value*(1+i)
 * 		Error handles for edges and blah
 * q and r for quit and reset
 * verify if quit/reset
 * valid moves made counter, print highest tile
 * fix probabilities for 2 and 4 gen, 0.8 for 2 and 0.2 for 4
 * 
 * print on console any key pressed after every move
 * print on console after every move the maximum tile and number of valid moves made
 */
