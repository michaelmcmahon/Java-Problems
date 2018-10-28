/* mmcmahon_wk5_Assignment_PartsWorker.java
 * Employee subclass PartsWorker that represents an employee whose pay is based on the number of pieces of merchandise produced. 
 *  Class PartsWorker contains private variables to store: Payment per piece, Number of pieces produced, Fixed bonus amount 
 *  Number of pieces required before a bonus is applied. Add two other methods to the PartsWorker class that you think might be useful. 
Notes: 
NegativePieceWageException? – see slide 15 deck 3
 */

public class PartsWorker extends Employee {
	private double wage; // declare instance variable wage for payment per piece
	private int pieces; // declare instance variable pieces number of pieces produced
	private double bonusAmount = 100.00; // declare instance variable bonus amount for fixed bonus amount
	private int bonusPieces = 100; // declare instance variable bonuspieces for pieces required before a bonus is applied

	// seven-argument constructor
	public PartsWorker(String first, String last, String ssn, double PieceWage,
			int NumerOfPieces, double FixBonusAmount, int FixBonusPieces) {
		super(first, last, ssn);
		setWage(PieceWage); // validate and store wage
		setPieces(NumerOfPieces); // validate and store pieces per week
		setBonusAmount(FixBonusAmount); // validate and store bonus amount
		setBonusPieces(FixBonusPieces); // validate and store the amount of pieces per week for bonus
	} // end seven-argument PartsWorker constructor

	// set wage method
	public void setWage(double PieceWage) {
		wage = (PieceWage < 0.0) ? 0.0 : PieceWage;
	} // end set wage method
	
	// return wage method
	   public double getWage()
	   {
	      return wage;
	   } // end return wage method

	// set pieces method
	public void setPieces(int NumerOfPieces) {
		pieces = (NumerOfPieces >= 0) ? NumerOfPieces : 0; 
	} // end set pieces method

	// return pieces method
	public int getPieces() {
		return pieces;
	} // end return pieces method
	
	// set bonus amount method
	public void setBonusAmount(double FixBonusAmount) {
		bonusAmount = (FixBonusAmount < 0.0) ? 0.0 : FixBonusAmount;
	} // end set bonus amount method
 
	// return bonus amount method
	public double getBonusAmount() {
		return bonusAmount;
	} // end return bonus amount method
	
	// set bonus pieces method
	public void setBonusPieces(int FixBonusPieces) {
		bonusPieces = (FixBonusPieces >= 0) ? FixBonusPieces : 0; 
	} // end set bonus pieces method

	// return bonus pieces method
	public int getBonusPieces() {
		return bonusPieces;
	} // end return bonus pieces method
	
	
	 // calculate weekly earnings; override abstract method earnings in Employee
	   public double earnings()
	   {
		if (getPieces() < 100) // no bonus
			return getWage() * getPieces();
		else
			return (getPieces() * getWage()) + bonusAmount; // with bonus
	   } // end method weekly earnings
	   
	   //ADDITIONAL METHOD 1: calculate average pieces produced per day by Parts Worker
	   public int avgPiecesPerDay()
	   {		
			return getPieces()/5; //assuming an 5 day week
	   } // end method average pieces produced per day
	   
	   //ADDITIONAL METHOD 2: calculate average amount earner per day by Parts Worker
	   public double avgWagePerDay()
	   {		
			return (getWage() * getPieces())/5; //assuming an 5 day week
	   } // end method average amount earner per day

	   // return String representation of PartsWorker object
	   public String toString()
	   {
	      return String.format( 
	    		  "Parts Worker: %s\n"
	    		  + "%s: $%,.2f;\n"
	    		  + "%s: %d \n"
	    		  + "%s: $%,.2f;\n"
	    		  + "%s: %d \n"
	    		  + "%s: %d \n"
	    		  + "%s: $%,.2f;", 
	    		  	  
	         super.toString(), 
	         "Payment per piece", getWage(), 
	         "Number of pieces produced per week", getPieces(), 
	      	 "The Bonus Amount", getBonusAmount(),
	  		 "The Number of pieces per week for bonus", getBonusPieces(), 
	      	 "The Average number of pieces produced per day", avgPiecesPerDay(),
	      	 "The Average amount earned per day by Parts Worker", avgWagePerDay());
	   } // end method toString
	 
} // end class PartsWorker
