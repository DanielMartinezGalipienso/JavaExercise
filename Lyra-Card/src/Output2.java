
public class Output2 {

	public static void main(String[] args) {
		
		//OUTPUT 2
		System.out.println("Output 2:\n");
		
		CashRegister unicafeExactum = new CashRegister();
		double theChange = unicafeExactum.payEconomical(10);
		System.out.println("the change was " + theChange );
		theChange = unicafeExactum.payEconomical(5);
		System.out.println("the change was " + theChange );
		theChange = unicafeExactum.payGourmet(4);
		System.out.println("the change was " + theChange );
		System.out.println( unicafeExactum );
		
		/*
		 * the change was 7.5
		 * the change was 2.5
		 * the change was 0.0
		 * money in register 1009.0
		 * economical lunches sold: 2
		 * gourmet lunches sold: 1
		 */
	}

}
