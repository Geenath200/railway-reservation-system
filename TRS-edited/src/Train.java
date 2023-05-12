import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class for a train
abstract class Train {
    private String trainName;
    private int trainNumber;
    private int totalSeats;
//    private ArrayList<Seat> seats =  new ArrayList<>();
    private int totalSeatsFirstClass;
    private int totalSeatsSecondClass;
    private int totalSeatsThirdClass;
    private int bookedTotalSeatsFirstClass = 0;
    private int bookedTotalSeatsSecondClass = 0;
    private int bookedTotalSeatsThirdClass = 0;
    private int startingPointID;
    private int destinationID;
    private String startTime;


    public Train(String trainName, int trainNumber, int totalSeatsFirstClass, int totalSeatsSecondClass, int totalSeatsThirdClass, int startingPointID, int destinationID, String startTime) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.totalSeatsFirstClass = totalSeatsFirstClass;
        this.totalSeatsSecondClass = totalSeatsSecondClass;
        this.totalSeatsThirdClass = totalSeatsThirdClass;
        this.startingPointID = startingPointID;
        this.destinationID = destinationID;
        this.totalSeats = totalSeatsFirstClass + totalSeatsSecondClass + totalSeatsThirdClass;
        this.startTime = startTime;
    }

    // Getters
    public String getTrainName() {
        return trainName;
    }
    public int getTrainNumber() {
        return trainNumber;
    }
    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedTotalSeatsFirstClass() {
        return bookedTotalSeatsFirstClass;
    }

    public int getBookedTotalSeatsSecondClass() {
        return bookedTotalSeatsSecondClass;
    }

    public int getBookedTotalSeatsThirdClass() {
        return bookedTotalSeatsThirdClass;
    }

    public abstract String getType();

    // get train data
    public static ArrayList<Train> getTrainDataList() {
        ArrayList<Train> trains = new ArrayList<>();
        trains.add(new ExpressTrain("Ruhunu Kumari", 1209, 200, 250, 600, 1, 9, "12.00"));
       trains.add(new ExpressTrain("Podi Manike", 2005, 200, 250, 500, 6, 1, "5.55"));
       trains.add(new ExpressTrain("Udarata Manike", 3015, 200, 250, 500, 6, 1, "8.30"));
        trains.add(new  ExpressTrain("4019", 4019, 150, 200, 600, 6, 1, "10.35"));
        trains.add(new  ExpressTrain("5023", 5023, 180, 200, 520, 6, 1, "12.40"));
        trains.add(new  ExpressTrain("6035", 6035, 100, 200, 400, 6, 1, "16.35"));
       trains.add(new IntercityTrain("Intercity", 7031, 150, 150, 0, 6, 1, "9.00"));
        trains.add(new IntercityTrain("Intercity", 8029, 150, 200, 0, 6, 1, "15.35"));
        trains.add(new IntercityTrain("Intercity AC", 9033, 250, 0, 0, 6, 1,"17.35"));


        return trains;
    }

    public static void updateTrainData() {

    }

    public static void getTrain(ArrayList<Train> trains){
        System.out.println();
        System.out.println(" Train number |    Train name   |     Arrival Time    |");
        System.out.println("---------------------------------------------------------");
        for (int i = 0 ; i < trains.size(); i++) {
            System.out.println( "      " + trains.get(i).trainNumber + "    |    " + trains.get(i).trainName + "         |   " + trains.get(i).startTime);
        }
    }


    // Setter
    public void setBookedTotalSeatsFirstClass(int bookedTotalSeatsFirstClass) {
        this.bookedTotalSeatsFirstClass = bookedTotalSeatsFirstClass;
    }

    public void setBookedTotalSeatsSecondClass(int bookedTotalSeatsSecondClass) {
        this.bookedTotalSeatsSecondClass = bookedTotalSeatsSecondClass;
    }

    public void setBookedTotalSeatsThirdClass(int bookedTotalSeatsThirdClass) {
        this.bookedTotalSeatsThirdClass = bookedTotalSeatsThirdClass;
    }

}

// Class for an economy train
class ExpressTrain extends Train {

    public ExpressTrain(String trainName, int trainNumber, int totalSeatsFirstClass, int totalSeatsSecondClass, int totalSeatsThirdClass, int startingPointID, int destinationID, String startTime) {
        super(trainName, trainNumber, totalSeatsFirstClass, totalSeatsSecondClass, totalSeatsThirdClass, startingPointID, destinationID, startTime);
    }

    @Override
    public String getType() {
        return "Express";
    }
}

// Class for a business train
class IntercityTrain extends Train {

    public IntercityTrain(String trainName, int trainNumber, int totalSeatsFirstClass, int totalSeatsSecondClass, int totalSeatsThirdClass, int startingPointID, int destinationID, String startTime) {
        super(trainName, trainNumber, totalSeatsFirstClass, totalSeatsSecondClass, totalSeatsThirdClass, startingPointID, destinationID, startTime);
    }

    @Override
    public String getType() {
        return "Intercity";
    }
}