package auto;
/* Program - Client AutoClient
Name: John A Chrin
*/

public class AutoClientv2
{
   public static void main( String [] args )
   {
      Auto sedan = new Auto( );
      String sedanModel = sedan.getModel( );
      int sedanMiles = sedan.getMilesDriven( );
      double sedanGallons = sedan.getGallonsOfGas( );
      System.out.println( "sedan: model is " + sedanModel
                 + "\n miles driven is " + sedanMiles
                 + "\n gallons of gas is " + sedanGallons );
                 
      Auto suv = new Auto( "Trailblazer", 7000, 437.5 );
      String suvModel = suv.getModel( );
      int suvMiles = suv.getMilesDriven( );
      double suvGallons = suv.getGallonsOfGas( );
      System.out.println( "suv: model is " + suvModel
                  + "\n miles driven is " + suvMiles
                  + "\n gallons of gas is " + suvGallons );
   }
   
}