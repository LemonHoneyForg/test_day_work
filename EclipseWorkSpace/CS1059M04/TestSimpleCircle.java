public class TestSimpleCircle
{
	/** Main method */
	public static void main(String[] args)
	{
		// Create a circle with radius 1
		SimpleCircle circle1 = new SimpleCircle();
		System.out.println("The area of the circle of radius " + circle1.radius + " is " + circle1.getArea());

		// Create a circle with radius 25
		SimpleCircle circle2 = new SimpleCircle(25);
		System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());

		// Create a circle with radius 125
		SimpleCircle circle3 = new SimpleCircle(125);
		System.out.println("The area of the circle of radius " + circle3.radius + " is " + circle3.getArea());

		// Modify circle radius
		circle2.radius = 100; // or circle2.setRadius(100)
		System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());

		// Create a circle with radius 1
		SimpleCircle square1 = new SimpleCircle();
		System.out.println("The area of the circle of radius " + square1.radius + " is " + square1.getArea());

		// Create a circle with radius 25
		SimpleCircle square2 = new SimpleCircle(25);
		System.out.println("The area of the circle of radius " + square2.radius + " is " + square2.getArea());

		// Create a circle with radius 125
		SimpleCircle square3 = new SimpleCircle(125);
		System.out.println("The area of the circle of radius " + square3.radius + " is " + square3.getArea());

		// Modify circle radius
		square2.radius = 100; // or circle2.setRadius(100)
		System.out.println("The area of the circle of radius " + square2.radius + " is " + square2.getArea());

	}
}

// Define the circle class with two constructors
class SimpleCircle
{
	double radius;

	/** Construct a circle with radius 1 */
	SimpleCircle()
	{
		radius = 1;
	}

	/** Construct a circle with a specified radius */
	SimpleCircle(double newRadius)
	{
		radius = newRadius;
	}

	/** Return the area of this circle */
	double getArea()
	{
		return radius * radius * Math.PI;
	}

	/** Return the perimeter of this circle */
	double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}

	/** Set a new radius for this circle */
	void setRadius(double newRadius)
	{
		radius = newRadius;
	}
}

class SimpleSquare
{
	double sideSize;

	/** Construct a circle with radius 1 */
	SimpleSquare()
	{
		sideSize = 1;

	}

	SimpleSquare(double newRadius)
	{
		sideSize = newRadius;
	}

	/** Return the area of this circle */
	double getArea()
	{
		return Math.pow(sideSize, 2);
	}

	/** Return the perimeter of this circle */
	double getPerimeter()
	{
		return 4 * sideSize;
	}

	/** Set a new radius for this circle */
	void setRadius(double newRadius)
	{
		sideSize = newRadius;
	}
}