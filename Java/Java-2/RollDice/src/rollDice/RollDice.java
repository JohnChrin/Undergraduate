package rollDice;
/* Chapter 1
Name: John Chrin
Date: 2016/01/26
Purpose: Roll Dice

This program:Rolls a pair of dice.
*/

public class RollDice {
    // HEADER
    public static void main(String[] args) {
	System.out.println("The number of times the dice are " + "rolled to get the sum 10 = " + rollDice(10));
	System.out.println("The number of times the dice are " + "rolled to get the sum 6 = " + rollDice(6));

    }

    public static int rollDice(int num) {
	int die1;
	int die2;
	int sum;
	int rollCount = 0;

	do {
	    die1 = (int) (Math.random() * 6) + 1;
	    die2 = (int) (Math.random() * 6) + 1;
	    sum = die1 + die2;
	    rollCount++;
	} while (sum != num);

	return rollCount;
    }
}