package sudokuSolutionChecker;

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

// Entire program inside of class.
public class SudokuSolutionChecker
{
	// Initialize the Sudoku puzzle grid
	static int[][] sudokuArray = { 	{ 1, 8, 4, 9, 6, 3, 7, 2, 5 }, 
									{ 5, 6, 2, 7, 4, 8, 3, 1, 9 },
									{ 3, 9, 7, 5, 1, 2, 8, 6, 4 }, 
									{ 2, 3, 9, 6, 5, 7, 1, 4, 8 }, 
									{ 7, 5, 6, 1, 8, 4, 2, 9, 3 },
									{ 4, 1, 8, 2, 3, 9, 6, 5, 7 }, 
									{ 9, 4, 1, 3, 7, 6, 5, 8, 2 }, 
									{ 6, 2, 3, 8, 9, 5, 4, 7, 1 },
									{ 8, 7, 5, 4, 2, 1, 9, 3, 6 } };

	// Main body of program that executes all the code to solve the puzzle.
	public static void main(String[] args)
	{
		// 'if' statement is given an boolean that is incapable of being false, when
		// found true, print the Sudoku puzzle.
		if (solvePuzzle(sudokuArray))
		{
			printarray(sudokuArray);
			System.out.println("TRUE");
		} else
		{
			System.out.println("FALSE");
		}
	}

	// solvePuzzle finds out if puzzle is solvable or not. True = solvable.
	public static boolean solvePuzzle(int a[][])
	{
		//Index tracker
		for (int row = 0; row < 9; row++)
		{
			for (int col = 0; col < 9; col++)
			{
				// isSafe, checks rows, cols, and box grids
				if (!(isSafe(a, row, col)))
					return false;
			}
		}
		return true;
	}

	// Part of 'isSafe', finds if current number is already in row.
	public static boolean isInRow(int a[][], int row, int col)
	{
		int jdex = col;
		int z = a[row][col];
		for (int j = 0; j < a.length; j++)
		{
			if (j == jdex)
				continue;
			if(z == (a[row][j]))
				return true;
		}
		return false;
	}

	// Part of 'isSafe', finds if current number is already in column.
	public static boolean isInColumn(int a[][], int row, int col)
	{
		int idex = row;
		int z = a[row][col];
		for (int i = 0; i < a.length; i++)
		{
			// NEED TO FIX TO FIND INDICIES NOT VALUE AT INDICIES
			if (i == idex)
				continue;
			if (z == (a[i][col]))
				return true;
		}
		return false;
	}

	// Part of 'isSafe', finds if current number is already in 3x3 grid box.
	public static boolean isInBox(int a[][], int row, int col, int boxStartRow, int boxStartCol)
	{
		int idex = row;
		int jdex = col;
		int z = a[row][col];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
			{
				if (((i + boxStartRow) == (idex))&&((j + boxStartCol) == (jdex)))
					continue;
				if (z == ( a[i + boxStartRow][j + boxStartCol]))
					return true;
			}
		return false;
	}

	// Finds out if it is okay to put a particular number in the current position.
	public static boolean isSafe(int a[][], int row, int col)
	{
		return !isInRow(a, row, col) && !isInColumn(a, row, col) && !isInBox(a, row, col, row - row % 3, col - col % 3);

	}

	// Finds next blank location in array.
	public static boolean blankLocation(int a[][], int i[], int j[])
	{
		for (int p = 0; p < a.length; p++)
		{
			for (int q = 0; q < a[p].length; q++)
			{
				if (a[p][q] == 0 )
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