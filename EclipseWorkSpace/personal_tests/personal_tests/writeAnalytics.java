/**
 * 
 */
package personal_tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/*

/**
 * 
 */
public class writeAnalytics
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static void WriteAnylitcs()
	{

	}

	public static void writeAnalysis(Team team) throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");
		String outputFileName = team.getTeamName() + ".txt";
		writer.write("\n========== Team Analysis ==========");
		writer.write("Team: " + team.getTeamName());
		writer.write("Total Athletes: " + team.getAthleteCount());
		writer.write("\n");

		team.writeAthleteResults();
		team.writeAthletesOutsideNormalBMI();
//
		double avg = team.calculateAverageMaxHeartRate();
		writer.write(String.valueOf("\nAverage Max Heart Rate: " + avg));
//
		team.writeAthletesAboveAverageMHR((int) avg);
		team.writeHighestMHR();
		team.writeSmallestLargestHeight();

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

	void displayAthleteResults()
	{
		System.out.println("========== Team Summary==========");
		System.out.println();

		System.out.print(getAthlteName());
		System.out.printf("BMI: %.2f", calculateBMI());
		System.out.println();
		System.out.print("Catagory: ");
		bmiCatagorys(calculateBMI());
		System.out.println("MHR: " + calculateBMI());
		System.out.println();
		System.out.println();

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
	private String teamName;
	public Athlte[] teamList = new Athlte[4];

	Team()
	{
		teamName = "luna";
		teamList = new Athlte[4];
		athleteCount = 0;
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

	void writeAthleteResults() throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		writer.write("========== Team Summary==========");
		writer.write("\n");
		for (int i = 0; i < teamList.length; i++)
		{
			writer.write(teamList[i].getAthlteName());
			writer.write("\n BMI: %.2f");
			writer.write(String.valueOf(teamList[i].calculateBMI()));
			writer.write("\n");
			writer.write("Catagory: ");
			writer.write(teamList[i].bmiCatagorys(teamList[i].calculateBMI()));

			writer.write("MHR: " + teamList[i].calculateMaxHeartRate());
			writer.write("\n");
			writer.write("\n");
		}

	}

	public int calculateAverageMaxHeartRate()
	{
		int sum = 0;

		for (int i = 0; i < teamList.length; i++)
		{

			sum += teamList[i].calculateMaxHeartRate();
			sum = sum / teamList.length;
		}
		return sum;
	}

	public String[] makeNameList()
	{
		String[] nameList = new String[teamList.length];

		for (int i = 0; i < teamList.length; i++)
		{

			nameList[i] = teamList[i].getAthlteName();

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
		if (athleteCount < teamList.length)
		{
			this.teamList[athleteCount] = object;
			athleteCount++;
		} else
		{
			System.out.println(spaceMax);
		}

	}

	public double[] makeHeight()
	{
		double[] heightList = new double[teamList.length];

		for (int i = 0; i < teamList.length; i++)
		{

			heightList[i] = teamList[i].getAthlteHight();

		}

		return heightList;
	}

	public void writeSmallestLargestHeight() throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		double[] heightList = makeHeight();
		String[] nameList = makeNameList();

		Arrays.sort(heightList);
		Arrays.sort(nameList);
		writer.write("Shortest Athlete: ");
		writer.write(nameList[0] + "-" + heightList[0]);

		writer.write("Tallest Athlete: ");
		writer.write(nameList[nameList.length - 1] + "-" + heightList[heightList.length - 1]);

	}

	/**
	 * The highest max heart rate by going through an already existing array of
	 * every athlete heart rate then posts the highest one found with minimal error
	 * 
	 * @throws IOException
	 */
	public void writeHighestMHR() throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		writer.write("the highest MHR is: " + Math.max(teamList[0].calculateMaxHeartRate(), teamList.length));

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
	public void writeAthletesAboveAverageMHR(int avrg) throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		int[] MhrList = new int[athleteCount];
		for (int i = 0; i < teamList.length; i++)
		{
			MhrList[i] = teamList[i].calculateMaxHeartRate();
		}
		String[] overAvrg = new String[teamList.length];
		boolean check = false;
		for (int i = 0; i < teamList.length; i++)
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
				writer.write(String.valueOf(overAvrg[i]));
			}
			writer.write("athlete's are above group average MHR");
		} else
		{
			writer.write("0 athlete's are above group average MHR");
		}

	}

	public void writeAthletesOutsideNormalBMI() throws IOException
	{
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		double sum = 0;
		double[] weightIn = new double[teamList.length];
		String[] overAvrg = new String[teamList.length];
		String[] underAvrg = new String[teamList.length];
		// Stores list of bmi's temporarily for use calculating what is outside of the
		// average

		for (int i = 0; i < teamList.length; i++)
		{
			weightIn[i] = teamList[i].calculateBMI();
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
				writer.write(String.valueOf((overAvrg[i])));
			}

			writer.write("athlete is above group average BMI");

		} else if (posCount == false)
		{

			for (int i = 0; i < underAvrg.length; i++)
			{
				writer.write(String.valueOf(underAvrg[i]));
			}

			writer.write("athlete is below group average BMI");

		} else
		{
			writer.write("none of athletes are out of average BMI");
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
		System.out.println("Results written to file:");
		System.out.println("C:\\\\GitHub Repos\\\\JavaRepo\\\\EclipseWorkSpace\\\\personal_tests\\\\newfile.txt");

		writer.write(fileContent);
		writer.close();
	}
}
