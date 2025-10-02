import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Booking> bookings;

    public RentalAgency() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // ---- Car Management ----
    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findCarById(String reg) {
        for (Car c : cars) {
            if (c.getRegistrationNumber().equals(reg)) return c;
        }
        return null;
    }

    // ---- Customer Management ----
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerById(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(id)) return c;
        }
        return null;
    }

    // ---- Bookings ----
    public void rentCar(Customer customer, Car car, LocalDate start, LocalDate end) {
        if (car.isAvailable()) {
            Booking booking = new Booking(customer, car, start, end);
            booking.startBooking(); // mark car as unavailable
            bookings.add(booking);
            System.out.println("✅ Booking successful for " + customer.getName() +
                    " with car " + car.getRegistrationNumber());
            System.out.println("   " + booking);
        } else {
            System.out.println("❌ Car " + car.getRegistrationNumber() + " is not available.");
        }
    }

    public void returnCar(Booking booking) {
        booking.completeBooking(); // mark car as available
        System.out.println("✅ Car " + booking.getCar().getRegistrationNumber() + " returned successfully.");
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void listCars() {
        System.out.println("Available Cars:");
        for (Car c : cars) {
            System.out.println(c);
        }
    }

    public void listCustomers() {
        System.out.println("Registered Customers:");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
