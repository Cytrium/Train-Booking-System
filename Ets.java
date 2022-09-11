public class Ets extends Train {   //sub
   private char pack;
   private char coach;
   private String seat;
   
   Ets() {
      super();
      pack = ' ';
      coach = ' ';
      seat = null;
   }
   
   Ets(int id, String n, char p, char c, String s) {
      super(id,n);
      pack = p;
      coach = c;
      seat = s;
   }
   
   char getCoach() {
      return coach;
   }
   String getSeatNo() {
      return seat;
   }
   char getPack() {
      return pack;
   }
   
   String displayPackage(){
      String status = null;
      if (pack == 'P' || pack == 'p')
         status = "Platinum";
      else if (pack == 'G' || pack == 'g')
         status = "Gold    ";
      else if (pack == 'S' || pack == 's')
         status = "Silver  ";
      else 
         status = "Please enter the correct package.";
     
      return status;
   }
   
}