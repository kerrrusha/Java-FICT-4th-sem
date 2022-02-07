public class App {
    public static void main(String[] args) {
        Airport airport = new Airport();

        airport.add_flight(new Flight("Rome", Aircraft_Type.MEDIUM_HAUL, new Time(14,0,0), Day.WEDNESDAY));
        airport.add_flight(new Flight("Paris", Aircraft_Type.MEDIUM_HAUL, new Time(12,30,0), Day.WEDNESDAY));
        airport.add_flight(new Flight("Barcelona", Aircraft_Type.MEDIUM_HAUL, new Time(15,45,0), Day.WEDNESDAY));
        airport.add_flight(new Flight("Madrid", Aircraft_Type.MEDIUM_HAUL, new Time(19,15,0), Day.THURSDAY));
        airport.add_flight(new Flight("Odessa", Aircraft_Type.LOCAL_AIRLINES, new Time(0,20,0), Day.THURSDAY));
        airport.add_flight(new Flight("Berlin", Aircraft_Type.MEDIUM_HAUL, new Time(4,0,0), Day.FRIDAY));
        airport.add_flight(new Flight("New York", Aircraft_Type.LONG_HAUL, new Time(5,0,0), Day.FRIDAY));
        airport.add_flight(new Flight("Los Angeles", Aircraft_Type.LONG_HAUL, new Time(13,45,0), Day.FRIDAY));
        airport.add_flight(new Flight("Las Vegas", Aircraft_Type.LONG_HAUL, new Time(10,20,0), Day.FRIDAY));
        airport.add_flight(new Flight("Los Angeles", Aircraft_Type.LONG_HAUL, new Time(19,20,0), Day.SATURDAY));
        airport.add_flight(new Flight("Istanbul", Aircraft_Type.SHORT_HAUL, new Time(17,35,0), Day.SUNDAY));

        //System.out.println(airport);

        // отримати список рейсів до заданого пункту призначення
        String destination = "Los Angeles";
        var select_by_destination_result = airport.select_by_destination(destination);

        System.out.println("Flights to " + destination + ":\n");
        for(var elem : select_by_destination_result)
            System.out.println(elem);

        //отримати список рейсів для заданого дня тижню
        Day day = Day.WEDNESDAY;
        var select_by_day_result = airport.select_by_departure_day(day);

        System.out.println("Flights at " + day + ":\n");
        for(var elem : select_by_day_result)
            System.out.println(elem);

        //отримати список рейсів для заданого дня тижня, час вильоту яких пізніше заданого
        Time time = new Time(13,0,0);
        System.out.println("Flights at " + day + ", later than " + time + ":\n");
        for(var elem : select_by_day_result)
            if (elem.get_departure_time().is_bigger(time))
                System.out.println(elem);
    }
}