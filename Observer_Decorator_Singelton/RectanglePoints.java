import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public class RectanglePoints extends DrawableDecorator{
	
	/**
	* Constructor
	* @param drawable object
	*/
	RectanglePoints(Drawable drawable)
	{
		super(drawable);
		this.setBackground(new Color(204,204,204));
	}
	
	/**
	* Overriding paint component from JPanel
	* @param Graphics object
	*/
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.draw(g); 
	}
	
	/**
	* Plots decorated rectangular plot
	* @param Graphics object
	*/
	public void draw(Graphics g)
	{
		super.draw(g);
		  Graphics2D graphics = (Graphics2D) g.create();

		if(xcoor.size()==10)
		{
			
			for(int i=0;i<xcoor.size();i++)
			{
				graphics.fill(new Rectangle2D.Double(xcoor.get(i), ycoor.get(i), 5, 5));
			}
			
			
			this.repaint();
		}
	}
	
	/**
	* sets the coordinates for the plot
	* @param x list of x coordinate
	* @param y list of y coordinate
	* @param maxX max value of x coordinate
	* @param maxY max value of y coordinate
	* @param average calculated by evaluator
	*/
	@Override
	public void setValues(ArrayList<Double> x,ArrayList<Double> y,double maxX,double maxY,double avg)
	{
		super.setValues(x,y,maxX,maxY,avg);
		xcoor=x;
		ycoor=y;
		maxXcoor=maxX;
		maxYcoor=maxY;
		
	}
}
