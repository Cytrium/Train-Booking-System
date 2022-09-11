public class Booking {
   
   private String origin;
   private String destination;
   private Date date;//composite object
   
   Booking(String or, String d, Date date) {
      origin = or;
      destination = d;
      this.date = date;
   }
   
   Booking(Booking a) {
      origin = a.origin;
      destination = a.destination;
      date = a.date;
   }
   
   double calcPrice() {
      double price = 0;
      
      if(origin.equalsIgnoreCase("Arau")) {  //initial price for arau origin
         if(destination.equalsIgnoreCase("Ipoh"))
            price = 15.0;
         else if(destination.equalsIgnoreCase("KL"))
            price = 20.0;
         else if(destination.equalsIgnoreCase("Muar"))
            price = 25.0;
         else System.out.println("error::destination does not exist");
      }
      else if(origin.equalsIgnoreCase("Ipoh")) {   //initial price for ipoh origin
         if(destination.equalsIgnoreCase("Arau"))
            price = 15.0;
         else if(destination.equalsIgnoreCase("KL"))
            price = 15.0;
         else if(destination.equalsIgnoreCase("Muar"))
            price = 20.0;
         else System.out.println("error::destination does not exist");
      }
      else if(origin.equalsIgnoreCase("KL")) {   //initial price for kl sentral origin
         if(destination.equalsIgnoreCase("Ipoh"))
            price = 15.0;
         else if(destination.equalsIgnoreCase("Arau"))
            price = 20.0;
         else if(destination.equalsIgnoreCase("Muar"))
            price = 20.0;
         else System.out.println("error::destination does not exist");
      }
      else if(origin.equalsIgnoreCase("Muar")) {   //initial price for sungai petani origin
         if(destination.equalsIgnoreCase("Ipoh"))
            price = 20.0;
         else if(destination.equalsIgnoreCase("KL"))
            price = 20.0;
         else if(destination.equalsIgnoreCase("Arau"))
            price = 25.0;
         else System.out.println("error::destination does not exist");
      }
      else System.out.println("error::origin does not exist");
      
      return price;
   }
   
    double calcPrice(double totPrice, Ets ets) {
      //initial price + package price
      if(ets.getPack() == 'S' || ets.getPack() == 's')
         totPrice += 20.0;
      else if(ets.getPack() == 'G' || ets.getPack() == 'g')
         totPrice += 30.0;
      else if(ets.getPack() == 'P' || ets.getPack() == 'P')
         totPrice += 50.0;
      else
         System.out.println("error::invalid package");
      
      return totPrice;
   }
   
//    boolean seatAvailable(Coach c) {
//       
//    }
   
  public String toString() {
      return ( origin + " - " + destination + "                                                 |" +
              "\n\t|______________________________________________________________________________|" +
              "\n\t|\tDepart: " + date.toString() + "                                                           |");
   }
}