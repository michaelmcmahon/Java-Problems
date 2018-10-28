/* mmcmahon_Final_Exam_Q1_Parts.java
 * The part file is opened by a class named Parts, which reads the values into an appropriate array or list.
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Parts {
	
	 Parts[] partsArray = new Parts[5]; // Initialise a Part Array
	 private String part; // name of the part
	 private String line; // line for file to array 
	 private int value; // value of this part
	 private int amount; // amount available of this part
	 int count = 0;

	// Part constructor
	public Parts(String partName, int valueAmt, int amountTot) {
		this.part = partName;
		this.value = valueAmt;
		this.amount = amountTot;
	}

	// ...set part
	public void setPart(String partName) {
		part = partName;
	}

	// ...get part
	public String getPart() {
		return part;
	}

	// ...set value
	public void setValue(int valueAmt) {
		value = valueAmt;
	}

	// ...get value
	public int getValue() {
		return value;
	}

	// ...set amount
	public void setAmount(int amountTot) {
		amount = amountTot;
	}

	// ...get amount
	public int getAmount() {
		return amount;
	}
	
	//read record.txt to Array
	 public void readFileToArray()
	   {
	      StringTokenizer tokenizer;

	      try
	      {
	    	//  Open the input file
	    	  BufferedReader inFile = new BufferedReader(new FileReader("c:/temp/record.txt"));

	         line = inFile.readLine();
	         while (line != null)
	         {
	        	//Split text file by lines
	            tokenizer = new StringTokenizer (line);
	            try
	            {
	               part = tokenizer.nextToken();  // First element is part name
	               amount = Integer.parseInt (tokenizer.nextToken()); // second element is amount
	               value = Integer.parseInt (tokenizer.nextToken()); // third element is value
	               partsArray[count++] = new Parts (part, amount, value); //Create an Array of Objects
	            }
	            catch (NumberFormatException exception)
	            {
	               System.out.println ("Error in input. Line ignored:");
	               System.out.println (line);
	            }
	            line = inFile.readLine();
	         }

	         inFile.close();
	      }
	      catch (FileNotFoundException exception)
	      {
	         System.out.println ("The file was not found.");
	      }
	      catch (IOException exception)
	      {
	         System.out.println (exception);
	      }
	   }	

	 
	 public Parts[] getPartsArray(){
			return partsArray;		
		}	 
	 
	public void printArray() {
		for (int i = 0; i < partsArray.length; i++)
			System.out.println(partsArray[i]);
	}

	// Return a parts string
	public String toString() {
		return part + " " + value + " " + amount + "";
	}

	public void modifyArrayTest(String partName, int valueAmt, int amountTot) {
		 boolean found = false;
		 for (int j = 0; j < partsArray.length; j++) {
		     if ( partsArray[j].part == partName ) {
		         found = true;
		     }
		 }
		 if (found) {
		     System.out.println( "\nThe array contains the string: " + partName );
		 } else {
		     System.out.println( "\nThe array does not contains the string: " + partName );
		     
		 }
		
	}

}
