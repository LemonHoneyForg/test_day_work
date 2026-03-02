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

		String userEnetered;

		Boolean userPass = false;

		String PassStored;

		String passEnetered;

		Boolean passPass = false;

		Boolean loginPass = false;

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

		while (loginPass == false || attempts <= 0)
		{
			if (userStored.equals(userEnetered))
			{
				userPass = true;
				if (PassStored.equals(passEnetered))
				{
					System.out.println("login is correct!");
					loginPass = true;
					passEnetered = "joy";
				} // pass end
			} else if (userPass == false)
			{
				System.out.println("user is false! please try again");
				attempts++;
			} else if (passPass == false)
			{
				System.out.println("pass is false! please try again");
				attempts++;
			}

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

}
// end of class
