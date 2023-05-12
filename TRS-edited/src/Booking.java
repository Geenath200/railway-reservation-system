import java.util.Scanner;
import java.util.ArrayList;

interface BookingInterface {
//    abstract void Booking();
}
class Booking implements BookingInterface {

    private long ticketId;
    private int noOfSeats;
    private int cls;
    private int startingStationID;
    private int destinationID;
    private double totPrice;
    private String status; // booked, cancelled , paid

    private static ArrayList<Booking> bookings = new ArrayList<>();

    //constructors
    public Booking( int noOfSeats, int cls, int startingStationID, int destinationID, double totPrice) {
        this.noOfSeats = noOfSeats;
        this.cls = cls;
        this.startingStationID = startingStationID;
        this.destinationID = destinationID;
        this.totPrice = totPrice;
    }

    public Booking(long ticketId, int noOfSeats, int cls, int startingStationID, int destinationID, double totPrice) {
        this.ticketId = ticketId;
        this.noOfSeats = noOfSeats;
        this.cls = cls;
        this.startingStationID = startingStationID;
        this.destinationID = destinationID;
        this.totPrice = totPrice;
    }

    public static ArrayList<Booking> getBookings() {
        return bookings;
    }

    public static long addNewBookings(Booking newBooking) {
        long ticketId = (long) (Math.random() * 90000000) + 10000000;
        bookings.add(new Booking(ticketId, newBooking.noOfSeats, newBooking.cls, newBooking.startingStationID, newBooking.destinationID, newBooking.totPrice));
        return ticketId;
    }
}
