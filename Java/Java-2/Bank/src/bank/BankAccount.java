package bank;
/* Program - Class Bank
Name: John A Chrin
*/

import java.text.DecimalFormat;

public class BankAccount {
    public final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");

    private double balance;
    public String lastDeposit;
    public String lastWithdraw;

    /**
     * Default constructor sets balance to 0.0
     */
    public BankAccount() {
	balance = 0.0;
    }

    /**
     * Overloaded constructor
     * 
     * @param startBalance
     *            beginning balance
     */
    public BankAccount(double startBalance) {
	deposit(startBalance);
    }

    /**
     * Accessor for balance
     * 
     * @return current account balance
     */
    public double getBalance() {
	return balance;
    }

    /**
     * Deposit amount to account
     * 
     * @param amount
     *            amount to deposit; amount must be >= 0.0
     */
    public String deposit(double amount) {
	if (amount >= 0.0) {
	    balance += amount;
	    lastDeposit = MONEY.format(amount);
	} else
	    System.err.println("Deposit amount must be positive.");
	return MONEY.format(amount);
    }

    /**
     * withdraw amount from account
     * 
     * @param amount
     *            amount to withdraw; amount must be >= 0.0 amount must be <= balance
     */
    public void withdraw(double amount) {
	if (amount >= 0.0) {
	    balance -= amount;
	    lastWithdraw = MONEY.format(amount);
	} else
	    System.err.println("Withdraw amount must be positive.");
    }

    /**
     * toString
     * 
     * @return the balance formatted as money
     */
    public String toString() {
	return ("balance is " + MONEY.format(balance));
    }
}