import java.awt.*;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Display extends JComponent{

	public Engine engine;
	public Colors colors;
	
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
			g.setColor(Color.BLACK);
			g.drawString("HIGH SCORES", getWidth()/2, getHeight()/2);
			engine.drawHS(g);
			break;
			
		case OPTIONS:
			engine.drawOptions(g);
			break;
		}
	}
	
}
