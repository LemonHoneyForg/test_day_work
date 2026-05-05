import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 
 */

public class Project02Trainer
{
	/**
	 * @param args
	 * @throws Exception Main body of the program that executes other methods and
	 *                   calls files
	 */
	public static void main(String[] args) throws Exception
	{
		displayProgramSummary();

		// ===== TEST 1 =====
		File file1 = new File("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\CS1059M04\\team1.txt");
		File file2 = new File("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\CS1059M04\\team2.txt");
		String fileName = "team1.txt";

		try
		{
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Nuggets", 6);

			teamSetUp(fileName, team, file1);

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

			teamSetUp(fileName, team, file2);

			runAnalysis(team);

		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}

		System.out.println("\nEnd of program");
	}

	/**
	 * @param fileName
	 * @param team
	 * @throws FileNotFoundException
	 * 
	 *                               Scans through each line in the properly
	 *                               formatted txt file for the relevant information
	 *                               name weight height and age and then converts
	 *                               them into variables to be stored in the athlete
	 *                               object
	 * 
	 */
	public static void teamSetUp(String fileName, Team team, File file) throws FileNotFoundException
	{

		Scanner scan = new Scanner(file);
		String fileContent = "";

		int intTemp = 0;

		while (scan.hasNextLine())
		{
			Athlte athlte1 = new Athlte();
			fileContent = "";
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
				team.addAthlte(athlte1);

			}

		}
		scan.close();
	}

	/**
	 * @param team
	 * @throws IOException
	 * 
	 *                     Execute a series of analytical/Demonstration methods to
	 *                     prove that the program meets all the checkpoints required
	 *                     for the assignment
	 * 
	 */
	@SuppressWarnings("static-access")
	public static void runAnalysis(Team team) throws IOException
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
/**
 * 
 */
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
		return this.teamName;
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
			// printing more then one name do to only one athlete object being overloaded
			System.out.print(teamList[i].getAthlteName());
			System.out.printf("BMI: %.2f", makeBMI(i));
			System.out.println();
			System.out.print("Catagory: ");
			bmiCatagorys(makeBMI(i));
			System.out.println("MHR: " + makeMHR(i));
			System.out.println();
			System.out.println();
		}

	}

	public static double[] makeMHRArry()
	{
		double sum = 0;
		double[] MhrList = new double[teamList.length];

		for (int i = 0; i < teamList.length; i++)
		{

			sum += 220 - teamList[(int) i].getAthlteAge();
			MhrList[i] = sum;
		}
		return MhrList;
	}

	/**
	 * creates an array of all Heights within a team and scans through it for the
	 * smallest value then outputs it all the way up to the largest value in the
	 * list
	 */
	public static double[] makeHeight()
	{
		double[] heightList = new double[teamList.length];

		for (int i = 0; i < teamList.length; i++)
		{

			heightList[i] = teamList[i].getAthlteHight();

		}

		return heightList;
	}

	public static String[] makeNameList()
	{
		String[] mhr = new String[teamList.length];

		for (int i = 0; i < teamList.length; i++)
		{

			mhr[i] = teamList[i].getAthlteName();

		}

		return mhr;
	}

	public static double makeBMI(int count)
	{
		double bmi = teamList[(int) count].getAthlteWeight() * 703
				/ (Math.pow(teamList[(int) count].getAthlteHight(), 2));
		return bmi;
	}

	/**
	 * @return
	 * 
	 *         not established as primarily necessary to the program but implemented
	 *         to reduce redundancy where possible Within other programs pertaining
	 *         to max heart rate
	 */
	public static double makeMHR(int count)
	{
		double mhr = 220 - teamList[(int) count].getAthlteAge();
		return mhr;
	}

	/**
	 * @param count
	 * 
	 *              Categorically organizes BMI so it can be updated with new
	 *              information
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
	 * 
	 *                This method is used after an athlete object has been fully
	 *                updated and is ready to add to the team all it does is take
	 *                the existing athlete class and adds it to an array in team
	 */
	@SuppressWarnings("static-access")
	public void addAthlte(Athlte object)
	{
		String spaceMax = "Team full";
		if (athleteCount < teamList.length)
		{
			this.teamList[athleteCount] = object;
			athleteCount++;
		} else
		{
			System.out.println(spaceMax);
		}

	}

	public static void displaySmallestLargestHeight()
	{
		double[] heightList = makeHeight();
		String[] nameList = makeNameList();

		Arrays.sort(heightList);
		Arrays.sort(nameList);
		System.out.println("Shortest Athlete: ");
		System.out.println(nameList[0] + "-" + heightList[0]);

		System.out.println("Tallest Athlete: ");
		System.out.println(nameList[nameList.length - 1] + "-" + heightList[heightList.length - 1]);

	}

	/**
	 * The highest max heart rate by going through an already existing array of
	 * every athlete heart rate then posts the highest one found with minimal error
	 */
	public static void displayHighestMHR()
	{
		double[] MhrList = makeMHRArry();

		System.out.println("the highest MHR is: " + Math.max(MhrList[0], MhrList.length));

	}

	/**
	 * @return
	 * 
	 *         Pulls the relevant data for calculating max heart rate and outputs
	 *         the average of the teams Collective max heart rates
	 */
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

	// WIP
	/**
	 * @param avrg Pulls the max heart rate of every athlete and displays the ones
	 *             that are above the calculated average as predefined by another
	 *             method
	 */
	public static void displayAthletesAboveAverageMHR(double avrg)
	{

		double[] MhrList = makeMHRArry();
		String[] overAvrg = new String[teamList.length];
		boolean check = false;
		for (int i = 0; i < MhrList.length; i++)
		{
			if (MhrList[i] > avrg)
			{
				overAvrg[i] = teamList[i].getAthlteName();
				check = true;
			}

		}

		if (check == true)
		{

			for (int i = 1; i <= overAvrg.length - 1; i++)
			{
				System.out.print(overAvrg[i]);
			}
			System.out.println("athlete's are above group average MHR");
		} else
		{
			System.out.println("0 athlete's are above group average MHR");
		}

	}

	/**
	 * Pulls the max heart rate of every athlete and displays the ones that are
	 * above the calculated average
	 */
	/**
	 * 
	 */
	public static void displayAthletesOutsideNormalBMI()
	{
		double sum = 0;
		double[] weightIn = new double[teamList.length];
		String[] overAvrg = new String[teamList.length];
		String[] underAvrg = new String[teamList.length];
		// Stores list of bmi's temporarily for use calculating what is outside of the
		// average

		for (int i = 0; i < teamList.length; i++)
		{
			weightIn[i] = makeBMI(i);
		}

		double average = sum / teamList.length;
		boolean posCount = false;
		boolean minCount = false;

		for (int i = 0; i < underAvrg.length; i++)
		{
			if (weightIn[i] > average)
			{
				overAvrg[i] = teamList[i].getAthlteName();

				posCount = true;
			} else if (weightIn[i] < average)
			{
				underAvrg[i] = teamList[i].getAthlteName();

				minCount = true;
			}

		}

		if (minCount == false)
		{
			for (int i = 0; i < underAvrg.length; i++)
			{
				System.out.print(overAvrg[i]);
			}

			System.out.println("athlete is above group average BMI");

		} else if (posCount == false)
		{

			for (int i = 0; i < underAvrg.length; i++)
			{
				System.out.println(underAvrg[i]);
			}

			System.out.println("athlete is below group average BMI");

		} else
		{
			System.out.println("none of athletes are out of average BMI");
		}
	}

	/**
	 * @param fileContent
	 * @throws IOException
	 * 
	 *                     Writes existing athletes in the program to file for
	 *                     demonstration of knowledge with reading and writing to
	 *                     txt
	 */
	void writeAthletesToFile(String fileContent) throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		writer.write(fileContent);
		writer.close();
	}
}
