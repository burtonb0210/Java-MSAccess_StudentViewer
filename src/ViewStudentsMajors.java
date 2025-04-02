import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ViewStudentsMajors.java
 * Handles database interactions for viewing student and major records.
 * Calls LoadListFromDatabase to retrieve and display both tables.
 *
 * @author Brandon Burton
 * @since 2/19/2025
 */

public class ViewStudentsMajors {
    // Define the global connection object
    private static Connection m_conAdministrator;

    /**
     * Opens the database connection to dbStudentMajors.accdb using MS Access.
     * @return True if the connection is successful, false otherwise.
     */
    public static boolean OpenDatabaseConnectionMSAccess() {
        boolean blnResult = false;

        try
        {
            // Correct file name
            String strDatabasePath = System.getProperty("user.dir") + "\\Database\\dbStudentMajors.accdb";
            String strConnectionString = "jdbc:ucanaccess://" + strDatabasePath;

            // Open Connection
            m_conAdministrator = DriverManager.getConnection(strConnectionString);
            blnResult = true;
            System.out.println("SUCCESS: Database connection established.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: Failed to connect to the database.");
        }

        return blnResult;
    }

    /**
     * Returns the database connection object.
     * @return Connection object or null if not connected.
     */
    public static Connection GetDatabaseConnection() {
    	
        return m_conAdministrator;
    }

    /**
     * Displays both student and major records.
     */
    public static void DisplayBoth() {
    	
        try
        {
            System.out.println("\nStudent Records:");
            LoadListFromDatabase("TStudents", 
                "intStudentID, strFirstName, strLastName, strAddress, strCity, strState, strZip, strPhoneNumber, strEmail");

            System.out.println("\nMajor Records:");
            LoadListFromDatabase("TMajors", "intMajorID, strMajor, strDescription");
        }
        catch (Exception excError)
        {
            System.out.println("ERROR: Database connection issue in method DisplayBoth. Please contact Support for Project CS.");
        }
        finally
        {
            System.out.println("Processing Complete by ViewStudentsMajors.");
        }
    }

    /**
     * Loads and displays records from the specified table.
     * @param strTable The table name.
     * @param strColumns The columns to retrieve.
     * @return True if data is loaded successfully, false otherwise.
     */
    public static boolean LoadListFromDatabase(String strTable, String strColumns) {
    	
        boolean blnResult = false;

        try
        {
            if (m_conAdministrator == null)
            {
                System.out.println("ERROR: Database connection is NULL.");
                return false;
            }

            String strSelect = "SELECT " + strColumns + " FROM " + strTable;

            Statement sqlCommand = m_conAdministrator.createStatement();
            ResultSet rstTSource = sqlCommand.executeQuery(strSelect);

            // Loop through the results and display each record.
            while (rstTSource.next())
            {
                if (strTable.equals("TStudents"))
                {
                    System.out.printf("ID: %d | Name: %s %s | Address: %s, %s, %s %s | Phone: %s | Email: %s%n",
                            rstTSource.getInt("intStudentID"),
                            rstTSource.getString("strFirstName"),
                            rstTSource.getString("strLastName"),
                            rstTSource.getString("strAddress"),
                            rstTSource.getString("strCity"),
                            rstTSource.getString("strState"),
                            rstTSource.getString("strZip"),
                            rstTSource.getString("strPhoneNumber"),
                            rstTSource.getString("strEmail"));
                }
                else if (strTable.equals("TMajors"))
                {
                    System.out.printf("ID: %d | Major: %s | Description: %s%n",
                            rstTSource.getInt("intMajorID"),
                            rstTSource.getString("strMajor"),
                            rstTSource.getString("strDescription"));
                }
            }

            rstTSource.close();
            sqlCommand.close();

            blnResult = true;
        }
        catch (SQLException sqlError)
        {
            System.out.println("ERROR: SQL issue encountered while retrieving records.");
        }
        catch (Exception excError)
        {
            System.out.println("ERROR: Unexpected issue in LoadListFromDatabase.");
        }

        return blnResult;
    }
}
