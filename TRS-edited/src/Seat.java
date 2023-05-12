class Seat {
    public enum SeatList {
        FirstClass,
        SecondClass,
        ThirdClass
    }
    private int seatNumber;
    private boolean isBooked;
    private SeatList seatClass;

    public Seat(int seatNumber, SeatList seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    // Getters
    public int getSeatNumber() {
        return seatNumber;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public SeatList getSeatClass() {
        return seatClass;
    }

    // Setters
    public void setBooked(boolean booked) {
        isBooked = booked;
    }

//    public boolean isAvailable() {
//
//    }
}
