import java.util.ArrayList;

public class RideShareTester {
    public static void main(String[] args){
        System.out.println("\nRideshare simulation.\n");

        Road r = new Road();
        System.out.println("Generated 32 stations");

        r.addCars(20);
        System.out.println("Generated 20 cars");

        r.addPeople(50);
        System.out.println("Generated 50 passengers");

        System.out.println("\nChecking the stations...\n");
        for(Station s : r.getStations()){
            System.out.println(s.toString());
        }

        System.out.println("\nChecking the cars...\n");
        for(Car c : r.getCars()){
            System.out.println(c.toString());
        }
        
        System.out.println("\nStarting the simulation...\n");

        int totalPassengers = 50;
        int totalArrived = 0;

        while(!r.hasReachedDestination()){
            System.out.println("Let's move and update the cars!");
            r.moveCars();

            totalArrived = 0;
            for(Car c : r.getCars()){
                totalArrived += c.getPassengersArrived();
            }
            System.out.println();
            System.out.println(r.toString());
            System.out.println();
        }

        System.out.println("\nChecking the cars after moving...\n\n\n");
        for(Car c : r.getCars()){
            System.out.println(c.toString());
        }

        double percentArrived = (double)(totalArrived)/(totalPassengers) * 100;
        System.out.println("\n\nPercent of passengers who got to destination with a simulation of 20 cars: " + (int)percentArrived + "%\n\n");
        System.out.println("Simulation done.\n");
    }
}
