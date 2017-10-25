import java.util.ArrayList;

//My Car class extends Vehicle so it inherits all the traits from vehicle
public class Car extends Vehicle {
	private int passengerNumber;
	public Car(int year,int regNum, String colour, String carName,int num,int cost,int TotalRentDays,int passengerNumber) { //constructor as it must take the same name as the class
		super(year,regNum, colour,carName,num,cost,TotalRentDays); //invoking super constructor
		
		this.passengerNumber = passengerNumber;
	}

	//getter
   public int getpassengerNumber() {
	 return passengerNumber;  
   }
   
 //method to calculate 
 	public static void CalculateCar(ArrayList<Car> cars) {
 		//variable initialization
 		 int i;
 		 int costOfCar=0;
 		 int totalCostOfCar=0;
 		 
 		 System.out.println("***Truck***");
 		 for(i=0; i<cars.size(); i++) {
 			 System.out.println("The cost of this truck per day is : "  +cars.get(i).getCost()); //getting cost
 			 costOfCar = (cars.get(i).getCost() * cars.get(i).TotalRentDays-1) ;//minus 1 to implement the free day
 			 System.out.println("The income from this truck is: " + costOfCar); 
 			 totalCostOfCar += costOfCar;
 			 System.out.println();
 		 }
 		 System.out.println("The total amount of money made by the truck vehicle is: " +totalCostOfCar);
 		 System.out.println("***********************************************************************************");
 		 System.out.println();
 	 } 

}
