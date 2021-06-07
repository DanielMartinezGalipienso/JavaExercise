import java.util.ArrayList;

public class PersonDatabase {
	
	//Attributes
	private String name;
	private ArrayList<Person> persons;
	

	//Constructors
	public PersonDatabase(String name, Person person) {
		this.name = name;
		this.persons = new ArrayList<Person>();
		this.persons.add(person);
	}
	public PersonDatabase(String name, ArrayList<Person> persons) {
		this.name = name;
		this.persons = persons;
	}

	public PersonDatabase(Person person) {
		this.persons = new ArrayList<Person>();
		this.persons.add(person);
	}
	public PersonDatabase(ArrayList<Person> persons) {
		this.persons = persons;
	}
	
	//Methods
	public void addOnePerson(Person personToAdd) {
		personsCreated();
		this.persons.add(personToAdd);
	}

	public void personsCreated() {
		if(this.persons == null) {
			this.persons = new ArrayList<Person>();
		}
	}
	
	//Methods
	
	//Find a person in the array and return his Index
	//If not have Person in array or, not can find, return -1
	public static int personIndexInDatabase(PersonDatabase databaseOfPerson, String personToFind) {
		databaseOfPerson.personsCreated();
		int count = 0;
		while(count < databaseOfPerson.getPersons().size()) {
			Person personInDatabaseToCompare = databaseOfPerson.getPersons().get(count);
			if(personInDatabaseToCompare.getName().equals(personToFind)) {
				return count;
			}
			count++;
		}
		return -1;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Persons:\n" + persons + "\n";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Person> getPersons() {
		return persons;
	}
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

}
