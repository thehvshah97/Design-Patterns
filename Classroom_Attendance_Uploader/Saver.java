import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
/**
 *
 * @author Ishrar Zaman
 * @author Harshit Viren Shah
 * This class saves the roster/attendance data as a csv file at a user-specified location
 *
 */
public class Saver {
    /**
     * Constructor for creating Saver object
     */
    Classroom classroom;
    Saver(Classroom classroom){
        this.classroom = classroom;
    }

    /**
     * The exportToCsv method is called when a user performs the 'save' action. This method will open a jFileChooser
     * save dialog that allows the user to specify a file name and file path to save the roster/attendance data as
     * a csv file. The roster/attendance will then be parsed from the tableModel and stored in the written file.
     */
    public void exportToCsv() {
        JFileChooser jFileChooser = new JFileChooser();
        int choice = jFileChooser.showSaveDialog(null);

        if (choice == 0) {

            try {
                TableModel tableModel = classroom.table.getModel();
                FileWriter writer = new FileWriter(new File(String.valueOf(jFileChooser.getSelectedFile()))+ ".csv");
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    if (i == tableModel.getColumnCount() - 1) {
                        writer.write(tableModel.getColumnName(i));
                    } else {
                        writer.write(tableModel.getColumnName(i) + ",");
                    }
                }

                writer.write("\n");

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        if (j == tableModel.getColumnCount() - 1) {
                            if (tableModel.getValueAt(i, j) == null) {
                                writer.write(",");
                            } else {
                                writer.write(tableModel.getValueAt(i, j).toString() + ",");
                            }
                        } else {
                            if (tableModel.getValueAt(i, j) == null) {
                                writer.write(",");
                            } else {
                                writer.write(tableModel.getValueAt(i, j).toString() + ",");
                            }
                        }
                    }
                    writer.write("\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
