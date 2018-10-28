
/*initialises a Parts object, creates 10 transactions and executes them at the same time. 
* Be sure to include a scenario where two Transactions compete for a particular part*/
public class TransactionTest {
	
public static void main(String[] args) {			
		Parts p1 = new Parts(null, 0, 0);
		p1.readFileToArray();
		p1.printArray();
		p1.modifyArrayTest("Body", 0, 101);		
	}

}
