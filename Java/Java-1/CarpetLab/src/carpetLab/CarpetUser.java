package carpetLab;
/* Chapter 8 Lab
   Name: John A Chrin
   Date: 2015/03/26
   Purpose: Chap 8., #3 (p.556)
   This program uses 2 classes,
   "RoomDimension" feeds into
   "RoomCarpet" in order to
   provide the cost of carpeting
   a room.
*/
import java.util.Scanner;

public class CarpetUser
{

// Test Method / Driver Method
public static void main(String[] args)
{
double Length;
double Width;
double Cost;

Scanner in = new Scanner(System.in);
System.out.println("Enter the length of the room in feet");
Length = in.nextDouble();

System.out.println("Enter the width of the room in feet");
Width = in.nextDouble();

System.out.println("Enter the cost per square foot of carpet\n$");
Cost = in.nextDouble();

RoomDimension roomd = new RoomDimension();
roomd.setLength(Length);
roomd.setWidth(Width);

RoomCarpet roomc = new RoomCarpet();
roomc.setCost(Cost);

System.out.println("The cost of carpeting your room is $" + (roomd.getArea() * Cost));
in.close();
                                                                                                                                                                                                                                       
}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}