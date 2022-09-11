public class Ticket {
   
   //private Train train;
   private Passenger passenger;
   private Booking booking;
   
   Ticket(Passenger passenger, Booking booking) {
      //this.train = train;
      this.passenger = passenger;
      this.booking = booking;
   }
   
   public int randomNum() {
      int min = 10000000, max = 90000000;
      int rand = (int)(Math.random()*(max-min+1)+min);
      return rand;
   }
   
   public String toString(Ets ets) {
      return (
      "\n\t ______________________________________________________________________________" +
      "\n\t|                  " + booking.toString() +
      "\n\t|                                               " + ets.displayPackage() + "\t\t\t\t\t\t       n|" +
      "\n\t|______________________________________________________________________________|" +
      "\n\t|                                                                              |" +
      "\n\t|   Ticket ID: " +  randomNum() +"                                                        |" +
      "\n\t|   NAME OF PASSENGER                                                          |" +
      passenger.toString(ets) +
      "\n\t|______________________________________________________________________________|");
   }   
   
   public String toString() {
      return (
      "\n\t ______________________________________________________________________________" +
      "\n\t|                  " + booking.toString() +
      "\n\t|                                                    " + "\t\t\t\t\t\t\t\t\t|" +
      "\n\t|______________________________________________________________________________|" +
      "\n\t|                                                                              |" +
      "\n\t|   Ticket ID: " +  randomNum() +"                                                        |" +
      "\n\t|   NAME OF PASSENGER                                                          |" +
      passenger.toString() +
      "\n\t|______________________________________________________________________________|");
   }
}
