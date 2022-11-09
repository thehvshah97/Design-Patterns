import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Color;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public class BarPlot extends DrawableDecorator {

	/**
	* Constructor
	* @param drawable object
	*/
	BarPlot(Drawable drawable) {
		super(drawable);
		this.setBackground(new Color(255,255,255));

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
	* Plots decorated bars
	* @param Graphics object
	*/
	public void draw(Graphics g) {
		super.draw(g);
		Graphics2D graphics = (Graphics2D) g.create();

		if (xcoor.size() == 10) {

			for (int i = 0; i < xcoor.size(); i++) {
				Rectangle2D rect = new Rectangle2D.Double(xcoor.get(i), ycoor.get(i) + 5, 8, maxYcoor - ycoor.get(i));
				graphics.draw(rect);
				graphics.setPaint(Color.gray);
				graphics.fill(rect);
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
	public void setValues(ArrayList<Double> x, ArrayList<Double> y, double maxX, double maxY, double avg) {
		super.setValues(x, y, maxX, maxY, avg);
		this.avg = avg;
		xcoor = x;
		ycoor = y;
		maxXcoor = maxX;
		maxYcoor = maxY;

	}
}
