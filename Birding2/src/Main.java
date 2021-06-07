import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Test.testOfAll();
		Scanner scan = new Scanner(System.in);
		
		//We create a Database with data already create for quick handling.
		//They need a name for the Database - for a more agile location of this -
		PersonDatabase databasePerson = Utilities.databaseCreatedPerson("databaseTest");
		BirdDatabase databaseBird = Utilities.databaseCreatedBird("databaseTest", databasePerson);
		
		while (true) {

			String command = Utilities.ask(scan, "What is your command?\n\t(Help for a view of all commands.)");
			if(command.equals("Quit")){
				System.out.print("Exiting.....");
				scan.close();
				break;
			}
			
			
			//To-Do
			//"Login / Logout" a Person - Change person already created & the anonymous if it disappear
			//Use the Login to determinate the person who send the Observation
			
			switch(command) {
			case "Help": MainController.help();
				break;
			case "Bird": MainController.addBird(scan, databaseBird, databasePerson);
				break;
			case "Observation": MainController.addObservation(scan, databaseBird, databasePerson);
				break;
			case "Person": MainController.addPerson(scan, databasePerson);
				break;
			case "Show": MainController.show(scan, databaseBird, databasePerson);
				break;
			case "Statistics": MainController.statistics(scan, databaseBird);
				break;
			case "Test": Test.testOfAll();
				break;
			default:
				Utilities.answer("Unknown command.");
				break;
			}
		}
	}
	
}
