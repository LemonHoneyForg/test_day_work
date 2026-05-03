
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
			Car car = new Car(make, model, price);
			newDealership.addCar(car);
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
	private int maxCars;
	private String name;
	private Car[] carCount = new Car[maxCars];

	Dealership()
	{
		maxCars = 25;
		name = "mike";
	}

	Dealership(String newName, int currentMaxCars)
	{
		this.maxCars = currentMaxCars;
		this.name = newName;
	}

	String getDealershipName()
	{
		return name;
	}

	public void setMax(int newMaxCars)
	{
		this.maxCars = newMaxCars;
	}

	public void setName(String newSetName)
	{
		this.name = newSetName;
	}

	double getMax()
	{
		return maxCars;
	}

	String getName()
	{
		return name;
	}

	public void addCar(Car object)
	{

		for (int i = 0; i < maxCars; i++)
		{
			if (i < maxCars)
			{
				carCount[i] = object;
			} else
			{
				System.out.println("ERROR: lot full");
			}
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
	private String make;
	private String modal;
	private double carCost;

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

	public void setCost(double newCarCost)
	{
		this.carCost = newCarCost;
	}

	public void setMake(String newMake)
	{
		this.make = newMake;
	}

	public void setModal(String newModal)
	{
		this.modal = newModal;
	}

	double getCost()
	{
		return carCost;
	}

	String getMake()
	{
		return make;
	}

	String getModal()
	{
		return modal;
	}

	public void getCarData()
	{

		System.out.println(make + " " + modal);
		System.out.println("cost in dollers $" + carCost);

	}

}
