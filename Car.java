import java.util.*;
public class Car {
    // Fields
    private int destination;
    private int currentLocation;
    private boolean direction;
    private ArrayList<Passanger> passengers;
    private int passengersArrived = 0;

    // Constructors
    public Car(int myDestination, int myCurrentLocation){
        destination = myDestination;
        currentLocation = myCurrentLocation;
        direction = destination > currentLocation; // Right = true
        passengers = new ArrayList<Passanger>();
    }

    // Methods
    public void addPassenger(Passanger p){
        if(passengers.size() < 3 && p.getDirection() == direction){
            passengers.add(p); // Only adds the passenger if the car is not full and is traveling the same direction as the passanger
        }
    }

    public void move(){
        if(currentLocation == destination){
            return; // If the car has already reached its destination, do not move
        } else if( direction == true){
            currentLocation++; // If the car is moving right, increase its location
        } else {
            currentLocation--; // If the car is moving left, decrease its location
        }
    }

    /**
     * The unload method unloads passengers at the current location if they are eligible.
     * There may be multiple people eligible for dropoff, but this method only drops off one
     * Passengers get removed only if the passenger has reached their destination or the car has reached its final destination
     */

    public Passanger unload(){
        for(int i = 0; i < passengers.size(); i++){
            Passanger a = passengers.get(i);
            if(a.getDestination() == currentLocation || destination == currentLocation){
                passengers.remove(i);
                if(a.getDestination() == currentLocation){
                    passengersArrived++;
                }
                return a;
            }
        }
        return null;
    }

    public boolean hasRoom(){
        return passengers.size() < 3;
    }

    public boolean hasPassengers(){
        if(passengers.size() > 0){
            return true;
        } else {
            return false;
        }
    }

    public int getLocation(){
        return currentLocation;
    }

    public int getPassengersArrived(){
        return passengersArrived;
    }

    public String toString(){
        return super.toString() + " Destination: " + destination + " Current location: " + currentLocation + " Going right? " + direction + " Passengers: " + passengers + " Passengers arrived: " + passengersArrived;
    }
}