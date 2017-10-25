//my house class is a subclass which inherits the property superclass 
public class House extends Property {
	//variable declaration
	  private int storeyNumber;
	  private int fees;
	  private int Beds;

	  
	  public House(int num,String name, String address, int cost,int TotalRentDays, int StoreyNum, int Beds,int storeyNumber, int fees) { //constructor
   	   super(num, name, address, cost,TotalRentDays); //accessing constructor from superclass
   	   this.storeyNumber= storeyNumber;
   	   this.fees= fees;
   	   this.Beds= Beds;
   	   
      }
	     //accessor
		 public void setStoreyNumber(int input5) {
			   this.storeyNumber= input5; 
		   }
		   
		 //mutator
		 public int getStoreyNumber() {
			   return storeyNumber;
		   }
		 
		 //accessor
		 public void setFees(int input6) {
			   this.fees= input6; 
		   }
		 
		 //mutator
		 public int getFees() {
			   return fees; 
		   }
		 
		 public void setBedss(int input7){
			 this.Beds= input7;
		 }
		 
		 public int getBedss() {
			 return Beds;
		 }
	
		 //print house method
		 public void printHouse() {
			 printDetails();//adding to the printDetails method from property
			   System.out.println("There are "+storeyNumber+" stories in the house");
			   System.out.println("There are "+Beds+" beds in the house ");
			   System.out.println("The house was rented for "+TotalRentDays+" day(s)");
			   System.out.println("The clearing fee is : "+fees+" euro");
		 }
		 
}
       
