import java.util.*;
public class Station {
    // Fields
    private int stationNumber;
    private ArrayList<Passanger> waitingLeft;
    private ArrayList<Passanger> waitingRight;
    private ArrayList<Passanger> done;
    
    // Constructors
    public Station(int myStationNumber){
        stationNumber = myStationNumber;
        waitingLeft = new ArrayList<Passanger>();
        waitingRight = new ArrayList<Passanger>();
        done = new ArrayList<Passanger>();
    }

    // Methods

}
