public class Flight {
    private String destination;
    private String flight_id;
    private Aircraft_Type aircraft_type;
    private Time departure_time;
    private Day departure_day;
    private String aircraft_id;

    public static int randint(int from, int to) {
        return (int) (Math.random()*(to - from+1) + from);
    }
    public String generate_id() {
        StringBuilder id = new StringBuilder();
        int digits = 6;
        for (int i = 0; i < digits; i++)
            id.append(randint(0, 9));
        return id.toString();
    }
    Flight() {
        departure_time = new Time();
    }
    Flight(String _dest, Aircraft_Type _type, Time _departure, Day _day) {
        destination = _dest;
        flight_id = generate_id();
        aircraft_type = _type;
        departure_time = new Time(_departure);
        departure_day = _day;
        aircraft_id = generate_id();
    }
    public String toString() {
        return "Flight ID:\t\t" + flight_id + "\n" +
                "Destination:\t" + destination + "\n" +
                "Departure day:\t" + departure_day + "\n" +
                "Departure time:\t" + departure_time.toString() + "\n" +
                "Aircraft ID:\t" + aircraft_id + "\n" +
                "Aircraft type:\t" + aircraft_type + "\n";
    }
    public String get_destination() {
        return destination;
    }
    public Day get_departure_day() {
        return departure_day;
    }
    public Time get_departure_time() {
        return departure_time;
    }
}