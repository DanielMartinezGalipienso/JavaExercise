package bank;

public class Accounts {

	public static void main(String[] args) {
		
		Account jose = new Account ("jose", 102.05);
		Account antonio = new Account ("antonio", 102.05);

		System.out.println(jose);
		System.out.println(antonio);
		transfer(jose, antonio, 50.05);
		System.out.println(jose);
		System.out.println(antonio);
		
		
		

	}
	

	//Métodos
	public static void transfer (Account first, Account second, double amount) {
		if(first.getBalance() > amount) {
		first.withdrawal(amount);
		second.deposit(amount);
		} else {
			return;
		}
	}
	
	public static void personalCredit (Account user, double balance) {
		user.deposit(balance);
	}
	
	public static void yourMethod (Account user, double balance) {
		//Método de pago
		user.withdrawal(balance);
	}

}
