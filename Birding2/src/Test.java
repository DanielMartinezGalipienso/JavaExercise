import java.util.ArrayList;

public class Test {
	
	
	public static void testClassBird() {
		
		
		//We will be create some birds
		Bird raven = new Bird("Raven");
		raven.setLatinName("Corvus Corvus");
		
		//Will create an ArrayList of Observations - 1st
		Observation firstObservation = new Observation(1);
		ArrayList<Observation> arrayOfObservations = new ArrayList<Observation>();
		arrayOfObservations.add(firstObservation);
		
		//We will create the second Bird with one Observation
		Bird segullBird = new Bird("Seagull", "Dorkus Dorkus", arrayOfObservations);

		BirdDatabase segull = new BirdDatabase(segullBird);
		
		//Add a second Observation for the second Bird
		firstObservation = new Observation(2);
		firstObservation.setObservationDetails("Switzerland - Teppes de Verbois");
		arrayOfObservations.add(firstObservation);
		arrayOfObservations.add(firstObservation);
		
		//Add the two Birds to the ArrayList of Birds
		//How before I try to use the two with the same array of Observations
		//they get the same Observations.
		//Let's change this creating another ArrayList of Observation
		//birds.add(new BirdDatabase(raven, arrayOfObservations));
		ArrayList<Observation> secondArrayOfObservations = new ArrayList<Observation>();
		secondArrayOfObservations.add(firstObservation);
		firstObservation = null;
		raven.addMoreObservations(secondArrayOfObservations);
		//Let's create the Database of Birds
		BirdDatabase birds = new BirdDatabase(raven);
		birds.addOneBird(segullBird);
		
		//Print the Birds From the Database birds
		System.out.println("\n\n\tDatabase Birds:\n");
		if (birds.getBirds() != null){
			for (Bird bird : birds.getBirds()) {
				System.out.println(bird);
			}
		} else {
			System.out.println("Birds from Database Birds - not found -");
		}
		
		
		//Print the birds From the Database segull
		System.out.println("\n\n\tDatabase Segull\n");
		if (segull.getBirds() != null) {
			for (Bird bird : segull.getBirds()){
				System.out.println(bird);
			}
		} else {
			System.out.println("Birds from Database Birds - not found");
		}
		
		
		
		//Print one bird in another DataBase without Observations
		System.out.println("\n\n\tDatabase without Observation:\n");
		Bird birdWithoutObservation = new Bird("Bird", new Observation(4));
		BirdDatabase birdDatabaseWithoutObservation = new BirdDatabase();

		if(birdDatabaseWithoutObservation.getBirds() != null) {
			for (Bird bird : birdDatabaseWithoutObservation.getBirds()) {
				System.out.println(bird);
			}
		} else {
			System.out.println("Birds from Database Without Observation - not found");
		}
		
		birdDatabaseWithoutObservation.addOneBird(birdWithoutObservation);
		
		if(birdDatabaseWithoutObservation.getBirds().size() > 0) {
			for (Bird bird : birdDatabaseWithoutObservation.getBirds()) {
				System.out.println(bird);
			}
		}
		
		
		
	}
	
	public static void testUtilities() {
		
		//Let's create an ArrayList of Bird
		BirdDatabase birds = new BirdDatabase();
		
		//We will be create some birds
		Bird raven = new Bird("Raven");
		raven.setLatinName("Corvus Corvus");
		
		//Will create an ArrayList of Observations for the next Bird
		Observation firstObservation = new Observation(3);
		ArrayList<Observation> arrayOfObservations = new ArrayList<Observation>();
		arrayOfObservations.add(firstObservation);
		
		//We will create the second Bird with one Observation
		Bird segull = new Bird("Seagull", "Dorkus Dorkus", arrayOfObservations);
		birds.addOneBird(segull);
		
		//Add a second Observation for the second Bird
		firstObservation = new Observation(1);
		firstObservation.setObservationDetails("Spain - Trigueros");
		arrayOfObservations.add(firstObservation);
		arrayOfObservations.add(firstObservation);
		firstObservation = null;
		
		//Add the two Birds to the ArrayList of Birds
		raven.addMoreObservations(arrayOfObservations);
		birds.addOneBird(raven);
		birds.addOneBird(segull);
		
		
		//Print array of observation
		System.out.println("Print of ArrayList of Observations....................");
		
		Utilities.printOfObservation(arrayOfObservations);
		
		System.out.println("\nEnd of testUtilities");
		System.out.println("----------------------------------------");
		
	}
	
	
	
	
	
	//Test Total
	public static void testOfAll() {
		testClassBird();
		testUtilities();
	}
	
}
