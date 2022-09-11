import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {
   
   public static int randomNum() {
      int min = 1000000, max = 9000000;
      int rand = (int)(Math.random()*(max-min+1)+min);
      return rand;
   }
   
   public static String fileInput(int s) {
      String name1 = null, name2 = null;
      try
      {
         FileReader reader = new FileReader("trainData.txt");
         BufferedReader in = new BufferedReader(reader);
         String inData = null;
         while ((inData = in.readLine())!=null)
         {
            StringTokenizer st = new StringTokenizer(inData,"|");
            name1 = st.nextToken();
            name2 = st.nextToken();
         }
         in.close();
      } // end try
      catch(FileNotFoundException fnf) {
         System.out.println(fnf.getMessage());
      }
      catch(EOFException eof) {
         System.out.println(eof.getMessage());
      }
      catch(IOException io) {
         System.out.println(io.getMessage());
      }
      if(s == 1)
         return name1;
      else
         return name2;
   }
   
   public static void fileOutput(String fileName,Ticket []ticket,Train []train) {
      try
      {
         FileWriter file = new FileWriter(fileName + ".txt");
         PrintWriter out = new PrintWriter(file);
         for (int i = 0; i < ticket.length; i++)
         {
            if(train[i] instanceof Komuter) {
               out.println(ticket[i].toString());
            }
            else {
               Ets ets = (Ets)train[i];
               out.println(ticket[i].toString(ets));
            }
 
         } // end for
 
         // close the files to make sure that all output are written to the files
         out.close(); 
 
      }//end try 
      catch(FileNotFoundException fnf) {
       System.out.println(fnf.getMessage());
       }
      catch(EOFException eof) {
       System.out.println(eof.getMessage());
       }
       
       catch(IOException io) {
       System.out.println(io.getMessage());
       }
      catch(Exception nf) {
       System.out.println(nf.getMessage());
       }
   }
     
   public static void main(String [] args) {
      Scanner input = new Scanner(System.in);
      
      JTextField field1 = new JTextField();
      JTextField field2 = new JTextField();
      JTextField field3 = new JTextField();
      JTextField field4 = new JTextField();
        
      Object [] fields = {
          "Enter Name:", field1,
          "Enter ic no:", field2,
          "Enter phone no:", field3,
          "Enter age:", field4
      };
      
      Object [] fieldDate = {
          "Enter date [day/month/year]:\n",
          "Enter day:", field1,
          "Enter month:", field2,
          "Enter year:", field3
      };
        
      String[] station = {"ARAU","IPOH","KL","MUAR"};
      String[] pckgOption = {"SILVER","GOLD","PLATINUM"};
      String[] coachOption = {"Coach A","Coach B","Coach C","Coach D"};
      
      int choose = 0;
      String seat = null;
      while(choose != 2) {
         System.out.println("                 ___________________________________________");
         System.out.println("                |                                           |");
         System.out.println("                |  WELCOME TO CYTRIUM TRAIN BOOKING SYSTEM  |");
         System.out.println("                |___________________________________________|");
         System.out.println("                             1.BOOK TICKET");
         System.out.println("                             2.EXIT");
         System.out.print("                                \nChoose [1-2]: ");
         choose = input.nextInt();
         
         switch(choose) {
            case 1:
               System.out.print("Enter pax: ");
               int pax = input.nextInt();
               Passenger []passenger = new Passenger[pax];
               System.out.println("\nPassenger Menu");
               for(int i = 0; i < pax; i++){
                  JOptionPane.showConfirmDialog(null,fields,"Passenger Menu",JOptionPane.OK_CANCEL_OPTION);
                  passenger[i] = new Passenger(field1.getText(),field2.getText(),field3.getText(),Integer.parseInt(field4.getText()));
                  field1.setText("");
                  field2.setText("");
                  field3.setText("");
                  field4.setText("");
               }
               
               Booking []booking = new Booking[pax];
               System.out.println("\nBooking Menu");
               String o = (String)JOptionPane.showInputDialog(null, "Select Origin:",
                           "Booking Menu", JOptionPane.QUESTION_MESSAGE, null, station, station[0]);
               String dest = (String)JOptionPane.showInputDialog(null, "Select Destination:", 
                           "Booking Menu", JOptionPane.QUESTION_MESSAGE, null, station, station[3]);
               JOptionPane.showConfirmDialog(null,fieldDate,"Date",JOptionPane.OK_CANCEL_OPTION);
               int d = Integer.parseInt(field1.getText());
               int m = Integer.parseInt(field2.getText());
               int y = Integer.parseInt(field3.getText());
               booking[0] = new Booking(o, dest, new Date(d, m, y));
               for(int i = 1; i < pax; i++) {
                  booking[i] = new Booking(booking[0]); //copy constructor
               }
               field1.setText("");
               field2.setText("");
               field3.setText("");
               
               Train []train = new Train[pax];
               int select = 0;
               while(select != 1 && select != 2) {
                  System.out.println("1.Komuter\n2.ETS");
                  System.out.print("\nSelect train[1-2]: ");
                  select = input.nextInt();
                  if(select == 1){
                     for(int i = 0; i < pax; i++) {
                        train[i] = new Komuter(randomNum(),fileInput(select));
                     }
                  }
                  else if(select == 2) {
                     //pilih package & coach & seat
                     String p = (String)JOptionPane.showInputDialog(null, "Select Package:",
                              "Package Menu", JOptionPane.QUESTION_MESSAGE, null, pckgOption, pckgOption[0]);
                     String c = (String)JOptionPane.showInputDialog(null, "Select Coach:",
                              "Coach Menu", JOptionPane.QUESTION_MESSAGE, null, coachOption, coachOption[0]);
                     for(int i = 0; i < pax; i++) {
                        System.out.print("\n1A|1B   1C|1D" +
                                         "\n2A|2B   2C|2D" +
                                         "\n3A|3B   3C|3D" +
                                         "\n4A|4B   4C|4D" +
                                         "\n5A|5B   5C|5D\nSelect seat: ");
                        String s = input.next();
                        train[i] = new Ets(randomNum(),fileInput(select),p.charAt(0),c.charAt(6),s);
                     }
                  }
                  else {
                     System.out.println("error::wrong input");
                  }
               }
               
               if(train[0] instanceof Komuter) {
                  System.out.println("\nTicket price: RM" + (booking[0].calcPrice() * pax));
               }
               else {
                  Ets ets = (Ets)train[0];
                  System.out.println("\nTicket price: RM" + (booking[0].calcPrice(booking[0].calcPrice(),ets) * pax));
               }
               
               Ticket []ticket = new Ticket[pax];
               for(int i = 0; i < pax; i++) {
                  ticket[i] = new Ticket(passenger[i],booking[i]);
               }
               for(int i = 0; i < pax; i++) {
                  if(train[i] instanceof Komuter) {
                     System.out.println(ticket[i].toString());
                  }
                  else {
                     Ets ets = (Ets)train[i];
                     System.out.println(ticket[i].toString(ets));
                  }   
               }
               
               System.out.print("Do you want to save in local file?[y/n]: ");
               char choice = input.next().charAt(0);
               
               switch(choice) {
               case 'y':
                  String fileName = JOptionPane.showInputDialog("Enter file name:");
                  fileOutput(fileName,ticket,train);
                  break;
               case 'n':
                  System.out.println("Please enjoy your ride. :) uwu");
                  break;
               }
               break;
            case 2:
               System.out.println("Thank you for using our system. :) uwu");
               break;
         }  
      } 
   }
}