
public class Main {

	public static void main(String[] args) {
		
		//Probar Class Person y MyDate
		
		Person user1 = new Person ("Jose Antonio");
		Person user2 = new Person ("Antonio");
		Person user3 = new Person ("Luis");
		
		MyDate day = new MyDate (7,11,1990);
		
		LyyraCard card1 = new LyyraCard (200);
		LyyraCard card2 = new LyyraCard (700);
		
		
		
		card1.setOwner(user2);
		card1.setDay(day);
		day = null;
		
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		

		System.out.println("\n" + day);
		

		System.out.println("\n" + card1);
		

		System.out.println("\n" + card1);
		System.out.println("\n" + card2);
		
		
		
		//Probar el menú
		
		Menu menu1 = new Menu (true);
		Menu menu2 = new Menu (true);
		Menu menu3 = new Menu (false);
		
		menu2.setMenu(false);
		menu2.menuSelectionTwo(3, 2);
		
		menu1.menuSelectionThree(1, 3, 1);
		
		menu3.menuSelectionOne(4);
		
		
		System.out.println("\nMenú 1:\n" + menu1);
		System.out.println("\nMenú 2:\n" + menu2);
		System.out.println("\nMenú 3:\n" + menu3);
		
		
		
		
	}

}
