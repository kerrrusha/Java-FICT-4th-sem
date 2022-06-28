package view;

import model.Flight;

import java.util.ArrayList;

public class AirportView {
    public static final String MENU_TITLE = "Main menu:";
    public static final String[] MENU_ITEMS = {
            "1. Show data",
            "2. Select flights by destination",
            "3. Select flights by departure day",
            "4. Select flights by departure day and those that are later than the entered time",
            "5. Exit"
    };
    public static final String INPUT_MENU_ITEM = "Choose menu item (number):\t";
    public static final String WRONG_INT_INPUT = "Incorrect input! Enter a number, please.";
    public static final String INT_NOT_IN_BOUNDS = "Entered number not in acceptable bounds!";
    public static final String WRONG_DAY_INPUT = "There is not such day! Enter a day in uppercase, please.";
    public static final String WRONG_TIME_INPUT = "Incorrect time input!";
    public static final String INT_INPUT_OUT_OF_BOUNDS = "Entered number out of bounds.";
    public static final String INPUT_DESTINATION = "Enter destination city:\t";
    public static final String INPUT_DEPARTURE_DAY = "Enter departure day (UPPERCASE):\t";
    public static final String INPUT_DEPARTURE_TIME = "Enter a time in 'hh:mm:ss' format:\t";
    public static final String SEARCH_RESULT = "Search results:";
    public static final String NOTHINGS_FOUND = "Sorry, nothing was found by your query.";
    public static final String NOT_EXISTING_DESTINATION = "There are no such destination!";
    public static final String NOT_EXISTING_DEPARTURE_DAY = "There are no such departure day!";
    public  void printMessage(String message) {
        System.out.println(message);
    }
    public  void printMessages(String[] messages) {
        for(var message : messages) {
            System.out.println(message);
        }
    }
    public  void printFlightList(ArrayList<Flight> flights) {
        for(var flight : flights) {
            System.out.println(flight);
        }
    }
}
