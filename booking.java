import java.util.Scanner;
public class booking{
    String name;
	String bus;
	String phno;
	int bookid[]=new int[1];
	
	booking(String name,String bus,String phno,int b1)
	{
			this.name=name;
			this.phno=phno;
			this.bus=bus;
			bookid[0]=b1;
			
	}
	public void getbookid()
	{
		if(bookid[0]==1)
		{
			System.out.println("bus booked for interstate travel");
		}
		else
		{
			System.out.println("bus booked for intrastate travel");
		}
	}
	

public static void main(String args[])
	{
		String name;
		String bus;
		String phno;
		int b1,b2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name");
		name=sc.nextLine();
		System.out.println("Enter your route");
		bus=sc.nextLine();
		System.out.println("Enter your phno");
		phno=sc.nextLine();
		System.out.println("Enter 1 for interstate  && Enter 2 for intrastate");
		b1=sc.nextInt();
	
		booking br= new booking(name,bus,phno,b1);
		br.getbookid();

	}
}