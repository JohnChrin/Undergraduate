/* CheckingAccount class, version 2
Name: John A Chrin
*/
package bankv2;

import bank.BankAccount;

public class CheckingAccount extends BankAccount
{
   /** default constructor
   *   explicitly calls the BankAccount default constructor
   */
   
   public CheckingAccount( )
   {
      super( ); // optional, call BankAccount Constructor
      System.out.println( "In CheckingAccount " + "default constructor" );
   }
   
   /** overloaded constructor
   *   calls BankAccount overloaded constructor
   *   @param startBalance starting balance
   */
   public CheckingAccount( double startBalance )
   {
      super( startBalance ); // call BankAccount constructor
      System.out.println( "In CheckingAccount " + "overloaded constructor");
   }
}

