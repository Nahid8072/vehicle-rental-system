import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class VehicleRentalSystem {
    private Map<String, Account> accountMap = new HashMap<>(); // To store registered accounts

    // Register a new customer
    public Account registerCustomer(String name, String email, String phoneNumber) {
        Customer customer = new Customer(name, email, phoneNumber);
        Account account = new Account(customer);
        accountMap.put(account.getAccountId(), account); // Store account with accountId as key
        System.out.println("Customer registered successfully!");
        System.out.println(account.toString());
        return account;
    }

    // Check if a customer is registered by name and accountId
    public boolean isRegisteredCustomer(String name, String accountId) {
        if (accountMap.containsKey(accountId)) {
            Account account = accountMap.get(accountId);
            return account.getCustomer().getName().equalsIgnoreCase(name);
        }
        return false;
    }
    // Book a vehicle for a registered customer
    public void bookVehicle(String name, String accountId) {
/*        if (isRegisteredCustomer(name, accountId)) {*/
            RentalSystem rentalSystem = new RentalSystem();

            Vehicle car = new Vehicle("Toyota", "Premio", 2020, 100);
            Vehicle motorbike = new Vehicle("Honda", "XBlade", 2020, 50);
            Vehicle truck = new Vehicle("Hino", "AK-1J", 2018, 200);

            rentalSystem.addVehicle(car);
            rentalSystem.addVehicle(motorbike);
            rentalSystem.addVehicle(truck);

            while (true) {
                Scanner scanner = new Scanner(System.in);
                //Options for the user
                System.out.println();
                System.out.println("===== Vehicle Rental System =====");
                System.out.println("1. Rent a Vehicle");
                System.out.println("2. Return a Vehicle");
                System.out.println("3. Display Rental Information");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        //Rent a vehicle
                        System.out.print("Enter the vehicle Brand: ");
                        String make = scanner.nextLine();
                        System.out.print("Enter the vehicle model: ");
                        String model = scanner.nextLine();

                        Vehicle selectedVehicle = null;

                        //Checks the vehicles in available vehicles
                        for (Vehicle v : rentalSystem.getAvailableVehicles()) {
                            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                                selectedVehicle = v;
                            }

                        }

                        if (selectedVehicle != null) {
                            //Add the vehicle to rented vehicles
                            rentalSystem.rentVehicle(selectedVehicle);
                            System.out.print("Enter the rental duration in days: ");
                            int rentalDuration = scanner.nextInt();
                            //Calculate total rental cost
                            double rc = rentalSystem.calculateRentalCost(selectedVehicle, rentalDuration);
                            System.out.println("Successfully rented.");
                            System.out.println("Total rental Cost: " + rc);
                        } else {
                            System.out.println("Matching vehicle is not available for rent.");
                        }
                        break;

                    }

                    case 2: {
                        //Return a vehicle
                        System.out.print("Enter the vehicle Brand: ");
                        String make = scanner.nextLine();
                        System.out.print("Enter the vehicle model: ");
                        String model = scanner.nextLine();

                        Vehicle selectedVehicle = null;

                        //Checks the vehicles in rented vehicles
                        for (Vehicle v : rentalSystem.getRentedVehicles()) {
                            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                                selectedVehicle = v;
                            }
                        }
                        if (selectedVehicle != null) {
                            //Add to the returned vehicles
                            rentalSystem.returnVehicle(selectedVehicle);
                            System.out.println("Vehicle returned successfully.");
                        } else {
                            System.out.println("Invalid return. Vehicle not rented.");
                        }
                    }

                    case 3: {
                        //Display Rental Information
                        rentalSystem.displayRentalInfo();
                        break;
                    }

                    case 4: {
                        //Exit
                        System.out.println("Thank you for using the Vehicle Rental System. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    }

                    default:
                        System.out.println("Invalid choice. Please enter valid option...");
                }
                System.out.println("Vehicle booking successful for " + name + " with Account ID: " + accountId);
            }
/*        } else {
            System.out.println("Invalid name or Account ID. Please register or provide valid details.");
        }*/
    }
}