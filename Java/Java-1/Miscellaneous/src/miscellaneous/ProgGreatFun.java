package miscellaneous;
/* Programming is great fun
Name: John A Chrin
Date: 2015/02/05
*/
import javax.swing.JOptionPane;

public class ProgGreatFun
{
   public static void main(String[] args)
   {
      String s = "Programming is Fun";
      //I am the caller of some method
      int i = displayResults(s);
      System.out.println("Returning " + i);
      System.out.println("Programming");
      System.out.print("Is Great Fun!");
   }
   
   public static int displayResults(String s)
   {
      JOptionPane.showMessageDialog(null, s);
      return 33333;
   }
   
}