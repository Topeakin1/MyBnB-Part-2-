//This is my main class, here i declare my array lists and call all my functions
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	
//main method 
	public static void main(String []args) {
		
		//initializing arrayLists
		ArrayList<House> houses = new ArrayList<House>(); //declaring an array list of type house called "houses"
		ArrayList<Apartment> apartments = new ArrayList<Apartment>();
		ArrayList<Villa> villas = new ArrayList<Villa>();
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Truck> trucks = new ArrayList<Truck>();
		
		//calling methods
		FillInProperties.FillInPropertiesMethod(houses, apartments, villas);
		
    	String decision = "Yes"; //decision
    	
		while(decision.equalsIgnoreCase("Yes")) { //while decision is yes we run give rental property
			FillInProperties.GiveRentalProperty(houses, apartments, villas);
			
			do {
				//while decision is not yes and is not no we will prompt the user again
				// if decision is no it just exits                                                         
				decision = JOptionPane.showInputDialog(null, "Rent again? Yes\\No");
			} while(!decision.equalsIgnoreCase("Yes") && !decision.equalsIgnoreCase("No")); 
		}
		// if any property is not rented, it does not generate any money
		

		Vehicle.FillInVehicle(cars, trucks); //assigning vehicle to respective arraylists

        decision = "Yes"; //decision
        
		while(decision.equalsIgnoreCase("Yes")) { //while decision is yes we run give rental property
			Vehicle.VehicleRental(cars, trucks);
			
			do {
				//while decision is not yes and is not no we will prompt the user again
				 //  if decision is no it just exits                                                          
				decision = JOptionPane.showInputDialog(null, "Rent again? Yes\\No");
			} while(!decision.equalsIgnoreCase("Yes") && !decision.equalsIgnoreCase("No")); 
		}
        
		FillInProperties.PrintOutMethod(houses,apartments,villas); //calling my printout method
		
		Vehicle.PrintAllVehicles(cars,trucks); //calling my vehicle printout method
		Truck.CalculateTruck(trucks); //truck calcuator method
		Car.CalculateCar(cars);
		FillInProperties.houseCost(houses); //house calculator method
		FillInProperties.apartmentCost(apartments); //apartment calculator method
		FillInProperties.villaCost(villas); //villa calculator method
	}
}