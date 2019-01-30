package miscellaneous;
/** QuickCheck 12
   @author Name: John A Chrin
   @version 1.0
   Date: 2015/03/10
   <p>
   Purpose: Chap 5., #1 (p.316)
      This program will ask the user
      to type in a string and a 
      string position. It will output
      the character at that string
      position.
   </p>
*/
import java.util.Scanner;

public class MethodTest
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      //prompt the user for a string.
      System.out.println("Please type in a string ");
      //read in string that user types in.
      String s = keyboard.nextLine();
      
      //prompt the user to type in a character position.
      System.out.println("Please type in a position ");
      //read in char position.
      int pos = keyboard.nextInt();
      
      //call showChar() method
      showChar (s,pos);
   }
   
   /**
      This method will input a string and a
      position within that string. It will
      output on screen the character at that
      position.
      @param   s  the string that was read in
      @param   pos   the character position
      @return NOTHING IS RETURNED
   */
   public static void showChar(String s, int pos)
   {
      char chAtPos = s.charAt (pos);
      System.out.println("Character at position " + pos +
                         " is " + chAtPos);
   }
}
