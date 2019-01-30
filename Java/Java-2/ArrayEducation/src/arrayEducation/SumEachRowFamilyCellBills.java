package arrayEducation;
/* Program - Client Processing Each Row of a Two-Dimensional Array
Name: John A Chrin
*/

import java.util.*;
import java.text.*;

public class SumEachRowFamilyCellBills
{
   public static void main( String [] args )
   {
      //DECLARE and INITIALIZE the array
      double [][] familyCellBills = {  {45.24, 54.67, 32.55, 25.61},
                                       {65.29, 49.75, 32.08, 26.11},
                                       {75.24, 54.53, 34.55, 28.16} };
                                       
      String [] months = { "July", "August", "September" };
      
      NumberFormat priceFormat = NumberFormat.getCurrencyInstance( );
      double currentMonthTotal;
      for ( int i = 0; i < familyCellBills.length; i++ )
      {
         currentMonthTotal = 0.0;   // initialize total for row
         for ( int j = 0; j < familyCellBills[i].length; j++ )
         {
            //ADD current family member bill to current monthly total
            currentMonthTotal += familyCellBills[i][j];
         }
         
         //PRINT total for row
         System.out.println( "The total for " + months[i] + " is "
                           + priceFormat.format( currentMonthTotal ) );
      } 
   }
}