
public class Main {

	public static void main(String[] args) {
		
		//Creación de objetos Apartment
		Apartment studioManhattan = new Apartment(1, 16, 5500);
		Apartment twoRoomsBrooklyn = new Apartment(2, 38, 4200);
		Apartment fourAndKitchenBronx = new Apartment(3, 78, 2500);
		
		
		//Probar el método larger
		//False
		System.out.println(studioManhattan.larger(twoRoomsBrooklyn));
		//True
		System.out.println(fourAndKitchenBronx.larger(twoRoomsBrooklyn) + "\n");
		
		//Probar el método priceDifference
		//71600
		System.out.println(studioManhattan.priceDifference(twoRoomsBrooklyn));
		//35400
		System.out.println(fourAndKitchenBronx.priceDifference(twoRoomsBrooklyn) + "\n");
		
		
		//Probar moreExpensiveThan
		//false
		System.out.println(studioManhattan.moreExpensiveThan(twoRoomsBrooklyn));
		//true
		System.out.println(fourAndKitchenBronx.moreExpensiveThan(twoRoomsBrooklyn));
		

	}

}
