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
        if(_hours < 0 || _hours > 23)
            throw new IllegalArgumentException("Invalid _hours argument:\t" + _hours);
        if(_minutes < 0 || _minutes > 59)
            throw new IllegalArgumentException("Invalid _minutes argument:\t" + _minutes);
        if(_seconds < 0 || _seconds > 59)
            throw new IllegalArgumentException("Invalid _seconds argument:\t" + _seconds);
        hours = _hours;
        minutes = _minutes;
        seconds = _seconds;
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
        return this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds;
    }
    public boolean is_bigger(Time other) {
        return this.hours > other.hours ||
                (this.hours == other.hours && this.minutes > other.minutes) ||
                (this.hours == other.hours && this.minutes == other.minutes && this.seconds > other.seconds);
    }
}