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
		g.setColor(new Color(254, 253, 251)); //off-white background
		g.drawRect(0, 0, getWidth(), getHeight());
		
		switch(engine.state) {
		
		case MENU:
			engine.drawMenu(g);
			break;
			
		case RUN:
			engine.drawRShell(g);
			engine.drawTileGrid(g);
			break;
		
		case END:
			engine.drawEnd(g);
			break;
		
		case HS:
			engine.drawHS(g);
			break;
			
		case OPTIONS:
			engine.drawOptions(g);
			break;
			
		case RESTART:
			engine.verify(g);
			break;
		case QUIT:
			engine.verify(g);
		}
	}
	
}
