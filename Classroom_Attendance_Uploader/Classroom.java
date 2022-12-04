import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * This class shows the uploaded Roster and attendance on the screen
 * @author Brent Li
 * @author Harshit Viren Shah
 */
public class Classroom extends JPanel{
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollpane;
	Classroom(){
		setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Classroom", TitledBorder.CENTER, TitledBorder.TOP));
	}

	/**
	 * @param data data from the csv that will be loaded
	 */
	public void loadRoster(String[][] data) {
		removeAll();
		String col[] = {"ID", "First Name", "Last Name", "ASURITE"};	
	    model = new DefaultTableModel(data, col);
        table = new JTable(model);
		scrollpane = new JScrollPane(table);
		add(scrollpane);
	}

	/**
	 * @param data data from the csv to be loaded
	 * @param columnName column headers
	 */
	public void loadAttendance(ArrayList<Student> data, String columnName){
		String error = "";
		boolean found = false;
		ArrayList<Student> unknown = new ArrayList<Student>();
		
		model.addColumn(columnName);
		for(int j = 0; j < data.size(); j++){
			found = false;
			for(int i = 0; i < table.getRowCount(); i++) {
				if(data.get(j).ASURITE_ID.equalsIgnoreCase((String) table.getValueAt(i, 3))){
					table.getModel().setValueAt(data.get(j).timeDuration, i, table.getColumnCount() - 1);
					found = true;
				}
			}
			if(!found){
				unknown.add(data.get(j));
			}
		}
		error+="<html>Data Loaded for "+(data.size()-unknown.size())+" students<br/><br/>";
		error+=unknown.size()+" attendee were found <br/>";
		for(int i=0;i<unknown.size();i++) {
			error+=unknown.get(i).ASURITE_ID+", connected for "+unknown.get(i).timeDuration+" minutes<br/>";
		}
		error+="</html>";
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel(error);
        panel.add(label);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
	}

	/**
	 * @return number of columns in the table currently
	 */
	public int getColumns(){
		return table.getColumnCount();
	}

	/**
	 * @param col column number
	 * @return header of the given column
	 */
	public String getColumnName(int col){
		return table.getColumnName(col);
	}

	/**
	 * @param col column number
	 * @return number of students who attended on that day
	 */
	public int getAttendanceData(int col){
		int sum = 0;
		for(int i = 0; i < table.getRowCount(); i++){
			int val = 0;
			try{
				val = (int)table.getModel().getValueAt(i, col);
			}
			catch(Exception e){
				val = 0;
			}
			if(val != 0){
				sum++;
			}
		}
		return sum;
	}
}
