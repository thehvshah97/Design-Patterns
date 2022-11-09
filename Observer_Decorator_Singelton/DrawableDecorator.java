import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;
public abstract class DrawableDecorator extends Drawable {
	
	protected Drawable drawable;
	
	/**
	* Constructor
	* @param drawable object
	*/
	DrawableDecorator(Drawable drawable)
	{
		this.drawable=drawable;
	}
	
	/**
	* sets the coordinates for the plot
	* @param x list of x coordinate
	* @param y list of y coordinate
	* @param maxX max value of x coordinate
	* @param maxY max value of y coordinate
	* @param average calculated by evaluator
	*/
	public void setValues(ArrayList<Double> xcoor,ArrayList<Double> ycoor,double maxXcoor,double maxYcoor,double avg)
	{
		this.drawable.setValues(xcoor,ycoor,maxXcoor,maxYcoor,avg);
	}

	/**
	* Plots decorated plot
	* @param Graphics object
	*/
	public void draw(Graphics g)
	{
		this.drawable.draw(g);
	}

}
