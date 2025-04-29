import java.io.IOException;
import java.util.*;

// By Hunter Leibee
class Truck extends Vehicle {
    public Truck(String licensePlate, String make, String model, int year) throws IOException{
        super(licensePlate, make, model, year);
    } 

    @Override 
    public double estimateAnnualMaintenanceCost() {
        Calendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);
        int ageOfVehicle = currentYear - super.getYear();
        return 800.0 + (100.0 * ageOfVehicle);
    }
}