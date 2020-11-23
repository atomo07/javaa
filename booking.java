import java.util.Scanner; 
import java.util.*;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;   
import discount.calcDiscount;         // prg 8 user-defined package

class InvalidException extends Exception //prg 9
{
    InvalidException(String s)
    { super(s);
    }

}

abstract class discount						// prg7 abstarct class and method																							
{
	abstract void offer();
}

interface busdetails{           // prg8 interface
  void name();
}

public class booking extends employee
{  
      List<Double> pricearray = new ArrayList<Double>();
      List<String> list=new ArrayList<String>(); 
      static double price;
      protected String driverName;
      Scanner console = new Scanner(System.in);

      booking(String username) {
        driverName = username;
      }

      public void bus() {
        int seat, quantity;
        char choice;
        int pl[] = { 800,1200,1500, 1700};
        String n[] = { "non AC", "non AC Sleeper", "AC", "AC Sleeper" };
        Scanner console = new Scanner(System.in);
        // try{
        do {
          // Get the value from the user.
          try {
            System.out.print("Enter 1 for non AC \n  ");
            System.out.print("Enter 2 for non AC sleeper \n");
            System.out.print("Enter 3 for AC \n ");
            System.out.print("Enter 4 for AC sleeper  \n");
            System.out.print("Enter busno: \n");
            seat = console.nextInt();
            System.out.println("Enter Quantity: \n");
            quantity = console.nextInt();
            double p = pl[seat];
            price = price + (quantity * p);
            list.add(n[seat]);
            pricearray.add(quantity * p);

          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index is Out of Bounds");
            System.exit(1);
          } // prg 9 Exception

          System.out.print("Add next seat?(Y for yes or N for no): ");
          choice = console.next().charAt(0);

        } while ((choice == 'y') || (choice == 'Y'));

      }

      private void details() {
        int Centrei = 710365;
        int CentreID = 156543;
      }

      void generatebill() {
        System.out.println("Bill Generates");
        System.out.println("--------------------------------------------");
        System.out.println("Ticket Booked                          Price(Rs)");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i) + "                                " + pricearray.get(i));
        }
        System.out.println("Total                              " + price);

      }

      final void offer() // Prg 7 abstract method definition along with final keyword
      {
        double discountpercentage = 12.0;
        calcDiscount dis = new calcDiscount(); // prg 8 package
        if (price >= 1500.00) {
          Double discountprice = dis.calculate(price, discountpercentage); // prg8 using method claculate from the
                                                                           // package
          Double discountamt = price - discountprice;
          System.out.println("discount availed                   " + discountpercentage + "%");
          System.out.println("Amount to pay                      " + discountamt);
        }

      }

      public void ordervalid(Double pay) throws InvalidException {   //prg 9
        if (pay == 0.0) {
          throw new InvalidException("Not valid !!");
        }

      }

      public static void main(String args[]) {
        Centre.Emp s1 = new Centre.Emp();
        employee eobj = new employee();
        Scanner sc = new Scanner(System.in);
        StringBuffer custname = new StringBuffer("Customer : "); // prg5 String Buffer object created
        eobj.name();
        Centre obj[] = new Centre[1];
        Centre.change();
        s1.show();

        obj[0] = new Centre(args[0], 230761); // command line argument(input from command line is taken in args[0])
                                              // (prg6)
        String st = args[0];
        boolean ans = empname.contains(st.toLowerCase()); // prg5 String Class method String.toLowerCase()
        if (ans) {

          obj[0].bus();
          try {                                  // prg9
            obj[0].ordervalid(price);
              } catch (Exception m){
           System.out.println(m);
           System.exit(1);}
        System.out.println("Customer : ");
        custname.append(sc.nextLine());          // prg5 append method for string buffer
    
        obj[0].display("UPI");
        obj[0].generatebill();
        obj[0].offer();                               // prg7 calling abstract method
      System.out.println(custname);                 // prg5 printing appended string buffer
     }
     else{System.out.println("No employee");}
     
       
}

}

class Centre extends booking{		       // Aggregation(Supermarket can still exist without this outlet)
static String Centrename = "MAVI TRAVELS";                       
static void change(){Centrename= "MAVI TRAVELS GHAZIABAD";}                 
static { System.out.println("     WELCOME    ");}            
int password;   					// declaring password in the class (prg6)                                            
Centre(String username, int password){
	super(username);                                // prg7 superkeyword
	this.password = password;			// this keyword (prg6)
}
Centre(String username, int password, int employeeID)       
{
	super(username);
	this.password= password;			// this keyword (prg6)
	int empID= employeeID;
}
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
LocalDateTime now = LocalDateTime.now();

void display(){System.out.println(driverName); 
System.out.println(dtf.format(now));}

void display(String mode)                                 
{
 System.out.println(Centrename+"\n"+ "Driver: " + driverName); 
 System.out.println(dtf.format(now));
 System.out.println("Paid by :     "+ mode);
}

static class Emp{                                           
    void show(){
     System.out.println("Welcome to MAVI TRAVELS.\nWe value your service. Have a good day!! ") ;
     System.out.println(" ");
               }
                }
}

class employee implements busdetails         //pr8 class employee implements interface storedetails  // prg 7 Composition class supermarket is dependant on employee. Supermarket cannot exist without employee
{
  static List<String> empname= new ArrayList<String>(3);
  public void name(){
  empname.add("aman");
  empname.add("CHIKU");
  empname.add("SUMAN");
     }

}











