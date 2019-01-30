package auto;
/* Program - Client AutoClientv4
Name: John A Chrin
*/

public class AutoClientv4
{
   public static void main( String [] args )
   {
      Auto suv = new Auto ( "Trailblazer", 7000, 437.5 );
      
      double mileage = suv.calculateMilesPerGallon( );
      System.out.println( "Mileage for suv is " + mileage );
   }
   
}