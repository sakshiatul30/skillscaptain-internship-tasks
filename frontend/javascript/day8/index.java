import java.util.ArrayList;
import java.util.Scanner;

// Abstract class
abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void displayDetails();
}

// Car subclass
class Car extends Vehicle {
    private int numDoors;
    private String fuelType;

    public Car(String make, String model, int year, double price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    public double calculateMileage() {
        return fuelType.equalsIgnoreCase("Diesel") ? 20 : 15;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car | " + make + " " + model +
                " | Year: " + year +
                " | Price: ₹" + price +
                " | Doors: " + numDoors +
                " | Fuel: " + fuelType +
                " | Mileage: " + calculateMileage() + " km/l");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCapacity;

    public Motorcycle(String make, String model, int year, double price, boolean hasSidecar, int engineCapacity) {
        super(make, model, year, price);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    public int calculateSpeed() {
        return engineCapacity * 2;
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle | " + make + " " + model +
                " | Year: " + year +
                " | Price: ₹" + price +
                " | Engine: " + engineCapacity + "cc" +
                " | Sidecar: " + hasSidecar +
                " | Speed: " + calculateSpeed() + " km/h");
    }
}

// Main class
public class Main {
    static ArrayList<Vehicle> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        inventory.add(new Car("Honda", "City", 2022, 1200000, 4, "Petrol"));
        inventory.add(new Motorcycle("Yamaha", "R15", 2023, 180000, false, 155));

        System.out.println("=== Vehicle Inventory ===");
        for (Vehicle v : inventory) {
            v.displayDetails();
        }
    }
}
