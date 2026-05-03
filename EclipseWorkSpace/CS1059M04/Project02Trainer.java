import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
		// File file = new File("C:\\GitHub
		// Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\captmidn.txt");
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
		File file = new File("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\CS1059M04\\team2.txt");
		Scanner scan = new Scanner(file);
		String fileContent = "";
		Athlte athlte1 = new Athlte();
		int count = 0;

		while (scan.hasNextLine())
		{
			fileContent = fileContent.concat(scan.next() + "\n");
			athlte1.setName(fileContent);

			while (scan.hasNextDouble())
			{
				count = 0;
				double tempValue = scan.nextDouble();
				athlte1.setWeight(tempValue);
				tempValue = 0;
				tempValue = scan.nextDouble();
				athlte1.setHight(tempValue);
				tempValue = 0;
				count = scan.nextInt();
				athlte1.setAge(count);
				team.addAthlte(athlte1, count);
				team.teamList[0] = team.addAthlte(athlte1, count);
			}
		}
		scan.close();
	}

	public static void runAnalysis(Team team) throws FileNotFoundException
	{
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();
//		team.displayAthletesOutsideNormalBMI();
//
//		double avg = team.calculateAverageMaxHeartRate();
//		System.out.println("\nAverage Max Heart Rate: " + avg);
//
//		team.displayAthletesAboveAverageMHR(avg);
//		team.displayHighestMHR();
//		team.displaySmallestLargestHeight();
//		String outputFileName = team.getTeamName() + ".txt";
//		team.writeAthletesToFile(outputFileName);

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

	public String name;
	public double hight;
	public double weight;
	public int age;
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

	public void setHight(double newHight)
	{
		this.hight = newHight;
	}

	public void setName(String newName)
	{
		this.name = newName;
	}

	public void setWeight(double newWeight)
	{
		this.weight = newWeight;
	}

	public void setAge(int newAge)
	{
		this.age = newAge;
	}

	String getAthlteName()
	{
		return this.name;
	}

	double getAthlteWeight()
	{
		return this.weight;
	}

	double getAthlteHight()
	{
		return this.hight;
	}

}

// ================= ADD TEAM CLASS =================
class Team
{

	private int athleteCount;
	private String teamName;
	public Athlte[] teamList = new Athlte[athleteCount];

	private String name;
	private double hight;
	private double weight;
	private int age;
	private double bmi = weight * 703 / (Math.pow(hight, 2));
	private int mhr = 220 - age;

	Team()
	{
		teamName = "luna";
		teamList = new Athlte[4];

	}

	Team(String newName, int newAthleteCount)
	{
		this.teamName = newName;

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

	public Athlte addAthlte(Athlte object, int counter)
	{

		return this.teamList[counter] = object;

	}

	void writeAthletesToFile(String fileContent) throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		writer.write(fileContent);
		writer.close();
	}
}
