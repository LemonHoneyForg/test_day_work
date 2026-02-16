
/**
 * 
 */
import java.util.Scanner;

public class StringsAndCharsMadlib
{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		// lists variable names for story will be used later
		String firstName;

		String lastName;

		String noun;

		String verbIng;

		String adjective;

		String place;
		// both are char's because we only want the Initial of the last name
		char lastInitial;

		char favoriteLetter;
		// Begins prompting the user for the needed inputs
		System.out.println("Enter first name");
		// captures user input
		firstName = input.next();

		System.out.println("Enter Last name");
		/*
		 * doing two things here last name is takin as- a string then we store the first
		 * char of that string as a char to use as- our char variable for the last name
		 * Initial
		 */
		lastName = input.next();
		lastInitial = lastName.charAt(0);
		System.out.println("Enter a noun");

		noun = input.next();

		System.out.println("Enter a verb ending in -ing");

		verbIng = input.next();

		System.out.println("Enter an adjective");

		adjective = input.next();

		System.out.println("Enter an place");

		place = input.next();

		System.out.println("Enter your favorite letter");

		favoriteLetter = input.next().charAt(0);
		/*
		 * combines accumulated strings and chars into single base template string
		 * provided for the completes summary that will be printed back to user for end
		 * product
		 */
		String summary = "Once upon a time," + firstName + " " + lastInitial + " was " + verbIng + " through the "
				+ place + " with a " + noun + ". It was a very " + adjective + " day. Their favorite letter was "
				+ favoriteLetter;

		System.out.println(summary);
		// closes scanner class to kill logic error
		input.close();
	} // end of main

}// end of class
