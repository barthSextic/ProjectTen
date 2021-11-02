package edu.mtc.egr281.chapter6;

// Rick Howell

import java.util.Random;

public class ColoredDie {
	
	private String color;
	private Random random;
	
	private static final int FACES = 6;
	
	// initializing Constructor
	public ColoredDie() {
		random = new Random();
	} // end constructor
	
	// access
	public String getColor() {
		return this.color;
	} // end get color method
	
	// mutator
	private void setColor(String newColor) {
		this.color = newColor;
	} // end set color method
	
	// NOTE: DEFAULT CASE SHOULD NEVER HAPPEN, IT IS LEFT IN AS A "JUST IN CASE"
	public String roll() {		
		switch (this.random.nextInt(ColoredDie.FACES)) {
		case 0: this.setColor(ProjectTen.COLOR_PALETTE[0]);
			break;
		case 1: this.setColor(ProjectTen.COLOR_PALETTE[1]);
			break;
		case 2: this.setColor(ProjectTen.COLOR_PALETTE[2]);
			break;
		case 3: this.setColor(ProjectTen.COLOR_PALETTE[3]);
			break;
		case 4: this.setColor(ProjectTen.COLOR_PALETTE[4]);
			break;
		case 5: this.setColor(ProjectTen.COLOR_PALETTE[5]);
			break; 
		default : this.setColor("Fell off table, roll again!");
			break;
		} // end switch
		return this.getColor();
	} // end roll method
	
} // end class
