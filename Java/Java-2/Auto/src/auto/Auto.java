package auto;
/* Program - Class Auto
Name: John A Chrin
*/

public class Auto
{
   //INSTANCE VARIABLES
   private String model;         //model of auto
   private int milesDriven;       //number of miles driven
   private double gallonsOfGas;  //number of gallons of gas
   
   //DEFAULT CONSTRUCTOR:
      //initializes model to "unknown"
      //milesDriven is auto-initialized to 0
      //and gallonsOfGas to 0.0
      public Auto( )
      {
         model = "unknown";
      }
      
   //OVERLOADED CONSTRUCTOR:
      //allows client to set beginning values for
      //model, milesDriven, and gallonsOfGas
      public Auto( String startModel, 
                  int startMilesDriven, 
                  double startGallonsOfGas )
      {
         //DECLARE model
         model = startModel;
         //DECLARE milesDriven
         setMilesDriven( startMilesDriven );
         //DECLARE gallonsOfGas
         setGallonsOfGas( startGallonsOfGas );
         
      }
      
   //ACCESSOR METHODS:
   //returns current value of model
   public String getModel( )
   {
      return model;
   }
   
   //returns current value of milesDriven
   public int getMilesDriven( )
   {
      return milesDriven;
   }
      
   //returns current value of gallonsOfGas
   public double getGallonsOfGas( )
   {
      return gallonsOfGas;
   }
   
   //SETTER METHODS:
   //sets value of milesDriven
   //prints error if new value is less than 0
   public void setModel( String newModel )
   {
      model = newModel;
   }
   
   
   public void setMilesDriven( int newMilesDriven )
   {
      if ( newMilesDriven >= 0 )
         milesDriven = newMilesDriven;
      else
      {
         System.err.println( "Miles driven cannont be negative." + "\n"
                           + "Value not changed." );
      }
   }
   public void setGallonsOfGas( double newGallonsOfGas )
   {
      if ( newGallonsOfGas >= 0 )
         gallonsOfGas = newGallonsOfGas;
      else 
      {
         System.err.println( "Gallons of gas connot be negative." + "\n"
                           + "Value not changed." );
      }
   }

public int calculateMilesPerGallon()
{

	return 23;
}
}