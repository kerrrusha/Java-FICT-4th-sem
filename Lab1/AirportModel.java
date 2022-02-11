public class AirportModel {
    private Flight[] flights;

    AirportModel() {
        flights = new Flight[0];
    }

    private void expand() {
        int newSize = flights.length + 1;
        Flight[] flights_expanded = new Flight[newSize];
        for(int i = 0; i < flights.length; i++) {
            flights_expanded[i] = flights[i];
        }
        this.flights = flights_expanded;
    }
    public void append(Flight flight) {
        expand();
        flights[flights.length-1] = flight;
    }
    public void append(Flight[] flights) {
        for(var flight : flights) {
            append(flight);
        }
    }

    public Flight[] selectByDestination(String destination) {
        int matches = 0;
        for(var flight : flights) {
            if(flight.getDestination().equals(destination)) {
                matches += 1;
            }
        }
        Flight[] result = new Flight[matches];
        int i = 0;
        for(var flight : flights) {
            if(flight.getDestination().equals(destination)) {
                result[i] = new Flight(flight);
                i += 1;
            }
        }
        return result;
    }
    public Flight[] selectByDepartureDay(Day departureDay) {
        int matches = 0;
        for(var flight : flights) {
            if(flight.getDepartureDay() == departureDay) {
                matches += 1;
            }
        }
        Flight[] result = new Flight[matches];
        int i = 0;
        for(var flight : flights) {
            if(flight.getDepartureDay() == departureDay) {
                result[i] = new Flight(flight);
                i += 1;
            }
        }
        return result;
    }
    public Flight[] selectByDepartureDayAndTime(Day day, Time time) {
        int matches = 0;
        for(var flight : flights) {
            if(flight.getDepartureDay() == day && flight.getDepartureTime().isBigger(time)) {
                matches += 1;
            }
        }
        Flight[] result = new Flight[matches];
        int i = 0;
        for(var flight : flights) {
            if(flight.getDepartureDay() == day && flight.getDepartureTime().isBigger(time)) {
                result[i] = new Flight(flight);
                i += 1;
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Airport flights list\n\n");
        for(var flight : flights)
            result.append(flight.toString()).append('\n');

        return result.toString();
    }
}