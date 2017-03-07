/**
 * Created by neilnachnani on 10/17/15.
 */

public class Bus implements Vehicle {
    private Route route;
    private int capacity;
    private int count;
    private Passenger[] busPassengers;

    public Bus(Route route) {
        this.route = route;
        this.capacity = 2;
        this.count = 0;
        busPassengers = new Passenger[0];
    }

    public Bus(Route route, int capacity) {
        this.route = route;
        this.capacity = capacity;
        this.count = 0;
        busPassengers = new Passenger[0];
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
        return busPassengers;
    }


    public boolean addPassenger(Passenger person, boolean waitingList) {
        if (person == null) {
            return false;
        }
        if (!waitingList && count > getCapacity()) {
            person.cancel();
            return false;
        }
        if (this.route.equals(person.getRoute())) {
            if (busPassengers.length + 1 <= capacity) {
                person.confirm();
            }
            busPassengers = java.util.Arrays.copyOf(busPassengers, busPassengers.length + 1);
            busPassengers[busPassengers.length - 1] = person;
            count++;
            return true;
        }
        person.cancel();
        return false;
    }


        /*for (int i = 0; i < busPassengers.length; i++) {
            if (busPassengers[i] == null) {
                busPassengers[i] = person;
                return true;
            } else {
                if (i == busPassengers.length - 1 && busPassengers[i] != null) {
                    this.capacity = this.capacity + 1;
                    Passenger[] temp = new Passenger[capacity];
                    for (int j = 0; j < temp.length - 1; j++) {
                        temp[j] = busPassengers[j];
                    }
                    temp[temp.length - 1] = person;
                    busPassengers = temp;
                    return true;
                }
            }
        }
        return false;
    }
    */


    public boolean addPassenger(Passenger person) {
        return addPassenger(person, true);
    }

            /*if (route.equals(person.getRoute())) {
                for (int i = 0; i < passengers.length; i++) {
                    if (passengers[i] == null) {
                        passengers[i] = person;
                        return true;
                    } else {
                        if (i == passengers.length - 1 && passengers[i] != null) {
                            this.capacity = this.capacity + 1;
                            Passenger[] temp = new Passenger[capacity];
                            for (int j = 0; j < temp.length - 1; j++) {
                                temp[j] = passengers[j];
                            }
                            temp[temp.length - 1] = person;
                            passengers = temp;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        */

    public Vehicle upgrade(int capacity) {
        Airplane p = new Airplane(this.route, capacity);
        for (int i = 0; i < busPassengers.length; i++) {
            p.addPassenger(busPassengers[i]);
            busPassengers[i].confirm();
        }
        return p;
    }
}
