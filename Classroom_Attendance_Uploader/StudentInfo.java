/**
 * 
 * @author Jnani Sunkavalli
 * StudentInfo creates objects for each student in the Roster
 */
public class StudentInfo{ 
    String firstName;
    String lastName;
    String asuRiteID;
    String id;
    
    /**
     * Constructor for creating StudentInfoObject
     */
    StudentInfo(){
        firstName = "";
        lastName = "";
        asuRiteID = "";
        id = "";
    }
    /**
     * Constructor for creating StudentInfoObject
     * @param firstname: String
     * @param lastName: String
     * @param asuRiteID: String
     * @param id: String
     */
	StudentInfo(String firstName, String lastName, String asuRiteID, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.asuRiteID = asuRiteID;
        this.id = id;
    }
}

