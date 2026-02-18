
/**
 * 
 */

import java.util.Scanner;

public class ConcertTicketPrices
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int rowOne = 450;
		int rowTwo = 300;
		int rowThree = 200;

		char sectionF = 'F';
		char sectionC = 'C';
		char sectionS = 'S';
		char sectionU = 'U';
		char userSection;
		int userRow;
		System.out.println(" For your ticket please enter the letter of the section you would like from F,C,S or U");

		userSection = input.next().charAt(0);
		Character.toUpperCase(userSection);

		if ((userSection == sectionF) || (userSection == sectionC) || (userSection == sectionS)
				|| (userSection == sectionU))
		{
			System.out.println("understood Section " + userSection + " what row from 1 through 60?");
			userRow = input.nextInt();

			if (userRow <= 1)
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
			} else
			{
				System.out.println("Invalid row,  program ending");
			}

		} else
		{
			System.out.println("Invalid Section,program ending");
		}

		input.close();
	}// end of main

}// end of class
