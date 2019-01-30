package convertDec2Binary;

/* 
   Name: John A Chrin
   Course: CSC242-01
   Date: 2018/01/31 Week #2
   Purpose: This program is designed to
   convert decimal notation to binary.
*/

import java.util.Scanner;
import java.lang.Math.*;

public class ConvertDec2Binary {
	static int integer;

	public static void main(String[] args) {
		// 1. Input

		// a. Allow user to input an integer from 0 -> 2,000,000.
		Scanner userinput = new Scanner(System.in);

		// b. Validate the input. If input is invalid, make them enter a value again.
		boolean validInput = false;
		while (!validInput) {
			try {
				System.out.println("Please input an integer from 0-2,000,000.");
				integer = Math.abs(Integer.parseInt(userinput.next()));
				validInput = true;
				System.out.println("Converting " + integer + " to Binary.");
			} catch (Exception e) {
				System.out.println("Input was not an integer, please input an integer.");
			}
		}
		userinput.close();
		// 2. Processing
		// a. Use the Division method for converting Decimal to Binary.

		convertBinary(integer);

		// 3. Output
		// a. At beginning of the program, display some kind of welcome message,
		// stating to the user what this program does.
		// b. When printing the results, display both the original decimal value
		// and the calculated binary value. Display the output in a nice format.

	}

	// i. This method is discussed in chapter 2 of the text.
	// b. Loop and divide the test number by 2. Loop until the quotient is zero.
	// c. Note: Remember remainders are given in reverse order (LSB first).
	public static void convertBinary(int num) {
		int binary[] = new int[40];
		int index = 0;
		// Creates entries into array of 1's & 0's AND reduces value of input.
		while (num > 0) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		// determine the number of bytes that need to be represented by our userInput.
		int numOfBits = 8;
		boolean done = false;
		while (!done) {
			if (integer <= Math.pow(2, numOfBits) - 1) {
				done = true;
			} else {
				numOfBits += 8;
			}
		}
		// print all of the zeroes of the highest bit so that every prints in a clean
		// 8bit + whitespace format.
		for (int i = 0; i < (8 - index % 8); i++) {
			System.out.print("0");
		}
		//System.out.print();
		// Outputs array as a string with spaces after every 8 elements .
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(binary[i]);
			if(i%8 == 0) {
				System.out.print(" ");
			}
		}
	}
}
