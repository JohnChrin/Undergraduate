package arrayEducation;
/* Program - Client Processing One Row of a Two-Dimensional Array
Name: John A Chrin
*/

import java.util.Scanner;
import java.text.NumberFormat;

public class SumARowFamilyCellBills
{
  public static void main( String args[] )
  {
  //DECLARE and INITIALIZE the array
  double [][] familyCellBills = { {45.24, 54.67, 32.55, 25.61},
                                  {65.29, 49.75, 32.08, 26.11},
                                  {75.24, 54.53, 34.55, 28.16} };
                                  
  String [] months = { "July", "August", "September" };
  for( int i = 0; i < months.length; i++ )
   System.out.println( "Month " + i + " : " + months[i] );
   
  
  //DECLARE VARIABLES
  Scanner scan = new Scanner( System.in );
  int currentMonth;
 
  do
   {
      System.out.print( "Enter a month number between 0 and 2 > " );
      currentMonth = scan.nextInt( );
   }  while ( currentMonth < 0 || currentMonth > 2 );
   
   double monthlyFamilyBills = 0.0;
   for ( int j = 0; j < familyCellBills[currentMonth].length; j++ )
   {
      //add current family member bill to total
      monthlyFamilyBills += familyCellBills[currentMonth][j];
   }
   
   NumberFormat priceFormat = NumberFormat.getCurrencyInstance( );
   System.out.println( "\nThe total family cell bills during "
                     + months[currentMonth] + " is "
                     + priceFormat.format( monthlyFamilyBills ) );
   
  }
}