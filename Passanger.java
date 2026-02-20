public class Passanger {
    // Fields
    private int destination;
    private boolean direction; // Will return true if going right and false if going left
    private int start;

    // Constructors
    public Passanger(int myDestination, int myStart){
        destination = myDestination;
        start = myStart;

        if(destination > start){
            direction = true;
        } else {
            direction = false;
        }
    }

    // Methods
    public int getDestination(){
        return destination;
    }

    public boolean getDirection(){
        return direction;
    }

    public int getStart(){
        return start;
    }

    public String toString(){
        return super.toString() + " Start: " + start + " Destination: " + destination;
    }
}