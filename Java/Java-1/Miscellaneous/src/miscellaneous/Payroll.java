package miscellaneous;
/* Chapter 7 Lab
   Name: John A Chrin
   Date: 2015/03/26
   Purpose: Chap 7., #2 (p.490)
   This program accepts an
   employee's identification
   number and returns  their
   gross pay.
*/
import java.util.Scanner;

public class Payroll
{
   /////////////////////////////////////////////// 
   //Instance Variables or Fields
   
   //Array of EMP-ID
   private static int[] EmployeeID = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
   
   //Array of hours
   private double[] hours;
   
   //Array payrate
   private double[] payRate;
   
   //Array wages
   private double[] wages;
   
   ///////////////////////////////////////////
   
   //CONSTRUCTOR METHODS
   public Payroll()
   {
     hours = new double[7];
     payRate = new double[7];
     wages = new double[7];
   }
  
   //ACCESSOR METHODS -- get Methods
   public int getEmployeeId(int index)
   {
     return EmployeeID[index];
   }
   public double getHours(int index)
   {
     return hours[index];
   }
   public double getPayrate(int index)
   {
     return payRate[index];
   }
   public double getWages(int index)
   {
     return wages[index];
   }
   
   //MUTATOR METHODS  -- set Methods
   public void setEmployeeId(int index, int empId)
   {
     EmployeeID[index] = empId;
   }
   public void setHours(int index, double hrs)
   {
     hours[index] = hrs;
   }
   public void setPayrate(int index, double pyrt)
   {
     payRate[index] = pyrt;
   }
   public void setWages(int index, double wges)
   {
     wages[index] = wges;
   }

   
   //OTHER METHODS
   
   //Test method or driver
   public static void main(String[] args)
   {
   //Create a Payroll OBJECT (instance)
   Payroll Walmart = new Payroll();
   Walmart.setEmployeeId(0,5658845);
   Payroll Target = new Payroll();
   
   // Create a user keyboard input request -- only done once
   Scanner keyboard = new Scanner(System.in);

   
   // Prompt the user:
   
   for (int index = 0; index < EmployeeID.length; index++)
   {
      System.out.println("Employee " + (Walmart.getEmployeeId(index)) + ": ");
      System.out.println("Enter the hours worked:");
      double hours = keyboard.nextDouble();
      Walmart.setHours(index,hours);
  
      // Prompt for payrate:
      System.out.println("Enter the hourly payrate:");
      double payRate = keyboard.nextDouble(); 
      Walmart.setPayrate(index, payRate);

     // calculate wages and set them
     Walmart.setWages(index, (hours * payRate));
   }
   
   System.out.println("Employee ID\tHours\t\tPayrate\t\tWages");
     for (int index = 0; index < EmployeeID.length; index++)
   {
      System.out.println( Walmart.getEmployeeId(index) + "\t\t" +
                         Walmart.getHours(index) + "\t\t" +
                         Walmart.getPayrate(index) + "\t\t" +
                         Walmart.getWages(index));
   }
     keyboard.close();
   }
}