package miscellaneous;
/* Chapter 4 Lab Example
   Name: John A Chrin
   Date: 2015/03/03
   Purpose: Chap 4., #2 (p.266)
      This program asks for input and calculates "speed"
      multiplied by "time" equals
      "distance". (It uses a loop to display the
      distance traveled per hour)
*/

// BRING IN OTHER PEOPLES CLASS FILES
import java.util.Scanner;

// NAME OF JAVA FILE
public class DistanceTraveled {
    private double speed;
    private double time;
    private double distance;
    private Scanner userInput = new Scanner(System.in);

    // WHERE WE INPUT CODE
    public static void main(String[] args) {
	new DistanceTraveled();
    }

    public DistanceTraveled() {
	// MESSAGE TO USER TO TELL THEM TO INPUT A "SPEED"
	System.out.println("Input a speed, it will be annotated in MPH");
	// INTEGER: SPEED is decided by "keyboard.nextInt()" which equals USER KEYBOARD INPUT AND IT PULLS AN INTEGER OUT OF IT
	speed = validInputChecker(userInput);
	// MESSAGE TO USER TO TELL THEM TO INPUT A "TIME"
	System.out.println("Input a time, it will be annotated in HOURS");
	// // INTEGER: TIME is decided by "keyboard.nextInt()" which equals USER KEYBOARD INPUT AND IT PULLS AN INTEGER OUT OF IT
	time = validInputChecker(userInput);
	// CREATE AN INTEGER TO MULTIPLY "SPEED * TIME"
	distance = speed * time;
	// TITLE CATEGORIES
	System.out.println("Hours\t\t\t\tDistance Traveled");
	System.out.println("------------------------------------------------------------------------------");
	// CREATE A LOOP TO OUTPUT A "DISTANCE" FOR EVERY "HOUR"(TIME) UNTIL MAX
	for (time = 1; time <= (distance / speed); time++) {  // DISPLAYS OUTPUT TO USER
	    System.out.println(time + "\tHours traveled at\t" + speed + " MPH " + " equals " + (speed * time)
		    + " miles traveled. ");
	}

    }

    // This is a sweet tool I crafted to validate inputs done by the user.
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