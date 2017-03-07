/**
 * Created by neilnachnani on 10/13/15.
 */
public class Passenger {
    private String name;
    private Route route;
    public static final String CANCELED = "Canceled";
    public static final String WAITLIST = "Waitlist";
    public static final String CONFIRMED = "Confirmed";
    private String bookingStatus;

    public Passenger(String name, Route route) {
        this.name = name;
        this.route = route;
        this.bookingStatus = WAITLIST;
    }

    public String getPassengerName() {
        return this.name;
    }

    public Route getRoute() {
        return this.route;
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }

    public void confirm() {
        if (this.bookingStatus.equals(WAITLIST)) {
            this.bookingStatus = CONFIRMED;
        }
    }

    public void cancel() {
        if (this.bookingStatus.equals(WAITLIST)) {
            this.bookingStatus = CANCELED;
        }
    }
}
