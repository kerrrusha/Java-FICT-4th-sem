package model;

import dataManager.FileSerializingManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AirportModel {
    public static class FilterUtility {
        public static ArrayList<Flight> selectByDepartureDay(ArrayList<Flight> queryable, WeekDay day) {
            return (ArrayList<Flight>) queryable.stream().filter(t -> t.getDepartureDay() == day).collect(Collectors.toList());
        }

        public static ArrayList<Flight> selectByDestination(ArrayList<Flight> queryable, String destination) {
            return (ArrayList<Flight>) queryable.stream().filter(t -> t.getDestination().equals(destination)).collect(Collectors.toList());
        }

        public static ArrayList<Flight> selectAfterTime(ArrayList<Flight> queryable, Time timeFrom) {
            return (ArrayList<Flight>) queryable.stream().filter(t -> t.getDepartureTime().isBigger(timeFrom)).collect(Collectors.toList());
        }
    }

    private final FileSerializingManager<Flight> data;

    public AirportModel(String dataFileAddress) throws IOException {
        data = new FileSerializingManager<>(dataFileAddress);
    }

    public ArrayList<Flight> getFlights() throws IOException, ClassNotFoundException {
        return data.readAll();
    }
    public void addFlight(Flight newFlight) throws IOException, ClassNotFoundException {
        data.addOne(newFlight);
    }
    public void addFlights(ArrayList<Flight> newFlights) throws IOException, ClassNotFoundException {
        data.addSeveral(newFlights);
    }
}
