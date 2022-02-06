public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    Time() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    Time(int _hours, int _minutes, int _seconds) {
        hours = (_hours >= 0 && _hours <= 23) ? _hours : 0;
        minutes = (_minutes >= 0 && _minutes <= 59) ? _minutes : 0;
        seconds = (_seconds >= 0 && _seconds <= 59) ? _seconds : 0;
    }
    Time(Time other) {
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
    public boolean is_equal(Time other) {
        if (this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds)
            return true;
        return false;
    }
    public boolean is_bigger(Time other) {
        if (
                this.hours > other.hours ||
                        (this.hours == other.hours && this.minutes > other.minutes) ||
                        (this.hours == other.hours && this.minutes == other.minutes && this.seconds > other.seconds)
        )
            return true;
        return false;
    }
}