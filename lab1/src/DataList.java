public class DataList {
    private static final Flight[] DATA = new Flight[]{
                new Flight("Rome", AircraftType.MEDIUM_HAUL, new Time(14, 0, 0), Day.WEDNESDAY),
                new Flight("Paris", AircraftType.MEDIUM_HAUL, new Time(12,30,0), Day.WEDNESDAY),
                new Flight("Barcelona", AircraftType.MEDIUM_HAUL, new Time(15,45,0), Day.WEDNESDAY),
                new Flight("Madrid", AircraftType.MEDIUM_HAUL, new Time(19,15,0), Day.THURSDAY),
                new Flight("Odessa", AircraftType.LOCAL_AIRLINES, new Time(0,20,0), Day.THURSDAY),
                new Flight("Berlin", AircraftType.MEDIUM_HAUL, new Time(4,0,0), Day.FRIDAY),
                new Flight("New York", AircraftType.LONG_HAUL, new Time(5,0,0), Day.FRIDAY),
                new Flight("Los Angeles", AircraftType.LONG_HAUL, new Time(13,45,0), Day.FRIDAY),
                new Flight("Las Vegas", AircraftType.LONG_HAUL, new Time(10,20,0), Day.FRIDAY),
                new Flight("Los Angeles", AircraftType.LONG_HAUL, new Time(19,20,0), Day.SATURDAY),
                new Flight("Istanbul", AircraftType.SHORT_HAUL, new Time(17,35,0), Day.SUNDAY)
        };

    public static Flight[] getData() {
        return DATA;
    }
}