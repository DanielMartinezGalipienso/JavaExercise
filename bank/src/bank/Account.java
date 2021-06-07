package bank;

public class Account {
	
	//Atributos
	private double balance;
	private String owner;
	
	//Constructor
	public Account (String owner, double balance) {
		this.balance = balance;
		this.owner = owner;
	}
	
	//Métodos
	public void deposit (double amount) {
		balance += amount;
	}
	
	public void withdrawal (double amount) {
		balance -= amount;
	}
	
	//Getter and Setters
	public double getBalance() {
		return balance;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	//toString
	@Override
	public String toString() {
		return this.getOwner() + " balance: " + this.getBalance();
	}
	
	
	
	

}
