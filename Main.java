import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        System.out.println("===== Car Rental System =====");
        if (!login.authenticate()) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        RentalAgency agency = new RentalAgency();

        // Add sample cars & customers (✅ now with correct parameters)
        agency.addCar(new Car("KAA123", "Toyota Corolla", "2020", 40.0));
        agency.addCar(new Car("KBB456", "Honda Civic", "2019", 35.0));
        agency.addCustomer(new Customer("C001", "John Doe", "0712345678"));
        agency.addCustomer(new Customer("C002", "Jane Smith", "0798765432"));

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. List Cars");
            System.out.println("2. List Customers");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Last Car");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    agency.listCars();
                    break;

                case 2:
                    agency.listCustomers();
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    String customerId = sc.nextLine();
                    System.out.print("Enter Car Registration: ");
                    String carId = sc.nextLine();
                    System.out.print("Enter Start Date (yyyy-MM-dd): ");
                    String startStr = sc.nextLine();
                    System.out.print("Enter End Date (yyyy-MM-dd): ");
                    String endStr = sc.nextLine();

                    Customer customer = agency.findCustomerById(customerId);
                    Car car = agency.findCarById(carId);

                    if (customer != null && car != null) {
                        LocalDate startDate = LocalDate.parse(startStr, fmt);
                        LocalDate endDate = LocalDate.parse(endStr, fmt);
                        agency.rentCar(customer, car, startDate, endDate);
                    } else {
                        System.out.println("❌ Invalid Customer ID or Car ID!");
                    }
                    break;

                case 4:
                    if (!agency.getBookings().isEmpty()) {
                        Booking lastBooking = agency.getBookings().get(agency.getBookings().size() - 1);
                        agency.returnCar(lastBooking);
                    } else {
                        System.out.println("❌ No bookings found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
