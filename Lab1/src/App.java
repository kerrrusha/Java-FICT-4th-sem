import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        flights.add(new Flight("Rome", Aircraft_Type.MEDIUM_HAUL, new Time(14,0,0), Day.WEDNESDAY));
        flights.add(new Flight("Paris", Aircraft_Type.MEDIUM_HAUL, new Time(12,30,0), Day.WEDNESDAY));
        flights.add(new Flight("Barcelona", Aircraft_Type.MEDIUM_HAUL, new Time(15,45,0), Day.WEDNESDAY));

        Airport airport = new Airport(flights);
        System.out.println(airport);
    }
}