
/**
 * 
 */

import java.util.Scanner;

public class ConcertTicketPrices
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		/*
		 * Establishing all variables at the start of the program to ensure that
		 * everything is organized in one place where it makes sense meaning that the
		 * details on the cost of the three rows is organized at the top of the program
		 * as well as the applicable sections that are available our initialized before
		 * we get into the if statements
		 */
		int rowOne = 450;
		int rowTwo = 300;
		int rowThree = 200;

		char sectionF = 'F';
		char sectionC = 'C';
		char sectionS = 'S';
		char sectionU = 'U';
		char userSection;
		int userRow;

		/*
		 * Takes in the first user input regarding the section and capitalizes it so
		 * that we can case match with the section names that we established beforehand
		 * properly
		 */
		System.out.println(" For your ticket please enter the letter of the section you would like from F,C,S or U");

		userSection = input.next().charAt(0);
		Character.toUpperCase(userSection);
		// checks input to established user sections and if matchs moves on to row
		// selection
		if ((userSection == sectionF) || (userSection == sectionC) || (userSection == sectionS)
				|| (userSection == sectionU))
		{
			System.out.println("understood Section " + userSection + " what row from 1 through 60?");
			userRow = input.nextInt();
			// Determines cost based on row and tells the user based on they're choice
			if (userRow < 1)
			{
				System.out.println("Invalid row,  program ending");
			} else if (userRow <= 15)
			{

				System.out.println("understood your ticket will cost $" + rowOne);
			} else if (userRow <= 30)
			{

				System.out.println("understood your ticket will cost $" + rowTwo);
			} else if (userRow <= 60)
			{

				System.out.println("understood your ticket will cost $" + rowThree);
			} else // ends program if user input is out of range (1-60)
			{
				System.out.println("Invalid row,  program ending");
			}

		} else // ends program if input doesn't match sections avalible
		{
			System.out.println("Invalid section,program ending");
		}

		input.close();
	}// end of main

}// end of class
