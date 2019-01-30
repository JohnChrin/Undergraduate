package sudokuSolutionGenerator;
/* 
   Name: John A Chrin
   Course: CSC240-03
   Date: 2018/02/14
   Purpose: This program is designed to
   create a two-dimensional 9x9 array of 
   integers and verifies whether or not 
   it is a solution to a particular 
   Sudoku puzzle.
*/

// 1.) Check each row, each column, and each 3x3 matrix.
// 2.) Do NOT check summation of each row.
// 3.) Initialize input into an array.

import java.util.Random;

// Entire program inside of class.
public class sudokuSolutionGenerator
{
// Initialize the Sudoku puzzle grid, with all tiles at 0, which is an invalid number.
	public static int[][] sudokuArray = new int[9][9];
	static Random rn = new Random();
	static int min = 1;
	static int max = 9;
	static int randomNum = rn.nextInt((max - min) + 1) + min;
// Main body of program that executes all the code to solve the puzzle.
	public static void main(String[] args)
	{
// 'if' statement is given an boolean that is incapable of being false, when found true, print the Sudoku puzzle.
		sudokuArray[randomNum][randomNum] = randomNum;
		if(solvePuzzle(sudokuArray) == true)
			printarray(sudokuArray);

	}
// solvePuzzle is searching for a multi-dimensional array input.
// Fills in all elements in array until legal solution is found.
	public static boolean solvePuzzle(int a[][])
	{
// Initialize pass by reference arrays to function as pass by reference ints.
		int[] i = {0};
		int[] j = {0};
// 'if' the puzzle can find zero blank locations, solvePuzzle is complete.
		if(!blankLocation(a, i, j))
			return true;
// Recursive for loop, finds legal/safe places to place a number, moves forward.
// 'if' it cannot find a legal/safe variable to place, it goes back one element.
		for (int q = 1; q < 10; q++)
		{
			if(isSafe(a, q, i, j))
			{
				a[i[0]][j[0]]=q;
				
				if(solvePuzzle(a))
					return true;
				
				a[i[0]][j[0]]= 0;
			}
		}
		return false;
	}

// Part of 'isSafe', finds if current number is already in row.
	public static boolean isInRow(int a[][], int z, int i[])
	{
		int p = i[0];
		for (int j = 0; j < a.length; j++)
		{
			if (z == a[p][j])
				return true;
		}
		return false;
	}
// Part of 'isSafe', finds if current number is already in column.
	public static boolean isInColumn(int a[][], int z, int j[])
	{
		int p = j[0];
		for (int i = 0; i < a.length; i++)
		{
			if (z == a[i][p])
				return true;
		}
		return false;
	}
// Part of 'isSafe', finds if current number is already in 3x3 grid box.
	public static boolean isInBox(int a[][], int z, int boxStartRow, int boxStartCol)
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
			{
				if (z == a[i + boxStartRow][j + boxStartCol])
					return true;
			}
		return false;
	}
// Finds out if it is okay to put a particular number in the current position.
	public static boolean isSafe(int a[][], int z, int i[], int j[])
	{
		return !isInRow(a, z, i) && !isInColumn(a, z, j) && !isInBox(a, z, i[0] - i[0] % 3, j[0] - j[0] % 3);

	}
// Finds next blank location in array.
	public static boolean blankLocation(int a[][], int i[],int j[])
	{
		for (int p = 0; p < a.length; p++)
		{
			for (int q = 0; q < a[p].length; q++)
			{
				if (a[p][q] == 0)
				{
					i[0] = p;
					j[0] = q;
					return true;

				}

			}
		}
		return false;
	}
// Prints array.
	public static void printarray(int a[][])
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}