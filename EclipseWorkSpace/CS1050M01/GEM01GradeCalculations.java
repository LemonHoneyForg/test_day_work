
// class is ID'd as assignment name
public class GEM01GradeCalculations
{
	// start of main
	public static void main(String[] args)
	{

		// grade weight .15 = 15%
		final double CLASS_PART_ONE = .15;
		// grade weight .2 = 20%
		final double CLASS_PART_TWO = .2;
		// grade weight .25 = 25%
		final double CLASS_PART_THREE = .25;
		// grade weight .2 = 20%
		// there are five category's but the last two are also 20% so I re-used
		// CLASS_PART_TWO

		// gradeVal 1-5 below represent each letter grade BEFORE Weight is calculated
		int gradeValOne = 94;

		int gradeValTwo = 84;

		int gradeValThree = 90;

		int gradeValFour = 99;

		int gradeValFive = 98;

		// doubles final 1-5 brake up the individual category's weight calculations to
		// better visualize the math for each
		// does math for category one of grade with Weight
		double finalOne = gradeValOne * CLASS_PART_ONE;

		// does math for category two of grade with Weight
		double finalTwo = gradeValTwo * CLASS_PART_TWO;

		// does math for category three of grade with Weight
		double finalThree = gradeValThree * CLASS_PART_THREE;

		// does math for category four of grade with Weight
		double finalFour = gradeValFour * CLASS_PART_TWO;

		// does math for category five of grade with Weight
		double finalFive = gradeValFive * CLASS_PART_TWO;

		// total of the calculated grades with Weight for overall final grade calculated
		double finalGrade = finalFive + finalFour + finalThree + finalTwo + finalOne;

		// letter grade out print to a decimal place of 2 for exact relevant info in
		// addition to string that tells user that this is they're grade
		System.out.printf("congrats! you have a grade of %.2f", finalGrade);

	}// end of main

}// end of class
