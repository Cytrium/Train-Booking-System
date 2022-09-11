import java.util.*;
public class Seat {
   
   String seats[] = new String[100];
   
   Seat() {
      for(int i = 0; i<100;i++)
         seats[i] = null;
   }
   
   void displaySeatA() {
      for(int i = 0; i < 20; i++) { //rows
         for(int j = 0; j < 5; j++) { //columns
            if(j == 2) { //column 2,3,4 is for hallway
               System.out.print("   ");
               
            } else {
               System.out.print("|" + seats[i] + "|");
               i++;//
            }
         }
         i--;//
         System.out.println();
      }
   }
   
   void setSeatA() {// untuk coach A
      for(int i = 0; i < 20; i++)
         seats[i] = "001";
         
      for(int i = 0; i < 20; i++) {
         int x = Integer.parseInt(seats[i]);//tukar nilai seats jadi int sebab nak buat operasi tambah
         x++;
         int digits = String.valueOf(x).length();//check ada berapa digit dalam x
         String s = Integer.toString(x);//tukar seats jadi string balik untuk nak display
         if(digits == 1)
            seats[i+1] = "00" + s;//kalau digit 1 so dia akan ada '00' kat depan cth 001/002/003
         else
            seats[i+1] = "0" + s;
      }
   }
   
   void markSeat(String s) {//nak tukar seats jadi 'X'
      for(int i = 0; i < 20; i++){
         if(seats[i].equals(s)){ //kalau seats == s(no seat yg dah dipilih)
            seats[i] = " X ";
         }
      }
   }
   
   public static void main(String[]args) {
      Scanner input = new Scanner(System.in);
      Seat a = new Seat();
      a.setSeatA();
      char c = 'y';
      while(c == 'y') {
         a.displaySeatA();
         System.out.print("Select seat: ");
         String s = input.next();
         a.markSeat(s);
         
         System.out.println("continue?[y/n]");
         c = input.next().charAt(0);
      }
      
   }
   
}