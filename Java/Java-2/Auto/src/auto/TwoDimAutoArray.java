package auto;
/* Program - Client Two-Dimensional Arrays of Objects
Name: John A Chrin
*/

public class TwoDimAutoArray
{
   public static void main( String args [] )
   {
   // instantiate several Auto object references
   Auto sedan1 = new Auto( "BMW", 0, 0.0 );
   Auto sedan2 = new Auto( "BMW", 100, 15.0 );
   Auto sedan3 = new Auto( "Toyota", 0, 0.0 );
   Auto sportsCar = new Auto( "Ferrari", 0, 0.0 );
   Auto rv1 = new Auto( "Jeep", 0, 0.0 );
   Auto rv2 = new Auto( "Ford", 200, 30.0 );
   
   //DECLARE and INITIALIZE two-dimensional array of Autos
   Auto [] [] cars = { { sedan1, sedan2, sedan3 },
                       { sportsCar, new Auto( ) },
                       { rv1, rv2 }                };
                       
   Auto retrievedCar = cars[1][0];
   //RetrievedCar gets the sportsCar object reference
   
   System.out.println( "cars[1][0]'s description is:\n"
               + retrievedCar );
   }
}