import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choiceInput = new Scanner(System.in);

        System.out.println("===WELCOME===");
        System.out.println("1. Show Cars");
        System.out.println("2. Rent a Car");
        System.out.println("3. Exit");

        int choice = choiceInput.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Choice 1 has been selected");
                break;
            case 2:
                System.out.println("Choice 2 has been selected");
                break;
            case 3:
                System.out.println("Choice 3 has been selected");
                break;
            default:
                System.out.println("No option selected");
        }

    }
}