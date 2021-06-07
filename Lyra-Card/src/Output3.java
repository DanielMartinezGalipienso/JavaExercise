
public class Output3 {

	public static void main(String[] args) {
		
		//OUTPUT 3
		System.out.println("\n\nOutput 3:\n");
		
		CashRegister unicafeExactum = new CashRegister();
		double theChange = unicafeExactum.payEconomical(10);
		System.out.println("the change was " + theChange );
		LyyraCard cardOfJim = new LyyraCard(7);
		boolean succeeded = unicafeExactum.payGourmet(cardOfJim);
		System.out.println("payment success: " + succeeded);
		succeeded = unicafeExactum.payGourmet(cardOfJim);
		System.out.println("payment success: " + succeeded);
		succeeded = unicafeExactum.payEconomical(cardOfJim);
		System.out.println("payment success: " + succeeded);
		System.out.println( unicafeExactum );
		
		
		/*
		 * the change was 7.5
		 * payment success: true
		 * payment success: false
		 * payment success: true
		 * money in register 1002.5
		 * economical lunches sold: 2
		 * gourmet lunches sold: 1
		 */
	}

}
