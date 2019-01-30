package miscellaneous;
/* Chapter 3 Lab Example
   Name: John A Chrin
   Date: 2015/02/26
   Purpose: Chap 3., #1 (p.187)
      This program reads in a number
      and converts it to a roman
      numeral and prints it.
*/

import java.util.Scanner;

public class RomanNumerals
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      //PROMPT the user for a number
      System.out.println("Type in a number between 1-10 to convert ");
      int num = in.nextInt();
      //INPUT VALIDATION -- protect against stupid user
      while (num <= 0 || num > 10)
      {
         System.out.println("THAT IS NOT RIGHT! ");
         System.out.println("YOU NEED TO Type in a number between 1 and 10");
         num = in.nextInt();
      }
      //if (num == 1)
      //   System.out.println("Roman Numeral : I");
      //else if (num == 2)
      //   System.out.println("Roman Numbeal : II");
      switch (num)
         {
            case 1 :
               System.out.println("Roman Numeral : I");
               break;
            case 2 :
               System.out.println("Roman Numeral : II");
               break;
            case 3 :
               System.out.println("Roman Numeral : III");
               break;
            case 4 :
               System.out.println("Roman Numeral : IV");
               break;
            case 5 :
               System.out.println("Roman Numeral : V");
               break;
            case 6 :
               System.out.println("Roman Numeral : VI");
               break;
            case 7 :
               System.out.println("Roman Numeral : VII");
               break;
            case 8 :
               System.out.println("Roman Numeral : VIII");
               break;
            case 9 :
               System.out.println("Roman Numeral : IX");
               break;
            case 10 :
               System.out.println("Roman Numeral : X");
               break;
            default : 
         }
    }
}