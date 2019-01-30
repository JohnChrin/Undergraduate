package passByReference;

/* 
   Name: John A Chrin
   Course: CSC345
   Date: 2018/09/02
   Assignment: 0
   Purpose: This program does pass by reference
   math. Something that Java is not great at but
   we do it anyway to show Java who is boss.
*/
public class PassByReference
{

	// this is where the work happens.
	public static void main(String[] args)
	{
		// next 3 lines are what the directions requested.
		Int x = new Int(3);
		int y = square(x) + twice(x) + once(x);
		System.out.println(y);
	}

	// 3 locally declared int methods to utilize Int's identical methods.
	public static int square(Int x)
	{
		x.square();
		return x.getNumb();
	}

	public static int twice(Int x)
	{
		x.twice();
		return x.getNumb();
	}

	public static int once(Int x)
	{
		x.once();
		return x.getNumb();
	}
}
