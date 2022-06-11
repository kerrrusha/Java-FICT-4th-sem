package controller;

import model.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import view.AirportView;
import view.UserInputManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportController {
    private AirportModel model;
    private AirportView view;
    private final UserInputManager inputManager;

    public static Logger logger = Logger.getLogger(AirportController.class);

    public AirportController() throws IOException {
        DOMConfigurator.configure("src/log4j.xml");
        logger.info("logger is ready");

        try {
            model = new AirportModel();
            //model.addFlights(ExampleDataList.getData());
        } catch (IOException e) {
            logger.fatal("creating AirportModel", e);
            System.exit(1);
        }

        view = new AirportView();

        inputManager = new UserInputManager();

        logger.info("AirportController successfully initialised");
    }

    public void run() {
        while (true) {
            AirportView.printMessage(AirportView.MENU_TITLE);
            AirportView.printMessages(AirportView.MENU_ITEMS);

            int chosenMenuPoint = inputChosenMenuPoint();

            try {
                switch (chosenMenuPoint) {
                    case 1 -> AirportView.printMessage(String.valueOf(model.getFlights()));
                    case 2 -> {
                        processByDestinationSelecting();
                    }
                    case 3 -> {
                        processByDepartureDaySelecting();
                    }
                    case 4 -> {
                        processByDepartureDayTimeSelecting();
                    }
                    case 5 -> {
                        logger.info("user quits the program");
                        return;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    private int inputChosenMenuPoint() {
        int from = 1;
        int to = AirportView.MENU_ITEMS.length;

        String answer;
        int chosenMenuPoint;
        while(true) {
            answer = inputManager.inputWithScanner(AirportView.INPUT_MENU_ITEM);
            if (!TypeCheckerUtility.isInt(answer)) {
                AirportView.printMessage(AirportView.WRONG_INT_INPUT);
                continue;
            }

            chosenMenuPoint = Integer.parseInt(answer);
            if (chosenMenuPoint < from || chosenMenuPoint > to) {
                AirportView.printMessage(AirportView.INT_INPUT_OUT_OF_BOUNDS);
                continue;
            }
            break;
        }
        return chosenMenuPoint;
    }
    private void processByDestinationSelecting() throws IOException, ClassNotFoundException {
        String destination = inputManager.inputWithScanner(AirportView.INPUT_DESTINATION);

        ArrayList<Flight> selectByDestination =
                (ArrayList<Flight>) model.selectBy(FilterParameter.DESTINATION, destination);
        AirportView.printMessage(AirportView.SEARCH_RESULT);
        if (selectByDestination.size() == 0)
            AirportView.printMessage(AirportView.NOTHINGS_FOUND);
        else
            AirportView.printFlightList(selectByDestination);
    }
    private void processByDepartureDaySelecting() throws IOException, ClassNotFoundException {
        String answer = inputManager.inputWithScanner(AirportView.INPUT_DEPARTURE_DAY);
        if (!TypeCheckerUtility.isWeekDay(answer)) {
            AirportView.printMessage(AirportView.WRONG_DAY_INPUT);
            return;
        }
        WeekDay departureDay = WeekDay.valueOf(answer);

        ArrayList<Flight> selectByDepartureDay =
                (ArrayList<Flight>) model.selectBy(FilterParameter.WEEKDAY, departureDay);

        AirportView.printMessage(AirportView.SEARCH_RESULT);
        if (selectByDepartureDay.size() == 0)
            AirportView.printMessage(AirportView.NOTHINGS_FOUND);
        else
            AirportView.printFlightList(selectByDepartureDay);
    }
    private void processByDepartureDayTimeSelecting() throws IOException, ClassNotFoundException {
        String answer = inputManager.inputWithScanner(AirportView.INPUT_DEPARTURE_DAY);
        if (!TypeCheckerUtility.isWeekDay(answer)) {
            AirportView.printMessage(AirportView.WRONG_DAY_INPUT);
            return;
        }
        WeekDay departureDay = WeekDay.valueOf(answer);

        answer = inputManager.inputWithScanner(AirportView.INPUT_DEPARTURE_TIME);
        if (!TypeCheckerUtility.isTime(answer)) {
            AirportView.printMessage(AirportView.WRONG_TIME_INPUT);
            return;
        }
        Time departureTime = Time.parseTime(answer);

        ArrayList<Flight> selectByDepartureDay =
                (ArrayList<Flight>) model.selectBy(FilterParameter.WEEKDAY, departureDay);
        ArrayList<Flight> selectByDepartureTime =
                (ArrayList<Flight>) model.selectBy(FilterParameter.TIME, departureTime);

        List<Flight> common = AirportModel.common(selectByDepartureDay, selectByDepartureTime);

        AirportView.printMessage(AirportView.SEARCH_RESULT);
        if (common.size() == 0)
            AirportView.printMessage(AirportView.NOTHINGS_FOUND);
        else
            AirportView.printFlightList((ArrayList<Flight>) common);
    }
}
