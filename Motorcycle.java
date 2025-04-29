import java.io.IOException;
import java.util.*;

// By Hunter Leibee
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate, String make, String model, int year) throws IOException{
        super(licensePlate, make, model, year);
    } 

    @Override 
    public double estimateAnnualMaintenanceCost() {
        Calendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);
        int ageOfVehicle = currentYear - super.getYear();
        return 300.0 + (40.0 * ageOfVehicle);
    }
}