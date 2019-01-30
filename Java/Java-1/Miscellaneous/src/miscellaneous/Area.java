package miscellaneous;

/* Chapter 8 Lab
   Name: John A Chrin
   Date: 2015/03/26
   Purpose: Chap 8., #1 (p.555)
   This program calculates the area of a circle, rectangle, and cylinder
   by using instance variables and pseudo exception handling via while loops.
*/
import java.util.Scanner;

public class Area {
    // All of the instance variables required. Set to private since they need not be accessed outside this class.
    private int length;
    private int width;
    private double radius;
    private double height;
    private Scanner userInput = new Scanner(System.in);				// Needed user to interact with program.

    public static void main(String[] args) {
	Area area = new Area();							// Instance of the Area class's default constructor.
	// Test area of a circle method.
	System.out.println("To calculate the area of a circle (number only):");
	System.out.println("Type in the radius of a circle");
	area.radius = area.validInputChecker(area.userInput);			// Sets the value after validating input from the user.
	System.out.println("Area of the circle is " + area.calcArea(area.radius) + "\n");

	// Test area of rectangle method.
	System.out.println("To calculate the area of a rectangle (number only):");
	System.out.println("Type in the length of the rectangle: ");
	area.length = (int) area.validInputChecker(area.userInput);		// (int) downcasts the output of the double, this allows the overload to work.
	System.out.println("Type in the width of the rectangle: ");
	area.width = (int) area.validInputChecker(area.userInput);
	System.out.println("Area of rectangle is " + area.calcArea(area.width, area.length) + "\n");

	// Test area of cylinder method.
	System.out.println("To calculate the area of a cylinder (number only):");
	System.out.println("Type in the radius of cylinder's base: ");
	area.radius = area.validInputChecker(area.userInput);
	System.out.println("Type in the cylinder's height: ");
	area.height = area.validInputChecker(area.userInput);
	System.out.println("Area of cylinder is " + area.calcArea(area.radius, area.height) + "\n");
	area.userInput.close();
    }

    // Calculate AREA of a CIRCLE.
    public double calcArea(double radius) {
	return (Math.PI * Math.pow(radius, 2));
    }

    // Calculate AREA of a RECTANGLE.
    // This method is marked with 'int' to not conflict with CYLINDER overload method below.
    public int calcArea(int width, int length) {
	return (width * length);
    }

    // Calculate AREA of a CYLINDER.
    public double calcArea(double radius, double height) {
	return (Math.PI * Math.pow(radius, 2) * height);
    }

    // Checks the userInput by first asking the user to input information and then validates its type (Exception handling).
    private double validInputChecker(Scanner userInput) {
	double output;
	while (true) {
	    if (userInput.hasNextDouble()) {
		output = userInput.nextDouble();
		break;
	    } else {
		userInput.next();
		System.out.println("Your input must be a digital number.");	// Will not stop until user enters the correct format.
	    }
	}
	return output;
    }
}