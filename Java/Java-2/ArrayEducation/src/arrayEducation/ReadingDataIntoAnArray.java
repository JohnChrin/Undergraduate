package arrayEducation;
/* Program - Client Reading Data Into An Array
Name: John A Chrin
*/

import java.util.Scanner;

public class ReadingDataIntoAnArray
{
   public static void main( String [] args )
   {
   Scanner scan = new Scanner( System.in );
   
   double [] cellBills = new double[6];
      for ( int i = 0; i < cellBills.length; i++ )
      {
      System.out.println( "Enter bill amount for month "
                        + ( i + 1 ) + "\t" );
      cellBills[i] = scan.nextDouble( ); //read current bill
      }
   }
}