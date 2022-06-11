public class Flight {
    private String destination;
    private String flightId;
    private AircraftType aircraftType;
    private Time departureTime;
    private Day departureDay;
    private String aircraftId;

    Flight() {
        departureTime = new Time();
    }
    Flight(Flight other) {
        this.destination = other.destination;
        this.flightId = other.flightId;
        this.aircraftType = other.aircraftType;
        this.departureTime = other.departureTime;
        this.departureDay = other.departureDay;
        this.aircraftId = other.aircraftId;
    }
    Flight(String destination, AircraftType aircraftType, Time departureTime, Day departureDay) {
        this.destination = destination;
        flightId = generateId();
        this.aircraftType = aircraftType;
        this.departureTime = new Time(departureTime);
        this.departureDay = departureDay;
        aircraftId = generateId();
    }

    public String getDestination() {
        return destination;
    }
    public String getFlightId() {
        return flightId;
    }
    public AircraftType getAircraftType() {
        return aircraftType;
    }
    public Time getDepartureTime() {
        return departureTime;
    }
    public Day getDepartureDay() {
        return departureDay;
    }
    public String getAircraftId() {
        return aircraftId;
    }

    public String toString() {
        return "Flight ID:\t\t" + flightId + "\n" +
                "Destination:\t" + destination + "\n" +
                "Departure day:\t" + departureDay + "\n" +
                "Departure time:\t" + departureTime.toString() + "\n" +
                "Aircraft ID:\t" + aircraftId + "\n" +
                "Aircraft type:\t" + aircraftType + "\n";
    }

    public static int randint(int from, int to) {
        return (int) (Math.random()*(to - from+1) + from);
    }
    public static String generateId() {
        StringBuilder id = new StringBuilder();
        int digits = 6;
        for (int i = 0; i < digits; i++)
            id.append(randint(0, 9));
        return id.toString();
    }
}