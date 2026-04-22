/**
 * 
 */

/**
 * 
 */
public class car_dealer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Dealership square1 = new Dealership();
		car car1 = new car();
		car1.getCarData();
	}

}

class Dealership
{
	int maxCars;
	String name;
	int[] carCount = new int[maxCars];

	Dealership()
	{
		maxCars = 25;
		name = "mike";
	}

	Dealership(int currentMaxCars, String newName)
	{
		maxCars = currentMaxCars;
		name = newName;
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

	public static void makeCarData(String make, String modal, double cost, int[] carCount)
	{
		System.out.println("========== Team Summary==========");
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

class car
{
	String make;
	String modal;
	double carCost;

	car()
	{
		carCost = 50000;
		make = "subaru";
		modal = "outback";
	}

	car(int newCarCost, String newModal, String newMake)
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
