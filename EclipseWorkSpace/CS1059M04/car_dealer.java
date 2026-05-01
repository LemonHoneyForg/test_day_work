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
		Car car1 = new Car();
		Dealership.addCar(car1.getCarData());
	}

}

class Dealership
{
	int maxCars;
	String name;
	public Car[] carCount = new Car[maxCars];

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

	void setName(String newSetName)
	{
		name = newSetName;
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
	String make;
	String modal;
	double carCost;

	Car()
	{

		make = "subaru";
		modal = "outback";
		carCost = 50000;
	}

	Car(String newMake, String newModal, double newCarCost)
	{
		make = newMake;
		modal = newModal;
		carCost = newCarCost;
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
