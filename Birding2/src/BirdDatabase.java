import java.util.ArrayList;

public class BirdDatabase {
	
	//Attributes
	private String name;
	private ArrayList<Bird> birds;
	
	
	//Constructor
	public BirdDatabase() {}
	//With name
	public BirdDatabase(String name, Bird bird) {
		this.name = name;
		this.birds = new ArrayList<Bird>();
		this.birds.add(bird);
	}
	public BirdDatabase(String name, ArrayList<Bird> birds) {
		this.name = name;
		this.birds = birds;
	}
	//Without name - for fast test without location request -
	public BirdDatabase(Bird bird) {
		this.birds = new ArrayList<Bird>();
		this.birds.add(bird);
	}
	public BirdDatabase(ArrayList<Bird> birds) {
		this.birds = birds;
	}
	
	
	//Methods
	public void addOneBird (Bird bird) {
		birdsCreated();
		this.birds.add(bird);
	}
	public void addBirds(ArrayList<Bird> birds) {
		birdsCreated();
		int i = 0;
		while (i < birds.size()) {
			this.birds.add(birds.get(i));
			i++;
		}
	}
	
	//Verify if the ArrayList is created
	public void birdsCreated() {
		if(this.birds==null) {
			this.birds = new ArrayList<Bird>();
		}
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Birds:\n" + birds + "\n";
	}
	//Getters and Setters

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Bird> getBirds() {
		return birds;
	}
	public void setBirds(ArrayList<Bird> birds) {
		this.birds = birds;
	}
	
}
