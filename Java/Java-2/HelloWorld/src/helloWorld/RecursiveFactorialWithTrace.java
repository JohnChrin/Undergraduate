package helloWorld;
/* Program - Class Computing the factorail of a number using recursion with TRACE
Name: John A Chrin
*/

public class RecursiveFactorialWithTrace
{
   public static void main( String [] args )
   {
      //compute factorial of 5 and output it
      System.out.println( "Factorial ( 5 ) is " + factorial( 5 ) );
   }
   
   /** recursive factorial method
   *  @ param   n   a positive integer
   *  @ return      the factorial of n
   */
   public static int factorial( int n )
   {
     System.out.println( "factorial( " + n + " ) called" );
     if ( n == 0 )  //base case
     {
      System.out.println( "\nBase case detected" );
      System.out.println( "factorial( " + n + " ) returning 1\n" );
      return 1;
     }
     else
     {
      int factorialNMinus1 = factorial( n - 1 );
      System.out.println( "factorial( " + n + " ) returning " + n + " * " + factorialNMinus1 );
      return ( n * factorialNMinus1 );
     }
   }
}