/* CheckingAccount Client, version 3
Name: John A Chrin
*/
package bankv3;
public class CheckingAccountClient
{
   public static void main( String [] args )
   {
      CheckingAccount c3 = new CheckingAccount( 100.00, 7.50 );
      System.out.println( "New checking account:\n"
                           + c3.toString( )
                           + "; monthly fee is "
                           + c3.getMonthlyFee( ) );
                           
      c3.applyMonthlyFee( ); // charge the fee to the account
      System.out.println( "\nAfter charging monthly fee:\n"
                           + c3.toString( )
                           + "; monthly fee is "
                           + c3.getMonthlyFee( ) );  
   }
}