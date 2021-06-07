
public class Observation {
	
	//Attributes
	private int numberOfBirdsSeen;
	private String observationDetails;
	private Person personWhoAddThisObservation;
	
	//Constructor
	public Observation() {}
	public Observation(int numberOfBirdsSeen) {
		this.numberOfBirdsSeen = numberOfBirdsSeen;
	}
	public Observation(int numberOfBirdsSeen, String observationDetails) {
		this.numberOfBirdsSeen = numberOfBirdsSeen;
		this.observationDetails = observationDetails;
	}
	//Constructor - With Person
	public Observation(int numberOfBirdsSeen, Person personWhoAddThisObservation) {
		this.numberOfBirdsSeen = numberOfBirdsSeen;
		if(personWhoAddThisObservation != null)
			this.personWhoAddThisObservation = personWhoAddThisObservation;
	}
	public Observation(int numberOfBirdsSeen, String observationDetails, Person personWhoAddThisObservation) {
		this.numberOfBirdsSeen = numberOfBirdsSeen;
		this.observationDetails = observationDetails;
		if (personWhoAddThisObservation != null)
			this.personWhoAddThisObservation = personWhoAddThisObservation;
	}
	
	//Methods

	public String getNameOfPersonWhoAddThisObservation() {
		if(this.personWhoAddThisObservation == null) {
			return "Anonymous";
		} else {
			return this.personWhoAddThisObservation.getName();
		}
	}
	
	//toString
	
	@Override
	public String toString() {
		return numberOfBirdsSeen + ": " + getObservationDetails() + " by " + getNameOfPersonWhoAddThisObservation();
	}
	
	//Getters and Setters
	public int getNumberOfBirdsSeen() {
		return numberOfBirdsSeen;
	}
	//setNumberOfBirdsInObservation
	public void setNumberOfBirdsSeen(int numberOfBirdsSeen) {
		this.numberOfBirdsSeen = numberOfBirdsSeen;
	}
	public String getObservationDetails() {
		if(!(observationDetails==null)) {
			return observationDetails;
		}else {
			return "Without location";
		}
	}
	public void setObservationDetails(String observationDetails) {
		this.observationDetails = observationDetails;
	}
	public Person getPersonWhoAddThisObservation() {
		return personWhoAddThisObservation;
	}
	public void setPersonWhoAddThisObservation(Person personWhoAddThisObservation) {
		this.personWhoAddThisObservation = personWhoAddThisObservation;
	}

	
}
