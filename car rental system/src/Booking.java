import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double calculateTotalCost() {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return days * car.getCostPerDay();
    }

    public void startBooking() {
        car.setAvailable(false);
    }

    public void completeBooking() {
        car.setAvailable(true);
    }
    public Car getCar() {
    return car;
}


    @Override
    public String toString() {
        return "Booking: " + customer.getName() + " rented " + car.getModel() +
                " from " + startDate + " to " + endDate +
                " | Total: $" + calculateTotalCost();
    }
}
