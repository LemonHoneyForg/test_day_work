
/**
 * 
 */
import java.util.Scanner;

public class L06MathCharStrings
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String firstName;

		System.out.println("Enter first name");

		firstName = input.next();

		System.out.println("First name " + firstName);

		System.out.println("Enter the initial of your last name");

		char lastInitial = input.next().charAt(0);

		String summary = "Hello " + firstName + " " + lastInitial;

		System.out.println(summary);
		input.close();
	} // end of main

}// end of class
