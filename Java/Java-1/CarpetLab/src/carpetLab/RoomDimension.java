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

public class RoomDimension
{
////////////* FIELDS / INSTANCES *////////////
//****************************************************************************************
private double Width;
private double Length;
private double Area;
public static double Potato;
//****************************************************************************************
////////////& CONSTRUCTORS / OBJECT CREATOR &////////////
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
   public RoomDimension()
   {  
   }
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
////////////^ SETTERS / MUTATORS ^////////////
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public void setWidth(double wid)
{
   Width = wid;
}
public void setLength(double leg)
{
   Length = leg;
}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
////////////% GETTERS / ACCESSORS %////////////
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
public double getArea()
{   
   return (Width*Length);
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
////////////$ OTHER METHODS $////////////
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}
