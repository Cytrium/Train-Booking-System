import java.util.Scanner;

   public class Date 
   {
       private int day;
       private int month;
       private int year;
   
       public String toString()
       {
           return String.format("%d / %d / %d",day,month,year);
       }
       
       //normal constructor
       Date(int day, int month, int year)
       {
           this.day = day;
           this.month = month;
           this.year = year;
       }
   
       //accessor
       int getDay()
       {
           return day;
       }
       
       int getMonth()
       {
           return month;
       }
       
       int getYear()
       {
           return year;
       }
       
   }