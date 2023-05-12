import java.util.ArrayList;
import java.util.Scanner;
interface Tkt{
    abstract void viewAvailableSeats();
}
public class Ticket {
    int ticketNumber;
    int seatNumber;
    double price;

    public Ticket(int ticketNumber, int seatNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void displayTicketDetails() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
    }

    static int[][] seats = new int[10][5];

    public static double calculatePrice(double rate, int distance, int numSeats) {
        return rate * distance * numSeats;
    }

    public static void bookTicket() {
        Scanner input = new Scanner(System.in);
        // get starting point station id
        System.out.println("Please select the starting station: ");
        RailwayStation.displayRailwayStation(RailwayStation.getRailwayStationDataList(), 1, true);
        System.out.print("Enter the Starting Station Id: ");
        int startingStationID = input.nextInt();

        // get starting destination id
        System.out.println("Please select the destination station: ");
        RailwayStation.displayRailwayStation(RailwayStation.getRailwayStationDataList(), startingStationID, false);
        System.out.print("Enter the destination Station Id: ");
        int destinationID = input.nextInt();

        // get train id
        System.out.println("Please select preferred train : ");
        Train.getTrain(Train.getTrainDataList());
//        RailwayStation.displayRailwayStation(RailwayStation.getRailwayStationDataList(), startingStationID,true);
        System.out.println("Enter the train number : ");
        int trainID = input.nextInt();

        System.out.print("Select the class : ");
        System.out.println();
        System.out.println("1. First Class");
        System.out.println("2. Second Class");
        System.out.println("3. Third Class");
        System.out.println();
        int cls = input.nextInt();
//        int bookedCount = 0;
//        int numberOfTickets;


        System.out.print("Enter number of tickets to book: ");
        int numTickets = input.nextInt();

//        while(true) {
//            System.out.print("Select the class : ");
//            System.out.println();
//            System.out.println("1. First Class");
//            System.out.println("2. Second Class");
//            System.out.println("3. Third Class");
//            System.out.println();
//            int cls = input.nextInt();
//            int bookedCount = 0;
//            int numberOfTickets;
//
//
//            System.out.print("Enter number of tickets to book: ");
//            int numTickets = input.nextInt();
//
//            if (cls == 1) {
//                int bookedFirstClassSeats = Train.getTrainDataList().get(trainID / 1000).getBookedTotalSeatsFirstClass();
//                int totalFirstClassSeats = Train.getTrainDataList().get(trainID / 1000).getTotalSeats();
//                int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
//
//                if(numTickets >= (availableFirstClassSeats)){
//                    isAvailableSeats = true;
//                    bookedFirstClassSeats += numTickets;
//                    Train.
//                    break;
//                }
//                else{
//                    System.out.println("Sorry only " + ( availableFirstClassSeats ) + "number of seats are available in the selected class");
//                }
//
//            } else if (cls==2) {
//                int bookedSecondClassSeats = Train.getTrainDataList().get(trainID / 1000).getBookedTotalSeatsFirstClass();
//                int totalSecondClassSeats = Train.getTrainDataList().get(trainID / 1000).getTotalSeats();
//                int availableSecondClassSeats = totalSecondClassSeats - bookedSecondClassSeats;
//
//                if(numTickets >= (availableSecondClassSeats)){
//                    isAvailableSeats = true;
//                    break;
//                }
//                else{
//                    System.out.println("Sorry only " + (availableSecondClassSeats) + "number of seats are available in the selected class");
//                }
//
//            }
//            else if(cls ==3) {
//                int bookedThirdClassSeats = Train.getTrainDataList().get(trainID / 1000).getBookedTotalSeatsFirstClass();
//                int totalThirdClassSeats = Train.getTrainDataList().get(trainID / 1000).getTotalSeats();
//                int availableThirdClassSeats = totalThirdClassSeats - bookedThirdClassSeats;
//
//                if(numTickets >= (availableThirdClassSeats)){
//                    isAvailableSeats = true;
//                    break;
//                }
//                else{
//                    System.out.println("Sorry only " + ( availableThirdClassSeats ) + "number of seats are available in the selected class");
//                }
//            }
//
//        }
        double rate = 0;

        switch (cls) {
            case 1:
                rate = 100;
                break;
            case 2:
                rate = 70;
                break;
            case 3:
                rate = 50;
                break;
        }
        double totalTicketPrice = calculatePrice(rate, RailwayStation.calculateDistance(startingStationID, destinationID), numTickets);

        Passenger p1 = new Passenger();
        p1.gettingDetails();// getting passenger details
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the preferred payment method");
        System.out.println("1. pay by cash");
        System.out.println("2. pay by card");
        int selection = scanner.nextInt();
        if (selection == 1) {
            Cash cash = new Cash();
            cash.pay(totalTicketPrice);
        } else {
            Card card = new Card();
            card.pay(totalTicketPrice);
        }
        System.out.println(numTickets + " tickets booked successfully.");

        long bookingID = Booking.addNewBookings(new Booking(numTickets, cls, startingStationID, destinationID, totalTicketPrice));
        System.out.println();
        System.out.println("Your booking Id is : " + bookingID);
        System.out.println();
        System.out.println("Please collect your tickets at the starting station.");

    }

    public static void cancelTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter column number: ");
        int column = scanner.nextInt();

        if (seats[row][column] == 0) {
            System.out.println("Seat is already empty.");
        } else {
            seats[row][column] = 0;
            System.out.println("Ticket cancelled successfully.");
        }
    }

    public static void updateTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter column number: ");
        int column = scanner.nextInt();

        if (seats[row][column] == 0) {
            System.out.println("Seat is empty. Cannot update.");
        } else {
            seats[row][column] = 0;
            System.out.println("Enter new row and column number for the ticket.");
            int newRow = scanner.nextInt();
            int newColumn = scanner.nextInt();

            if (seats[newRow][newColumn] == 0) {
                seats[newRow][newColumn] = 1;
                System.out.println("Ticket updated successfully.");
            } else {
                System.out.println("Sorry, seat is already booked.");
                seats[row][column] = 1;
            }
        }
    }

    public static void viewAvailableSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (seats[i][j] == 0) {
                    System.out.print((i + 1) + "-" + (j + 1) + " ");
                }
            }
            System.out.println();
        }
    }

}

class Firstclassticket extends Ticket{

    public Firstclassticket(int ticketNumber, int seatNumber, double price) {
        super(ticketNumber, seatNumber, price);
    }
}
class Secondclassticket extends Ticket{
    public Secondclassticket(int ticketNumber, int seatNumber, double price) {
        super(ticketNumber, seatNumber, price);
    }
}

class Thirdclassticket extends Ticket{
    public Thirdclassticket(int ticketNumber, int seatNumber, double price) {
        super(ticketNumber, seatNumber, price);
    }
}

