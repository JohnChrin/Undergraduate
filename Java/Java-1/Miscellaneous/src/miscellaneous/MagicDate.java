package miscellaneous;
/* Lab 3
   Name: John A Chrin
   Date: 2015/02/25
   Purpose: Asks the user to enter a
   month/day/year and if 
   (month * day) = year
   then the date is magic!
*/

import java.util.Scanner; //Needed for the Scanner Class

public class MagicDate {
    private int day;
    private int month;
    private int year;
    Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
	new MagicDate();
    }

    public MagicDate() {
	// Ask user for input
	System.out.print("Enter a month");
	month = (int) validInputChecker(userInput);

	// Ask user for input
	System.out.print("Enter a day");
	day = (int) validInputChecker(userInput);

	// Ask user for input
	System.out.print("Enter a 4 digit year (eg - 1987)");
	year = (int) validInputChecker(userInput);

	// check date and display output
	if (month * day == year)
	    System.out.println("The date is magic!");
	else
	    System.out.println("The date is not magic :(");
    }

    // This is a sweet tool I crafted to validate inputs done by the user.
    private double validInputChecker(Scanner userInput) {
	while (true) {
	    if (userInput.hasNextDouble()) {
		return userInput.nextDouble();
	    } else {
		userInput.next();
		System.out.println("Your input must be a digital number.");	// Will not stop until user enters the correct format.
	    }
	}
    }
}