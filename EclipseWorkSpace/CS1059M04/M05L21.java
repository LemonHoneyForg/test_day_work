
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
		double bmiAvrg;
		double mhrAvrg;
		System.out.print("how many athletes are you entering?");
		athleteCount = keyboardInput.nextInt();

		isValidNumber(keyboardInput, athleteCount);

		double[] athleteBmiArray = new double[athleteCount];

		athleteBmiArray = makeBmiArray(keyboardInput, athleteCount);

		bmiAvrg = getAvrg(athleteBmiArray);

		double[] athleteMhrArray = new double[athleteCount];

		athleteMhrArray = makeMhrArray(keyboardInput, athleteCount);

		mhrAvrg = getAvrg(athleteMhrArray);

		String[] athleteNameArray = new String[athleteCount];

		athleteNameArray = makeAthleteNames(keyboardInput, athleteCount);

		makeAthleteData(athleteNameArray, athleteBmiArray, athleteMhrArray);

		System.out.println("bmi exeptions are: ");

		displayOutOfRange(bmiAvrg, athleteBmiArray, athleteNameArray);

		System.out.println("MHR exeptions are: ");

		displayOutOfRange(mhrAvrg, athleteBmiArray, athleteNameArray);

		keyboardInput.close();
	}

	public static double getAvrg(double[] valueList)
	{

		double sum = 0;
		for (int i = 0; i < valueList.length; i++)
		{

			sum += valueList[i];
		}

		double average = sum / valueList.length;
		return average;
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
		double[] athleteAgeArray = new double[athleteCount];
		int count = 1;
		double placeHolder;
		for (int i = 0; i < athleteCount; i++)
		{
			System.out.print("enter athlete " + count + "'s age please");
			placeHolder = input.nextInt();

			athleteAgeArray[i] = 206.9 - (0.67 * placeHolder);

			System.out.println("recorded athlete " + count);
			count++;
		}
		System.out.println("all BMI's stored");

		return athleteAgeArray;
	}

	public static boolean isValidNumber(Scanner input, double userValue)
	{
		double userNumber = userValue;
		boolean isValid = false;

		do
		{
			if (userNumber <= 0)
			{
				System.out.println("invalid number");
				System.out.println("please enter number greater then 0 below");
				userNumber = input.nextInt();
			} else
			{
				isValid = true;
			}
		} while (isValid == false);

		return isValid;
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

			System.out.println("enter weight, in pounds: " + count + " please");
			weight = input.nextInt();

			System.out.println("enter height, in inches: " + count + " please");
			height = input.nextInt();

			count++;

			athleteBmiArray[i] = weight * BMI_US_FACTOR / (Math.pow(height, 2));
			System.out.println("recorded athlete " + count);
		}
		System.out.println("all BMI's stored");
		return athleteBmiArray;
	}

	public static String[] makeAthleteNames(Scanner input, int athleteCount)
	{
		String[] athleteNameArray = new String[athleteCount];
		int count = 1;
		for (int i = 0; i < athleteCount; i++)
		{
			System.out.println("enter athlete " + count + "s name");
			athleteNameArray[i] = input.next();
			System.out.println("recorded athlete " + athleteNameArray[i]);
			count++;
		}
		System.out.println("all athlete names recorded");

		return athleteNameArray;
	}

	public static void bmiCatagorys(int count)
	{

		final double BMI_OVER_FACTOR = 25;

		final double BMI_STANDARD_FACTOR = 18.5;

		if (count >= BMI_OVER_FACTOR)
		{
			System.out.println("High");
		} else if (count >= BMI_STANDARD_FACTOR)
		{
			System.out.println("Normal");
		} else
		{
			System.out.println("Underweight");
		}

	}

	public static void makeAthleteData(String[] names, double bmis[], double[] heartRates)
	{
		System.out.println("========== Team Summary==========");
		System.out.println();
		int temp;
		for (int i = 0; i < bmis.length; i++)
		{
			System.out.println(names[i]);
			System.out.printf("BMI: " + "%.2f", bmis[i]);
			System.out.println();
			System.out.print("Catagory: ");
			temp = i;
			bmiCatagorys(temp);
			System.out.println("MHR: " + heartRates[i]);
			System.out.println();
			System.out.println();
		}

	}

}
