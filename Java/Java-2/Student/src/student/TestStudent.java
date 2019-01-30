package student;
/*Program - Client TestStudent
Name: John A Chrin
*/


public class TestStudent
{
   public static void main( String [] args )
   {
   Student Teddy = new Student( "Teddy Gram", "420-00-1337", 4.0 );
      System.out.println( Teddy.toString ( ) );
      
   Student Ricky = new Student( "Ricky Bobby", "555-55-5555", .1 );
      System.out.println( Ricky );
      
      Teddy.setName( "Teddy Slam" );
      Teddy.setSs( "420-00-1336" );
      Ricky.setGpa( .2 );
      
      System.out.println( "Teddy's last name was changed to " + Teddy.getName( ) );
      System.out.println( "Teddy's SS was changed to " + Teddy.getSs( ) );
      System.out.println( "Ricky's GPA was boosted " + Ricky.getGpa( ) );

   if ( Teddy.equals( Ricky ) )
         System.out.println ( "Teddy & Ricky are equal ");
   else 
         System.out.println ( "Teddy & Ricky are not equal ");
   
   }
}