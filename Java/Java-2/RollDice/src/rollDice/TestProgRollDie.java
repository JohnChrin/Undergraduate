package rollDice;
/*Program - Client TestDie
Name: John A Chrin
*/

import java.util.*;

public class TestProgRollDie
{

   static Scanner console = new Scanner(System.in);
   
   public static void main(String[]args)
   {
      RollDie die1 = new RollDie();
      RollDie die2 = new RollDie();
      
      System.out.println("Line  9: die1: " + die1);
      System.out.println("Line 10: die2: " + die2);
      System.out.println("Line 11: After rolling "
                        + "die1: " + die1.roll());
      System.out.println("Line 12: After rolling "
                        + "die2: " + die2.roll());
      System.out.println("Line 13: Sum of the number "
                        + " rolled by the dice is: "
                        + (die1.getNum() + die2.getNum()));
      System.out.println("Line 14: After again rolling "
                        + "the sum of the numbers rolled is: "
                        + (die1.roll() + die2.roll()));
      
   }
}