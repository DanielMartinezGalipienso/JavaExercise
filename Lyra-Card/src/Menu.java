
public class Menu {
	
//Atributos
	//Menú seleccionado 0 Econimical - 1 Gourmet
	private boolean menu;
	private int starter;
	private int main;
	private int dessert;
	
//Constructores
	public Menu (boolean menu) {
		this.menu = menu;
		this.starter = 1;
		this.main = 1;
		this.dessert = 1;
	}	
	public Menu (boolean menu, int starter) {
		this.menu = menu;
		this.starter = starter;
		this.main = 0;
		this.dessert = 1;
	}	
	public Menu (boolean menu, int starter, int main) {
		this.menu = menu;
		this.starter = starter;
		this.main = main;
		this.dessert = 1;
	}
	public Menu (boolean menu, int starter, int main, int dessert) {
		this.menu = menu;
		this.starter = starter;
		this.main = main;
		this.dessert = dessert;
	}
	
	
//Métodos
	//Seleccion de Menú
	public void menuSelectionOne (int starter) {
		this.setStarter(starter);
	}
	
	public void menuSelectionTwo (int starter, int main) {
		this.setStarter(starter);
		this.setMain(main);
	}
	
	public void menuSelectionThree (int starter, int main, int dessert) {
		this.setStarter(starter);
		this.setMain(main);
		this.setDessert(dessert);
	}
	
	
	//Set Menú gourmet or economical
	public void selectMenu (boolean menu) {
		this.setMenu(menu);
	}
	
	//Saber el tipo de menú mediante String
	public String typeMenu (boolean menu) {
		if (menu == true) {
			return "Gourmet";
		} else {
			return "Economical";
		}
	}
	
	
//Getter and Setters
	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}

	public int getStarter() {
		return starter;
	}

	public void setStarter(int starter) {
		this.starter = starter;
	}

	public int getMain() {
		return main;
	}

	public void setMain(int main) {
		this.main = main;
	}

	public int getDessert() {
		return dessert;
	}

	public void setDessert(int dessert) {
		this.dessert = dessert;
	}
	
	
//toString
	@Override
	public String toString() {
		return "Menu: " + this.typeMenu(this.isMenu()) 
		+ "\nStarter: " + starter
		+ "\nMain: " + main
		+ "\nDessert: " + dessert;
	}
	
	
	
	
	
	
	
	
}
