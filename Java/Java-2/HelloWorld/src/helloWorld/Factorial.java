package helloWorld;

/* Program - Class Factorial
Name: John A Chrin
*/
import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Factorial calculator, does not take negatives or letters, but rounds decimals.
public class Factorial
{
	// Formats the decimal to look like an integer for display.
	static NumberFormat formatter = new DecimalFormat("0");

	// Executes a loop to allow the user to enter as many factorial requests as needed.
	public static void main(String[] args) throws Exception
	{
		// Scan allows user input to be stored in the "input" String.
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("Welcome to the factorial calculator, you may exit at anytime by typing: EXIT");
		// This do-while loop is the execution of all conditions that decide whether or not your input is valid.
		do
		{
			System.out.println("Enter a number you wish to see the factorial of: ");
			input = scan.next();

			if (isDouble(input))
			{
				if (Double.valueOf(input) > 0)
				{
					System.out.println(formatter.format(factPrint(Double.valueOf(input))));
				} else
				{
					System.out.println("Factorial calculator does not handle negatives.");
				}
			} else if (input.equals("exit") || input.equals("EXIT"))
			{
				break;
			} else
			{
				System.out.println("Enter a positive number and no letters.");
			}
		} while (!input.equals("exit") || !input.equals("EXIT"));
		// After loop conclusion the system exits.
		System.out.println("Thank you for using the factorial calculator. Good-bye!");
		scan.close();
		System.exit(0);

	}
	// Checks if user input is able to be a double (number).
	public static boolean isDouble(String thing)
	{
		try
		{
			Double.parseDouble(thing);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}
	// Initiates the factorial recursion by submitting a preliminary statement to the user as feedback to their input.
	public static double factPrint(double num)
	{
		System.out.print("Factorial of " + formatter.format(num) + " = ");
		return fact(Math.round(num));

	}
	// Actual factorial math is done here.
	public static double fact(double num)
	{

		if (num == 0)
			return 1;
		else
			return num * fact(num - 1);
	}
}
