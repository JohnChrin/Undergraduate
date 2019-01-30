/* CheckingAccount Client, version 4
Name: John A Chrin
*/
package bankv4;
public class CheckingAccountClient
{
   public static void main( String [] args )
   {
      CheckingAccount c4 = new CheckingAccount( 100.00, 7.50 );
      System.out.println( "New checking account:\n" + c4); 
   }
}