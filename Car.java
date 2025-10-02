public class Car {
    private String registrationNumber;
    private String model;
    private String modelYear;
    private boolean available;
    private double costPerDay;

    public Car(String registrationNumber, String model, String modelYear, double costPerDay) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.modelYear = modelYear;
        this.costPerDay = costPerDay;
        this.available = true;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public String getModel() { return model; }
    public String getRegistrationNumber() { return registrationNumber; }
    public double getCostPerDay() { return costPerDay; }

    @Override
    public String toString() {
        return model + " (" + registrationNumber + ") - " + (available ? "Available" : "Rented") +
                ", Cost/Day: $" + costPerDay;
    }
}
