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
	
	//Empty Tiles
	Color emptyA = new Color(211, 206, 195); //desaturated beige
	
	//default after 2048
	Color defaultA = new Color(42, 38, 31); //dark beige-grey
	
	//Warm Scheme
	Color aW = new Color(226, 224, 207); //light beige
	Color bW = new Color(240, 229, 144); //soft light yellow
	Color cW = new Color(240, 197, 144); //soft light orange
	Color dW = new Color(240, 149, 144); //soft light red
	Color eW = new Color(235, 116, 109); //soft medium red
	
	//Cool Scheme
	Color aC = new Color(201, 201, 201); //light grey
	Color bC = new Color(168, 206, 221); //soft light blue
	Color cC = new Color(129, 160, 195); //soft medium blue
	Color dC = new Color(103, 126, 159); //slate
	Color eC = new Color(68, 112, 152); //soft dark blue
	
	//Pastel Scheme
	Color aP = new Color(255, 253, 234); //eggshell
	Color bP = new Color(237, 237, 237); //light grey?
	Color cP = new Color(202, 210, 236); //light lavender
	Color dP = new Color(245, 183, 212); //pastel pink
	Color eP = new Color(214, 235, 226); //pastel green
	
	//Natural Scheme
	Color aN = new Color(164, 154, 127); //light brown
	Color bN = new Color(152, 145, 126); //slightly darker brown
	Color cN = new Color(129, 145, 127); //green
	Color dN = new Color(107, 134, 123); //slightly darker green
	Color eN = new Color(92, 117, 113); //darker green
	
	//Grey Scheme
	Color aG = new Color(237, 237, 237);
	Color bG = new Color(201, 201, 201);
	Color cG = new Color(145, 145, 145);
	Color dG = new Color(107, 107, 107);
	Color eG = new Color(84, 84, 84);
	
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
			setA(aG);
			setB(bG);
			setC(cG);
			setD(dG);
			setE(eG);
			break;
		
		case NATURAL:
			setA(aN);
			setB(bN);
			setC(cN);
			setD(dN);
			setE(eN);
			break;
		
		case PASTEL:
			setA(aP);
			setB(bP);
			setC(cP);
			setD(dP);
			setE(eP);
			break;
			
		}
		
	}
	
}
