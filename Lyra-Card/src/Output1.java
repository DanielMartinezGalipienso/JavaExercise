
public class Output1 {

	public static void main(String[] args) {
		
		//OUTPUT 1
		System.out.println("Output 1:\n");
		
		LyyraCard cardOfPekka = new LyyraCard(10);
		System.out.println("money on the card " + cardOfPekka.balance() );
		boolean succeeded = cardOfPekka.pay(8);
		System.out.println("money taken: " + succeeded );
		System.out.println("money on the card " + cardOfPekka.balance() );
		succeeded = cardOfPekka.pay(4);
		System.out.println("money taken: " + succeeded );
		System.out.println("money on the card " + cardOfPekka.balance() ); 
		
		/*
		 * money on the card 10.0
		 * money taken: true
		 * 
		 * money on the card 2.0
		 * money taken: false
		 * 
		 * money on the card 2.0
		*/
	}

}
