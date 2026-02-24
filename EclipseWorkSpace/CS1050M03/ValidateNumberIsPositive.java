import java.util.Scanner;

public class ValidateNumberIsPositive
{
	public static void main(String[] args)
	{

		// Create a Scanner
		Scanner input = new Scanner(System.in);

		System.out.print("enter a positive number");
		int answer = input.nextInt();

		while (answer < 0)
		{
			System.out.print("ERROR please try again");
			answer = input.nextInt();
		}

		System.out.println("You got it!");
		input.close();
	}
}
