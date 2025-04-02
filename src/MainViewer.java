import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * MainViewer.java
 * Provides the user interface for selecting options to view student and major records.
 * Calls appropriate methods to retrieve and display database data.
 * 
 * @author Brandon Burton
 * @since 2/19/2025
 */

public class MainViewer {

    public static void main(String[] args) {
    	
        if (ViewStudentsMajors.OpenDatabaseConnectionMSAccess())
        {
            boolean blnContinue = true;

            while (blnContinue)
            {
                DisplayMenu();
                blnContinue = AskToContinue();
            }

            // Display program ending message if the user chooses not to continue.
            System.out.println("Program successfully ended.");
        }
        else
        {
            System.out.println("ERROR: Could not establish database connection. Exiting...");
        }
    }

    
    /**
     * Displays the menu options to the user.
     */
    public static void DisplayMenu() {
    	
        System.out.println("\nEnter Option 1 - View Student Records");
        System.out.println("Enter Option 2 - View Major Records");
        System.out.println("Enter Option 3 - View Both Student and Major Records");

        int intChoice = ReadIntegerFromUser("Please enter your choice: ");
        ProcessChoice(intChoice);
    }

    
    /**
     * Processes the user's choice and calls the corresponding methods.
     * @param intChoice The user's menu selection.
     */
    public static void ProcessChoice(int intChoice) {
    	
        switch (intChoice) {
        
            case 1:
                DisplayStudentInfo.Display();
                break;
                
            case 2:
                DisplayMajorInfo.Display();
                break;
                
            case 3:
                ViewStudentsMajors.DisplayBoth();
                break;
                
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
    }

    
    /**
     * Asks the user if they want to return to the main menu.
     * @return True if the user wants to continue, false otherwise.
     */
    public static boolean AskToContinue() {
    	
        String strResponse = ReadStringFromUser("Would you like to return to the main menu? (Y/N): ").toUpperCase();
        return strResponse.equals("Y");
    }

    
    /**
     * Reads an integer value from the user with input validation.
     * @param strPrompt The prompt message displayed to the user.
     * @return The integer input from the user.
     */
    public static int ReadIntegerFromUser(String strPrompt) {
    	
        int intValue = 0;
        boolean isValid = false;

        try
        {
            while (!isValid)
            {
                System.out.print(strPrompt);
                String strBuffer = ReadStringFromUser("");

                // Convert from string to integer
                try
                {
                    intValue = Integer.parseInt(strBuffer);
                    isValid = true;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("ERROR: Invalid input. Please enter a numeric value.");
                }
            }
        }
        catch (Exception excError)
        {
            System.out.println("ERROR: Unable to read input.");
        }

        return intValue;
    }

    
    /**
     * Reads a string value from the user.
     * @param strPrompt The prompt message displayed to the user.
     * @return The string input from the user.
     */
    public static String ReadStringFromUser(String strPrompt) { 
    	
        String strValue = "";

        try
        {
            System.out.print(strPrompt);
            BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));
            strValue = burInput.readLine();
        }
        catch (Exception excError)
        {
            System.out.println("ERROR: Unable to read input.");
        }

        return strValue.trim();
    }
}
