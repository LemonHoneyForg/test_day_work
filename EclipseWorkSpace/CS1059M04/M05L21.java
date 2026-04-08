
/**
 * 
 */
import java.util.Scanner;

/**
 * 
 */
public class M05L21
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);
		int athleteCount;

		System.out.print("how many athletes are you entering?");
		athleteCount = keyboardInput.nextInt();

		double[] athleteBmiArray = new double[athleteCount];

		athleteBmiArray = makeBmiArray(keyboardInput, athleteCount);

		double[] athleteMhrArray = new double[athleteCount];

		athleteMhrArray = makeMhrArray(keyboardInput, athleteCount);

		keyboardInput.close();
	}

	public static void displayOutOfRange(double athleteAvrg, double[] athleteNumbers, String[] athleteNames)
	{
		int aboveCount = 0; // The numbers of elements above average
		int belowCount = 0; // The numbers of elements above average
		for (int i = 0; i < athleteNumbers.length; i++)
		{
			if (athleteNumbers[i] > athleteAvrg)
			{ // Count if number[i] > average
				aboveCount++;
				System.out.println("athlete " + athleteNames[i] + " is above group average");
			} else if (athleteNumbers[i] < athleteAvrg)
			{ // Count if number[i] > average
				belowCount++;
				System.out.println("athlete " + athleteNames[i] + " is below group average");
			} else
			{
				System.out.println("none of athletes are out of average");
			}

		}

		System.out.println("Number of athletes above the average(" + athleteAvrg + ") is " + aboveCount);
		System.out.println("Number of athletes below the average(" + athleteAvrg + ") is " + belowCount);

		System.out.println("total MHR's entered is " + (athleteNumbers.length));
	}

	public static double[] makeMhrArray(Scanner input, int athleteCount)
	{
		double[] athleteMhrArray = new double[athleteCount];
		int count = 1;

		for (int i = 0; i < athleteCount; i++)
		{
			System.out.print("enter MHR " + count + " please");
			athleteMhrArray[i] = input.nextInt();

		}
		System.out.println("all BMI's stored");

		return athleteMhrArray;
	}

	public static double[] makeBmiArray(Scanner input, int athleteCount)
	{

		double[] athleteBmiArray = new double[athleteCount];
		final double BMI_US_FACTOR = 703;
		double weight;
		double height;

		int count = 1;

		for (int i = 0; i < athleteCount; i++)
		{
			System.out.println("for athlete " + count + "'s BMI");

			System.out.println("enter weight " + count + " please");
			weight = input.nextInt();

			System.out.println("enter height " + count + " please");
			height = input.nextInt();

			count++;

			athleteBmiArray[i] = weight * BMI_US_FACTOR / (Math.pow(height, 2));
		}
		System.out.println("all BMI's stored");
		return athleteBmiArray;
	}

	public static void enterAthleteData(String[] names, double bmis[], double[] heartRates, Scanner input)
	{
		// TODO Auto-generated method stub

	}

}
