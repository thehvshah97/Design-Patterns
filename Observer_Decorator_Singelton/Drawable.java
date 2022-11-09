import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public abstract class Drawable extends JPanel
{
	ArrayList<Double> xcoor;
	ArrayList<Double> ycoor;
	double maxXcoor;
	double maxYcoor;
	double avg;
	
	/**
	* Plots the graph
	* @param graphics object
	*/
	public  abstract void draw(Graphics g);
	
	/**
	* sets the coordinates for the plot
	* @param x list of x coordinate
	* @param y list of y coordinate
	* @param maxX max value of x coordinate
	* @param maxY max value of y coordinate
	* @param average calculated by evaluator
	*/
	public abstract void setValues(ArrayList<Double> xcoor,ArrayList<Double> ycoor,double maxXcoor,double maxYcoor,double avg);

	/**
	* Overriding paint component from JPanel
	* @param Graphics object
	*/
    @Override
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        }
    
}
