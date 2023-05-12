import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Book Ticket");
            //System.out.println("2. Cancel Ticket");
         //   System.out.println("3. Update Ticket");
            System.out.println("2. Exit");

            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    Ticket.bookTicket();
                    break;
                /*case 2:
                    Ticket.cancelTicket();
                    break;
                case 3:
                    Ticket.updateTicket();
                    break;*/
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
            start();



    }
}
