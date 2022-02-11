public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    Time() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    Time(int hours, int minutes, int seconds) {
        if(hours >= 0 && hours <= 23)
            this.hours = hours;
        if(minutes >= 0 && minutes <= 59)
            this.minutes = minutes;
        if(seconds >= 0 && seconds <= 59)
            this.seconds = seconds;
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
    public boolean isEqual(Time other) {
        return this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds;
    }
    public boolean isBigger(Time other) {
        return this.hours > other.hours ||
                (this.hours == other.hours && this.minutes > other.minutes) ||
                (this.hours == other.hours && this.minutes == other.minutes && this.seconds > other.seconds);
    }
}