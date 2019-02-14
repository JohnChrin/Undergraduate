package arrayEducation;
/* Program - Client Processing One Column of a Two-Dimensional Array
Name: John A Chrin
*/

import java.util.Scanner;
import java.text.NumberFormat;

public class MaxMemberBill
{
   public static void main( String [] args) 
   {
      //DECLARE AND INITIALIZE THE ARRAY
      double [][][] familyCellBills = {{  {45.24, 54.67, 32.55, 25.61},
                                       {65.29, 49.75, 32.08, 26.11},
                                       {75.24, 54.53, 34.55, 28.16} },
	      {  {45.24, 54.67, 32.55, 25.61},
                                           {65.29, 49.75, 32.08, 26.11},
                                           {75.24, 54.53, 34.55, 28.16} }};
      
      String [] familyMembers = { "Joe", "Jane", "Mike", "Sarah" };
      for( int i = 0; i < familyMembers.length; i++ )
         System.out.println( "Family member " + i + " : "
                              + familyMembers[i] );
                              
      Scanner scan = new Scanner( System.in );
      int currentMember;

         System.out.print( "Enter a family member between 0 and 3 > " );
         System.out.println(familyCellBills.length);

   }
}