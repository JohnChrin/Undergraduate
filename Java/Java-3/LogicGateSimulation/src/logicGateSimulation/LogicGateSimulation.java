package logicGateSimulation;

/* 
   Name: John A Chrin
   Course: CSC242-01
   Date: 2018/03/26 Week #9
   Purpose: This program is designed to
   simulate logic gates.
*/

import java.lang.Math;

// Entire program inside of class.
public class LogicGateSimulation
{
	public static void main(String[] args)
	{
		int[][] truthTable = constructTable();
		for (int i = 0; i < 8; i++)
		{
			for (int j = 3; j < 7; j++)
			{
				// A = (x) AND (z)
				if (j == 3)
				{
					if (truthTable[i][0] == 1 && truthTable[i][2] == 1)
					{
						truthTable[i][j] = 1;
					} else
						truthTable[i][j] = 0;
				}
				// B = (A) XOR (NOT Y)
				if (j == 4)
				{
					if ((truthTable[i][j - 1] == 1 && truthTable[i][1] == 1)
							|| (truthTable[i][j - 1] == 0 && truthTable[i][1] == 0))
					{
						truthTable[i][j] = 1;
					} else
						truthTable[i][j] = 0;
				}
				// C = (B) XOR (NOT Y)
				if (j == 5)
				{
					if ((truthTable[i][j - 1] == 1 && truthTable[i][1] == 1)
							|| (truthTable[i][j - 1] == 0 && truthTable[i][1] == 0))
					{
						truthTable[i][j] = 1;
					} else
						truthTable[i][j] = 0;
				}
				// D = (C) OR (NOT X)
				if (j == 6)
				{
					if (truthTable[i][j - 1] == 1 || truthTable[i][0] == 0)
					{
						truthTable[i][j] = 1;
					} else
						truthTable[i][j] = 0;
				}
			}
		}
		printTable(truthTable);
	}
	// Table maker
	private static int[][] constructTable()
	{
		int n = 3;
		int q = n - 1;
		int rows = (int) Math.pow(2, n);
		int[][] variableTable = new int[8][7];
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				variableTable[i][j] = ((i / (int) Math.pow(2, q)) % 2);
				q--;
			}
			q = n - 1;
		}
		return variableTable;
	}

	private static void printTable(int[][] x)
	{
		System.out.println("x\ty\tz\tAnd A\tXor B\tXor C\tOr D");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				System.out.print(x[i][j] + "\t");
			}
			System.out.println();
		}
	}

}