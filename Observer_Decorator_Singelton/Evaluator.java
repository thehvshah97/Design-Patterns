import java.util.*;

/**
*@author Ramachandra Sai
*@author Disha Agarawal
*@author Harshit 
*/
public class Evaluator implements Observer {

	protected static Evaluator evaluator;
	static double sum=0;
	static int count=0;
	static double avg;
	
	/**
	* Private Constructor for Singleton
	*/
	private Evaluator()
	{
		
	}
	
	/**
	* @return singleton Evaluator instance
	*/
	public static Evaluator getInstance()
	{
		if(evaluator==null)
			evaluator= new Evaluator();
		return evaluator;
	}
	
	/**
	* computes the average of all the random data points
	* @param the last data point generated by source
	*/
	public void ComputeAvg(double a)
	{
		count++;
		sum+=a;
		avg= sum/count;
	}
	
	/**
	* updates the average by getting the last data point generated by source
	* @param instance of Observable- Source 
	*/
	public void Update(Observable o) {
		ComputeAvg(((Source)o).getValue());
	}
}