package miscellaneous;
/* Sum of Two Numbers
Name: John A Chrin
Date: 2015/02/05
Lab: Page 106 #5
*/
import javax.swing.JOptionPane; // <--- Wanted to make the message pop out in a box, but couldn't quite grasp it.

public class SumofTwoNumbers // <--- Access Specifier: controls where the class may be access from.
{
   public static void main(String[] args) // <--- Method
   {
     //this is my code
     int a, b, total;
     a = 62;
     b = 99;
     total = a + b;
     
     System.out.println("The age range at which I will");
     System.out.println("no longer lift big weights is " + a + " to " + b + ",");
     System.out.println("and I will live for " + total + " years, how sad :(.");
   }
   
}   

