//this is class FillInProperties, it does NOT inherit the property class as it acts as my "sub" main, here i implement my printing and cost generator 
import java.io.BufferedReader;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FillInProperties  {
	
	//
	public static void FillInPropertiesMethod(ArrayList<House> houses,ArrayList<Apartment> apartments, ArrayList<Villa> villas)  {
		try (BufferedReader BC= new BufferedReader(new FileReader("InputProperty.txt"))){ //reading in input property text file

			String line; 
			while ((line = BC.readLine()) != null) {
				String [] myArray= line.split(" "); //gets rid of white spaces and creates indexes 
				if(myArray.length>0) {
					if(myArray[0].equals("1")) {
						//adding values from input file to arraylist (myArray[0]) is missing cause that represents property type
						apartments.add(new Apartment(Integer.parseInt(myArray[1]),myArray[2],myArray[3],Integer.parseInt(myArray[4]),Integer.parseInt(myArray[5]),Integer.parseInt(myArray[6]),Integer.parseInt(myArray[7])));
					}
					
					else if(myArray[0].equals("2")) {
						//adding values from input file to arraylist
						houses.add(new House(Integer.parseInt(myArray[1]),myArray[2],myArray[3],Integer.parseInt(myArray[4]),Integer.parseInt(myArray[5]),Integer.parseInt(myArray[6]),Integer.parseInt(myArray[7]),Integer.parseInt(myArray[8]),Integer.parseInt(myArray[9])));
					}
					
					else if(myArray[0].equals("3")) {
						//adding values from input file to arraylist
						villas.add(new Villa(Integer.parseInt(myArray[1]),myArray[2],myArray[3],Integer.parseInt(myArray[4]),Integer.parseInt(myArray[5]),Integer.parseInt(myArray[6]),Integer.parseInt(myArray[7]),Integer.parseInt(myArray[8]),Integer.parseInt(myArray[9])));
					}
					
					else { //my form of exception handling
						System.out.println("Please enter in a number, either 1, 2 or 3");
					}
				}
			}

		}
		//exception handling 
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	//method for printing out all the properties
	public static void PrintOutMethod(ArrayList<House> houses,ArrayList<Apartment> apartments, ArrayList<Villa> villas) {
		int k;
		for(k=0; k<3; k++) {
			villas.get(k).villPrint();
			System.out.println();
			apartments.get(k).printApartment();
			System.out.println();
			houses.get(k).printHouse();
			System.out.println();
		}
		
		try{
			//writing to Output property textfile
			PrintStream a= new PrintStream(new File("OutputProperty.txt"));
			
			for(k=0; k<apartments.size(); k++) {
				a.println("The register number is: "+apartments.get(k).getNum());
				a.println("The owners name is: "+apartments.get(k).getName());
				a.println("The owners address is: "+apartments.get(k).getName());
				a.println("The cost of the property is: "+apartments.get(k).getCost()+ " euro per day");
				a.println("There are "+apartments.get(k).getStoreyNum()+ " stories in the apartment");
				a.println("There are "+apartments.get(k).getBeds()+ " beds in the apartment ");
				a.println("The apartment was rented for "+apartments.get(k).getTotalRentDays()+" day(s)");
				a.println();
			}
			
			for(k=0; k<houses.size(); k++) {
				a.println("The register number is :" + houses.get(k).getNum());
				a.println("The owners name is " + houses.get(k).getName());
				a.println("The owners address is " + houses.get(k).getAddress());
				a.println("The cost of the property is: "+houses.get(k).getCost());
				a.println("There are "+houses.get(k).getStoreyNumber()+ " stories in the house");
				a.println("There are "+houses.get(k).getBedss()+ " beds in the house");
				a.println("The clearing fee for the house is " +houses.get(k).getFees());
				a.println("The property was rented for " +houses.get(k).getTotalRentDays()+ " days");
				a.println();
			}
			
			for(k=0; k<villas.size(); k++) {
				a.println("The register number is: "+villas.get(k).getNum());
				a.println("The owners name is: "+villas.get(k).getName());
				a.println("The owners address is: "+ villas.get(k).getName());
				a.println("The cost of the property is: "+villas.get(k).getCost()+ " euro per day");
				a.println("There are " +villas.get(k).getStoreyNumber()+" stories in the property");
				a.println("There are " +villas.get(k).getBeds()+" beds in the property");
				a.println("The cost of room service is: "+villas.get(k).getRoomService()+ " euro per day");
				a.println("Luxury tax is " +villas.get(k).getLuxuryTax()+" euro per day");
				a.println("This property was rented for " +villas.get(k).getTotalRentDays()+" day(s)");
				a.println();
			  }
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	     //generates the cost of the house property
		 public static void houseCost(ArrayList<House> houses){
			 int i;
			 int costOfHouse = 0;
			 int totalCostOfHouse = 0;
			 System.out.println("**HOUSE PROPERTY*");
			 for(i=0; i<houses.size(); i++) {
				 System.out.println("The cost of this house per day is : "  +houses.get(i).getCost());
				 costOfHouse = (houses.get(i).getCost() + houses.get(i).getFees()) * houses.get(i).TotalRentDays;
				 System.out.println("The income from this house is: " + costOfHouse);
				 totalCostOfHouse += costOfHouse;
				 System.out.println();
			 }
			 
			 System.out.println("The total amount of money made by the house property is: "+ totalCostOfHouse);
			 System.out.println("**********************************************************************");
			 System.out.println();
	}
	
		 //method to generate cost of the apartment property
		 public static void apartmentCost(ArrayList<Apartment> apartments) {
			 //variable initialization
			 int i;
			 int costOfApartment=0;
			 int totalCostOfApartment=0;
			 
			 System.out.println("**APARTMENT PROPERTY**");
			 for(i=0; i<apartments.size(); i++) {
				 System.out.println("The cost of this apartment per day is : "  +apartments.get(i).getCost());
				 costOfApartment = apartments.get(i).getCost() * apartments.get(i).TotalRentDays;
				 System.out.println("The income from this apartment is: " + costOfApartment);
				 totalCostOfApartment += costOfApartment;
				 System.out.println();
			 }
			 System.out.println("The total amount of money made by the apartment property is: " +totalCostOfApartment);
			 System.out.println("***********************************************************************************");
			 System.out.println();
		 }
	
		 //method to generate cost of the villa property
		 public static void villaCost(ArrayList<Villa> villas) {
			 
			 //Variable initialisation 
			 int i;
			 int costOfVilla=0;
			 int totalCostOfVilla=0;
			 
			 System.out.println("**VILLA PROPERTY**");
			 for(i=0; i<villas.size(); i++) {
				 System.out.println("The cost of this villa per day is " +villas.get(i).getCost() ); //printing cost of each villa per day
				 costOfVilla = (villas.get(i).getCost() + villas.get(i).getLuxuryTax() + villas.get(i).getRoomService()) * villas.get(i).TotalRentDays;
				 System.out.println("The income from this villa is: " + costOfVilla);
				 totalCostOfVilla += costOfVilla;				 
				 System.out.println("The luxury tax is: " +villas.get(i).getLuxuryTax() + " euro extra per day");
				 System.out.println("The room service is: " +villas.get(i).getRoomService() + " euro extra per day");
				 System.out.println();
			 }
			 System.out.println("The total amount of money made by the villa property is: "+totalCostOfVilla);
		 }
		 //I decided to do the cost in three methods rather than in one to make it clearer that they are 3 different properties rather than one 
		 
		 //method for prompting user to input property id and amount of days property was rented for
		 public static void GiveRentalProperty(ArrayList<House> houses,ArrayList<Apartment> apartments, ArrayList<Villa> villas) {
	    	JTextField propertyField = new JTextField(2); //property text field
			JTextField rentalField = new JTextField(2);   //rental text field

			JPanel myPanel = new JPanel(); //creating an instance of JPanel
			    
			 //adding various attributes to the panel
			 myPanel.add(new JLabel("Property ID:")); 
			 myPanel.add(propertyField);
			 myPanel.add(Box.createHorizontalStrut(40)); // a spacer
			 myPanel.add(new JLabel("Rental Days:"));
			 myPanel.add(rentalField);
			    
                //user prompt
			 int result = JOptionPane.showConfirmDialog(null, myPanel,
			      "Please Enter the Property ID and the Rental Days", JOptionPane.OK_CANCEL_OPTION);
			   
			  if (result == JOptionPane.OK_OPTION) {
			    	
			        //converting string to integer
			    	int userInput=Integer.parseInt(propertyField.getText()); 
					int userInput2=Integer.parseInt(rentalField.getText());
	
					int k; 
					//getting rental item for apartment
					for(k=0; k<apartments.size(); k++) {
					     if(apartments.get(k).getNum() == userInput) {
					        apartments.get(k).RentalItemm(userInput2);
					       	}
					  }
					        
					    //getting rental item for house
					  for(k=0; k<houses.size(); k++) {
					   		if(houses.get(k).getNum() == userInput) {
					  			houses.get(k).RentalItemm(userInput2);					    		
					  		}
					  }
					
					    	 //getting rental item for villa
					  for(k=0; k<villas.size(); k++) {
					  		if(villas.get(k).getNum() == userInput){
					  			villas.get(k).RentalItemm(userInput2);					    	
					   		}
					   	}
			    }
			    else
			    	return;
			    }   
}
		 
			

