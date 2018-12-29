import java.awt.Color;

public class Colors {
	
	Color a, b, c, d, e;
	
	public enum Scheme {
		WARM, COOL, PASTEL, NATURAL, GREY
	}
	
	Scheme scheme = Scheme.WARM;
	
	public Colors(Color a, Color b, Color c, Color d, Color e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}
	
	//Getters
	public Color getA() {
		return a;
	}
	public Color getB() {
		return b;
	}
	public Color getC() {
		return c;
	}
	public Color getD() {
		return d;
	}
	public Color getE() {
		return e;
	}
	
	//Setters
	public void setA(Color a) {
		this.a = a;
	}
	public void setB(Color b) {
		this.b = b;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public void setD(Color d) {
		this.d = d;
	}
	public void setE(Color e) {
		this.e = e;
	}

	public void setScheme(String text) {
		switch(text) {
		
		case "WARM":
			scheme = Scheme.WARM;
			break;
			
		case "COOL":
			scheme = Scheme.COOL;
			break;
			
		case "PASTEL":
			scheme = Scheme.PASTEL;
			break;
			
		case "NATURAL":
			scheme = Scheme.NATURAL;
			break;
			
		case "GREY":
			scheme = Scheme.GREY;
			break;
		}
	}
	
	//Warm Scheme
	Color aW = new Color(226, 224, 207); //light beige
	Color bW = new Color(240, 229, 144); //soft light yellow
	Color cW = new Color(240, 197, 144); //soft light orange
	Color dW = new Color(240, 149, 144); //soft light red
	Color eW = new Color(235, 116, 109); //soft medium red
	
	//Cool Scheme
	Color aC = new Color(232, 237, 218); //cool beige
	Color bC = new Color(182, 219, 215); //soft light teal
	Color cC = new Color(167, 207, 239); //soft light blue
	Color dC = new Color(186, 173, 204); //soft light purple
	Color eC = new Color(165, 144, 157); //soft medium purple
	
	public void setCurrentColors() {
		
		switch(scheme) {
		
		case WARM:
			setA(aW);
			setB(bW);
			setC(cW);
			setD(dW);
			setE(eW);
			break;
			
		case COOL:
			setA(aC);
			setB(bC);
			setC(cC);
			setD(dC);
			setE(eC);
			break;
			
		case GREY:
			break;
		
		case NATURAL:
			break;
		
		case PASTEL:
			break;
			
		}
		
	}
	
}
