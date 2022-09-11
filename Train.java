public abstract class Train {    //super
   
   private int trainID;
   private String trainName;
   
   Train() {
      trainID = 0;
      trainName = null;
   }
   
   Train(int id, String n) {
      trainID = id;
      trainName = n;
   }
   
   int getTrainID() {
      return trainID;
   }
   String getTrainName() {
      return trainName;
   }
   
   void setTrain(int id, String n) {
      trainID = id;
      trainName = n;
   }
   
   public String toString() {
      return ("\nTrain ID: " + trainID +
              "\nTrain name: " + trainName);
   }
}