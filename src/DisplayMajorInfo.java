/**
 * DisplayMajorInfo.java
 * Handles retrieving and displaying major records from the database.
 * Calls LoadListFromDatabase in ViewStudentsMajors to retrieve major data.
 *
 * @author Brandon Burton
 * @since 2/19/2025
 */
public class DisplayMajorInfo
{
    /**
     * Retrieves and displays major records.
     */
    public static void Display() {
    	
        try 
        {
            System.out.println("\nMajor Records:");
            ViewStudentsMajors.LoadListFromDatabase("TMajors", "intMajorID, strMajor, strDescription");
            
        } 
        catch (Exception excError) 
        {
            System.out.println("ERROR: Unexpected issue in DisplayMajorInfo.");
            
        } 
        finally 
        {
            System.out.println("Processing Complete by DisplayMajorInfo.");
        }
    }
}
