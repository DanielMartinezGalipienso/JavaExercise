import java.util.Scanner;

public class MainController {
	
	
	   // ----------------- //
	  //   Methods for     //
	 //       Main        //
	// ----------------- //
	
	
	//Add a bird - if add a Observation for this, call newObservation
	public static void addBird(Scanner input, BirdDatabase dataBase, PersonDatabase databasePerson) {
		//Create the bird with the data of user
		String commonNameOfBird = Utilities.ask(input, "What is his Common Name? ");
		String latinNameOfBird = Utilities.ask(input, "And his Latin Name? ");
		Bird birdToAdd = new Bird(commonNameOfBird, latinNameOfBird);
		
		//Ask for request if want to add an observation for this bird
		String optionFromUser = Utilities.ask(input, "Want to add an observation? (yes / no)");
		if(optionFromUser.equals("yes")) {
			Observation observation = observationNew(input, databasePerson);
			birdToAdd.addOneObservation(observation);
		}
		
		//Add the bird in Database
		addOneBird(birdToAdd, dataBase);

		Utilities.answer("Bird" + commonNameOfBird + "created successfully.");
	}
	
	//Add an observation for an existing bird - call newObservation
	public static void addObservation(Scanner input, BirdDatabase databaseBird, PersonDatabase databasePerson) {
		//Verify if have birds
		if(haveBirdsInDatabase(databaseBird) == false) {
			Utilities.answer("Not have any bird.\nTry to add some birds.");
		} else {
			String latinNameOfBird = Utilities.ask(input, "What is the Latin name that has the bird?");
			//Find a bird with the latinName
			int indexOfBird = existThisBird(latinNameOfBird, databaseBird);
			if (indexOfBird == -1) {
				//If the bird not have found.
				Utilities.answer("The bird " + latinNameOfBird + " has not been found.");
			}else {
				//Create the observation and add to the bird
				Observation observation = observationNew(input, databasePerson);
				addObservationForThisBird(observation, databaseBird, indexOfBird);
			}
		}
	}
	
	
	//Add a Person -> Is optional add a Person in the observations of birds.
	public static void addPerson(Scanner input, PersonDatabase databasePerson) {
		String namePersonToAdd = Utilities.ask(input, "What is his name?");
		if(existThisPerson(namePersonToAdd, databasePerson) != -1) {
			
			Utilities.answer("The person \"" + namePersonToAdd + "\" already exist.");
			
		} else {
			databasePerson.addOnePerson(new Person(namePersonToAdd));
			Utilities.answer("Person \"" + namePersonToAdd + "\" added.");
			
		}
	}
	
	//Show a list of the bird of all of them
	public static void show (Scanner input, BirdDatabase databaseBird, PersonDatabase databasePerson) {
		String userResponse = Utilities.ask(input, "What want to show? (Bird/Person) ");
		
		switch(userResponse) {
		case "Bird": showBirds(input, databaseBird);
			break;
		case "Person": showPersons(input, databasePerson);
			break;
		default:
			Utilities.answer("Unknown " + userResponse);
		}
	}
	
	
	//Show the statistics of observations of all the birds
	public static void statistics(Scanner input, BirdDatabase databaseBird) {
		//Statistics of observations
		if(haveBirdsInDatabase(databaseBird) == false) {
			Utilities.answer("Not have any bird.\nTry to add some birds.");
		} else {
			Utilities.answer(statisticsOfAllBirdsInString(databaseBird));
		}
	}
	
	//Show a list of actions for Birds
	public static void help() {
		Utilities.answer("All the commands:\n\n"
				+"Bird\t\t -> Add a new Bird.\n"
				+"Observation\t -> Add an observation for an existent Bird.\n"
				+"Person\t\t -> Add a new Person who add an observation"
				+"Show\t\t -> Show an specific Bird.\n"
				+"Statistics\t -> Show a list of information about all the birds.\n"
				+"Help\t\t -> Command for know all the commands.\n"
				+"Quit\t\t -> Exit from the program.\n"
				+"Test\t\t -> Test of birds in Database");
	}
	
		
	// - - - - - - - - - - - - - - - - - - - - - - - //
	// - - - - - - - - - - - - - - - - - - - - - - - //
	// - - - - - - - - - - - - - - - - - - - - - - - //
	
	
	
	    // ----------------- //
	   //                   //
	  //  Methods for add  //
	 //                   //
	// ----------------- //
	
	
	
						   // ----------------- //
						  //   Method for      //
						 //    add a bird     //
						// ----------------- //
	
