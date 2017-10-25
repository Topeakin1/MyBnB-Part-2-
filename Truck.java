import java.util.ArrayList;

//Truck extends vehicle because a truck "is a" vehicle, truck is a subclass of superclass Vehicle
public class Truck extends Vehicle{ 
	private int cargoWeight;
	
	public Truck(int year,int regNum, String colour, String carName,int num,int cost,int TotalRentDays, int cargoWeight) {// constructor
		super(year,regNum,colour,carName,num,cost,TotalRentDays); //invoke superclass constructor 
		
		this.cargoWeight = cargoWeight; //setting cargoweight
	}
	
	//getter
	public int getCargoWeight()
	{
		return cargoWeight;
	}
	
	//method to calculate truck income
	public static void CalculateTruck(ArrayList<Truck> trucks) {
		//variable initialization
		 int i;
		 int costOfTruck=0;
		 int totalCostOfTruck=0;
		 
		 System.out.println("***Truck***");
		 for(i=0; i<trucks.size(); i++) {
			 System.out.println("The cost of this truck per day is : "  +trucks.get(i).getCost()); //getting cost
			 costOfTruck = (trucks.get(i).getCost() * trucks.get(i).TotalRentDays-1) + trucks.get(i).getCargoWeight();//minus 1 to implement the free day
			 System.out.println("The income from this truck is: " + costOfTruck); 
			 totalCostOfTruck += costOfTruck;
			 System.out.println();
		 }
		 System.out.println("The total amount of money made by the truck vehicle is: " +totalCostOfTruck);
		 System.out.println("***********************************************************************************");
		 System.out.println();
	 } 
}
