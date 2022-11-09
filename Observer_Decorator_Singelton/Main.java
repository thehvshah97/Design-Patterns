import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public class Main extends JFrame implements ActionListener {

	private boolean state = false;
	
	/**
	* Overriding paint component from JPanel
	* @param PlotPanel object
	* @param Source object
	*/
	Main(JPanel pp, Source ds)
	{
		setSize(1200,1200);
		setLayout(new BorderLayout());
		add(pp, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JButton btn=new JButton("Run");
        add(pp);
		pp.add(new JPanel().add(btn));
		pack();
		
      btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	
        	  state = true;
       	              
        	  }
      }
      );


    	while(true) {

    		try {
            Thread.sleep(100);
    		}
    		catch(Exception exe) {
    			
    		}
    		if(state) {
      		  
      		  ds.GenerateData();

      		  try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {

			}}
    	}
	
    	}


	/**
	* the function is called as the project is started
	* @param String[] args
	*/
	public static void main(String[] args)
	{
		Source ds=new Source();
		PlotPanel pp =new PlotPanel();
		ds.addObservers(pp);
		Evaluator e=Evaluator.getInstance();
		ds.addObservers(e);
		
		Main m=new Main(pp,ds);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}