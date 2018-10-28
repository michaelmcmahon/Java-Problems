/* mmcmahon_wk6_Assignment_ReadTxtFile.java
 * Write a Java program to read and process a text file. The name of the text file is entered by the user. 
 * If the file does not exist, the program displays an error message and exits. Otherwise, the file is opened 
 * and read, keeping a count of the number of lines, words, and total number of characters. These three values 
 * are displayed in a message box after the whole file has been read. After use, the file is closed. (Note that 
 * your character count should not include white spaces).
 */


import java.io.*;
import java.lang.IllegalStateException;
import javax.swing.JOptionPane;

public class ReadTxtFile {
	
	public static void main(String[] args) throws IOException {
		
		int words = 0; // Total words count variable
		int lines = 0; // Total lines count variable
		int chars = 0; // Total character count variable
		String line; // line variable
 
		//Asks user to enter file name
		String inName = JOptionPane.showInputDialog("Enter file name");
		try // Try the following block of code
	      {
		// Open the input file 
		BufferedReader inBuf = new BufferedReader(new FileReader(inName));

		// Read each line from the input file until null returned
		while ((line = inBuf.readLine()) != null) {
			// Increase the total lines count
			lines++;
			
			// Read each word using white space as delineator 
			String str [] = line.split((" "));
			
			// Increase the total word count
            for ( int i = 0; i <str.length ; i ++) {
              if (str [i].length() > 0) {
                words ++; 
              }
            }

            // Remove white spaces and increase the char count 
            for( int i=0; i<line.length(); i++ )
            {
                if(line.charAt(i)!=' ')
                chars ++;
            }
		}

		//The Line, Word and Char count values are displayed in a message box
		JOptionPane.showMessageDialog(null, "Number of Lines is: " + lines
				+ "\nNumber of Words is: " + words
				+ "\nNumber of Characters is: " + chars);
		
		inBuf.close(); // Close the file
		  
	      }
		// Catch exception if the file is not found
		catch ( FileNotFoundException fileNotFoundException )
	      {
			JOptionPane.showMessageDialog(null, "Error: File not found." );
	         System.exit( 1 );
	      } // end catch
		
		//Catch exception if the file cannot be read
		catch ( IllegalStateException stateException )
	      {
	         System.err.println( "Error: reading from file." );
	         System.exit( 1 );
	      } // end catch
		
		// Exit application
		System.exit(0); // Exit
	}
}