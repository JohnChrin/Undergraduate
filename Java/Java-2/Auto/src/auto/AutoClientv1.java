package auto;
/* Program - Client AutoClient
Name: John A Chrin
*/

public class AutoClientv1
{
   public static void main( String [] args )
   {
      System.out.println( "Instantiate sedan" );
      Auto sedan = new Auto( );
   
      System.out.println( "\nInstantiate suv" );
      Auto suv = new Auto( "Trailblazer", 7000, 437.5 );
      
      System.out.println( "\nInstantiate mini" );
      // attempt to set invalid value for gallons of gas
      Auto mini = new Auto( "Mini Cooper", 200, -1.0 );
   }
   
}