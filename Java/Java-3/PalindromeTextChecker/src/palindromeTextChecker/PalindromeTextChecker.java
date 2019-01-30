package palindromeTextChecker;

/* 
   Name: John A Chrin
   Course: CSC240-04
   Date: 2018/04/28
   Purpose: This program shows you a list
   of palindromes that exist in a given text file
   then organizes the original text file into an alphabetical list
   of words, finally outputs 2 new text files (1. a-m) & (2. n-z).
*/
// Grab ALL the tools, we'll figure out what we need later, bring the garage to us.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.IOException;

// Entire program inside of class.
public class PalindromeTextChecker
{
	public static void main(String args[]) throws Exception
	{
		// Read in the text file messages
		Scanner readTextFile = new Scanner(new File("palindromes.txt"));
		ArrayList<String> textFileWords = new ArrayList<String>();
		while (readTextFile.hasNext())
		{
			textFileWords.add(readTextFile.next());
		}
		readTextFile.close();

		// Convert everything to lower case.
		ListIterator<String> iterator = textFileWords.listIterator();
		while (iterator.hasNext())
		{
			iterator.set(iterator.next().toLowerCase());

		}
		// Removes periods.
		for (int i = 0; i < textFileWords.size(); i++)
		{
			String x;
			x = textFileWords.get(i).replace(".", "");
			textFileWords.set(i, x);
		}
		
		//Removes duplicates to minimize array.
		Set<String> removeDuplicates = new HashSet<>();
		removeDuplicates.addAll(textFileWords);
		textFileWords.clear();
		textFileWords.addAll(removeDuplicates);


		// Sorts parsed list into alphabetical order.
		String temp;
		for (int i = 0; i < textFileWords.size(); i++)
		{
			for (int j = i + 1; j < textFileWords.size(); j++)
			{
				if (textFileWords.get(i).compareTo(textFileWords.get(j)) > 0)
				{
					temp = textFileWords.get(i);
					textFileWords.set(i, textFileWords.get(j));
					textFileWords.set(j, temp);
				}
			}
		}

		// Ask for user to input a number to request a particular message.
		int messageNum = -1;
		while (messageNum < 0)
		{
			try
			{
				findPalin(textFileWords);
				output(textFileWords);
				messageNum +=1;
			} catch (InputMismatchException e)
			{
			}
		}

	}

	private static void findPalin(ArrayList<String> textFileWords)
	{
		for (int i = 0; i < textFileWords.size(); i++)
		{

			int left = 0;
			String word = textFileWords.get(i);
			int right = word.length() - 1;
			while (right >= left)
			{
				char templeft = word.charAt(left);
				char tempright = word.charAt(right);
				if(Character.isDigit(templeft) || Character.isDigit(tempright))
				{
					break;
				}
				if (word.charAt(left) != word.charAt(right))
				{
					break;
				}
				else
				{
					++left;
					--right;
				}
				if(right < left)
				{
					System.out.println(word);
					break;
				}

			}
			
		}

	}
	private static void output(ArrayList<String> textFileWords) throws IOException
	{
		ArrayList<String> output1 = new ArrayList<String>();
		ArrayList<String> output2 = new ArrayList<String>();
		
		//Creating 2 new arrayLists to store alphabetically separated list.
		for(int i = 0; i<textFileWords.size(); i++)
		{	
			//output1 a-m
			for (char alphabet = 'a'; alphabet <= 'm'; alphabet++)
			{
				String temp = String.valueOf(alphabet);
				if(textFileWords.get(i).startsWith(temp))
				{
					output1.add(textFileWords.get(i));
					break;
				}
			}
			//output2 n-z
			for (char alphabet = 'n'; alphabet <= 'z'; alphabet++)
			{
				String temp = String.valueOf(alphabet);
				if(textFileWords.get(i).startsWith(temp))
				{
					output2.add(textFileWords.get(i));
					break;
				}
			}

		}
		//Add-in words that start with numbers at the end of output2
		for(int i = 0; i<textFileWords.size(); i++)
		{
			char tempdigit = textFileWords.get(i).charAt(0);
			if(Character.isDigit(tempdigit))
			{
				output2.add(textFileWords.get(i));
			}
		}

		//Write a-m list into a textfile.
		FileWriter writer1 = new FileWriter("output1.txt"); 
		for(String str: output1) {
		  writer1.write(str + "\r\n");
		}
		writer1.close();
		//Write n-z + numbers list into a textfile.
		FileWriter writer2 = new FileWriter("output2.txt"); 
		for(String str: output2) {
		  writer2.write(str + "\r\n");
		}
		writer2.close();
	}
}