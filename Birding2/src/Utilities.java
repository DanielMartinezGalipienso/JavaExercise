import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
	
	    // ----------- //
	   //             //
	  //   Methods   //
	 //             //
	// ----------- //
	
	//   Ask to the user the question passed by String   //
	//   And it returns the user's response.   //
	public static String ask(Scanner input, String quest) {
		System.out.print(quest);
		return input.nextLine();
	}
	//askInt required nextLine() after!!
	public static int askInt(Scanner input, String quest) {
		System.out.print(quest);
		return input.nextInt();
	}
	public static void answer(String answer) {
		System.out.println(answer);
	}
	
	
	    // ---------------------------- //
	   //                              //
	  //   Database already created   //
	 //                              //
	// ---------------------------- //
	

	
	//   Database with birds   //
	public static BirdDatabase databaseCreatedBird(String nameOfDatabase, PersonDatabase persons) {
		ArrayList<Bird> birds = new ArrayList<Bird>();
		
		//Search for the person
		Person corvusA = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Ciubotariu Alexandru-Ionuț"));
		Person corvusB = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Javier Álvarez González"));
		Person corvusC = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Fernando Díaz Fernandez"));
		Person corvusD = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Harold Wijts"));
		Person tetraxA = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Paco Bustamante"));
		Person tetraxB = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Carlos Lázaro"));
		Person ciconiaA = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Bart De Schutter"));
		Person psittaculaA = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Solenn C"));
		Person psittaculaB = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Jose L. Tella"));
		Person psittaculaC = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Carmela Quijano"));
		Person psittaculaD = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Fco. Javier Salcedo Ortiz"));
		Person psittaculaE = persons.getPersons().get(PersonDatabase.personIndexInDatabase(persons, "Pedro Romero Vidal"));
		
		//Common raven - 1st bird - Cuervo grande
		//Latin name:
		//Corvus corax
		ArrayList<Observation> raven = new ArrayList <Observation>();
		raven.add(new Observation(1, "Romania - Neamț", corvusA)); //Observer Ciubotariu Alexandru-Ionuț
		raven.add(new Observation(1, "Spain - Montemayor", corvusB)); //Observer Javier Álvarez González
		raven.add(new Observation(2, "Spain - Córdoba", corvusC)); //Observer Fernando Díaz Fernandez
		raven.add(new Observation(1, "Spain - Camarles - flying", corvusD)); //Observer Harold Wijts
		//Little bustard - 2nd bird - Sisón común
		//Latin name:
		//Tetrax tetrax
		ArrayList<Observation> bustard = new ArrayList <Observation>();
		bustard.add(new Observation(1, "Spain - Cabanillas del Campo - adult, singing, seen and heard", tetraxA)); //Observer Paco Bustamante
		bustard.add(new Observation(1, "Spain - Cabanillas del Campo - moving southwest", tetraxA)); //Observer Paco Bustamante
		bustard.add(new Observation(3, "Spain - Cabanillas del Campo - moving southeast", tetraxA)); //Observer Paco Bustamante
		bustard.add(new Observation(1, "Spain - Cabanillas del Campo - singing, seen and heard", tetraxA)); //Observer Paco Bustamante
		bustard.add(new Observation(2, "Spain - Alcázar de San Juan", tetraxB)); //Observer Carlos Lázaro
		//Oriental stork - 3rd bird - Cigüeña oriental
		//Latin name:
		//Ciconia boyciana
		ArrayList<Observation> stork = new ArrayList <Observation>();
		stork.add(new Observation(12, "China - Hong Kong - Mai Po Nature Reserve - seen", ciconiaA)); //Observer Bart De Schutter
		stork.add(new Observation(1, "China - Hong Kong - Mai Po Nature Reserve - flying, seen", ciconiaA)); //Observer Bart De Schutter
		stork.add(new Observation(2, "China - Hong Kong - Mai Po Nature Reserve - seen", ciconiaA)); //Observer Bart De Schutter
		//Rose-ringed parakeet - 4th bird - Cotorra de Kramer
		//Latin name:
		//Psittacula krameri
		ArrayList<Observation> parakeet = new ArrayList <Observation>();
		parakeet.add(new Observation(1, "France - Ville-d'Avray - call, hear", psittaculaA)); //Observer Solenn C
		parakeet.add(new Observation(3, "France - Meudon - flying, seen and hear", psittaculaA)); //Observer Solenn C
		parakeet.add(new Observation(1, "France - Bois de Clamart - Forêt Domaniale - call, hear", psittaculaA)); //Observer Solenn C
		parakeet.add(new Observation(2, "France - Meudon - singing, hear", psittaculaA)); //Observer Solenn C
		parakeet.add(new Observation(1, "France - Meudon - flying, hear", psittaculaA)); //Observer Solenn C
		parakeet.add(new Observation(1, "Spain - Ciudad de Sevilla - ♂︎ adult, flying", psittaculaB)); //Observer Jose L. Tella
		parakeet.add(new Observation(1, "France - Clichy - flying, hear", psittaculaA)); //Observer Solenn C
		parakeet.add(new Observation(1, "Spain - Cádiz - Parque Genovés - seen and hear", psittaculaC)); //Observer Carmela Quijano
		parakeet.add(new Observation(1, "Spain - Loma del Acebuchal", psittaculaD)); //Observer Fco. Javier Salcedo Ortiz
		parakeet.add(new Observation(1, "Spain - Campus Pablo de Olavide - hear", psittaculaE)); //Observer Pedro Romero Vidal
		
		//Add the birds to database
		birds.add(new Bird("Common raven", "Corvus corax", raven));
		birds.add(new Bird("Little bustard", "Tetrax tetrax", bustard));
		birds.add(new Bird("Oriental stork", "Ciconia boyciana", stork));
		birds.add(new Bird("Rose-ringed parakeet", "Psittacula krameri", parakeet));

		BirdDatabase databaseOfBirdsForUse = new BirdDatabase(nameOfDatabase, birds);
		return databaseOfBirdsForUse;
	}
	
	
	public static PersonDatabase databaseCreatedPerson(String nameOfDatabasePerson) {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		//Person of bird - Corvus corax
		persons.add(new Person("Ciubotariu Alexandru-Ionuț")); //1
		persons.add(new Person("Javier Álvarez González")); //2
		persons.add(new Person("Fernando Díaz Fernandez")); //3
		persons.add(new Person("Harold Wijts")); //4
		
		//Person of bird - Tetrax tetrax
		persons.add(new Person("Paco Bustamante")); // 1~4
		persons.add(new Person("Carlos Lázaro")); // 5

		//Person of bird - Ciconia boyciana
		persons.add(new Person("Bart De Schutter")); //1~3

		//Person of bird - Psittacula krameri
		persons.add(new Person("Solenn C")); // 1~5, 7
		persons.add(new Person("Jose L. Tella")); // 6
		persons.add(new Person("Carmela Quijano")); // 8
		persons.add(new Person("Fco. Javier Salcedo Ortiz")); // 9
		persons.add(new Person("Pedro Romero Vidal")); // 10
		

		PersonDatabase databaseOfPersonsForUse = new PersonDatabase(nameOfDatabasePerson, persons);
		return databaseOfPersonsForUse;
	}
	
	
	
	
	
	
	
	      // ----------------- //
	     //       Extra       //
	    // ----------------- //
	   //                   //
	  //   Print options   //
	 //                   //
	// ----------------- //

	
	//   Print of ArrayList of Object Observation   //
	public static void printOfObservation(ArrayList<Observation> observations) {
		
		System.out.println("\n\nObservations");
		System.out.println("----------------------------------------");
		
		//Loop for every observation of the ArrayList of observations
		for (Observation observation : observations) {
			System.out.print("");
			System.out.println(observation);
		}
		
	}
	
	//   Print of ArrayList of Object Observation allowed in ArrayList of Birds   //
	public static void printOfObservationForDatabaseBird(BirdDatabase databaseBird) {

		System.out.println("\n\nObservations of Birds");
		System.out.println("----------------------------------------");
		
		for (Bird bird: databaseBird.getBirds()) {
			System.out.println("\n\n" + bird.getLatinName() + ", common name: " + bird.getName() + ":\n");
			if (bird.getObservationCount() > 0) {
				for (Observation observation : bird.getObservations()) {
					System.out.println(observation + "\n");
				}
			}
		}
	}
	
	//   Print of birds   //
	public static void stadisticsOfBirds(ArrayList<Bird> birds) {
		
		System.out.println("\n\nBirds: ");
		System.out.println("----------------------------------------");
		
		for (Bird bird : birds) {
			System.out.println(bird);
		}
	}
	
}
