package model;

import dataManager.FileSerializingManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AirportModel {
    private final FileSerializingManager<Flight> data;

    public AirportModel() throws IOException {
        data = new FileSerializingManager<>();
    }

    public List<Flight> getFlights() throws IOException, ClassNotFoundException {
        return data.readAll();
    }
    public void addFlight(Flight newFlight) throws IOException, ClassNotFoundException {
        data.addOne(newFlight);
    }
    public void addFlights(List<Flight> newFlights) throws IOException, ClassNotFoundException {
        data.addSeveral(newFlights);
    }
    public List<Flight> selectBy(FilterParameter parameter, Object key) throws IOException, ClassNotFoundException {
        switch(parameter) {
            case DESTINATION -> {
                String finalCity = (String) key;
                return getFlights().stream().filter(t -> t.getDestination().equals(finalCity)).collect(Collectors.toList());
            }
            case TIME -> {
                Time finalTime = (Time) key;
                return getFlights().stream().filter(t -> t.getDepartureTime().isBigger(finalTime)).collect(Collectors.toList());
            }
            case WEEKDAY -> {
                WeekDay finalDay = (WeekDay) key;
                return getFlights().stream().filter(t -> t.getDepartureDay() == finalDay).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }
    public static List<Flight> common(List<Flight> a, List<Flight> b) {
        var result = new ArrayList<Flight>();
        for (Flight aFlight : a) {
            if (AirportModel.contains(b, aFlight))
                result.add(aFlight);
        }
        return result;
    }
    public static boolean contains(List<Flight> a, Flight flight) {
        for (Flight aFlight : a)
            if (aFlight.isEqual(flight))
                return true;
        return false;
    }
}
