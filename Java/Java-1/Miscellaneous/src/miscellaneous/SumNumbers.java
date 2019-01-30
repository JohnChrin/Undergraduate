package miscellaneous;
/* Chapter 4 Lab Example, #1 (p.266)
   Name: John A Chrin
   Date: 2015/02/26
   Purpose: This program asks the user
   for a number and then sums up from
   1 to that number.
*/

import java.util.Scanner;

public class SumNumbers
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      //PROMPT the user to type in a number
      System.out.println("Type in a number greater than 0");
      int number = keyboard.nextInt();
      //INPUT VALIDATION -- protect against stupid user
      while (number <= 0)
      {
         System.out.println("WRONG!");
         System.out.println("Type a number greater than 0");
         number = keyboard.nextInt();
      }
      int sum = 0;
      //for (initialization; test; change)
      for(int i=1; i<=number; i++)
      {
         //sum = sum + i;
         sum += i;
         //This shows how much the i is
         System.out.println("i is " + i + " sum is " + sum);
         }
         System.out.println("SUM is " + sum);
      
   }  
}