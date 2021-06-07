
public class CashRegister {
	
	//Atributos
	
	//Amount of cash in the register
	private double cashInRegister;
	//Amount of economical lunches sold
	private int economicalSold;
	//Amount of gourmet lunches sold
	private int gourmetSold;
	
	//Constructor
	public CashRegister () {
		this.cashInRegister = 1000;
		this.economicalSold = 0;
		this.gourmetSold = 0;
	}
	
	//Métodos
	
	//Pay an Economical lunch in cash
	public double payEconomical (double cashGiven) {
		
		//One economical lunch = 2.5€
		double lunch = 2.5;
		
		//If the given money is enough for the lunch
		if (cashGiven >= lunch) {
			
			//Add an Economical lunch sold
			this.economicalSold += 1;
			//Add the money to the cash
			this.cashInRegister += lunch;
			
			//Return the change
			return cashGiven - lunch;
			
		} else {
			//If not gave enough money, return this
			return cashGiven;
		}
		
	}
	
	//Pay a Gourmet lunch in cash
	public double payGourmet (double cashGiven) {
		
		//One Goutmet lunch = 4.0
		double lunch = 4;
		
		//If the given money is enough for the lunch
		if (cashGiven >= lunch) {
			
			//Add a Gourmet lunch sold
			this.gourmetSold +=1;
			//Add the money to the cash
			this.cashInRegister += lunch;
			
			//Return the change
			return cashGiven - lunch;
			
		} else {
			//If not gave enough money, return this
			return cashGiven;
		}
		
	}
	
	//Pay an Economical lunch with card
	public boolean payEconomical (LyyraCard card) {
		
		//One economical lunch = 2.5
		double lunch = 2.5;
		
		//If have enough balance in the card for the lunch
		if (card.getBalance() >= lunch) {
			
			//Add an Economical lunch sold
			this.economicalSold += 1;
			//Pay the lunch with the card
			card.pay(lunch);
			
			//Return true
			return true;
			
		} else {
			
			//If not have enough balance in card, return false
			return false;
		}
		
	}
	
	//Pay a Gourmet lunch with card
	public boolean payGourmet (LyyraCard card) {
		
		//One gourmet lunch = 4
		double lunch = 4;
		
		//If have enough valance in the card for the lunch
		if (card.getBalance() >= lunch) {
			
			//Add a Gourmet lunch sold
			this.gourmetSold += 1;
			//Pay the lunch with the card
			card.pay(lunch);
			
			//Return true
			return true;
			
		} else {
			//If not have enough balance in card, return false
			return false;
		}
	}
	
	//Add money to the card
	public void loadMoneyToCard (LyyraCard card, double sum) {
		
		if (sum > 0) {
			//Add money to the cash
			this.cashInRegister += sum;
			//Charge the money to the card
			card.loadMoney(sum);
		}
		
	}
	
	//toString
	@Override
	public String toString() {
		return "Money in register: " + this.getCashInRegister() +
				"\nEconomical lunches sold: " + this.getEconomicalSold() +
				"\nGourmet lunches sold: " + this.getGourmetSold();
	}
	
	//Setters ang Getters
	public double getCashInRegister() {
		return cashInRegister;
	}

	public void setCashInRegister(double cashInRegister) {
		this.cashInRegister = cashInRegister;
	}

	public int getEconomicalSold() {
		return economicalSold;
	}

	public void setEconomicalSold(int economicalSold) {
		this.economicalSold = economicalSold;
	}

	public int getGourmetSold() {
		return gourmetSold;
	}

	public void setGourmetSold(int gourmetSold) {
		this.gourmetSold = gourmetSold;
	}

	
	
	

}
