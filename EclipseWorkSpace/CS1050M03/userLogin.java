import java.util.Scanner;

public class userLogin
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		String userStored;

		String PassStored;

		String userEnetered;

		String passEnetered;

		Boolean login = true;

		int attempts = 0;

		System.out.println("enter what you want user to be");
		userStored = input.next();

		System.out.println("enter what you want pass to be");
		PassStored = input.next();

		System.out.println("great! thank you for setting up your account ");

		System.out.println("please login in");

		System.out.println("enter what your user ");
		userEnetered = input.next();

		System.out.println("enter your pass");
		passEnetered = input.next();

		while (!login)
		{
			if (userStored.equals(userEnetered))
			{
				if (PassStored.equals(passEnetered))
				{
					System.out.println("login is correct!");
				} // pass end
			} else if (userStored.equals(userEnetered))
			{

			} // user end
		} // while end

		if ((userStored.equals(userEnetered)) && PassStored.equals(passEnetered))
		{
			System.out.println("login is correct!");
		} else
		{
			System.out.println("WRONG LOGIN");
		}

		input.close();
	}// end of main

}// end of class
