
public class Apartment {
	
	//Atributos
	
	private int rooms;
	private int squareMeters;
	private int pricePerSquareMeters;
	
	//Constructor
	
	public Apartment (int rooms, int squareMeters, int pricePerSquareMeters) {
		this.rooms = rooms;
		this.squareMeters = squareMeters;
		this.pricePerSquareMeters = pricePerSquareMeters;
	}
	
	//Métodos
	
	public boolean larger (Apartment otherApartment) {
		if (this.getSquareMeters() > otherApartment.getSquareMeters()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int priceDifference (Apartment otherApartment) {
		int priceFirstApartment = this.getSquareMeters() * this.getPricePerSquareMeters();
		int priceSecondApartment = otherApartment.getSquareMeters() * otherApartment.getPricePerSquareMeters();
		
		if ((priceFirstApartment - priceSecondApartment) < 0) {
			return (priceFirstApartment - priceSecondApartment) * -1;
		} else {

			return priceFirstApartment - priceSecondApartment;
		}
	}
	
	public boolean moreExpensiveThan (Apartment otherApartment) {
		int priceFirstApartment = this.getSquareMeters() * this.getPricePerSquareMeters();
		int priceSecondApartment = otherApartment.getSquareMeters() * otherApartment.getPricePerSquareMeters();
		
		if (priceFirstApartment - priceSecondApartment > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	//Getters and Setters
	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getSquareMeters() {
		return squareMeters;
	}

	public void setSquareMeters(int squareMeters) {
		this.squareMeters = squareMeters;
	}

	public int getPricePerSquareMeters() {
		return pricePerSquareMeters;
	}

	public void setPricePerSquareMeters(int pricePerSquareMeters) {
		this.pricePerSquareMeters = pricePerSquareMeters;
	}
	
	//toString
	@Override
	public String toString() {
		return "Apartment [rooms=" + rooms + ", squareMeters=" + squareMeters + ", pricePerSquareMeters="
				+ pricePerSquareMeters + "]";
	}
	
	
	

}
