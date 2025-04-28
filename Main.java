import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try {
            // Create a Car
            Car car = new Car("CAR123", "Honda", "Civic", 2016);
            car.addService(new Service("Oil Change", 79.99, "03-01-2024"));
            car.addService(new Service("Tire Rotation", 49.99, "04-15-2024"));
            vehicles.add(car);

            // Create a Truck
            Truck truck = new Truck("TRK456", "Ford", "F-150", 2012);
            truck.addService(new Service("Brake Replacement", 300.00, "02-20-2024"));
            vehicles.add(truck);

            // Create a Motorcycle
            Motorcycle motorcycle = new Motorcycle("MOTO789", "Yamaha", "YZF-R3", 2020);
            motorcycle.addService(new Service("Chain Adjustment", 60.00, "01-10-2024"));
            motorcycle.addService(new Service("Oil Change", 45.00, "02-15-2024"));
            vehicles.add(motorcycle);

            // Display maintenance estimates
            System.out.println("Vehicle Maintenance Estimates:");
            for (Vehicle v : vehicles) {
                System.out.println(v.getMake() + " " + v.getModel() + " (" + v.getYear() + ")");
                System.out.println("License Plate: " + v.getLicensePlate());
                System.out.println("Estimated Annual Maintenance Cost: $" + v.estimateAnnualMaintenanceCost());
                System.out.println();
            }

            // Display service history for each vehicle
            System.out.println("Service Histories:");
            for (Vehicle v : vehicles) {
                System.out.println(v.getMake() + " " + v.getModel() + ":");
                System.out.println(v.getSummary());
            }

        } catch (IOException e) {
            System.out.println("Vehicle creation error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Service creation error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
