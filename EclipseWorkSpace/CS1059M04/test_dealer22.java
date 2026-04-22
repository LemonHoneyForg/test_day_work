/**
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;

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
