
/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class GEM01GradeCalculations
{

	public static void main(String[] args)
	{

		// grade weight .15 = 15%
		final double CLASS_PART_ONE = .15;
		// grade weight .2 = 20%
		final double CLASS_PART_TWO = .2;
		// grade weight .25 = 25%
		final double CLASS_PART_THREE = .25;
		// grade weight .2 = 20%
		// there are five catagorys but the last two are also 20%

		int gradeValOne;

		int gradeValTwo;

		int gradeValThree;

		int gradeValFour;

		int gradeValFive;

		// sets up user input for five grades
		Scanner keyboardInput = new Scanner(System.in);
		// asks for grade 1
		System.out.print("\nEnter your first grade: ");
		gradeValOne = keyboardInput.nextInt();

		// asks for grade 2
		System.out.print("\nEnter your Second grade: ");
		gradeValTwo = keyboardInput.nextInt();

		// asks for grade 3
		System.out.print("\nEnter your third grade: ");
		gradeValThree = keyboardInput.nextInt();

		// asks for grade 4
		System.out.print("\nEnter your forth grade: ");
		gradeValFour = keyboardInput.nextInt();

		// asks for grade 5
		System.out.print("\nEnter your fith grade: ");
		gradeValFive = keyboardInput.nextInt();
		// does math for category one of grade
		double finalOne = gradeValOne * CLASS_PART_ONE;

		// does math for category one of grade
		double finalTwo = gradeValTwo * CLASS_PART_TWO;

	}// end of main

}// end of class
