package bank;

public class Main {

	public static void main(String[] args) {
		
		Account jose = new Account ("jose", 102.05);
		Account antonio = new Account ("antonio", 102.05);

		System.out.println(jose);
		System.out.println(antonio);
		Accounts.transfer(jose, antonio, 50.05);
		System.out.println(jose);
		System.out.println(antonio);
		
		
		Accounts.personalCredit(jose, 30);
		System.out.println("\n" + jose + "\n");
		
		Accounts.yourMethod(antonio, 120.02);
		System.out.println(antonio);

	}

}
