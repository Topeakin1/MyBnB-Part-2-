import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.File;

public class Vehicle implements RentalItem {
	/* **When entering VehicleID enter a number from 5-9** */
	//variable initialization
	private int year;
	private int regNum;
	private String colour;
	private String carName;
	private int num;
	private int cost;
	int TotalRentDays;
	
	public Vehicle(int year,int regNum, String colour, String carName,int num,int cost,int TotalRentDays) { //constructor
		
		//setting variables
		this.year= year;
		this.regNum= regNum;
		this.colour= colour;
		this.carName= carName;
		this.num = num;
		this.cost = cost;
		this.TotalRentDays = TotalRentDays;
	}
	
	//cost getter
	public int getCost() {
		return cost;
	}

	 //cost setter
	public void setCost(int cost) {
		if(cost>0) { //cost has to be positive
			this.cost = cost; //creating an instance of cost
			}	
			}
	
	//getter
	public int getNum() {
		return num; 
	}
	
	//getter
	public int getYear() {
		return year;
	}

	//getter
	public int getRegNum() {
		return regNum;
	}
	
	//getter
	public String getColour() {
		return colour;
	}

	//getter
	public  String getCarName() {
		return carName;
	}
	
	//interface implementation
	public void RentalItemm(int Rentdays){
		
		TotalRentDays += Rentdays;	
	}
	
//method for filling in vehicle details
   public static void FillInVehicle(ArrayList<Car> cars,ArrayList<Truck> trucks) {
	   try (BufferedReader BC= new BufferedReader(new FileReader("InputVehicle.txt"))){
		   String line; 
			while ((line = BC.readLine()) != null) { //reading each line
				String[] myArray= line.split(" "); //removing white space
				if(myArray.length>0) {
					if(myArray[0].equals("1")) { //if first element in arraylist is 1 its a car
						cars.add(new Car(Integer.parseInt(myArray[1]),Integer.parseInt(myArray[2]), myArray[3],myArray[4],Integer.parseInt(myArray[5]),Integer.parseInt(myArray[6]),Integer.parseInt(myArray[7]),Integer.parseInt(myArray[8])));
					}
					else if(myArray[0].equals("2")) { //if first element in arraylist is 2 its a truck
						trucks.add(new Truck(Integer.parseInt(myArray[1]),Integer.parseInt(myArray[2]),myArray[3],myArray[4],Integer.parseInt(myArray[5]),Integer.parseInt(myArray[6]),Integer.parseInt(myArray[7]), Integer.parseInt(myArray[8])));
						}
					else {//exception
						System.out.println("Error, please enter in 1 or 2");
					}
	   }
   }
} 
	   //exception handling
	   catch (IOException e) {
			e.printStackTrace();
		}
	   
   }
   
   //method for printing vehicles to output vehicle.txt
   public static void  PrintAllVehicles(ArrayList<Car> cars,ArrayList<Truck> trucks) {
	   try{
			PrintStream a= new PrintStream(new File("OutputVehicle.txt"));
			int k;
			for(k=0; k<cars.size(); k++) {
				
				System.out.println("Car"+ (k+1));
				System.out.println("---------------------------------------");
				System.out.println("This car was made in the year: "+cars.get(k).getYear());
				System.out.println("The registration number of the car is: "+cars.get(k).getRegNum());
				System.out.println("The colour of the car is: "+cars.get(k).getColour());
				System.out.println("There name of the car is:  "+cars.get(k).getCarName());
				System.out.println("VehicleID: "+cars.get(k).getNum());
				System.out.println("Cost of rent p/day: "+cars.get(k).getCost());
				System.out.println();
				
				a.println("This car was made in the year: "+cars.get(k).getYear());
				a.println("The registration number of the car is: "+cars.get(k).getRegNum());
				a.println("The colour of the car is: "+cars.get(k).getColour());
				a.println("There name of the car is:  "+cars.get(k).getCarName());
				a.println("The amount of passengers allowed in this car is: "+cars.get(k).getpassengerNumber());
				a.println();
			}
			
			for(k=0; k<trucks.size(); k++) {
				System.out.println("Truck"+ (k+1));
				System.out.println("--------------------------------------------");
				System.out.println("This truck was made in the year: "+trucks.get(k).getYear());
				System.out.println("The registration number of the truck is: "+trucks.get(k).getRegNum());
				System.out.println("The colour of the truck is: "+trucks.get(k).getColour());
				System.out.println("There name of the truck is:  "+trucks.get(k).getCarName());
				System.out.println("VehicleID:  "+trucks.get(k).getNum());
				System.out.println("Rent cost p/day:  "+trucks.get(k).getCost());
				System.out.println();
				
				a.println("This truck was made in the year: "+trucks.get(k).getYear());
				a.println("The registration number of the truck is: "+trucks.get(k).getRegNum());
				a.println("The colour of the truck is: "+trucks.get(k).getColour());
				a.println("There name of the truck is:  "+trucks.get(k).getCarName());
				a.println("The cost of this truck is: "+trucks.get(k).getCost());
				a.println("The cargoweight of this truck is "+trucks.get(k).getCargoWeight());
				a.println("The vehicleID of this truck is " +trucks.get(k).getNum());
				a.println();
				
			}	
		}
	   //exception
		catch (IOException e) {
			e.printStackTrace();
		}
   }
   
   //method for renting a vehicle prompt
   public static void VehicleRental(ArrayList<Car> cars,ArrayList<Truck> trucks) {
	   	JTextField vehicleField = new JTextField(2); //property text field
	    JTextField rentalField = new JTextField(2);   //rental text field

	    JPanel myPanel = new JPanel(); //creating an instance of JPanel
	    
	    //adding various attributes to the panel
	    myPanel.add(new JLabel("Vehicle ID:")); 
	    myPanel.add(vehicleField);
	    myPanel.add(Box.createHorizontalStrut(140)); // a spacer
	    myPanel.add(new JLabel("Rental Days:"));
	    myPanel.add(rentalField);
	    
       //user prompt
	    int result = JOptionPane.showConfirmDialog(null, myPanel,
	        "Please Enter the Vehicle ID(number between 5&9) and the Rental Days ", JOptionPane.OK_CANCEL_OPTION);
	   
	    if (result == JOptionPane.OK_OPTION) {
	    	
	          //converting string to integer
	    	  int userInput=Integer.parseInt(vehicleField.getText()); 
			  int userInput2=Integer.parseInt(rentalField.getText());		     

			  int k; 
			  //getting rental item for apartment
			  for(k=0; k<trucks.size(); k++) {
			      if(trucks.get(k).getNum() == userInput) {
			      	trucks.get(k).RentalItemm(userInput2);
			      }
			  }
			        
			    //getting rental item for house
			  for(k=0; k<cars.size(); k++) {
			   		if(cars.get(k).getNum() == userInput) {
			  			cars.get(k).RentalItemm(userInput2);					    		
			  		}
			  }
	    }
	    else
	    	return; 
	    }   
}
