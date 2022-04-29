package model;

import org.jetbrains.annotations.NotNull;
import java.io.Serializable;

public class Time implements Serializable {
    private static final int serialVersionUID = 1;

    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    public Time(int hours, int minutes, int seconds) {
        if(hours < 0 || hours > 23)
            throw new IllegalArgumentException("Hours must be from 0 to 23");
        if(minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("Minutes must be from 0 to 59");
        if(seconds < 0 || seconds > 59)
            throw new IllegalArgumentException("Seconds must be from 0 to 59");

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    Time(@NotNull Time other) {
        this.hours = other.hours;
        this.minutes = other.minutes;
        this.seconds = other.seconds;
    }
    public String toString() {
        String result = "";

        if(hours < 10)
            result += "0";
        result += hours + ":";

        if(minutes < 10)
            result += "0";
        result += minutes + ":";

        if(seconds < 10)
            result += "0";
        result += String.valueOf(seconds);

        return result;
    }
    public boolean isEqual(@NotNull Time other) {
        return this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds;
    }
    public boolean isBigger(@NotNull Time other) {
        return this.hours > other.hours ||
                (this.hours == other.hours && this.minutes > other.minutes) ||
                (this.hours == other.hours && this.minutes == other.minutes && this.seconds > other.seconds);
    }
    public boolean in24HoursFormat() {
        return (0 <= hours && hours <= 23 && 0 <= minutes && minutes <= 59 && 0 <= seconds && seconds <= 59);
    }

    public static Time parseTime(String str) throws IllegalArgumentException {
        // 'str' argument must be String presentation of Time object in format "12:00:00"
        if (str == null)
            throw new IllegalArgumentException("Argument is null");

        str = str.replaceAll("\\s", "");    //remove all spaces

        return switch (str.length()) {
            case 2 -> new Time(Integer.parseInt(str), 0, 0);
            case 5 -> new Time(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(3, 5)), 0);
            case 8 -> new Time(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(3, 5)), Integer.parseInt(str.substring(6, 8)));
            default -> throw new IllegalArgumentException("Argument came not in acceptable form ('12:00:00')");
        };
    }
}