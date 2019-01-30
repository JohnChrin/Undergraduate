package arrayEducation;
/*Program - CellBills Class
Name: John A Chrin
*/

public class CellBills
{
   public static void main( String [] args )
   {
   //DECLARE and instantiate the array elements
   double [] cellBills = new double [6];
   
   //ASSIGN values to array elements
   cellBills[0] = 45.24;
   cellBills[1] = 54.67;
   cellBills[2] = 42.55;
   cellBills[3] = 44.61;
   cellBills[4] = 65.29;
   cellBills[5] = 49.75;
   
   System.out.println( "The first monthly cell bill is "
                     + cellBills[0] );
   System.out.println( "The last monthly cell bill is "
                     + cellBills[cellBills.length - 1] );
   }
}