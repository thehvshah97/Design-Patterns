import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * This class uploads the roster for the user which is shown in Table on the screen
 * @author Brent Li
 * @author Harshit Viren Shah
 * @author Jnani Sunkavalli
 */
public class Roster {
	Classroom classroom;
	Roster(Classroom classroom){
		this.classroom = classroom;
	}

    /**
     * Gets the file path of the file
     * @return filepath or error
     */
	public String getFilePath() {
        try{
        	JFileChooser jFileChooser = new JFileChooser();
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
            jFileChooser.addChoosableFileFilter(filter);
            jFileChooser.showOpenDialog(null);
            File file = jFileChooser.getSelectedFile();
            return(file.getPath());
        }catch(Exception e) {
        	return "Error While Reading File";
        }
    }

    /**
     * Parses the file to obtain the data
     * @param filePath the filepath of the file
     */
	public void parseFile(String filePath) {
        Scanner scanner = new Scanner(System.in);

        try{    
            scanner = new Scanner(new File(filePath));
        } catch(Exception e){ 
            System.out.println(e);
            scanner.close();
        }

        String line = "";
        List<StudentInfo> list = new ArrayList<>();

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            String[] info = line.split(",");
            StudentInfo student = new StudentInfo(info[1].trim(),info[2].trim(),info[3].trim(),info[0].trim());
            list.add(student);
        }

        scanner.close();
		String[][] data = new String[list.size()][4];
		
		for(int i=0;i<list.size();i++){
			data[i][0] = list.get(i).id;
			data[i][1] = list.get(i).firstName;
			data[i][2] = list.get(i).lastName;
			data[i][3] = list.get(i).asuRiteID;			
		}
		classroom.loadRoster(data);
	 }
}
