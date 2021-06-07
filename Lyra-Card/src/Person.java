
public class Person {
	
	//Atributos
	private String name;
	
	//Constructor
	public Person (String name) {
		this.name = name;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
