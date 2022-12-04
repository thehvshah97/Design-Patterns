
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
/**
 * This class reads the action performed by the user and calls the related functionality
 * @author Brent Li
 * @author Harshit Viren Shah
 */
public class Controller implements ActionListener {
	Classroom classroom;
	Controller(Classroom classroom){
		this.classroom = classroom;
	}

	/**
	 * Button event handler
	 * @param e action event
	 */
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if(action.equals("About")) {
			About about = new About();
			about.setSize(400, 200);
			about.setTitle("About");
			about.setVisible(true);
		}

		else if(action.equals("Add Attendance")) {
			Attendance attendance = new Attendance(classroom);
			File file = attendance.getFilePath();
			if(!file.equals(null)) {
				attendance.parseFile(file);
			}
		}

		else if(action.equals("Load a Roster")) {
			Roster roster = new Roster(classroom);
			String filePath = roster.getFilePath();
			if(!filePath.equals("Error While Reading File")) {
				roster.parseFile(filePath);
			}
		}

		else if (action.equals("Save")) {
			Saver saver = new Saver(classroom);
			saver.exportToCsv();
		}

        else if (action.equals("Plot Data")){
			if(classroom.getColumns() > 4){
				JFrame frame= new JFrame("Attendance Data");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(600, 600);
				String[] dates = new String[classroom.getColumns() - 4];
				int[] data = new int[classroom.getColumns() - 4];

				for(int i = 0; i < data.length; i++){
					dates[i] = classroom.getColumnName(i + 4);
					data[i] = classroom.getAttendanceData(i + 4);
				}

				BarChart chart = new BarChart(data, dates, frame);
				frame.add(chart);
				frame.setVisible(true);
			}
		}

		Main.window.setSize(Main.window.getWidth() + 1, Main.window.getHeight());
		Main.window.setSize(Main.window.getWidth() - 1, Main.window.getHeight());
	}
}


