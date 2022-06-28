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
    private final AirportView view;
    private final UserInputManager inputManager;

    public static Logger logger = Logger.getLogger(AirportController.class);

    public AirportController() {
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

        inputManager = new UserInputManager(view);

        logger.info("AirportController successfully initialised");
    }

    public void run() {
        while (true) {
            view.printMessage(AirportView.MENU_TITLE);
            view.printMessages(AirportView.MENU_ITEMS);

            int chosenMenuPoint = inputChosenMenuPoint();

            try {
                switch (chosenMenuPoint) {
                    case 1 -> view.printMessage(String.valueOf(model.getFlights()));
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
            catch (ClassNotFoundException e) {
                logger.fatal("exception - classNotFoundException:\n", e);
                System.exit(-1);
            }
            catch (IOException e) {
                logger.fatal("exception - IOException:\n", e);
                System.exit(-1);
            }
            catch (Exception e) {
                logger.fatal("exception - Exception:\n", e);
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
                view.printMessage(AirportView.WRONG_INT_INPUT);
                continue;
            }

            chosenMenuPoint = Integer.parseInt(answer);
            if (chosenMenuPoint < from || chosenMenuPoint > to) {
                view.printMessage(AirportView.INT_INPUT_OUT_OF_BOUNDS);
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
        view.printMessage(AirportView.SEARCH_RESULT);
        if (selectByDestination.size() == 0)
            view.printMessage(AirportView.NOTHINGS_FOUND);
        else
            view.printFlightList(selectByDestination);
    }
    private void processByDepartureDaySelecting() throws IOException, ClassNotFoundException {
        String answer = inputManager.inputWithScanner(AirportView.INPUT_DEPARTURE_DAY);
        if (!TypeCheckerUtility.isWeekDay(answer)) {
            view.printMessage(AirportView.WRONG_DAY_INPUT);
            return;
        }
        WeekDay departureDay = WeekDay.valueOf(answer);

        ArrayList<Flight> selectByDepartureDay =
                (ArrayList<Flight>) model.selectBy(FilterParameter.WEEKDAY, departureDay);

        view.printMessage(AirportView.SEARCH_RESULT);
        if (selectByDepartureDay.size() == 0)
            view.printMessage(AirportView.NOTHINGS_FOUND);
        else
            view.printFlightList(selectByDepartureDay);
    }
    private void processByDepartureDayTimeSelecting() throws IOException, ClassNotFoundException {
        String answer = inputManager.inputWithScanner(AirportView.INPUT_DEPARTURE_DAY);
        if (!TypeCheckerUtility.isWeekDay(answer)) {
            view.printMessage(AirportView.WRONG_DAY_INPUT);
            return;
        }
        WeekDay departureDay = WeekDay.valueOf(answer);

        answer = inputManager.inputWithScanner(AirportView.INPUT_DEPARTURE_TIME);
        if (!TypeCheckerUtility.isTime(answer)) {
            view.printMessage(AirportView.WRONG_TIME_INPUT);
            return;
        }
        Time departureTime = Time.parseTime(answer);

        ArrayList<Flight> selectByDepartureDay =
                (ArrayList<Flight>) model.selectBy(FilterParameter.WEEKDAY, departureDay);
        ArrayList<Flight> selectByDepartureTime =
                (ArrayList<Flight>) model.selectBy(FilterParameter.TIME, departureTime);

        List<Flight> common = AirportModel.common(selectByDepartureDay, selectByDepartureTime);

        view.printMessage(AirportView.SEARCH_RESULT);
        if (common.size() == 0)
            view.printMessage(AirportView.NOTHINGS_FOUND);
        else
            view.printFlightList((ArrayList<Flight>) common);
    }
}
