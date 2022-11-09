import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public class LinePlot extends Drawable{
	
	
	
	/**
	* Overriding paint component from JPanel
	* @param Graphics object
	*/
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(153,153,153));
		this.draw(g);
	}
	
	/**
	* Plots concrete Line
	* @param Graphics object
	*/
	public void draw(Graphics g)
	{
		
		  Graphics2D graphics = (Graphics2D) g.create();
		double height=getSize().height;
		double width=getSize().width;
		Path2D polyline = new Path2D.Double();
		
		
		if(xcoor.size()==10)
			{
			polyline.moveTo(xcoor.get(0),ycoor.get(0));
			for(int i=1;i<xcoor.size();i++)
			{ 
				
			polyline.lineTo(xcoor.get(i),ycoor.get(i));
			
			}
			graphics.draw(polyline);
			
			Line2D line2d=new Line2D.Double(0,avg , maxXcoor,avg);
			graphics.setColor(Color.RED);
	        graphics.draw(line2d);
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
	public void setValues(ArrayList<Double> x,ArrayList<Double> y,double maxX,double maxY,double avg)
	{
		this.avg=avg;
		xcoor=x;
		ycoor=y;
		maxXcoor=maxX;
		maxYcoor=maxY;
		
	}
}

