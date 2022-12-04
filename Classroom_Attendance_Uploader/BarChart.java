import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * All bar chart logic is handled here for plot attendance data
 * @author Brent Li
 */
class BarChart extends JPanel{
	int[] data;
	String[] xlabels;
	String ylabel;
	int windowWidth, windowHeight;
	int borderWidthBuffer, borderHeightBuffer;
	int graphTop, graphBottom, graphLeft, graphRight, graphLength, gap;

	/**
	 * @param data attendance data for each column
	 * @param xlabels stores the date of each attendance column to be used as the x axis labels
	 * @param frame JFrame object to allow for UI logic
	 */
	public BarChart(int[] data, String[] xlabels, JFrame frame){
		this.xlabels = xlabels;
		this.ylabel = "Students";
		this.data = data;
		windowWidth = frame.getWidth();
		windowHeight = frame.getHeight();
	}

	/**
	 * @param g Graphics object to draw
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		this.setBackground(Color.WHITE);

		Graphics2D g2 = (Graphics2D) g;

		g2.setFont(new Font("TimesRoman", Font.PLAIN, 15));

		getCoords();
		drawBars(g2);
		drawAxis(g2);
	}

	/**
	 * Configures all coordinates needed for UI logic
	 */
	public void getCoords(){
		borderWidthBuffer = (int)(windowWidth * 0.1);
		borderHeightBuffer = (int)(windowHeight * 0.1);

		graphTop = borderHeightBuffer;
		graphBottom = windowHeight - borderHeightBuffer - 30;
		graphLeft = borderWidthBuffer;
		graphRight = windowWidth - borderWidthBuffer;

		graphLength = graphRight - graphLeft;
		gap = graphLength / xlabels.length;
	}

	/**
	 * Draws the axis, axis labels, and title
	 * @param g graphics object for drawing
	 */
	public void drawAxis(Graphics2D g){
		g.setColor(Color.BLACK);
		g.drawLine(graphLeft, graphBottom, graphLeft, graphTop);
		g.drawLine(graphLeft, graphBottom, graphRight, graphBottom);
		g.drawString("Attendance Data", windowWidth / 2 - 30, borderHeightBuffer / 2);
		for(int i = 0; i < xlabels.length; i++){
			g.drawString(xlabels[i], (graphLeft + i * (gap) + (gap / 2)) - 15, graphBottom + 20);
		}
		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(-90), 0, 0);
		Font font = new Font(null, g.getFont().getStyle(), g.getFont().getSize());
		Font fontRotated = font.deriveFont(at);
		g.setFont(fontRotated);
		g.drawString(ylabel, graphLeft - 20, graphTop + (graphBottom - graphTop) / 2);
	}

	/**
	 * Draws the bars for the bar chart
	 * @param g graphics object for drawing
	 */
	public void drawBars(Graphics2D g){
		int highest = 0;
		for(int i = 0; i < data.length; i++){
			if(data[i] > highest){
				highest =  data[i];
			}
		}

		int chartHeight = graphBottom - graphTop;
		int ratio = (chartHeight - 20) / highest;

		for(int i = 0; i < data.length; i++){
			g.setColor(new Color(33, 69, 176));
			g.fillRect(graphLeft + 5 + i * gap, graphBottom - (data[i] * ratio), gap - 10, data[i] * ratio);
			g.setColor(new Color(0, 0, 0));
			g.drawString(Integer.toString(data[i]), (graphLeft + i * (gap) + (gap / 2)) - 5, graphTop + (graphBottom - data[i] * ratio) - 10 - borderHeightBuffer);
		}
	}
}