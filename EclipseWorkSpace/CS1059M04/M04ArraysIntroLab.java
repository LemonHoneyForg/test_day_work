import java.util.Scanner;

public class M04ArraysIntroLab
{
	public static void main(String[] args)
	{

		int studentTotal;

		boolean isValid = false;
		// sets up user input for five grades
		Scanner keyboardInput = new Scanner(System.in);
		// asks for grade 1
		System.out.print("how many students do you have in your class?");
		studentTotal = keyboardInput.nextInt();
		do
		{
			if (studentTotal < 0)
			{
				System.out.println("invalid number");
				System.out.println("please enter number greater then 0 below");
				studentTotal = keyboardInput.nextInt();
			} else
			{
				isValid = true;
			}
		} while (isValid == false);

		int[] studentArray = new int[studentTotal];
		int[] holdArray = new int[studentTotal];

		for (int i = 0; i < holdArray.length; i++)
		{
			System.out.println("enter students grades");
			studentArray[i] = keyboardInput.nextInt();
		}

		System.out.println("now please enter the students names in the same order you entered they're grades");

		String[] studentNames = studentNames(studentTotal);

		avgNumber(studentArray, studentTotal);

		keyboardInput.close();
	}// end of main

	public static void avgNumber(int[] gradesEntered, int gradescope)
	{
		int sum = 0;

		for (int i = 0; i < gradescope; i++)
		{
			sum += gradesEntered[i];
		}

		double average = sum / gradescope;

		int count = 0; // The numbers of elements above average
		for (int i = 0; i < gradescope; i++)
		{
			if (gradesEntered[i] > average)
			{ // Count if number[i] > average
				count++;
			}
		}
		System.out.println("Average is " + average);
		System.out.println("Number of grade above the average is " + count);

	}

	public static String[] studentNames(int studentNumber)
	{
		Scanner input2 = new Scanner(System.in);
		String[] studentArray = new String[studentNumber + 1];
		int count = 1;
		for (int i = 0; i < studentNumber; i++)
		{
			System.out.println("enter student " + count + "s name");
			studentArray[i] = input2.next();
			System.out.println("recorded student " + count);
			count++;
		}
		System.out.println("all students recorded");
		input2.close();
		return studentArray;
	}
}// end of class