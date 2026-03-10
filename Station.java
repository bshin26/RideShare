import java.util.*;
public class Station {
    // Fields
    private int stationNumber;
    private ArrayList<Passenger> waitingLeft;
    private ArrayList<Passenger> waitingRight;
    private ArrayList<Passenger> done;
    
    // Constructors
    public Station(int myStationNumber){
        stationNumber = myStationNumber;
        waitingLeft = new ArrayList<Passenger>();
        waitingRight = new ArrayList<Passenger>();
        done = new ArrayList<Passenger>();
    }

    // Methods
    public void addPassenger(Passenger p){
        if(p.getDestination() == stationNumber){
            done.add(p);
        } else if(p.getDirection()){
            waitingRight.add(p); // p.getDirection will return either true or false. In this case, it will return ture, which adds the passenger to the right
        } else {
            waitingLeft.add(p);
        }
    }

    /**
     * Method for giving back a passenger that is leftbound
     * A single person traveling to the left will return null if nobody is available
     */

    public Passenger nextLeft(){
        if(waitingLeft.size() == 0){
            return null; // If nobody is waiting to go left, it will returrn null
        } else {
            return waitingLeft.remove(0); // Otherwise, remove and return the first person in the line
        }
    }

    /**
     * Method for giving back a passenger that is rightbound
     * A single person traveling to the right will return null if nobody is available
     */

    public Passenger nextRight(){
        if(waitingRight.size() == 0){
            return null;
        } else {
            return waitingRight.remove(0); // Same logic as nextLeft
        }
    }

    public int getStationNumber(){
        return stationNumber;
    }

    public ArrayList<Passenger> getWaitingRight(){
        return waitingRight;
    }

    public ArrayList<Passenger> getWaitingLeft(){
        return waitingLeft;
    }

    public int doneCount(){
        return done.size();
    }

    public String toString(){
        String s = "Station " + stationNumber + ":\n";
        s += "  Waiting Left: " + waitingLeft.size() + "\n";
        s += "  Waiting Right: " + waitingRight.size() + "\n";
        s += "  Done: " + done.size() + "\n";
        return s;
    }
}
