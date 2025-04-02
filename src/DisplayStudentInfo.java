/**
 * DisplayStudentInfo.java
 * Handles retrieving and displaying student records from the database.
 * Calls LoadListFromDatabase in ViewStudentsMajors to retrieve student data.
 *
 * @author Brandon Burton
 * @since 2/19/2025
 */
public class DisplayStudentInfo {
	
    /**
     * Retrieves and displays student records.
     */
    public static void Display() {
    	
        try 
        {       	
            System.out.println("\nStudent Records:");
            ViewStudentsMajors.LoadListFromDatabase("TStudents", 
            		"intStudentID, strFirstName, strLastName, strAddress, strCity, strState, strZip, strPhoneNumber, strEmail");
            
        } 
        catch (Exception excError) 
        {
            System.out.println("ERROR: Unexpected issue in DisplayStudentInfo.");
            
        } 
        finally 
        {
            System.out.println("Processing Complete by DisplayStudentInfo.");
            
        }
    }
}
