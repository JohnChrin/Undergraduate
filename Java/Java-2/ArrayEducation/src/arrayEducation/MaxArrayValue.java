package arrayEducation;
/* Finding a maximum array value
Name: John A Chrin
*/

import java.text.NumberFormat;

public class MaxArrayValue
{
   public static void main( String [] args )
   {
   double [] cellBills = new double [6];
   cellBills[0] = 45.24;
   cellBills[1] = 54.67;
   cellBills[2] = 42.55;
   cellBills[3] = 44.61;
   cellBills[4] = 65.29;
   cellBills[5] = 49.75;
   
   int maxIndex = 0;    //initialize to index
   for ( int i = 1; i < cellBills.length; i++ )
      {
      if ( cellBills[i] > cellBills[maxIndex] )
         maxIndex = i; //save index of maximum value
      }
   
   NumberFormat priceFormat = NumberFormat.getCurrencyInstance( );
   System.out.println ( "The highest bill, "
                      + priceFormat.format( cellBills[maxIndex] )
                      + ", was found at index " + maxIndex );
   }
}