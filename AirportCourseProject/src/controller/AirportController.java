package controller;

import dataManager.ExampleDataList;
import model.AirportModel;
import model.Flight;
import model.Time;
import model.WeekDay;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import view.AirportView;
import view.UserInputManager;

import java.io.IOException;

public class AirportController {
    private class Validator {
        public boolean checkIntBeth(int number, int from, int to) {
            return (from <= number && number <= to);
        }
        public boolean checkDestination(String destination) throws IOException, ClassNotFoundException {
            return model.getFlights().stream().map(Flight::getDestination).distinct().toList().contains(destination);
        }
        @SuppressWarnings("all")
        public boolean checkDepartureDay(WeekDay day) throws IOException, ClassNotFoundException {
            return model.getFlights().stream().map(Flight::getDepartureDay).distinct().toList().contains(day);
        }
        public boolean checkTime(Time time) {
            return time.in24HoursFormat();
        }
    }

    private AirportModel model;
    private AirportView view;
    private final UserInputManager inputManager;
    private final Validator validator;

    public static Logger logger = Logger.getLogger(AirportController.class);

    public AirportController() {
        FileAppender appender = null;
        try {
            appender = new FileAppender(new PatternLayout("%d{HH:mm:ss,SSS}\t%-5p: %m%n"), "log.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);
        logger.info("logger is ready");

        String dataFileAddress = ".//data.ser";

        try {
            model = new AirportModel(dataFileAddress);
            //model.addFlights(ExampleDataList.getData());
        } catch (IOException e) {
            logger.error("creating AirportModel", e);
        }
        logger.info("AirportModel initialised");

//        logger.info("trying to load all flights...");
//        var flights = model.getFlights();
//        logger.debug("After initialising, AirportModel contains:\n" + flights);

        view = new AirportView();
        logger.info("AirportView initialised");

        inputManager = new UserInputManager();
        logger.info("UserInputManager initialised");

        validator = new Validator();
        logger.info("Validator initialised");

        logger.info("AirportController successfully initialised");
    }

    public void run() throws IOException, ClassNotFoundException {
        logger.info("running AirportController");
        menu();
    }
    public void menu() throws IOException, ClassNotFoundException {
        logger.info("opening Airport menu");

        while (true) {
            AirportView.printMessage(AirportView.MENU_TITLE);
            AirportView.printMessages(AirportView.MENU_ITEMS);

            logger.info("menu point input");
            int from = 1;
            int to = AirportView.MENU_ITEMS.length;
            int answer = inputManager.inputIntBeth(from, to);
            if (!validator.checkIntBeth(answer, from, to)) {
                AirportView.printMessage(AirportView.INT_NOT_IN_BOUNDS);
                continue;
            }

            switch (answer) {
                case 1 -> AirportView.printMessage(String.valueOf(model.getFlights()));
                case 2 -> {
                    logger.info("destination input");
                    String destination = inputManager.inputString(AirportView.INPUT_DESTINATION);
                    if (!validator.checkDestination(destination)) {
                        AirportView.printMessage(AirportView.NOT_EXISTING_DESTINATION);
                        continue;
                    }

                    logger.info("filtering flights by destination:\t" + destination);
                    var selectByDestination =
                            AirportModel.FilterUtility.selectByDestination(model.getFlights(), destination);
                    AirportView.printMessage(AirportView.SEARCH_RESULT);
                    if (selectByDestination.size() == 0)
                        AirportView.printMessage(AirportView.NOTHINGS_FOUND);
                    else
                        AirportView.printFlightList(selectByDestination);
                }
                case 3 -> {
                    logger.info("WeekDay input");
                    WeekDay departureDay = inputManager.inputDay(AirportView.INPUT_DEPARTURE_DAY);
                    if (!validator.checkDepartureDay(departureDay)) {
                        AirportView.printMessage(AirportView.NOT_EXISTING_DEPARTURE_DAY);
                        continue;
                    }

                    logger.info("filtering flights by departure day:\t" + departureDay);
                    var selectByDepartureDay =
                            AirportModel.FilterUtility.selectByDepartureDay(model.getFlights(), departureDay);

                    AirportView.printMessage(AirportView.SEARCH_RESULT);
                    if (selectByDepartureDay.size() == 0)
                        AirportView.printMessage(AirportView.NOTHINGS_FOUND);
                    else
                        AirportView.printFlightList(selectByDepartureDay);
                }
                case 4 -> {
                    logger.info("WeekDay input");
                    WeekDay day = inputManager.inputDay(AirportView.INPUT_DEPARTURE_DAY);
                    if (!validator.checkDepartureDay(day)) {
                        AirportView.printMessage(AirportView.NOT_EXISTING_DEPARTURE_DAY);
                        continue;
                    }
                    logger.info("Time input");
                    Time timeFrom = inputManager.inputTime(AirportView.INPUT_DEPARTURE_TIME);
                    if (!validator.checkTime(timeFrom)) {
                        AirportView.printMessage(AirportView.WRONG_TIME_INPUT);
                        continue;
                    }

                    logger.info("filtering flights by departure day:\t" + day);
                    var selectByDepartureDay =
                            AirportModel.FilterUtility.selectByDepartureDay(model.getFlights(), day);
                    logger.info("filtering flights by time:\t" + timeFrom);
                    var selectByDepartureDayAndTime =
                            AirportModel.FilterUtility.selectAfterTime(selectByDepartureDay, timeFrom);

                    AirportView.printMessage(AirportView.SEARCH_RESULT);
                    if (selectByDepartureDayAndTime.size() == 0)
                        AirportView.printMessage(AirportView.NOTHINGS_FOUND);
                    else
                        AirportView.printFlightList(selectByDepartureDayAndTime);
                }
                case 5 -> {
                    logger.info("quit");
                    return;
                }
            }
        }
    }
}
