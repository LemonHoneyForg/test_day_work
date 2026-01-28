
/**
 * This program takes user input to see if they can guess the 
 * random number generated. Add comments to explain the code.
 */

import java.util.Scanner;

public class GuessNumber
{
	public static void main(String[] args)
	{
		// variable for multiplier is decided
		final int RANDOM_MULTIPLIER = 100;

		int number = (int) (Math.random() * RANDOM_MULTIPLIER) + 1;

		Scanner keyboardInput = new Scanner(System.in);
		// interface with user starts
		System.out.println("Guess a magic number between 0 and 100");
		// while the guess is not the number the possess runs
		int guess = -1;
		while (guess != number)
		{
			// asks for user input till guess = number
			System.out.print("\nEnter your guess: ");
			guess = keyboardInput.nextInt();
			// yes case for if guess = number
			if (guess == number)
			{
				System.out.println("Yes, the number is " + number);
			} else if (guess > number)
			{
				// Adjusts if too high
				System.out.println("Your guess is too high");
			} else
			{
				// Adjusts if too low
				System.out.println("Your guess is too low");
			}
		}

	}// end of main
}// end of class
