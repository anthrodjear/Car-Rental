# 🚗 Car Rental System (Java, OOP) + Login Program

## 📌 Project Description
This project is developed as part of **Object-Oriented Programming II Assignment**.  
It implements a **Car Rental System** using Java OOP principles and a **Login system** with masked password input.

### Features
- **Login System**
  - Username + password authentication
  - Password masked as `*`
  - Max **3 login attempts**
- **Car Rental System**
  - Add Customers
  - List available Cars
  - Rent a Car
  - Return a Car
  - Calculate rental cost by days
- **OOP Concepts**
  - Classes: `Car`, `Customer`, `Booking`, `RentalAgency`
  - Encapsulation (private fields, getters/setters)
  - Composition (Agency has Cars, Customers, Bookings)
  - Test cases with different scenarios

---

## 🏗️ UML Class Diagram
Below is a simplified UML diagram for the system:

```plaintext
+----------------+         +----------------+
|   Customer     |         |      Car       |
+----------------+         +----------------+
| -customerId    |         | -registration  |
| -name          |         | -model         |
| -phoneNumber   |         | -year          |
+----------------+         | -available     |
| +getName()     |         | +isAvailable() |
+----------------+         +----------------+
        |                          |
        |                          |
        +-----------+--------------+
                    |
              +-----v------+
              |  Booking   |
              +------------+
              | -customer  |
              | -car       |
              | -startDate |
              | -endDate   |
              +------------+
              | +calculate |
              +------------+
                    |
             +------v-------+
             | RentalAgency |
             +--------------+
             | -cars        |
             | -customers   |
             | -bookings    |
             +--------------+
             | +rentCar()   |
             | +returnCar() |
             | +listCars()  |
             +--------------+
