/**
 * Created by neilnachnani on 10/13/15.
 */

public class VehicleManagement {
    private int bus;
    private int plane;
    private int vehicleCount;
    Vehicle[] vehicles;

    public VehicleManagement(int bus, int plane) {
        this.bus = bus;
        this.plane = plane;
        this.vehicles = new Vehicle[0];
        this.vehicleCount = 0;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public int getCount() {
        return vehicleCount;
    }

    public int lookupVehicle(Route route) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getRoute().equals(route)) {
                return i;
            }
        }
        return -1;
    }

    public int getAvailableBus() {
        return this.bus;
    }

    public int getAvailablePlane() {
        return this.plane;
    }

    public boolean createRoute(Route route, int capacity) {
        if (this.bus == 0) {
            return false;
        }
        Vehicle newBus = new Bus(route, capacity);
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getRoute().equals(route)) {
                return false;
            }
        }
        vehicles = java.util.Arrays.copyOf(vehicles, vehicles.length + 1);
        vehicles[vehicleCount] = newBus;
        this.vehicleCount++;
        this.bus--;
        return true;
    }



        /*for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getRoute().equals(route)) {
                return false;
            } else {
                vehicles[vehicles.length] = newBus;
                this.bus--;
                this.vehicleCount++;
                return true;
            }
        }
        return false;
    }
    */

    public boolean addPassengerToVehicle(Passenger person) {
        for (int i = 0; i < vehicles.length; i++) {
            if (person.getRoute().equals(vehicles[i].getRoute())) {
                if (vehicles[i].getCount() < 2 * vehicles[i].getCapacity() &&
                        vehicles[i] instanceof Bus && this.plane > 0) {
                    vehicles[i].addPassenger(person);
                    if (vehicles[i].getCount() >= (2 * vehicles[i].getCapacity()) &&
                            vehicles[i] instanceof Bus && this.plane > 0) {
                        vehicles[i] = vehicles[i].upgrade(vehicles[i].getCapacity() * 3);
                        this.bus++;
                        this.plane--;
                    }
                    if (this.plane < 0) {
                        return vehicles[i].addPassenger(person, false);
                    }
                    return true;
                } else if (vehicles[i] instanceof Airplane &&
                        vehicles[i].getCount() < vehicles[i].getCapacity()) {
                    vehicles[i].addPassenger(person);
                    return true;
                } else if (vehicles[i] instanceof Bus && this.plane == 0 &&
                        vehicles[i].getCount() < vehicles[i].getCapacity()) {
                    vehicles[i].addPassenger(person);
                    return true;
                }
            }
        }
        person.cancel();
        return false;
    }


}
/*if (((Route) obj).from.equals(this.from) && ((Route) obj).to.equals(this.to)) {
        return true;
        */