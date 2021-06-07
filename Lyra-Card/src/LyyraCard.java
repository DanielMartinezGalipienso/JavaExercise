
public class LyyraCard {
	
	//Atributos
	private double balance;
	private Person owner;
	private MyDate day;
	
	//Constructor
	public LyyraCard (double balance) {
		this.balance = balance;
	}
	
	//Métodos
	public double balance() {
		return this.getBalance();
	}
	
	public void loadMoney(double amount) {
		if (amount>0) {
			this.balance+=amount;
		} else {
			return;
		}
	}
	
	public boolean pay (double amount) {
		if (amount < 0) {
			return false;
		} else if (this.getBalance() > amount) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	
	//Getter and Setters
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public MyDate getDay() {
		return day;
	}
	
	public void setDay(MyDate day) {
		this.day = day;
	}
	
	//toString
	@Override
	public String toString() {
		return "LyyraCard [balance=" + balance
				+ "\nOwner: " + this.getOwner()
				+ "\nDay: " + this.getDay();
	}
	
	

}
