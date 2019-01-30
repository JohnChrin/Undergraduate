package miscellaneous;
/* Chapter 7 Lab
   Name: John A Chrin
   Date: 2015/03/26
   Purpose: Chap 7., #1 (p.490)
      This program stores rainfall
      data for the 12 months of
      the year into an ARRAY. It
      contains 4 METHODS.
      Return = total rainfall for year
      Return = average monthly rainfall
      Return = month with most rainfall
      Return = month with least rainfall
*/

// Bring in a private class of Scanner to ask for user input.
import java.util.Scanner;

// Name of my program.
public class Rainfall
{
   //instance fields or variables
   private double[] totals;
   {
   
   }
   
   //constructor method: initialize variables
   public Rainfall()
   {
      totals = new double[12]; //12 months in a year
      
   }
   
   //ACCESSOR METHODS: getters
   
   //returns entire array to give me all the months of rainfall
   public double[] getTotalsArray()
   {
      return totals;
   }
   
   //returns the rainfall for a given month
   //month 0 = January... month 11 = December
   public double getMonthTotal(int month)
   {
      return totals[month];
   }
   
   //MUTATOR METHODS -- setters: changes the data
   //Changes the value of 0 for each month to give the months rainfall data
   public void setMonthTotal(int month, double monthTotal)
   {
      totals[month] = monthTotal;
   }
   
   //OTHER METHODS
   //a running total += is saying that the totalyearrain is equal to totals[i] plus previous totals[i]
   public double totalRainfallForYear()
   {
      double totalYearRain = 0;
      for(int i=0; i < totals.length; i++)
      {
         totalYearRain += totals[i];
      }
      return totalYearRain;
   }
   
   public double avgRainfallForYear()
   {
      double avgRain = totalRainfallForYear()/totals.length;
      return avgRain;
   }
   
   public int monthMostRain()
   {
      int monthMost = 0; //start it out with January
      for (int i=1;i<totals.length;i++)
      {
         if (totals[i] > totals[monthMost])
            monthMost = i;
      } 
      return monthMost; 
   }
   
   public int monthLeastRain()
   {
      int monthLeast = 0; //start it out with January
      for (int i=1;i<totals.length;i++)
      {
         if (totals[i] > totals[monthLeast])
            monthLeast = i;
      }  
      return monthLeast;
   }
   
   //TEST CODE
   public static void main(String[] args)
   {
      Rainfall phillyRain = new Rainfall();
      Scanner in = new Scanner(System.in);
      for (int i=1; i<=12;i++)
      {
      System.out.println("Please enter rainfall for month " + i);
      double rainfall = in.nextDouble();
      phillyRain.setMonthTotal((i-1), rainfall);
      }
   //print out array, total, avg, most, least
   //THIS WILL PRINT OUT MEMORY ADDRESS - DON'T WANT THAT
   //System.out.println(phillyRain.getTotalsArray());
   for (int month=0; month<12; month++)
      System.out.println("Month " + month + " Rainfall = " +
                         phillyRain.getMonthTotal(month));
   ////////////////////////////////////////////////////////
      System.out.println("TOTAL RAIN for YEAR: " +
                         phillyRain.totalRainfallForYear());
      System.out.println("AVERAGE RAIN for YEAR: " +
                         phillyRain.avgRainfallForYear());
      System.out.println("Month with Mostest Rainfall: " + 
                         phillyRain.monthMostRain());
      System.out.println("Month with Leastest Rainfall: " + 
                         phillyRain.monthLeastRain());
   }
   
}
