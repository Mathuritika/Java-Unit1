class Vehicle {
    String brand, model;
    double price;

    Vehicle(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}
class Car extends Vehicle {
    int seatingCapacity;
    String fuelType;

    Car(String brand, String model, double price, int seatingCapacity, String fuelType) {
        super(brand, model, price);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    double chargingTime;

    ElectricCar(String brand, String model, double price, int seatingCapacity, String fuelType, int batteryCapacity, double chargingTime) {
        super(brand, model, price, seatingCapacity, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging Time: " + chargingTime + " hours");
    }
}

class Motorcycle extends Vehicle {
    int engineCapacity;
    String type;

    Motorcycle(String brand, String model, double price, int engineCapacity, String type) {
        super(brand, model, price);
        this.engineCapacity = engineCapacity;
        this.type = type;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
        System.out.println("Type: " + type);
    }
}

public class VehicleHierarchy {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 30000, 5, "Petrol");
        ElectricCar eCar = new ElectricCar("Tesla", "Model 3", 50000, 5, "Electric", 75, 6.5);
        Motorcycle bike = new Motorcycle("Harley-Davidson", "Iron 883", 10000, 883, "Cruiser");
        
        System.out.println("Car Details:");
        car.displayDetails();
        System.out.println();
        
        System.out.println("Electric Car Details:");
        eCar.displayDetails();
        System.out.println();
        
        System.out.println("Motorcycle Details:");
        bike.displayDetails();
    }
}
