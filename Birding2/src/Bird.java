import java.util.ArrayList;

public class Bird {
	
	//Attributes
	private String name;
	private String latinName;
	private int observationCount;
	private ArrayList<Observation> observations;
	
	
	//Constructor
	public Bird() {}
	public Bird(String name) {
		this.name = name;
		this.observations = new ArrayList<Observation>();
	}
	public Bird(String name, String oficialName) {
		this.name = name;
		this.latinName = oficialName;
		this.observations = new ArrayList<Observation>();
	}
	public Bird(String name, String oficialName, Observation observation) {
		this.name = name;
		this.latinName = oficialName;
		this.observations = new ArrayList<Observation>();
		this.observations.add(observation);
	}
	public Bird(String name, Observation observation) {
		this.name = name;
		this.observations = new ArrayList<Observation>();
		this.observations.add(observation);
	}
	//An old version with observations added to the bird - not more used
	public Bird(String name, String oficialName, ArrayList<Observation> observations) {
		this.name = name;
		this.latinName = oficialName;
		this.observations = observations;
	}

	//Methods
	//Add an Observation
	public void addOneObservation(Observation observation) {
		this.observations.add(observation);		
	}
	
	//Add more of one Observation - Used in test
	public void addMoreObservations(ArrayList<Observation> observations) {
		int i = 0;
		while(i < observations.size()) {
			this.observations.add(observations.get(i));
			i++;
		}
	}
	//Obtain all the observations for this bird
	//The sum of the numberOfBirdsSeen
	//Not the count of observations added
	public int allObservationsCount() {
		int countOfObservationTotalOfBirds = 0;
		//Verify if have observations for the bird
		if(this.observations != null) {
			for(Observation observationsOfBirds : this.observations){
				countOfObservationTotalOfBirds += observationsOfBirds.getNumberOfBirdsSeen();
			}
			return countOfObservationTotalOfBirds;
			
		} else {
			return countOfObservationTotalOfBirds;
		}
	}

	
	
	@Override
	public String toString() {
		return "\nLatin name: " + latinName + ", common name: " + name + "\n"
				+ "Observations added: " + getObservationCount()
				+ "\nObservations of this bird: " + allObservationsCount() + "\n"+ observations;
				/*
				+ ", \n\tobservations:" + observations.toString() + "\n";
				*/
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
	public int getObservationCount() {
		this.setObservationCount();
		return observationCount;
	}
	//Count of Observations added for the bird
	//Not the sum of numberOfBirdsSeen
	public void setObservationCount() {
		int totalOfObservations = 0;
		if(this.observations.size() > 0) {
			int i = 0;
			while (i < this.observations.size()) {
				totalOfObservations += 1;
				i++;
			}
		}
		
		this.observationCount = totalOfObservations;
	}
	
	public ArrayList<Observation> getObservations() {
		return observations;
	}
	public void setObservations(ArrayList<Observation> observations) {
		this.observations = observations;
	}
	
	
	
}
