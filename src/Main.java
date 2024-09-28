import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();

        while (true) {
            System.out.println("\nWelcome to Vehicle Rental System");
            System.out.println("1. Register Customer");
            System.out.println("2. Book Vehicle");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Registration flow
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    rentalSystem.registerCustomer(name, email, phoneNumber);
                    break;
                case 2:
                    // Booking flow
                    System.out.print("Enter Name: ");
                    String bookingName = scanner.nextLine();
                    System.out.print("Enter Account ID: ");
                    String accountId = scanner.nextLine();
                    rentalSystem.bookVehicle(bookingName, accountId);
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Thank you for using the Vehicle Rental System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
