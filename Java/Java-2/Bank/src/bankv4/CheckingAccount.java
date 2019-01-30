/* CheckingAccount class, version 4
Name: John A Chrin

*/
package bankv4;
public class CheckingAccount extends bank.BankAccount
{
   public final double DEFAULT_FEE = 5.00;
   private double monthlyFee;
   
   /** default constructor
   *   explicitly calls the BankAccount default constructor
   *   set monthlyFee to default value
   */
   public CheckingAccount( )
   {
      super( ); //optional
      monthlyFee = DEFAULT_FEE;
   }
  
   /** overloaded constructor
   *   calls BankAccount overloaded constructor
   *   @param startBalance starting balance
   *   @param startMonthlyFee starting monthly fee
   */
   public CheckingAccount( double startBalance,
                           double startMonthlyFee )
   {
      super( startBalance ); // call BankAccount constructor
      setMonthlyFee( startMonthlyFee );
   }
   
   /** applyMonthlyFee method
   *   charges the monthly fee to the account
   */
   public void applyMonthlyFee( )
   {
      withdraw( monthlyFee );
   }
   
   /** accessor method for monthlyFee
   *   @return monthlyFee
   */
   public double getMonthlyFee( )
   {
      return monthlyFee;
   }
   
   /**mutator method for monthlyFee
   *  @param newMonthlyFee new value for monthlyFee
   */
   public void setMonthlyFee( double newMonthlyFee )
   {
      if ( monthlyFee >= 0.0 )
         monthlyFee = newMonthlyFee;
      else
         System.err.println( "Monthly fee cannot be negative" );
   }
   
   /* toString method
   *  @return String containing formatted balance and monthlyFee
   *  invokes superclass toString to format balance
   */
   public String toString( )
   {
      return super.toString( )
            + "; monthly fee is " + MONEY.format( monthlyFee );
   }
}