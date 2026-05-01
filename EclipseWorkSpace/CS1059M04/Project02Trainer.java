import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * 
 */

public class Project02Trainer
{
	public static void main(String[] args)
	{
		displayProgramSummary();

		// ===== TEST 1 =====
		String fileName = "team1.txt";

		try
		{
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Nuggets", 6);

			teamSetUp(fileName, team);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		// ===== TEST 2 =====
		fileName = "team2.txt";

		try
		{
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Team CS", 4);

			teamSetUp(fileName, team);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		System.out.println("\nEnd of program");
	}

	public static void teamSetUp(String fileName, Team team) throws FileNotFoundException
	{
		File file = new File("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\captmidn.txt");
		Scanner scan = new Scanner(file);
		String fileContent = "";
		while (scan.hasNextLine())
		{
			fileContent = fileContent.concat(scan.nextLine() + "\n");
		}
	}

	public static void runAnalysis(Team team) throws FileNotFoundException
	{
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();
		team.displayAthletesOutsideNormalBMI();

		double avg = team.calculateAverageMaxHeartRate();
		System.out.println("\nAverage Max Heart Rate: " + avg);

		team.displayAthletesAboveAverageMHR(avg);
		team.displayHighestMHR();
		team.displaySmallestLargestHeight();
		String outputFileName = team.getTeamName() + ".txt";
		team.writeAthletesToFile(outputFileName);

	}

	// ================= DISPLAY =================

	public static void displayProgramSummary()
	{
		System.out.println("**************************************");
		System.out.println("Team and Athlete Analysis");
		System.out.println("**************************************");
		System.out.println("Reads athlete data from file");
		System.out.println("Displays athlete results");
		System.out.println("Performs team analysis");
		System.out.println("Writes results to file");
		System.out.println();
	}
}

// ================= ADD ATHLETE CLASS =================
class Athlte
{

	private String name;
	private double hight;
	private double weight;
	private int age;
	private double bmi = weight * 703 / (Math.pow(hight, 2));
	private int mhr = 220 - age;

	Athlte()
	{
		name = "luna";
		hight = 67;
		weight = 167;
		age = 20;

	}

	Athlte(String newName, double newHight, double newWeight, int age)
	{
		this.name = newName;
		this.hight = newHight;
		this.weight = newWeight;
		this.age = age;
	}

	String getAthlteName()
	{
		return name;
	}

	public void displayAthleteResults()
	{
		System.out.println();
		System.out.println(name);
		System.out.printf("BMI: %.2f", bmi);
		System.out.println();
		System.out.println("Catagory: ");
		bmiCatagorys(bmi);
		System.out.println();
		System.out.println("MHR: " + mhr);
	}

	public void bmiCatagorys(double count)
	{

		final double BMI_OVER_FACTOR = 25;

		final double BMI_STANDARD_FACTOR = 18.5;

		if (count >= BMI_OVER_FACTOR)
		{
			System.out.println("High");
		} else if (count >= BMI_STANDARD_FACTOR)
		{
			System.out.println("Normal");
		} else
		{
			System.out.println("Underweight");
		}

	}

}

// ================= ADD TEAM CLASS =================
class Team
{

	private String teamName;
	private int athleteCount;
	private Athlte[] teamList;

	Team()
	{
		teamName = "luna";
		teamList = new Athlte[4];

	}

	Team(String newName, int newAthleteCount)
	{
		this.teamName = newName;
		this.teamList = new Athlte[athleteCount];
	}

	String getTeamName()
	{
		return teamName;
	}

	int getAthleteCount()
	{
		return athleteCount;
	}

	public void displayAthleteResults()
	{
		System.out.println();
		for (int i = 0; i < athleteCount; i++)
		{
			System.out.println(teamList[i]);

		}

	}

}
