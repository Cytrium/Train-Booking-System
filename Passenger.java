public class Passenger {
   
   private String name, icNo, phoneNo;
   private int age;
   
   
   Passenger(String name, String icNo, String phoneNo, int age) {
      this.name = name;
      this.icNo = icNo;
      this.phoneNo = phoneNo;
      this.age = age;
   }
   
   String getName() {
      return name;
   }
   String getIcNo() {
      return icNo;
   }
   String getPhoneNo() {
      return phoneNo;
   }
   
   public String toString(Ets ets) {
      return ("\n\t|   " + name + "\t\t\t Train Name:" + ets.getTrainName() + "\t\t\t\t\t\t\t\t\t\t |" +
              "\n\t|   Ic: " + icNo + "\t\t\t\t\t Coach: " + ets.getCoach() + "\t\t\t\t\t\t\t\t\t\t\t\t |" +
              "\n\t|   Phone no: " + phoneNo + "\t\t\t Seat no: " + ets.getSeatNo() + "\t\t\t\t\t\t\t\t\t\t\t |");
   }
   public String toString() {
      return ("\n\t|   " + name +  "\t\t\t\t\t\t\t\t\t\t\t\t\t\t             |" +
              "\n\t|   Ic: " + icNo + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |" +
              "\n\t|   Phone no: " + phoneNo + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t             |");
   }
}