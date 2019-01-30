package digitalClockPrint;

/* 
   Name: John A Chrin
   Course: CSC240-03
   Date: 2018/03/08
   Purpose: This program displays today's
   calendar information in addition to 
   the current time.
*/

import java.util.Date;
import java.util.Scanner;

// Entire program inside of class.
public class DigitalClockPrint
{
	public static void main(String args[])
	{
		// Instantiate a Date object
		Date currenttime = new Date();
		// display time and date
		String str = String.format("%tc", currenttime);
		System.out.println(str);
		// captures and splits current time into individual elements
		String[] timeSplit = str.split("(?!^)");
		String[] timeDigital = { timeSplit[11], timeSplit[12], timeSplit[13], timeSplit[14], timeSplit[15] };
		// prints digital time
		printTime(timeDigital);
	}
	// Prints digital clock type picture from current time.
	public static void printTime(String[] x)
	{
		// Create picture storing arrays
		String[][] a = new String[7][5];
		String[][] b = new String[7][5];
		String[][] c = new String[7][5];
		String[][] d = new String[7][5];
		String[][] e = new String[7][5];
		String[][][] arrays = new String[5][][];
		arrays[0] = a;
		arrays[1] = b;
		arrays[2] = c;
		arrays[3] = d;
		arrays[4] = e;

		// Generate all possible digital pictures
		String[][] colon = new String[7][5];
		colon[0][0] = " ";
		colon[0][1] = " ";
		colon[0][2] = " ";
		colon[0][3] = " ";
		colon[0][4] = " ";
		colon[1][0] = " ";
		colon[1][1] = " ";
		colon[1][2] = "-";
		colon[1][3] = " ";
		colon[1][4] = " ";
		colon[2][0] = " ";
		colon[2][1] = "|";
		colon[2][2] = " ";
		colon[2][3] = "|";
		colon[2][4] = " ";
		colon[3][0] = " ";
		colon[3][1] = " ";
		colon[3][2] = "-";
		colon[3][3] = " ";
		colon[3][4] = " ";
		colon[4][0] = " ";
		colon[4][1] = " ";
		colon[4][2] = "-";
		colon[4][3] = " ";
		colon[4][4] = " ";
		colon[5][0] = " ";
		colon[5][1] = "|";
		colon[5][2] = " ";
		colon[5][3] = "|";
		colon[5][4] = " ";
		colon[6][0] = " ";
		colon[6][1] = " ";
		colon[6][2] = "-";
		colon[6][3] = " ";
		colon[6][4] = " ";
		String[][] zero = new String[7][5];
		zero[0][0] = " ";
		zero[0][1] = " ";
		zero[0][2] = "-";
		zero[0][3] = "-";
		zero[0][4] = " ";
		zero[1][0] = " ";
		zero[1][1] = "|";
		zero[1][2] = " ";
		zero[1][3] = " ";
		zero[1][4] = "|";
		zero[2][0] = " ";
		zero[2][1] = "|";
		zero[2][2] = " ";
		zero[2][3] = " ";
		zero[2][4] = "|";
		zero[3][0] = " ";
		zero[3][1] = " ";
		zero[3][2] = " ";
		zero[3][3] = " ";
		zero[3][4] = " ";
		zero[4][0] = " ";
		zero[4][1] = "|";
		zero[4][2] = " ";
		zero[4][3] = " ";
		zero[4][4] = "|";
		zero[5][0] = " ";
		zero[5][1] = "|";
		zero[5][2] = " ";
		zero[5][3] = " ";
		zero[5][4] = "|";
		zero[6][0] = " ";
		zero[6][1] = " ";
		zero[6][2] = "-";
		zero[6][3] = "-";
		zero[6][4] = " ";
		String[][] one = new String[7][5];
		one[0][0] = " ";
		one[0][1] = " ";
		one[0][2] = " ";
		one[0][3] = " ";
		one[0][4] = " ";
		one[1][0] = " ";
		one[1][1] = " ";
		one[1][2] = " ";
		one[1][3] = "|";
		one[1][4] = " ";
		one[2][0] = " ";
		one[2][1] = " ";
		one[2][2] = " ";
		one[2][3] = "|";
		one[2][4] = " ";
		one[3][0] = " ";
		one[3][1] = " ";
		one[3][2] = " ";
		one[3][3] = " ";
		one[3][4] = " ";
		one[4][0] = " ";
		one[4][1] = " ";
		one[4][2] = " ";
		one[4][3] = "|";
		one[4][4] = " ";
		one[5][0] = " ";
		one[5][1] = " ";
		one[5][2] = " ";
		one[5][3] = "|";
		one[5][4] = " ";
		one[6][0] = " ";
		one[6][1] = " ";
		one[6][2] = " ";
		one[6][3] = " ";
		one[6][4] = " ";
		String[][] two = new String[7][5];
		two[0][0] = " ";
		two[0][1] = " ";
		two[0][2] = "-";
		two[0][3] = "-";
		two[0][4] = " ";
		two[1][0] = " ";
		two[1][1] = " ";
		two[1][2] = " ";
		two[1][3] = " ";
		two[1][4] = "|";
		two[2][0] = " ";
		two[2][1] = " ";
		two[2][2] = " ";
		two[2][3] = " ";
		two[2][4] = "|";
		two[3][0] = " ";
		two[3][1] = " ";
		two[3][2] = "-";
		two[3][3] = "-";
		two[3][4] = " ";
		two[4][0] = " ";
		two[4][1] = "|";
		two[4][2] = " ";
		two[4][3] = " ";
		two[4][4] = " ";
		two[5][0] = " ";
		two[5][1] = "|";
		two[5][2] = " ";
		two[5][3] = " ";
		two[5][4] = " ";
		two[6][0] = " ";
		two[6][1] = " ";
		two[6][2] = "-";
		two[6][3] = "-";
		two[6][4] = " ";
		String[][] three = new String[7][5];
		three[0][0] = " ";
		three[0][1] = " ";
		three[0][2] = "-";
		three[0][3] = "-";
		three[0][4] = " ";
		three[1][0] = " ";
		three[1][1] = " ";
		three[1][2] = " ";
		three[1][3] = " ";
		three[1][4] = "|";
		three[2][0] = " ";
		three[2][1] = " ";
		three[2][2] = " ";
		three[2][3] = " ";
		three[2][4] = "|";
		three[3][0] = " ";
		three[3][1] = " ";
		three[3][2] = "-";
		three[3][3] = "-";
		three[3][4] = " ";
		three[4][0] = " ";
		three[4][1] = " ";
		three[4][2] = " ";
		three[4][3] = " ";
		three[4][4] = "|";
		three[5][0] = " ";
		three[5][1] = " ";
		three[5][2] = " ";
		three[5][3] = " ";
		three[5][4] = "|";
		three[6][0] = " ";
		three[6][1] = " ";
		three[6][2] = "-";
		three[6][3] = "-";
		three[6][4] = " ";
		String[][] four = new String[7][5];
		four[0][0] = " ";
		four[0][1] = " ";
		four[0][2] = " ";
		four[0][3] = " ";
		four[0][4] = " ";
		four[1][0] = " ";
		four[1][1] = "|";
		four[1][2] = " ";
		four[1][3] = " ";
		four[1][4] = "|";
		four[2][0] = " ";
		four[2][1] = "|";
		four[2][2] = " ";
		four[2][3] = " ";
		four[2][4] = "|";
		four[3][0] = " ";
		four[3][1] = " ";
		four[3][2] = "-";
		four[3][3] = "-";
		four[3][4] = " ";
		four[4][0] = " ";
		four[4][1] = " ";
		four[4][2] = " ";
		four[4][3] = " ";
		four[4][4] = "|";
		four[5][0] = " ";
		four[5][1] = " ";
		four[5][2] = " ";
		four[5][3] = " ";
		four[5][4] = "|";
		four[6][0] = " ";
		four[6][1] = " ";
		four[6][2] = " ";
		four[6][3] = " ";
		four[6][4] = " ";
		String[][] five = new String[7][5];
		five[0][0] = " ";
		five[0][1] = " ";
		five[0][2] = "-";
		five[0][3] = "-";
		five[0][4] = " ";
		five[1][0] = " ";
		five[1][1] = "|";
		five[1][2] = " ";
		five[1][3] = " ";
		five[1][4] = " ";
		five[2][0] = " ";
		five[2][1] = "|";
		five[2][2] = " ";
		five[2][3] = " ";
		five[2][4] = " ";
		five[3][0] = " ";
		five[3][1] = " ";
		five[3][2] = "-";
		five[3][3] = "-";
		five[3][4] = " ";
		five[4][0] = " ";
		five[4][1] = " ";
		five[4][2] = " ";
		five[4][3] = " ";
		five[4][4] = "|";
		five[5][0] = " ";
		five[5][1] = " ";
		five[5][2] = " ";
		five[5][3] = " ";
		five[5][4] = "|";
		five[6][0] = " ";
		five[6][1] = " ";
		five[6][2] = "-";
		five[6][3] = "-";
		five[6][4] = " ";
		String[][] six = new String[7][5];
		six[0][0] = " ";
		six[0][1] = " ";
		six[0][2] = "-";
		six[0][3] = "-";
		six[0][4] = " ";
		six[1][0] = " ";
		six[1][1] = "|";
		six[1][2] = " ";
		six[1][3] = " ";
		six[1][4] = " ";
		six[2][0] = " ";
		six[2][1] = "|";
		six[2][2] = " ";
		six[2][3] = " ";
		six[2][4] = " ";
		six[3][0] = " ";
		six[3][1] = " ";
		six[3][2] = "-";
		six[3][3] = "-";
		six[3][4] = " ";
		six[4][0] = " ";
		six[4][1] = "|";
		six[4][2] = " ";
		six[4][3] = " ";
		six[4][4] = "|";
		six[5][0] = " ";
		six[5][1] = "|";
		six[5][2] = " ";
		six[5][3] = " ";
		six[5][4] = "|";
		six[6][0] = " ";
		six[6][1] = " ";
		six[6][2] = "-";
		six[6][3] = "-";
		six[6][4] = " ";
		String[][] seven = new String[7][5];
		seven[0][0] = " ";
		seven[0][1] = " ";
		seven[0][2] = "-";
		seven[0][3] = "-";
		seven[0][4] = " ";
		seven[1][0] = " ";
		seven[1][1] = " ";
		seven[1][2] = " ";
		seven[1][3] = " ";
		seven[1][4] = "|";
		seven[2][0] = " ";
		seven[2][1] = " ";
		seven[2][2] = " ";
		seven[2][3] = " ";
		seven[2][4] = "|";
		seven[3][0] = " ";
		seven[3][1] = " ";
		seven[3][2] = " ";
		seven[3][3] = " ";
		seven[3][4] = " ";
		seven[4][0] = " ";
		seven[4][1] = " ";
		seven[4][2] = " ";
		seven[4][3] = " ";
		seven[4][4] = "|";
		seven[5][0] = " ";
		seven[5][1] = " ";
		seven[5][2] = " ";
		seven[5][3] = " ";
		seven[5][4] = "|";
		seven[6][0] = " ";
		seven[6][1] = " ";
		seven[6][2] = " ";
		seven[6][3] = " ";
		seven[6][4] = " ";
		String[][] eight = new String[7][5];
		eight[0][0] = " ";
		eight[0][1] = " ";
		eight[0][2] = "-";
		eight[0][3] = "-";
		eight[0][4] = " ";
		eight[1][0] = " ";
		eight[1][1] = "|";
		eight[1][2] = " ";
		eight[1][3] = " ";
		eight[1][4] = "|";
		eight[2][0] = " ";
		eight[2][1] = "|";
		eight[2][2] = " ";
		eight[2][3] = " ";
		eight[2][4] = "|";
		eight[3][0] = " ";
		eight[3][1] = " ";
		eight[3][2] = "-";
		eight[3][3] = "-";
		eight[3][4] = " ";
		eight[4][0] = " ";
		eight[4][1] = "|";
		eight[4][2] = " ";
		eight[4][3] = " ";
		eight[4][4] = "|";
		eight[5][0] = " ";
		eight[5][1] = "|";
		eight[5][2] = " ";
		eight[5][3] = " ";
		eight[5][4] = "|";
		eight[6][0] = " ";
		eight[6][1] = " ";
		eight[6][2] = "-";
		eight[6][3] = "-";
		eight[6][4] = " ";
		String[][] nine = new String[7][5];
		nine[0][0] = " ";
		nine[0][1] = " ";
		nine[0][2] = "-";
		nine[0][3] = "-";
		nine[0][4] = " ";
		nine[1][0] = " ";
		nine[1][1] = "|";
		nine[1][2] = " ";
		nine[1][3] = " ";
		nine[1][4] = "|";
		nine[2][0] = " ";
		nine[2][1] = "|";
		nine[2][2] = " ";
		nine[2][3] = " ";
		nine[2][4] = "|";
		nine[3][0] = " ";
		nine[3][1] = " ";
		nine[3][2] = "-";
		nine[3][3] = "-";
		nine[3][4] = " ";
		nine[4][0] = " ";
		nine[4][1] = " ";
		nine[4][2] = " ";
		nine[4][3] = " ";
		nine[4][4] = "|";
		nine[5][0] = " ";
		nine[5][1] = " ";
		nine[5][2] = " ";
		nine[5][3] = " ";
		nine[5][4] = "|";
		nine[6][0] = " ";
		nine[6][1] = " ";
		nine[6][2] = "-";
		nine[6][3] = "-";
		nine[6][4] = " ";

		// Assign a picture to each array
		for (int i = 0; i < 5; i++)
		{
			if (x[i].equals(":"))
			{
				arrays[i] = colon;
			} else if (x[i].equals("0"))
			{
				arrays[i] = zero;
			} else if (x[i].equals("1"))
			{
				arrays[i] = one;
			} else if (x[i].equals("2"))
			{
				arrays[i] = two;
			} else if (x[i].equals("3"))
			{
				arrays[i] = three;
			} else if (x[i].equals("4"))
			{
				arrays[i] = four;
			} else if (x[i].equals("5"))
			{
				arrays[i] = five;
			} else if (x[i].equals("6"))
			{
				arrays[i] = six;
			} else if (x[i].equals("7"))
			{
				arrays[i] = seven;
			} else if (x[i].equals("8"))
			{
				arrays[i] = eight;
			} else
			{
				arrays[i] = nine;
			}
		}

		// printing of each element by their respective row/column to get a full picture
		for (int row = 0; row < 7; row++)
		{
			for (int col = 0; col < 5; col++)
			{
				System.out.print(arrays[0][row][col]);
			}
			for (int col = 0; col < 5; col++)
			{
				System.out.print(arrays[1][row][col]);
			}
			for (int col = 0; col < 5; col++)
			{
				System.out.print(arrays[2][row][col]);
			}
			for (int col = 0; col < 5; col++)
			{
				System.out.print(arrays[3][row][col]);
			}
			for (int col = 0; col < 5; col++)
			{
				System.out.print(arrays[4][row][col]);
			}
			System.out.println();
		}

	}
}
