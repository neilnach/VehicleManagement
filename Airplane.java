/**
 * Created by neilnachnani on 10/18/15.
 */
public class Airplane implements Vehicle {
    private int capacity;
    private Route route;
    private int count;
    private Passenger[] airplanePassengers;

    public Airplane(Route route, int capacity) {
        this.route = route;
        this.capacity = capacity;
        this.count = 0;
        airplanePassengers = new Passenger[0];
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Route getRoute() {
        return this.route;
    }

    public int getCount() {
        return this.count;
    }

    public Passenger[] getPassengers() {
        return airplanePassengers;
    }

    public boolean addPassenger(Passenger person, boolean waitingList) {
        if (person == null) {
            return false;
        }
        if (this.route.equals(person.getRoute()) && getCount() < getCapacity()) {
            airplanePassengers = java.util.Arrays.copyOf(airplanePassengers, airplanePassengers.length + 1);
            person.confirm();
            airplanePassengers[airplanePassengers.length - 1] = person;
            this.count++;
            return true;
        }
        person.cancel();
        return false;
        /*
        return this.(person);

         */
    }

    public boolean addPassenger(Passenger person) {
        return addPassenger(person, false);
    }

    public Vehicle upgrade(int capacity) {
        return null;
    }
}
