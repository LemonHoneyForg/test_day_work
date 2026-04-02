
/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class BMIRevised
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		double weight;
		// The user's height
		double height;
		// The user's BMI
		boolean runBmiAgain = false;

		char userInput;

		boolean vaildChar = false;
		// Create a Scanner object for scanning input from keyboard
		Scanner keyboardInput = new Scanner(System.in);
		do
		{
			// Tell the user what the program will do.
			System.out.println("This program will calculate your body mass index, or BMI.");

			// Get the user's weight.
			System.out.print("Enter your weight, in pounds: ");
			// ADD CODE to input next double for weight
			weight = keyboardInput.nextDouble();
			// Get the user's height.
			System.out.print("Enter your height, in inches: ");
			// ADD CODE input next double for height
			height = keyboardInput.nextDouble();

			boolean validBmi = realBmi(weight, height);
			double bmiCheck = calcBmi(weight, height);
			if (validBmi == true)
			{
				printBmi(weight, height, bmiCheck);
				do
				{
					System.out.println("would you like to enter another athlete’s data for BMI? (Y/N)");
					userInput = keyboardInput.next().charAt(0);
					char capUserChar = Character.toUpperCase(userInput);
					if ((capUserChar == 'Y') || ((capUserChar == 'N')))
					{
						vaildChar = true;
					} else
					{
						System.out.println("please enter Y or N");
					}
				} while (vaildChar == false);
				char capChar = Character.toUpperCase(userInput);
				runBmiAgain = runAgain(capChar);
			} else
			{
				System.out.println("sorry user weight or height can not be zero ending program");
			}

		} while (runBmiAgain == true);
		System.out.println("understood ending program");
		keyboardInput.close();
	}// end of main

	public static double calcBmi(double userWeight, double userHeight)
	{
		final double BMI_US_FACTOR = 703;

		double bmi = userWeight * BMI_US_FACTOR / (Math.pow(userHeight, 2));

		return bmi;
	}

	public static void printBmi(double height, double weight, double bmicalc)
	{

		System.out.printf("With a height of " + height + " and weight of " + weight + " athlete’s BMI is %.2f",
				bmicalc);
		System.out.println();
	}

	public static boolean realBmi(double userWeight, double userHeight)
	{

		boolean bmiValue = false;
		if (userWeight < 0 || userHeight < 0)
		{
			bmiValue = false;
		} else
		{
			bmiValue = true;
		}
		return bmiValue;
	}

	public static boolean runAgain(char userAnswer)
	{

		boolean programRepeat = false;
		if ((userAnswer == 'Y'))
		{
			programRepeat = true;
		} else
		{
			programRepeat = false;
		}
		return programRepeat;
	}

}// end of class