	public static boolean addOneBird(Bird birdToAdd, BirdDatabase databaseBird) {
		databaseBird.addOneBird(birdToAdd);
		return true;
	}
	
	
	public static boolean addObservationForThisBird(Observation observation, BirdDatabase databaseBird, int indexOfBird) {
		databaseBird.getBirds().get(indexOfBird).addOneObservation(observation);
		return true;
	}
	
						    // ----------------- //
						   //   Method for      //
						  //    add an         //
						 //     observation   //
						// ----------------- //
	
	
	//Add a new observation - always called for add or observation
	public static Observation observationNew(Scanner input, PersonDatabase databasePerson) {
		//Request of information of Observation -> Count of birds
		int observationNumber = Utilities.askInt(input, "What is the count of birds? ");
		input.nextLine();
		Observation observationToAdd = new Observation(observationNumber);
		
		//Ask if want to add a location / detailed information of senn
		String optionFromUserLocation = Utilities.ask(input, "Add an detailed location? (yes/no) ");
		if(optionFromUserLocation.equals("yes")) {
			String locationForBirdObservation = Utilities.ask(input, "What is the location where is seen this bird? ");
			observationToAdd.setObservationDetails(locationForBirdObservation);
		}
		
		String optionFromUserPerson = Utilities.ask(input, "Want to add the person who add this observation? (yes/no) ");
		//To-Do - Person who add this observation
		if(optionFromUserPerson.equals("yes")) {
			while(true) {
				String nameOfPerson = Utilities.ask(input, "What is the name of the person to add? ");
				int indexOfPerson = existThisPerson(nameOfPerson, databasePerson);
				if (indexOfPerson == -1) {
					String addPerson = Utilities.ask(input, "This person not exist\nWant to add one Person? (yes/no) ");
					if(addPerson.equals("yes")) {
						
						String addPersonExisting = Utilities.ask(input, "This person already exist? (yes/no) ");
						
						if(!addPersonExisting.equals("yes")) {
							String addAnotherPerson = Utilities.ask(input, "Want to add a new person in Database? (yes/no) ");
							if(addAnotherPerson.equals("yes")) {
								Person personToAdd = createPerson(input, databasePerson);
								databasePerson.addOnePerson(personToAdd);
								Utilities.answer("Person added.");
							}
						}
					} else {
						Utilities.answer("Not adding a Person");
						break;
					}
				} else {
					observationToAdd.setPersonWhoAddThisObservation(databasePerson.getPersons().get(indexOfPerson));
					break;
				}
			}
			
		}
		
		Utilities.answer("Observation crated.");
		//Return the observation
		return observationToAdd;
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - //

	      // ----------------- //
	     //                   //
	    //  Method for       //
	   //   create one      //
	  //    Person         //
	 //                   //
	// ----------------- //
	
	
	public static Person createPerson(Scanner input, PersonDatabase databasePerson) {
		while(true) {
			String nameOfPerson = Utilities.ask(input, "What is the name of the person to be added? ");
			if(existThisPerson(nameOfPerson, databasePerson) == -1) {
				Person personCreated = new Person(nameOfPerson);
				return personCreated;
			} else {
				Utilities.answer("This person already exist.");
			}
			
		}
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - //

	      // ----------------- //
	     //                   //
	    //  Methods for      //
	   //   verify and      //
	  //    search         //
	 //                   //
	// ----------------- //
	 
	
						    // ----------------- //
						   //   Method for      //
						  //    verify if      //
						 //     have birds    //
						// ----------------- //
	
	public static boolean haveBirdsInDatabase(BirdDatabase databaseBird) {
		if(databaseBird.getBirds() == null) {
			return false;
		} else {
			return true;
		}
	}
						      // ----------------- //
						     //   Method for      //
						    //    verify if      //
						   //     this bird     //
						  //      already      //
						 //       exist       //
						// ----------------- //
	
	//Return the indexOfBird or -1 if not find the bird/not have birds in dataBase
	public static int existThisBird(String latinNameOfBird, BirdDatabase databaseBird) {
		if(haveBirdsInDatabase(databaseBird) == true) {
			int indexOfBird = 0;
			while (indexOfBird < databaseBird.getBirds().size()) {
				if(databaseBird.getBirds().get(indexOfBird).getLatinName().equals(latinNameOfBird)) {
					return indexOfBird;
				}
				indexOfBird++;
			}
		}
		//If not find the bird or not have birds in dataBase
		return -1;
	}
						    // ----------------- //
						   //   Method for      //
						  //    verify if      //
						 //     have persons  //
						// ----------------- //
	
	public static boolean havePersonsInDatabase(PersonDatabase databasePerson) {
		if(databasePerson.getPersons() == null) {
			return false;
		} else {
			return true;
		}
	}
						      // ----------------- //
						     //   Method for      //
						    //    verify if      //
						   //     this person   //
						  //      already      //
						 //       exist       //
						// ----------------- //
	
	
	public static int existThisPerson(String nameOfPerson, PersonDatabase databasePerson) {
		if(havePersonsInDatabase(databasePerson) == true) {
			int indexOfPerson = 0;
			while (indexOfPerson < databasePerson.getPersons().size()) {
				if(databasePerson.getPersons().get(indexOfPerson).getName().equals(nameOfPerson)) {
					return indexOfPerson;
				}
				indexOfPerson++;
			}
		}
		
		return -1;
	}
	
						    // ----------------- //
						   //   Method for      //
						  //    search one     //
						 //     bird          //
						// ----------------- //
	
	public static Bird searchOneBirdForLatinName(String latinNameOfBird, BirdDatabase databaseBird) {
		Bird bird = new Bird();
		
		int i = 0;
		while (i < databaseBird.getBirds().size()) {
			Bird birdWantedToShow = databaseBird.getBirds().get(i);
			if(birdWantedToShow.getLatinName().equals(latinNameOfBird)) {
				bird = birdWantedToShow;
				break;
			}
			i++;
		}
		
		return  bird;
	}
	
						    // ----------------- //
						   //   Method for      //
						  //    search one     //
						 //     person        //
						// ----------------- //
	public static Person searchOnePerson(String nameOfPerson, PersonDatabase databasePerson) {
		Person person = new Person();
		
		int i = 0;
		while (i < databasePerson.getPersons().size()) {
			Person personWantedToShow = databasePerson.getPersons().get(i);
			if(personWantedToShow.getName().equals(nameOfPerson)) {
				person = personWantedToShow;
				break;
			}
			i++;
		}
		
		return  person;
	}
	

	     // ----------------- //
	    //                   //
	   //  Methods for      //
	  //   show            //
	 //                   //
	// ----------------- //
	

						    // ----------------- //
						   //   Method for      //
						  //    show one       //
						 //     bird          //
						// ----------------- //
	
	public static void showBirds(Scanner input, BirdDatabase databaseBird) {
		
		//Show all the Birds from the BirdDatabase
		if(haveBirdsInDatabase(databaseBird) == false) {
			Utilities.answer("Not have any bird.\nTry to add some birds.");
		} else {
			
			String birdForShowName = Utilities.ask(input, "What bird want to see? (Latin name of bird/all) ");
			if(birdForShowName.equals("all")) {
				System.out.println(databaseBird);
			} else {
				Bird birdToShow = searchOneBirdForLatinName(birdForShowName, databaseBird);
				if(birdToShow.getName() == null) {
					Utilities.answer("The bird " + birdForShowName + " has not be found.");
				} else {
					System.out.println(birdToShow);
				}
			}
			
		}
		
	}
	

						    // ----------------- //
						   //   Method for      //
						  //    show one       //
						 //     person        //
						// ----------------- //
	public static void showPersons(Scanner input, PersonDatabase databasePerson) {

		//Show all the Persons from the PersonDatabase
		if(havePersonsInDatabase(databasePerson) == false) {
			Utilities.answer("Not have any person.\nTry to add some person.");
		} else {
			
			String personForShowName = Utilities.ask(input, "What peron want to see? (Name of person/all) ");
			if(personForShowName.equals("all")) {
				System.out.println(databasePerson);
			} else {
				Person personToShow = searchOnePerson(personForShowName, databasePerson);
				if(personToShow.getName() == null) {
					Utilities.answer("The person " + personForShowName + " has not be found.");
				} else {
					System.out.println(personToShow);
				}
			}
			
		}
	}
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - //
	
	    // ----------------- //
	   //   Method for      //
	  //    statistics     //
	 //     of birds      //
	// ----------------- //
	
	public static String statisticsOfAllBirdsInString(BirdDatabase databaseBird) {
		String stringOfStadistics = new String();
		int i = 0;
		while(i < databaseBird.getBirds().size()) {
			Bird bird = databaseBird.getBirds().get(i);
			stringOfStadistics += ("\n" + bird.getLatinName() + ":\n\tObservations: " + bird.getObservations().size());
			stringOfStadistics += ("\n\tTotal of observations: " + bird.allObservationsCount() + "\n");
			i++;
		}
		return stringOfStadistics;
	}
	
	
	
	
}
