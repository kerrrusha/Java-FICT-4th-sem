import java.util.ArrayList;
import java.util.Objects;

public class Airport {
    private ArrayList<Flight> flights;

    Airport() {
        flights = new ArrayList<>();
    }
    Airport(ArrayList<Flight> _flights) {
        flights = new ArrayList<>(_flights);
    }
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Airport flights list\n\n");
        for(var flight : flights)
            result.append(flight.toString()).append('\n');

        return result.toString();
    }
    public void add_flight(Flight _flight) {
        flights.add(_flight);
    }
    public ArrayList<Flight> select_by_destination(String dest) {
        var result = new ArrayList<Flight>();
        for(var flight : flights) {
            if(Objects.equals(flight.get_destination(), dest))
                result.add(flight);
        }
        return result;
    }
    public ArrayList<Flight> select_by_departure_day(Day _day) {
        var result = new ArrayList<Flight>();
        for(var flight : flights) {
            if(flight.get_departure_day() == _day)
                result.add(flight);
        }
        return result;
    }
}