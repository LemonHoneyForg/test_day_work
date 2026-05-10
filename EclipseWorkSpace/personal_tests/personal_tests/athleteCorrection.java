/**
 * 
 */
package personal_tests;

/**
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 
 */

public class athleteCorrection
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

		String fileName = "team1.txt";
		try
		{
			fileName = "team1.txt";
			System.out.println("\nTesting file: " + fileName);

			Team team = new Team("Nuggets", 6);

			teamSetUp(fileName, team);

			runAnalysis(team);
			writeAnalysis(fileName, team);
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
			writeAnalysis(fileName, team);
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
	public static void teamSetUp(String fileName, Team team) throws FileNotFoundException
	{
		File file1 = new File("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\CS1059M04\\" + fileName);
		Scanner scan = new Scanner(file1);
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
	public static void runAnalysis(Team team) throws IOException
	{
		System.out.println("\n========== Team Analysis ==========");
		System.out.println("Team: " + team.getTeamName());
		System.out.println("Total Athletes: " + team.getTeamSize());
		System.out.println();

		team.displayAthleteResults();
		team.displayAthletesOutsideNormalBMI();
//
		double avg = team.calculateAverageMaxHeartRate();
		System.out.println("\nAverage Max Heart Rate: " + avg);
//
		team.displayAthletesAboveAverageMHR((int) avg);
		team.displayHighestMHR();
		team.displaySmallestLargestHeight();

	}

	/**
	 * @param fileName
	 * @param team
	 * @throws IOException
	 * 
	 *                     the back_end version of runAnalysis. does the same
	 *                     operation just writes to file for later use
	 */
	public static void writeAnalysis(String fileName, Team team) throws IOException
	{

		String outputFileName = "";
		outputFileName += "\n" + fileName + ".txt \t";
		outputFileName += team.writeAthleteResults(outputFileName);
		outputFileName += team.writeAthletesOutsideNormalBMI(outputFileName);
//
		double avg = team.calculateAverageMaxHeartRate();
		outputFileName += (String.valueOf("\nAverage Max Heart Rate: " + avg));
//
		outputFileName += team.writeAthletesAboveAverageMHR((int) avg, outputFileName);
		outputFileName += team.writeHighestMHR(outputFileName);
		outputFileName += team.writeSmallestLargestHeight(outputFileName);
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
	private double bmi;
	private int mhr;
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

	int getAthlteAge()
	{
		return this.age;
	}

	double getAthlteHight()
	{
		return this.hight;
	}

	int calculateMaxHeartRate()
	{
		mhr = 220 - getAthlteAge();
		return this.mhr;
	}

	double calculateBMI()
	{

		bmi = getAthlteWeight() * 703 / (Math.pow(getAthlteHight(), 2));
		;
		return this.bmi;
	}

	/**
	 * @param count
	 * 
	 *              Categorically organizes BMI so it can be updated with new
	 *              information
	 */
	public String bmiCatagorys(double count)
	{
		String catagorys = "";
		final double BMI_OVER_FACTOR = 25;

		final double BMI_STANDARD_FACTOR = 18.5;

		if (count >= BMI_OVER_FACTOR)
		{
			catagorys = "High";
		} else if (count >= BMI_STANDARD_FACTOR)
		{
			System.out.println("Normal");
			catagorys = "Normal";
		} else if (count <= BMI_STANDARD_FACTOR)
		{
			System.out.println("Underweight");
			catagorys = "Underweight";
		}

		return catagorys;
	}

	/**
	 * Pulls the max heart rate of every athlete and displays the ones that are
	 * above the calculated average
	 */
	/**
	 * 
	 */

	/**
	 * creates an array of all Heights within a team and scans through it for the
	 * smallest value then outputs it all the way up to the largest value in the
	 * list
	 */

}

// ================= ADD TEAM CLASS =================
/**
 * 
 */
class Team
{

	private int athleteCount;
	private int teamSize;
	private String teamName;
	private Athlte[] teamList;

	Team()
	{
		this.teamName = "luna";
		this.teamSize = 6;
		this.teamList = new Athlte[teamSize];
		this.athleteCount = 0;

	}

	Team(String newName, int newTeamSize)
	{
		this.teamName = newName;
		this.teamList = new Athlte[newTeamSize];
		this.teamSize = newTeamSize;
	}

	String getTeamName()
	{
		return this.teamName;
	}

	int getAthleteCount()
	{
		return this.athleteCount;
	}

	int getTeamSize()
	{
		return this.teamSize;
	}

	void displayAthleteResults()
	{
		System.out.println("========== Team Summary==========");
		System.out.println();
		for (int i = 0; i < this.teamList.length; i++)
		{
			System.out.print(this.teamList[i].getAthlteName());
			System.out.printf("BMI: %.2f", this.teamList[i].calculateBMI());
			System.out.println();
			System.out.print("Catagory: ");
			this.teamList[i].bmiCatagorys(this.teamList[i].calculateBMI());
			System.out.println("MHR: " + this.teamList[i].calculateBMI());
			System.out.println();
			System.out.println();
		}
	}

	public String writeAthleteResults(String fileContent) throws IOException
	{
		DecimalFormat df = new DecimalFormat("0.00");
		fileContent += "\n========== Team Summary==========";

		for (int i = 0; i < this.teamList.length; i++)
		{
			fileContent += ("\n" + this.teamList[i].getAthlteName());
			fileContent += ("\n BMI: ");
			fileContent += ("\n " + String.valueOf(df.format(this.teamList[i].calculateBMI())));
			fileContent += ("\n Category: ");
			fileContent += ("\n" + this.teamList[i].bmiCatagorys(this.teamList[i].calculateBMI()));

			fileContent += ("\nMHR: " + this.teamList[i].calculateMaxHeartRate());

		}
		return fileContent;
	}

	public int calculateAverageMaxHeartRate()
	{
		int sum = 0;

		for (int i = 0; i < this.teamList.length; i++)
		{

			sum += this.teamList[i].calculateMaxHeartRate();
			sum = sum / this.teamList.length;
		}
		return sum;
	}

	public String[] makeNameList()
	{
		String[] nameList = new String[this.teamList.length];

		for (int i = 0; i < this.teamList.length; i++)
		{

			nameList[i] = this.teamList[i].getAthlteName();

		}

		return nameList;
	}

	/**
	 * @param object
	 * @param counter
	 * 
	 *                This method is used after an athlete object has been fully
	 *                updated and is ready to add to the team all it does is take
	 *                the existing athlete class and adds it to an array in team
	 */

	public void addAthlte(Athlte object)
	{
		String spaceMax = "Team full";
		if (this.athleteCount < this.teamList.length)
		{
			this.teamList[athleteCount] = object;
			this.athleteCount++;
		} else
		{
			System.out.println(spaceMax);
		}

	}

	public double[] makeHeight()
	{
		double[] heightList = new double[this.teamList.length];

		for (int i = 0; i < this.teamList.length; i++)
		{

			heightList[i] = this.teamList[i].getAthlteHight();

		}

		return heightList;
	}

	public void displaySmallestLargestHeight()
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
	public void displayHighestMHR()
	{
		System.out.println(
				"the highest MHR is: " + Math.max(this.teamList[0].calculateMaxHeartRate(), this.teamList.length));

	}

	/**
	 * @return
	 * 
	 *         Pulls the relevant data for calculating max heart rate and outputs
	 *         the average of the teams Collective max heart rates
	 */

	// WIP
	/**
	 * @param avrg Pulls the max heart rate of every athlete and displays the ones
	 *             that are above the calculated average as predefined by another
	 *             method
	 */
	public void displayAthletesAboveAverageMHR(int avrg)
	{
		int[] MhrList = new int[athleteCount];
		for (int i = 0; i < this.teamList.length; i++)
		{
			MhrList[i] = this.teamList[i].calculateMaxHeartRate();
		}
		String[] overAvrg = new String[this.teamList.length];
		boolean check = false;
		for (int i = 0; i < this.teamList.length; i++)
		{
			if (MhrList[i] > avrg)
			{
				overAvrg[i] = this.teamList[i].getAthlteName();
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

	public void displayAthletesOutsideNormalBMI()
	{
		double sum = 0;
		double[] weightIn = new double[this.teamList.length];
		String[] overAvrg = new String[this.teamList.length];
		String[] underAvrg = new String[this.teamList.length];
		// Stores list of bmi's temporarily for use calculating what is outside of the
		// average

		for (int i = 0; i < this.teamList.length; i++)
		{
			weightIn[i] = this.teamList[i].calculateBMI();
		}

		double average = sum / this.teamList.length;
		boolean posCount = false;
		boolean minCount = false;

		for (int i = 0; i < underAvrg.length; i++)
		{
			if (weightIn[i] > average)
			{
				overAvrg[i] = this.teamList[i].getAthlteName();

				posCount = true;
			} else if (weightIn[i] < average)
			{
				underAvrg[i] = this.teamList[i].getAthlteName();

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

	public String writeSmallestLargestHeight(String fileContent) throws IOException
	{

		double[] heightList = makeHeight();
		String[] nameList = makeNameList();

		Arrays.sort(heightList);
		Arrays.sort(nameList);

		fileContent += ("\n Shortest Athlete: ");
		fileContent += ("\n" + nameList[0] + "-" + heightList[0]);

		fileContent += ("\n Tallest Athlete: ");
		fileContent += ("\n" + nameList[nameList.length - 1] + "-" + heightList[heightList.length - 1]);
		return fileContent;
	}

	/**
	 * The highest max heart rate by going through an already existing array of
	 * every athlete heart rate then posts the highest one found with minimal error
	 * 
	 * @throws IOException
	 */
	public String writeHighestMHR(String fileContent) throws IOException
	{

		fileContent += (" \nthe highest MHR is: "
				+ Math.max(this.teamList[0].calculateMaxHeartRate(), this.teamList.length));

		return fileContent;
	}

	/**
	 * @return
	 * 
	 *         Pulls the relevant data for calculating max heart rate and outputs
	 *         the average of the teams Collective max heart rates
	 */

	// WIP
	/**
	 * @param avrg Pulls the max heart rate of every athlete and displays the ones
	 *             that are above the calculated average as predefined by another
	 *             method
	 * @throws IOException
	 */
	public String writeAthletesAboveAverageMHR(int avrg, String fileContent) throws IOException
	{

		int[] MhrList = new int[this.teamList.length];
		for (int i = 0; i < this.teamList.length; i++)
		{
			MhrList[i] = this.teamList[i].calculateMaxHeartRate();
		}
		String[] overAvrg = new String[this.teamList.length];
		boolean check = false;
		for (int i = 0; i < this.teamList.length; i++)
		{
			if (MhrList[i] > avrg)
			{
				overAvrg[i] = this.teamList[i].getAthlteName();
				check = true;
			}

		}

		if (check == true)
		{

			for (int i = 1; i <= overAvrg.length - 1; i++)
			{
				fileContent += ("\n" + String.valueOf(overAvrg[i]));
			}
			fileContent += ("\n athlete's are above group average MHR");
		} else
		{
			fileContent += ("\n 0 athlete's are above group average MHR");
		}
		return fileContent;
	}

	public String writeAthletesOutsideNormalBMI(String fileContent) throws IOException
	{
		double sum = 0;
		double[] weightIn = new double[this.teamList.length];
		String[] overAvrg = new String[this.teamList.length];
		String[] underAvrg = new String[this.teamList.length];
		// Stores list of bmi's temporarily for use calculating what is outside of the
		// average

		for (int i = 0; i < this.teamList.length; i++)
		{
			weightIn[i] = this.teamList[i].calculateBMI();
		}

		double average = sum / this.teamList.length;
		boolean posCount = false;
		boolean minCount = false;

		for (int i = 0; i < underAvrg.length; i++)
		{
			if (weightIn[i] > average)
			{
				overAvrg[i] = this.teamList[i].getAthlteName();

				posCount = true;
			} else if (weightIn[i] < average)
			{
				underAvrg[i] = this.teamList[i].getAthlteName();

				minCount = true;
			}

		}

		if (minCount == false)
		{
			for (int i = 0; i < underAvrg.length; i++)
			{
				fileContent += ("\n" + String.valueOf((overAvrg[i])));
			}

			fileContent += ("\n athlete is above group average BMI");

		} else if (posCount == false)
		{

			for (int i = 0; i < underAvrg.length; i++)
			{
				fileContent += ("\n" + String.valueOf(underAvrg[i]));
			}

			fileContent += ("\n athlete is below group average BMI");

		} else
		{
			fileContent += ("\n none of athletes are out of average BMI");
		}
		return fileContent;
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
		System.out.println("Results written to file:");
		System.out.println("C:\\\\GitHub Repos\\\\JavaRepo\\\\EclipseWorkSpace\\\\personal_tests\\\\newfile.txt");

		writer.write(fileContent);

		writer.close();
	}
}