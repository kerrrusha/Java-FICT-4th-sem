package view;

import model.Time;
import model.WeekDay;

public class TypeCheckerUtility {
    public static boolean isInt(String input) {
        if (input == null)
            return false;
        try {
            int i = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isWeekDay(String input) {
        if (input == null)
            return false;
        try {
            WeekDay w = WeekDay.valueOf(input);
        } catch (IllegalArgumentException iae) {
            return false;
        }
        return true;
    }
    public static boolean isTime(String input) {
        if (input == null)
            return false;
        try {
            Time t = Time.parseTime(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
