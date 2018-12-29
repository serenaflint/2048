import java.awt.*;
import javax.swing.JComponent;

public class Display extends JComponent{

	public Engine engine;
	
	public Display(Engine engine) {
		this.engine = engine;
		setPreferredSize(new Dimension(1000, 1000));
		addKeyListener(engine);
		addMouseListener(engine);
		setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(254, 253, 251));
		g.drawRect(0, 0, getWidth(), getHeight());
		
		switch(engine.state) {
		
		case MENU:
			engine.drawMenu(g);
			break;
			
		case RUN:
			//plays game
			g.setColor(Color.BLACK);
			g.drawString("RUNNING", getWidth()/2, getHeight()/2);
			break;
		
		case END:
			//final screen, option to play again etc.
			break;
		
		case HS:
			//engine.drawScores(g);
			g.setColor(Color.BLACK);
			g.drawString("HIGH SCORES", getWidth()/2, getHeight()/2);
			break;
			
		case OPTIONS:
			//configuration and all that fun stuff
			g.setColor(Color.BLACK);
			g.drawString("OPTIONS", getWidth()/2, getHeight()/2);
			break;
		}
	}
	
}
