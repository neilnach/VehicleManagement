/**
 * Created by neilnachnani on 10/23/15.
 */
public class Test {
    public static void main(String[] args) {
        Route r = new Route("a", "b");
        Bus b = new Bus(r, 2);
        b.addPassenger(new Passenger("alpha", r));
        b.addPassenger(new Passenger("beta", r));
        b.addPassenger(new Passenger("gamma", r));
        b.addPassenger(new Passenger("delta", r));
        Passenger[] passengers = b.getPassengers();
        for (int i = 0; i < passengers.length; i++) {
            System.out.println(passengers[i].getBookingStatus());
        }
        int[] i = new int[0];
        System.out.println(i.length);
    }
}
