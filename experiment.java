import java.util.*;

public class experiment
{   
    private Coach coach;
    private Passenger passenger;
    private Booking booking;
   
    void Ticket(Coach coach, Passenger passenger, Booking booking) {
        this.coach = coach;
        this.passenger = passenger;
        this.booking = booking;
   }
   
    public static void main(String[] args) //throw IOException
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Name : ");
        String name = input.nextLine();
    
        System.out.print("IC num : ");
        String icNo = input.nextLine();

        System.out.print("Phone Num : ");
        String phoneNo = input.nextLine();

        System.out.print("Age : ");
        int age = input.nextInt();
        input.nextLine();
        
        System.out.print("Origin : ");
        String ori = input.nextLine();
        
        System.out.print("Destination : ");
        String dest = input.nextLine();
        
        String origin = ori.toUpperCase();
        String destination = dest.toUpperCase();

        System.out.print("Day : ");
        int day = input.nextInt();
  
        System.out.print("Month : ");
        int month = input.nextInt();
  
        System.out.print("Year : ");
        int year = input.nextInt();
        
        System.out.println("\nSelect Package");
        System.out.println("S-Silver");
        System.out.println("G-Gold");
        System.out.println("P-Platinum");
        System.out.println("\nEnter the letter to choose[S/G/P]: ");
        char choosePck = input.next().charAt(0);

        
        Passenger passenger = new Passenger(name, icNo, phoneNo, age);
        Coach coach = new Coach(choosePck);
        Date date = new Date(day,month,year);
        Booking booking = new Booking(origin,destination,date);


        

    
        System.out.println("\t ______________________________________________________________________________");
        System.out.println("\t|                      " + booking.toString() + "                           ");
        System.out.println("\t|                                               " + coach.getPack() /*Platinum or Silver or Gold */ + "      |");
        System.out.println("\t|______________________________________________________________________________|");
        System.out.println("\t|                                                                              |");
        System.out.println("\t|   NAME OF PASSENGER                                                          |");
        System.out.println(passenger.toString());
        System.out.println("\t|______________________________________________________________________________|");
    
        
        // try
        // {
        //     FileWriter writer = new FileWriter("ticketReceipt.txt");
        //     PrintWriter out = new PrintWriter(writer);

        //     String name = null; float score, total = 0;
            
        //     out.println("\t\t ______________________________________________________________________________");
        //     out.println("\t\t|                      " + booking.toString() + "                             |");
        //     out.println("\t\t ______________________________________________________________________________");
        //     out.println("");
            

//             string nameturn;
	
// 	if (ticket_type < 2)
// {
// 	for (int i = 0 ; i <passenger_count ; i++ )
// 	{
// 	nameturn = name[i];	
		
// 	cout << "\t\t ______________________________________________________________________________" <<endl;
// 	cout << "\t\t| BOARDING PASS                                   | BOARDING PASS              |" <<endl;
// 	displaycategoryticket (ekonomi_count ,business_count ,firstclass_count );
// 	cout << "\t\t|_________________________________________________|____________________________|" <<endl;
// 	cout << "\t\t|                                                 |                            |" <<endl;
// 	cout << "\t\t|  NAME OF PASSENGER         FLIGHT       GATE    | NAME OF PASSANGER    GATE  |" <<endl;
// 	displaynameticket( nameturn , passenger_count);
// 	cout << "\t\t|  SEAT: "<< i + 20 << "C                 BOARDING TIME: 11.30 | BOARDING TIME: 11.30       |" <<endl;
// 	displayfromticket (from);
// 	displaygoticket (go);
// 	displaydateticket ( mon, day);
// 	cout << "\t\t|                                                 | SEAT: "<< i + 20 << "C   FLIGHT: ISL089 |" <<endl;
// 	cout << "\t\t|_________________________________________________|____________________________|" <<endl;
// 	}
// }


        //}

    //     catch (FileNotFoundException fnf)
    //   {
    //      System.out.println (fnf.getMessage());
    //   }
    //   catch (EOFException eof)
    //   {
    //      System.out.println (eof.getMessage());
    //   }
    //   catch (IOException io)
    //   {
    //      System.out.println (io.getMessage());
    //   }
    }
}