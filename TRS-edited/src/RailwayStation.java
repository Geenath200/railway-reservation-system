import java.util.ArrayList;
import java.util.Iterator;

public class RailwayStation {
    private int railwayStationID;
    private String name;
    private int distanceFromColomboFort;

    // Constructors


    public RailwayStation() {
    }

    public RailwayStation(int id, String name, int distanceFromColomboFort) {
        this.railwayStationID = id;
        this.name = name;
        this.distanceFromColomboFort = distanceFromColomboFort;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getDistanceFromColomboFort() {
        return distanceFromColomboFort;
    } // calculate distance

    public static ArrayList<RailwayStation> getRailwayStationDataList() { // train station list
        ArrayList<RailwayStation> railwayStationArrayList = new ArrayList<>();

        railwayStationArrayList.add(new RailwayStation(1,"Colombo Fort", 0));
        railwayStationArrayList.add(new RailwayStation(2,"Maradana", 10));
        railwayStationArrayList.add(new RailwayStation(3,"Ragama", 20));
        railwayStationArrayList.add(new RailwayStation(4,"Polgahawela", 50));
        railwayStationArrayList.add(new RailwayStation(5,"Rambukkana",80));
        railwayStationArrayList.add(new RailwayStation(6,"Kandy",100));

        return railwayStationArrayList;
    }

    public static void displayRailwayStation(ArrayList<RailwayStation> railwayStationsList, int stationID, boolean type) { // type ? starting point: destination
        System.out.println();
        System.out.println(" StationID |    Station name | ");
        System.out.println("-------------------------------");

        if(type){
            System.out.println( "      " + railwayStationsList.get(stationID - 1).railwayStationID + "    |    " + railwayStationsList.get(stationID - 1).name);
        }
        for (int i = stationID ; i < railwayStationsList.size()-1; i++) {
            System.out.println( "      " + railwayStationsList.get(i).railwayStationID + "    |    " + railwayStationsList.get(i).name);
        }

        if(!type){
            System.out.println("      " + railwayStationsList.get(railwayStationsList.size() - 1).railwayStationID + "    |    " + railwayStationsList.get(railwayStationsList.size() - 1).name);
        }

        System.out.println();
    }

    public static int calculateDistance(int startingID, int destinationID) {
        return -getRailwayStationDataList().get(destinationID).getDistanceFromColomboFort() + getRailwayStationDataList().get(startingID).getDistanceFromColomboFort();
    }
}
