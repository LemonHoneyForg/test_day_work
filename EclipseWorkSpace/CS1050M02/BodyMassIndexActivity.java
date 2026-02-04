/**
 * Calculate the BMI using formula in US units. 
 * User will enter weight in pounds and height in inches
 */

// ADD CODE to import Scanner class
import java.util.Scanner;

public class BodyMassIndexActivity
{

	public static void main(String[] args)
	{
		// Create constand an variables
		// constants
		final double BMI_US_FACTOR = 703;
		// factor formula in pounds
		// Variables
		// The user's weight
		double weight;
		// The user's height
		double height;
		// The user's BMI

		// Create a Scanner object for scanning input from keyboard
		Scanner keyboardInput = new Scanner(System.in);
		// Tell the user what the program will do.
		System.out.println("This program will calculate your " + "body mass index, or BMI.");

		// Get the user's weight.
		System.out.print("Enter your weight, in pounds: ");
		// ADD CODE to input next double for weight
		weight = keyboardInput.nextDouble();
		// Get the user's height.
		System.out.print("Enter your height, in inches: ");
		// ADD CODE input next double for height
		height = keyboardInput.nextDouble();
		// Calculate the user's body mass index.
		double bmi = weight * BMI_US_FACTOR / (height * height);

		// Display the user's BMI.
		System.out.printf("\tYour body mass index (BMI) is %.2f", bmi);

		keyboardInput.close();
	}// end of main
}// end of class