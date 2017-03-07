/**
 * Created by neilnachnani on 10/13/15.
 */
public interface Vehicle {
    public int getCapacity(); //returns number of seats available

    public Route getRoute(); //returns the route serviced by the vehicle

    public int getCount(); //returns total number of bookings on the vehicle

    public Passenger[] getPassengers(); //returns an array of passengers associated to the vehicle

    public boolean addPassenger(Passenger person, boolean waitingList); //adds passenger to passenger array

    public boolean addPassenger(Passenger person); //always allows passenger on waiting list

    public Vehicle upgrade(int capacity); //returns the upgrade of the given vehicle with the given capacity
}
