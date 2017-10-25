/*This is my superclass it contains a constructor, my methods, mutators and accessors */

public class Property implements RentalItem{ //implements the interface
	
	    //variable declaration
	   private int num;
	   private String name;
	   private String address;
	   private int cost;
	   int TotalRentDays;

	    public Property(int num,String name, String address, int cost,int TotalRentDays) { //constructor (has to have same name as class)
	      setCost(cost); 
	      setName(name);
	      setNum(num);
	      setAddress( address);
	      setTotalRentDays(TotalRentDays);
	    }
        
	    //mutator
        public void setTotalRentDays(int TotalRentDays) {
        	this.TotalRentDays= TotalRentDays;
        }
        
        //accesor
        public int getTotalRentDays() {
        	return TotalRentDays;
        }

        // accessor
		public int getNum() {
			return num; 
		}

        //mutator
		public void setNum(int num) {
			this.num = num;
		}

        //accessor
		public String getAddress() {
			return address;
		}

        //mutator
		public void setAddress(String address) {
			if(address!=null) { //stops code from crashing address cant be null
				this.address = address;
			}
			
		}

        //accessor
		public String getName() {
			return name;
		}

        //mutator
		public void setName(String name) {
			this.name = name;
		}

        //cost accessor
		public int getCost() {
			return cost;
		}

        //cost mutator
		public void setCost(int cost) {
			if(cost>0) { //cost has to be positive
				this.cost = cost; //creating an instance of cost
			}	
		}
		
		public void RentalItemm(int Rentdays){
			TotalRentDays += Rentdays;
		}
		
		//print details method
		public void printDetails(){
			System.out.println("The register number is: "+num);
			System.out.println("The owners name is: "+name);
			System.out.println("The owners address is: "+address);
			System.out.println("The cost of the property is: "+cost+ " euro per day");
			
		} 
	}