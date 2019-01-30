package student;
/* Program - Class Student
Name: John A Chrin
*/

//Name = String
//SS = String
//GPA = Int

import java.text.DecimalFormat;

public class Student
{
   //instance variables
   private String name; //student name
   private String ss;   //social security #
   private double gpa;  //grade point avg
   
   //CONSTRUCTOR
   public Student( )
   {
      name = "Creature";
   }
   
   //OVERLOADED CONSTRUCTOR
   public Student( String startName,
                   String startSs,
                   double startGpa )
   {
      name = startName;
      setSs( startSs );
      setGpa( startGpa );
   }
   
   //ACCESSOR METHODS:
   public String getName( )
   {
      return name;
   }
   
   public String getSs( )
   {
      return ss;
   }
   
   public double getGpa( )
   {
      return gpa;
   }
   
   //SETTER METHODS:
   public void setName( String newName )
   {
      name = newName;
   }
   
   public void setSs( String newSs )
   {
      ss = newSs;
   }
   
   public void setGpa( double newGpa )
   {
      if ( newGpa >= 0.0 )
      {
         gpa = newGpa;
      }
      else
      {
         System.err.println( "GPA cannot be negative, no one is that stupid " );
         System.err.println( "GPA value not changed" );
      }
      
   }
   
   //toString: returns a String of instance variable values
   public String toString( )
   {
      DecimalFormat gpaFormat = new DecimalFormat( "#0.00" );
      return "Name: " + name
               + "; Social Security #: " + ss
               + "; GPA: "
               + gpaFormat.format( gpa );
              
   }
   
   //equals: returns true if fields of parameter object
   //        are equal to fields in this object
   public boolean equals( Object o )
   {
      if ( ! ( o instanceof Student ) )
         return false;
      else
      {
         Student objStudent = ( Student ) o;
        if ( name.equals( objStudent.name )
               && ss.equals( objStudent.ss )
               && gpa == objStudent.gpa )
             return true;
           else
             return false;
      }
   }       
}