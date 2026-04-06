
/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class BMI_Final
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
		boolean isValid = false;

		do
		{
			if (athleteCount <= 0)
			{
				System.out.println("invalid number");
				System.out.println("please enter number greater then 0 below");
				athleteCount = keyboardInput.nextInt();
			} else
			{
				isValid = true;
			}
		} while (isValid == false);

		String[] athleteNameArray = new String[athleteCount];
		int count = 1;
		for (int i = 0; i < athleteCount; i++)
		{
			System.out.println("enter athlete " + count + "s name");
			athleteNameArray[i] = keyboardInput.next();
			System.out.println("recorded athlete " + athleteNameArray[i]);
			count++;
		}
		System.out.println("all athlete names recorded");

		double[] athleteBmiArray = new double[athleteCount];
		count = 1;
		for (int i = 0; i < athleteCount; i++)
		{
			System.out.println("enter athlete " + count + "s BMI");
			athleteBmiArray[i] = keyboardInput.nextDouble();
			System.out.println("recorded BMI " + athleteBmiArray[i]);
			count++;
		}
		System.out.println("all athlete BMI's recorded");
		double avrgBMI = avgCalc(athleteBmiArray);
		displayOutOfRange(avrgBMI, athleteBmiArray, athleteNameArray);

		double[] athleteMhrArray = new double[athleteCount];
		count = 1;
		for (int i = 0; i < athleteCount; i++)
		{
			System.out.println("enter athlete " + count + "s MHR");
			athleteMhrArray[i] = keyboardInput.nextDouble();
			System.out.println("recorded MHR " + athleteMhrArray[i]);
			count++;
		}
		System.out.println("all athlete MHR's recorded");
		double avrgHMR = avgCalc(athleteMhrArray);
		System.out.println("all athlete MHR's recorded");
		displayOutOfRange(avrgHMR, athleteMhrArray, athleteNameArray);
		keyboardInput.close();
	}

	public static double avgCalc(double[] allavg)
	{

		int sum = 0;

		for (int i = 0; i < allavg.length; i++)
		{
			sum += allavg[i];
		}

		double bmiMax = sum / allavg.length;

		return bmiMax;
	}

	public static double heartRateAvgCalc(double[] allHMRs)
	{
		int sum = 0;

		for (int i = 0; i < allHMRs.length; i++)
		{
			sum += allHMRs[i];
		}

		double mhrMax = sum / allHMRs.length;

		return mhrMax;
	}

	public static void isPosNumber(int athleteCount)
	{

	}

	public static String[] athleteNames(int athleteNumber)
	{
		Scanner input2 = new Scanner(System.in);
		String[] athleteArray = new String[athleteNumber];
		int count = 1;
		for (int i = 0; i < athleteNumber; i++)
		{
			System.out.println("enter student " + count + "s name");
			athleteArray[i] = input2.next();
			System.out.println("recorded student " + count);
			count++;
		}
		System.out.println("all students recorded");
		input2.close();
		return athleteArray;
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

	public static double[] makeBmiArray(double[] athleteWeight, double[] athleteHeight)
	{
		double[] athleteBmiArray = new double[athleteHeight.length];
		final double BMI_US_FACTOR = 703;
		for (int i = 0; i < athleteHeight.length; i++)
		{
			athleteBmiArray[i] = athleteWeight[i] * BMI_US_FACTOR / (Math.pow(athleteHeight[i], 2));
		}

		return athleteBmiArray;
	}

}
