package dataManager;

import model.AircraftType;
import model.Flight;
import model.Time;
import model.WeekDay;

import java.util.ArrayList;

public class ExampleDataList {
    private static final ArrayList<Flight> DATA = new ArrayList<Flight>() {
        {
            add(new Flight("Rome", AircraftType.MEDIUM_HAUL, new Time(14, 0, 0), WeekDay.WEDNESDAY));
            add(new Flight("Paris", AircraftType.MEDIUM_HAUL, new Time(12, 30, 0), WeekDay.WEDNESDAY));
            add(new Flight("Barcelona", AircraftType.MEDIUM_HAUL, new Time(15, 45, 0), WeekDay.WEDNESDAY));
            add(new Flight("Madrid", AircraftType.MEDIUM_HAUL, new Time(19, 15, 0), WeekDay.THURSDAY));
            add(new Flight("Odessa", AircraftType.LOCAL_AIRLINES, new Time(0, 20, 0), WeekDay.THURSDAY));
            add(new Flight("Berlin", AircraftType.MEDIUM_HAUL, new Time(4, 0, 0), WeekDay.FRIDAY));
            add(new Flight("New York", AircraftType.LONG_HAUL, new Time(5, 0, 0), WeekDay.FRIDAY));
            add(new Flight("Los Angeles", AircraftType.LONG_HAUL, new Time(13, 45, 0), WeekDay.FRIDAY));
            add(new Flight("Las Vegas", AircraftType.LONG_HAUL, new Time(10, 20, 0), WeekDay.FRIDAY));
            add(new Flight("Los Angeles", AircraftType.LONG_HAUL, new Time(19, 20, 0), WeekDay.SATURDAY));
            add(new Flight("Istanbul", AircraftType.SHORT_HAUL, new Time(17, 35, 0), WeekDay.SUNDAY));
        }
    };

    public static ArrayList<Flight> getData() {
        return DATA;
    }
}
