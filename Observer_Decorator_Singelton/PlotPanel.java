import java.util.*;
import java.util.Collections;
import java.util.Queue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public class PlotPanel extends JPanel implements Observer {
	ArrayList<Drawable> d=new ArrayList<Drawable>();
	ArrayList<Double> q=new ArrayList<Double>(Collections.nCopies(10, 0.0));
	ArrayList<Double> xcoor=new ArrayList<Double>();
	ArrayList<Double> ycoor=new ArrayList<Double>();
	double height;
	double width;
	Evaluator e= Evaluator.getInstance();
	
	/**
	* Constructor adds drawable objects to drawable list
	*/
	PlotPanel()
	{
		setPreferredSize(new Dimension(500,500));
    	d.add(new BarPlot(new RectanglePoints(new LinePlot())));
		d.add(new RectanglePoints(new LinePlot()));
		d.add(new LinePlot());
	
	}
	
	/**
	* updates the queue of random generated data points
	* @param instance of Observable- Source 
	*/
	public void Update(Observable o) {
		this.q=((Source)o).getData();
		if(q.size()==10) {
			coordinateCalc();
			for(Drawable k:d )
			{
				height=getSize().height/4;
				width=getSize().width;
				k.setValues(xcoor,ycoor,width,height,e.avg);
			}
		}
	}
	
	/**
	* Overriding paint component from JPanel
	* @param Graphics object
	*/
	protected void paintComponent(Graphics g) {
		
		
		coordinateCalc();
		for(Drawable k:d )
		{
			height=getSize().height/4;
			width=getSize().width;
			k.setValues(xcoor,ycoor,width,height,0.0);
		}

    	for(Drawable k:d )
		{
			add(k);
		}
    	
    	
    	setLayout(new GridLayout(4,1));
    	
    }
	
	/**
	* scales data points
	*/
    public  void coordinateCalc()
	{
		xcoor= new ArrayList<Double>();
		ycoor=new ArrayList<Double>();
		double y[]=new double[q.size()];
		for(int i=1;i<q.size();i++)
			y[i]=i;
		int cx=0;
		height=getSize().height/4;
		width=getSize().width/4;
		
		for(Double x:q)
		{
			
			ycoor.add((x*(height))/100);
		    xcoor.add((y[cx%10]*(width))/2);

			cx++;
		}
		
	}
}
