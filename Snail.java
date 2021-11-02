package edu.mtc.egr281.chapter6;

// Rick Howell

public class Snail {
	
	private String color;
	private int currentSpace;
	
	public Snail(String newColor) {
		this.setColor(newColor);
		this.setCurrentSpace(0);
	} // end snail constructor
	
	public int getCurrentSpace() {
		return this.currentSpace;
	} // end get current space method
	
	private void setCurrentSpace(int newCurrentSpace) {
		this.currentSpace = newCurrentSpace;
	} // end set current space method
	
	public String getColor() {
		return this.color;
	} // end get color method
	
	private void setColor(String newColor) {
		this.color = newColor;
	} // end set color method
	
	public void incrementCurrentSpace() {
		this.setCurrentSpace(this.getCurrentSpace() + 1);
	} // end increment current space method
	
} // end snail class
