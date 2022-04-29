package view;

import model.Time;
import model.WeekDay;

import java.util.Scanner;

public class UserInputManager {
    private final Scanner sc;

    public UserInputManager() {
        sc = new Scanner(System.in);
    }

    public int inputIntWithScanner() {
        AirportView.printMessage(AirportView.INPUT_MENU_ITEM);

        String line = sc.nextLine();
        while (!TypeCheckerUtility.isInt(line)) {
            AirportView.printMessage(AirportView.WRONG_INT_INPUT);
            AirportView.printMessage(AirportView.INPUT_MENU_ITEM);
            line = sc.nextLine();
        }
        return Integer.parseInt(line);
    }

    public int inputIntBeth(int from, int to) {
        int result = inputIntWithScanner();
        while (result > to || result < from) {
            AirportView.printMessage(AirportView.INT_INPUT_OUT_OF_BOUNDS);
            result = inputIntWithScanner();
        }
        return result;
    }

    public String inputString(String message) {
        AirportView.printMessage(message);
        return sc.nextLine();
    }

    public WeekDay inputDay(String message) {
        AirportView.printMessage(message);
        String dayString = sc.nextLine();
        while (!TypeCheckerUtility.isWeekDay(dayString)) {
            AirportView.printMessage(AirportView.WRONG_DAY_INPUT);
            dayString = sc.nextLine();
        }
        return WeekDay.valueOf(dayString);
    }

    public Time inputTime(String message) {
        AirportView.printMessage(message);
        String timeString = sc.nextLine();

        while(!TypeCheckerUtility.isTime(timeString)){
            AirportView.printMessage(AirportView.WRONG_TIME_INPUT);
            timeString = sc.nextLine();
        }

        return Time.parseTime(timeString);
    }
}
