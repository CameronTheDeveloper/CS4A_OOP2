import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public abstract class Vehicle 
{
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    List<Service> serviceHistory;

    //By Doug Kaplan
    public Vehicle(String licensePlate, String make, String model, int year) throws IOException
    {
        if (licensePlate.trim().isEmpty())
        {
            throw new IOException("License Plate is required");
        }
        else if (make.trim().isEmpty())
        {
            throw new IOException("Make is required");
        }
        else if (model.trim().isEmpty())
        {
            throw new IOException("Model is required");
        }
        else if (year >= 2028)
        {
            throw new IOException("Year cannot be greater than 2028");
        }
        else if (year <= 1900)
        {
            //Picked 1900 to protect against accidentally typing things like 1895 instead of 1995 but 
            //what if you are trying to register Hans Hautsch of Nuremburg's clockwork carriage from 1649? 
            //https://en.wikipedia.org/wiki/History_of_the_automobile
            throw new IOException("Year cannot be less than 1900");
        }


        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.serviceHistory = new ArrayList<>();
    }

     //Getters
    public String getLicensePlate() {return licensePlate;}
    public String getMake() {return make;}
    public String getModel() {return model;}
    public int getYear() {return year;}
    public List<Service> getServiceHistory() {return serviceHistory;}
    
    //Setters
    public void setLicensePlate(String licensePlate) throws IOException 
    {
        if (licensePlate.trim().isEmpty()) 
        {
            throw new IOException("License Plate is required");
        }
        this.licensePlate = licensePlate;
    }
    
    public void setMake(String make) throws IOException 
    {
        if (make.trim().isEmpty()) 
        {
            throw new IOException("Make is required");
        }
        this.make = make;
    }
    
    public void setModel(String model) throws IOException 
    {
        if (model.trim().isEmpty()) 
        {
            throw new IOException("Model is required");
        }
        this.model = model;
    }
    
    public void setYear(int year) throws IOException 
    {
        if (year >= 2028) 
        {
            throw new IOException("Year cannot be greater than 2028");
        } else if (year <= 1900) 
        {
            throw new IOException("Year cannot be less than 1900");
        }
        this.year = year;
    }
    
    public void addService(Service service) 
    {
        if (service != null) 
        {
            serviceHistory.add(service);
        }
    }

    abstract double estimateAnnualMaintenanceCost();

    String getSummary()
    {
        System.out.println("Summary:\n");

        for (Service e : serviceHistory)
        {
            System.out.println(e);
        }
    }


}