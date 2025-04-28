import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Service {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    private String description;
    private double cost;
    private LocalDate date;

    public Service(String description, double cost, String date){
        if(description.isEmpty()){
            System.out.println("Cannot have a blank description.");
        }
        else{
            this.description = description;
        }

        if(cost < 0){
            System.out.println("Cannot have a negative cost.");
        }
        else{
            this.cost = cost;
        }

        if(date.isEmpty()){
            System.out.println("Cannot have a blank date.");
        }
        else{
            try {
                this.date = LocalDate.parse(date, FORMATTER);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Please use MM-dd-yyyy.");
            }
        }
    }

    public void setDescription(String description){
        if(description.isEmpty()){
            System.out.println("Cannot have a blank description.");
        }
        else{
            this.description = description;
        }
    }

    public String getDescription(){
        return this.description;
    }

    public void setCost(double cost){
        if(cost < 0){
            System.out.println("Cannot have a negative cost.");
        }
        else{
            this.cost = cost;
        }
    }

    public double getCost(){
        return this.cost;
    }

    public void setDate(String date){
        if(date.isEmpty()){
            System.out.println("Cannot have a blank date.");
        }
        else{
            try {
                this.date = LocalDate.parse(date, FORMATTER);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Please use MM-dd-yyyy.");
            }
        }
    }

    public LocalDate getDate(){
        return this.date;
    }

    @Override
    public String toString(){
        return "\nService Type: " + this.description 
        + "\nCost: $" + String.format("%.2f", this.cost) 
        + "\nDate: " + date.format(FORMATTER);
    }
}