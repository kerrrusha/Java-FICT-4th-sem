import java.util.ArrayList;

public class Airport {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    Airport(ArrayList<Flight> _flights) {
        flights = _flights;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Airport flights list\n\n");
        for(var flight : flights){
            result.append(flight.toString()+'\n');
        }
        return result.toString();
    }
}