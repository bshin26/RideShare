import java.util.*;

public class Road {
    // Fields
    private ArrayList<Station> station;
    private ArrayList<Car> car;
    private static final int STATIONNUMB = 32;

    // Constructors
    public Road(){
        station = new ArrayList<Station>();
        for(int i = 0; i < STATIONNUMB; i++){
            station.add(new Station(i));
        }
        car = new ArrayList<Car>();
    }

    // Methods
    public void addPeople(int numPassengers){
        for(int i = 0; i < numPassengers; i++){
            int start = (int)(Math.random() * STATIONNUMB);
            int end = (int)(Math.random() * STATIONNUMB);
            while(end == start){
                end = (int)(Math.random() * STATIONNUMB); // Ensures the passengers actually need a ride
            }
            station.get(start).addPassenger(new Passenger(start, end)); // This will: Create the passenger and assign their starting and ending station, get the station number, and add that passenger to that station
        }
    }

    public void addCars(int numCars){
        for(int i = 0; i < numCars; i++){
            int start = (int)(Math.random() * STATIONNUMB);
            int end = (int)(Math.random() * STATIONNUMB);
            while(end == start){
                end = (int)(Math.random() * STATIONNUMB);
            }
            car.add(new Car(start, end)); // Same logic as addPeople, but with cars
        }
    }

    public boolean hasReachedDestination(){
        for(Car c : car){
            if(c.getLocation() != c.getDestination()){
                return false; // Loops cars to see if they have reached their destination
            }
        }
        return true;
    }

    public ArrayList<Station> getStations(){
        return station;
    }

    public ArrayList<Car> getCars(){
        return car;
    }
    
    public void moveCars(){
        // This part unloads all eligivle passenger from the cars to the stations
        for(Car c: car){
            while(true){ // Using a while(true) loop in order to continue unloading the passengers until there are no more eligible passengers
                Passenger p = c.unload();
                if(p != null){
                    int location = c.getLocation();
                    station.get(location).addPassenger(p);
                } else {
                    break;
                }
            }
        }
        // This part essentially loads passengers into the car 
        for(Station s : station){
            for(Car c : car){
                if(c.getLocation() == s.getStationNumber()){
                    while(c.hasRoom()){
                        Passenger p = null;
                        // Up to here, the program has: looped through every station and every car, checked if the car is currently at a certain station, and loads passengers while the car still has room

                        if(c.getDirection()){
                            if(s.getWaitingRight().size() > 0){
                                p = s.getWaitingRight().remove(0);
                            }
                        } else {
                            if(s.getWaitingLeft().size() > 0){
                                p = s.getWaitingLeft().remove(0);
                            }
                        } // Checks if passengers are going right or left, and if they are they are removed from the list
                        if(p == null){
                            break;
                        }
                        c.addPassenger(p);
                    }
                }
            }
        }
        // This part moves the cars
        for(Car c : car){
            if(c.getLocation() != c.getDestination() || c.hasPassengers()){
                c.move(); // Moves the car if the car's current location is either not equal to its final destination or it still has passengers loaded
            }
        }
    }

    public String toString(){
        String s = "Stations: \n";
        for(Station st : station){
            s += st.toString();
            s += "\n\n";
        }
        s += "Cars: \n";
        for(Car c : car){
            s += c.toString();
            s += "\n";
        }
        return s;
    }
}
