import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class uploads the attendance for the user which is shown in Table on the screen
 * @author Harshit Viren Shah
 */
class Attendance extends JFrame{
    Classroom classroom;
    /**
     * Constructor for Attendance Class
     * @param classroom Classroom
     */
    Attendance(Classroom classroom){
    	this.classroom = classroom;
    }
	
    /**
     * This function lets the user select a folder
     * @returns File Uploaded folder
     */
	public File getFilePath() {
        try{
        	JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.showOpenDialog(this);
            File file = jFileChooser.getSelectedFile();
            return file;
        }catch(Exception e) {
        	return null;
        }
    }
	
	/**
     * This function parses and loads the folder uploaded by the user
     * @param File Uploaded file
     */
    
    public void parseFile(File file) {
        File folder = new File(file.getAbsolutePath());

        ArrayList<Student> studentsAttendanceData = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        for (final File fileEntry : folder.listFiles()) {
            boolean b2=Pattern.compile("[0-9]{8} attendance.csv").matcher(fileEntry.getName()).matches();
            if (b2) {
                try{
                    scanner = new Scanner(fileEntry);
                }
                catch(Exception error){
                    System.out.println(error);
                    scanner.close();
                }
        
                while(scanner.hasNextLine()){
                    String studentData = scanner.nextLine();
                    String[] data = studentData.split(",");
                    Student student = new Student();
                    student.ASURITE_ID = data[0].trim();
                    student.timeDuration = Integer.parseInt(data[1].trim());
                    studentsAttendanceData.add(student);
                }
        
                HashMap <String, Integer> mergeData = new HashMap <String, Integer>();
        
                for (int i=0; i<studentsAttendanceData.size(); i++){
                    if (mergeData.containsKey(studentsAttendanceData.get(i).ASURITE_ID)){
                        int time = mergeData.get(studentsAttendanceData.get(i).ASURITE_ID) + studentsAttendanceData.get(i).timeDuration;
                        mergeData.put(studentsAttendanceData.get(i).ASURITE_ID, time);
                        studentsAttendanceData.remove(i);
                        i--;
                    }
                    else{
                        mergeData.put(studentsAttendanceData.get(i).ASURITE_ID, studentsAttendanceData.get(i).timeDuration);
                    }
                }
        
                for (int i=0; i<studentsAttendanceData.size(); i++){
                    Student temp = new Student();
                    temp.ASURITE_ID = studentsAttendanceData.get(i).ASURITE_ID;
                    temp.timeDuration = mergeData.get(temp.ASURITE_ID);
                    studentsAttendanceData.set(i, temp);
                }
                String name = fileEntry.getName();
                String[] list = name.split(" ");
                String columnName = list[0].substring(4, 6)+"/"+list[0].substring(6, 8)+"/"+list[0].substring(2, 4);
                classroom.loadAttendance(studentsAttendanceData, columnName);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
        scanner.close();
    }
}
