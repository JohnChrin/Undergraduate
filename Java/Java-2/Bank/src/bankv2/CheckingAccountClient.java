package bankv2;
/* CheckingAccount Client, version 2
Name: John A Chrin
*/

public class CheckingAccountClient {
    public static void main(String[] args) {
	// use default constructor
	CheckingAccount c1 = new CheckingAccount();
	System.out.println("New checking account: " + c1 + "\n");

	// use overloaded constructor
	CheckingAccount c2 = new CheckingAccount(100.00);
	System.out.println("New checking account: " + c2);
    }
}