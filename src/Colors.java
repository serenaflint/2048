/**
 * Colors.java
 * Collaboration between partners; Jayda Medina and Serena Flint
 * This class sets up the colors and themes of the game.
 */

import java.awt.Color;

public class Colors {
	
	Color a, b, c, d, e;
	
	public enum Scheme {
		WARM, COOL, PASTEL, RETRO, GREY
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
			
		case "RETRO":
			scheme = Scheme.RETRO;
			break;
			
		case "GREY":
			scheme = Scheme.GREY;
			break;
		}
	}
	
	//Miscellaneous Tile Colors
	Color emptyA = new Color(211, 206, 195); //light beige-grey
	Color defaultA = new Color(42, 38, 31); //very dark beige-grey
	
	//Sound & Music Buttons
	Color oOff = new Color(144, 240, 149); //soft green
	Color oOn = new Color(240, 149, 144); //soft red
	
	//Background & Text Colors
	Color offwhite = new Color(254, 253, 251); //off-white
	Color dgrey = new Color(82, 82, 82); //dark grey
	Color lyGrey = new Color(167, 165, 154); //yellow grey
	Color lcGrey = new Color(154, 163, 167); //blue grey
	Color trans = new Color(254, 253, 251, 170); //transparent white
	
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
	
	//Retro Scheme
	Color aR = new Color(255, 236, 180); //eggshell
	Color bR = new Color(244, 161, 39); //light orange
	Color cR = new Color(229, 119, 30); //medium orange
	Color dR = new Color(117, 200, 174); //teal
	Color eR = new Color(90, 61, 43); //brown
	
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
		
		case RETRO:
			setA(aR);
			setB(bR);
			setC(cR);
			setD(dR);
			setE(eR);
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
	
	@Override
	public String toString() {
		return "A: " + this.a + ", B: " + this.b + ", C: " + this.c + ", D: " + this.d + ", E: " + this.e;
	}
	
}
