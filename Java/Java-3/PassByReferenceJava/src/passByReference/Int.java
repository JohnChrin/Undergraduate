package passByReference;
/* 
   Name: John A Chrin
   Course: CSC345
   Date: 2018/09/02
   Assignment: 0
   Purpose: This program executes pass by reference
   math.
*/
public class Int
{
	// declare an int for Int to use
	private static int numb;

	// default constructor per directions
	public Int(int numb)
	{
		// use previously declared int
		this.numb = numb;
	}

	public static int getNumb()
	{
		return numb;
	}

	// created 3 class methods that return the class instance value after updating
	// it via math.
	public static void square()
	{
		numb = numb * numb;
	}

	public static void twice()
	{
		numb = 2 * numb;
	}

	public static int once()
	{
		return numb;
	}
}
