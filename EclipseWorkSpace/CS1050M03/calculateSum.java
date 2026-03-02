
/**
 * 
 */
import java.util.Scanner;

/**
 * 
 */
public class calculateSum
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.print("enter a positive number");
		int userMax = input.nextInt();

		int endSum = printSum(userMax);

		System.out.println(endSum);

		input.close();
	}// end of main

	public static int printSum(int userCount)
	{
		int sum = 0;
		int total = 0;

		for (int count = 0; userCount >= count; count++)
		{

			total = total + sum;
			sum++;

		}
		return total;
	}

}// class
