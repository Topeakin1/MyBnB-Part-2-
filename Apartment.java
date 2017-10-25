//this is my apartment subclass and it inherits the property superclass

public class Apartment extends Property { 
	   private int StoreyNum;
	   private int Beds; 

	       public Apartment(int num,String name, String address, int cost,int TotalRentDays, int StoreyNum, int Beds) { //constructor
	    	   super(num, name, address, cost, TotalRentDays); //accessing constructor from superclass
	    	   this.StoreyNum=  StoreyNum;
	    	   this.Beds = Beds;
	       }

		//setter
		   public void setStoreyNum(int input) {
			   if(StoreyNum>0) { //cant have minus stories 
				   this.StoreyNum= input; 
			   }
		   }
		   
		   //getter
		   public int getStoreyNum() {
			   return StoreyNum;
		   }
		   
		   //setter
		   public void setBeds (int input1) {
			   if(Beds>0) { //cant have minus number of beds
				   this.Beds = input1;
			   }
		   }
		   
		   //getter
		   public int getBeds() {
			   return Beds;
		   }
		   
		   //print apartment method
		   public void printApartment() {
			   printDetails(); //adding to the printDetails method from property
			   System.out.println("There are "+StoreyNum+" stories in the apartment");
			   System.out.println("There are "+Beds+" beds in the apartment ");
			   System.out.println("The apartment was rented for "+TotalRentDays+" day(s)");
		   }
		   	
}
