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
		int intTemp = 0;
		int count = 0;
		while (scan.hasNextLine())
		{
			fileContent = fileContent.concat(scan.next() + "\n");
			athlte1.setName(fileContent);

			while (scan.hasNextDouble())
			{
				intTemp = 0;
				double tempValue = scan.nextDouble();
				athlte1.setWeight(tempValue);
				tempValue = 0;
				tempValue = scan.nextDouble();
				athlte1.setHight(tempValue);
				tempValue = 0;
				intTemp = scan.nextInt();
				athlte1.setAge(intTemp);
				team.addAthlte(athlte1, count);
				count++;
			}
		}
		scan.close();
	}

	@SuppressWarnings("static-access")
	public static void runAnalysis(Team team) throws FileNotFoundException
	{
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getAthleteCount());
		System.out.println();

		team.displayAthleteResults();
		team.displayAthletesOutsideNormalBMI();
//
		double avg = team.calculateAverageMaxHeartRate();
		System.out.println("\nAverage Max Heart Rate: " + avg);
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

	Athlte()
	{
		name = "luna";
		hight = 67;
		weight = 167;
		age = 20;

	}

	/**
	 * @param newName
	 * @param newHight
	 * @param newWeight
	 * @param age
	 */
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

	double getAthlteAge()
	{
		return this.age;
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
	public static Athlte[] teamList = new Athlte[4];

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

	public static void displayAthleteResults()
	{
		System.out.println("========== Team Summary==========");
		System.out.println();

		for (int i = 0; i < teamList.length; i++)
		{
			System.out.println(teamList[i].getAthlteName());
			System.out.printf("BMI: %.2f", makeBMI(i));
			System.out.println();
			System.out.print("Catagory: ");
			bmiCatagorys(makeBMI(i));
			System.out.println("MHR: " + makeMHR(i));
			System.out.println();
			System.out.println();
		}

	}

	public static double makeBMI(int count)
	{
		double bmi = teamList[(int) count].getAthlteWeight() * 703
				/ (Math.pow(teamList[(int) count].getAthlteHight(), 2));
		return bmi;
	}

	public static double makeMHR(int count)
	{
		double mhr = 220 - teamList[(int) count].getAthlteAge();
		return mhr;
	}

	/**
	 * @param count
	 */
	public static void bmiCatagorys(double count)
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

	/**
	 * @param object
	 * @param counter
	 */
	public void addAthlte(Athlte object, int counter)
	{
		String spaceMax = "Team full";
		if (counter < teamList.length)
		{
			teamList[counter] = object;
		} else
		{
			System.out.println(spaceMax);
		}

	}

	public static double calculateAverageMaxHeartRate()
	{

		double sum = 0;
		for (int i = 0; i < teamList.length; i++)
		{

			sum += 220 - teamList[(int) i].getAthlteAge();
		}

		double average = sum / teamList.length;
		return average;
	}

	/**
	 * 
	 */

	public static void displayAthletesOutsideNormalBMI()
	{
		double sum = 0;
		double[] weightIn = new double[teamList.length];

		for (int i = 0; i < teamList.length; i++)
		{
			weightIn[i] = teamList[(int) i].getAthlteWeight();
			sum += teamList[(int) i].getAthlteWeight() * 703 / (Math.pow(teamList[(int) i].getAthlteHight(), 2));
		}

		double average = sum / teamList.length;

		for (int i = 0; i < teamList.length; i++)
		{
			if (weightIn[i] > average)
			{ // Count if number[i] > average

				System.out.println("athlete " + teamList[i].getAthlteName() + " is above group average");
			} else if (weightIn[i] < average)
			{ // Count if number[i] > average

				System.out.println("athlete " + teamList[i].getAthlteName() + " is below group average");
			} else
			{
				System.out.println("none of athletes are out of average");
			}

		}

	}

	void writeAthletesToFile(String fileContent) throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		writer.write(fileContent);
		writer.close();
	}
}
