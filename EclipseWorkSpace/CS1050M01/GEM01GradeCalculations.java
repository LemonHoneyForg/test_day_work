
/**
 * 
 */

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
		// there are five catagorys but the last two are also 20% so I re-used
		// CLASS_PART_TWO

		int gradeValOne = 94;

		int gradeValTwo = 84;

		int gradeValThree = 90;

		int gradeValFour = 99;

		int gradeValFive = 98;

		// does math for category one of grade
		double finalOne = gradeValOne * CLASS_PART_ONE;

		// does math for category two of grade
		double finalTwo = gradeValTwo * CLASS_PART_TWO;

		// does math for category three of grade
		double finalThree = gradeValThree * CLASS_PART_THREE;

		// does math for category four of grade
		double finalFour = gradeValFour * CLASS_PART_TWO;

		// does math for category five of grade
		double finalFive = gradeValFive * CLASS_PART_TWO;

		// total of the calculated grades
		double finalGrade = finalFive + finalFour + finalThree + finalTwo + finalOne;

		// letter grade out print to a decimal place of 2
		System.out.printf("congrats! you have a grade of %.2f", finalGrade);

	}// end of main

}// end of class
