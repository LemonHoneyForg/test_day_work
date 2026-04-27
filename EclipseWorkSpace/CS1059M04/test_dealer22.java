
/**
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */
public class test_dealer22
{

	public static void main(String[] args)
	{
		displayProgramSummary();
		String fileName = "cars1.txt";
		try
		{
			System.out.println("\nTesting file: " + fileName);
			Dealership dealership = new Dealership("CS Dealership", 6);
			dealershipSetUp(fileName, dealership);
			dealership.displayCars();
			System.out.println("\nMost Expensive Car:");
			dealership.displayMostExpensiveCar();
			String outputFileName = dealership.getDealershipName() + ".txt";
			dealership.writeCarsToFile(outputFileName);
		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}
		System.out.println("\nEnd of program");
	}

	public static void dealershipSetUp(String fileName, Dealership newDealership) throws FileNotFoundException
	{
		File inputFile = new File(fileName);
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNext())
		{
			String make = fileScanner.next();
			String model = fileScanner.next();
			double price = fileScanner.nextDouble();
			Car car1 = new Car(make, model, price);
			newDealership.addCar(car1);
		}
		fileScanner.close();
	}

	public static void displayProgramSummary()
	{
		System.out.println("**************************************");
		System.out.println("Dealership and Car Analysis");
		System.out.println("**************************************");
		System.out.println("Reads car data from a file");
		System.out.println("Displays all cars");
		System.out.println("Finds most expensive car");
		System.out.println();
	}

}

class Dealership
{
	int maxCars;
	String name;
	public int[] carCount = new int[maxCars];

	Dealership()
	{
		maxCars = 25;
		name = "mike";
	}

	Dealership(String newName, int currentMaxCars)
	{
		maxCars = currentMaxCars;
		name = newName;
	}

	String getDealershipName()
	{
		return name;
	}

	void setMax(int newMaxCars)
	{
		maxCars = newMaxCars;
	}

	double getMax()
	{
		return maxCars;
	}

	void setName(String newSetName)
	{
		name = newSetName;
	}

	String getName()
	{
		return name;
	}

	public static void addCar()
	{
		try
		{
			for (int i = 0; i < 6; i++)
			{
				carCount[i] = 1;
			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void displayCars(String make, String modal, double cost, int[] carCount)
	{
		System.out.println("========== car Summary==========");
		System.out.println();
		for (int i = 0; i < carCount.length; i++)
		{
			System.out.println(carCount[i]);

		}

	}

	public static boolean isAtMax()
	{
		boolean closedLot = false;

		return closedLot;
	}

}

class Car
{
	String make;
	String modal;
	double carCost;

	Car()
	{
		carCost = 50000;
		make = "subaru";
		modal = "outback";
	}

	Car(String newModal, String newMake, double newCarCost)
	{
		make = newMake;
		modal = newModal;
		carCost = newCarCost;
	}

	double getCost()
	{
		return carCost;
	}

	String getName()
	{
		return make + " " + modal;
	}

	public void getCarData()
	{

		System.out.println(make + " " + modal);
		System.out.println("cost in dollers $" + carCost);
	}

}
