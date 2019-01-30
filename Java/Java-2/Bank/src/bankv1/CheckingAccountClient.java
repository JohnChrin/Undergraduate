package bankv1;
/* CheckingAccount Client, version 1
Name: John A Chrin
*/

public class CheckingAccountClient
{
	public static void main(String[] args)
	{
		CheckingAccount c1 = new CheckingAccount();
		System.out.println("New check account: " + c1);

		c1.deposit(1123242350.75);
		System.out.println("\nAfter depositing " + c1.lastDeposit + ": " + c1);

		c1.withdraw(22000000.25);
		System.out.println("\nAfter withdrawing " + c1.lastWithdraw + ": " + c1);
	}
}