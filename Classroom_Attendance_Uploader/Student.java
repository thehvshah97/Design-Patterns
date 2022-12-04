import javax.swing.JTable;

/**
 * 
 * @author Harshit Viren Shah
 * This class records the attendance of the user for the day
 */
public class Student extends JTable{
    public String ASURITE_ID;
    public int timeDuration;
    /**
     * Constructor for adding attendance of student
     */
    Student() {
        ASURITE_ID = "";
        timeDuration = 0;
    }
}

