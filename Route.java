/**
 * Created by neilnachnani on 10/13/15.
 */
public class Route {
    String from;
    String to;

    public Route(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            if (((Route) obj).from.equals(this.from) && ((Route) obj).to.equals(this.to)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("Route: From %s to %s\n", this.from, this.to);
    }
}



