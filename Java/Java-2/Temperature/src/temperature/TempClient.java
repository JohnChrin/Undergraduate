package temperature;
/* Program - Client Temperatures
Name: John A Chrin
Purpose: Uses two-dimensional array to 
         STORES: 
                HIGHEST and LOWEST Temperatures
                for each MONTH of the YEAR. (12 * 2 = 24 temps)
   (THIS)OUTPUT:
                AVG High
                AVG Low
                HIGHEST for year
                LOWEST for year
*/

import java.util.*;
import java.text.NumberFormat;

public class TempClient
{
   public static void main( String [] args )
   {
      //WELCOME THE USER (Premier Weather Temperature System Extraordinair)
      System.out.println( "Welcome to the Premier Weather Temperature System Extraordinair" );
      
      Scanner scan = new Scanner( System.in );
      
      String [] month = { "January", 
                          "February", 
                          "March", 
                          "April", 
                          "May", 
                          "June", 
                          "July", 
                          "August", 
                          "September", 
                          "October", 
                          "November", 
                          "December" };
                          
      int [][] highLow = new int[12][2];
      
         for (int i = 0; i < highLow.length; i++)
         {
               System.out.print( "Enter the highest temp for " + (month[i]) + "\t" );
               
               for (int j = 0; j < 1; j++)
               {
                  highLow[i][j] = scan.nextInt( ); //User inputs HIGH TEMP                    
                  System.out.print( "Enter the lowest temp for " + (month[i]) + "\t");
                  highLow[i][(j + 1)] = scan.nextInt( ); //User inputs LOW TEMP
               }

         }
         
        //AVG HIGH TEMP
         double sum = 0;
         for (int i = 0; i < highLow.length; i++)
         {
         sum += highLow[i][0];
         }
         System.out.println("The Average high temp is " + (sum / highLow.length));
         
        //AVG LOW TEMP
         double bum = 0;
         for (int i = 0; i < highLow.length; i++)
         {
         bum += highLow[i][1];
         }
         System.out.println("The Average low temp is " + (sum / highLow.length));
         
        //HIGHEST TEMP
         int maxIndex = 0;
         for (int i = 1; i < highLow.length; i++)
            {
               if( highLow[i][0] > highLow[maxIndex][0])
               maxIndex = i;
            }
         System.out.println("The index number of the HIGHEST TEMP was " + maxIndex );
         
        //LOWEST TEMP 
         int minIndex = 0;
         for (int i = 1; i < highLow.length; i++)
            {
               if( highLow[i][1] < highLow[minIndex][1])
               minIndex = i;
               
            }
         System.out.println("The index number of the LOWEST TEMP was " + minIndex );
         
         
      //SCANNER input:
                  //ASK FOR HIGH (int)
                  //ASK FOR LOW (int)
                  //next MONTH
                  
                  //end
                  //OUTPUT all month temps in order
                  //OUTPUT AVG High
                  //OUTPUT AVG Low
                  //OUTPUT indexHIGHEST TEMP (index number + the actual #)
                  //OUTPUT indexLOWEST TEMP (index number + the actual #)
 
 
   }
}   