import java.util.Scanner;

public class InputUtility {
    public static int inputIntWithScanner() {
        Scanner sc = new Scanner(System.in);
        AirportView.printMessage(AirportView.INPUT_MENU_ITEM);
        while(!sc.hasNextInt()) {
            AirportView.printMessage(AirportView.WRONG_INT_INPUT);
            AirportView.printMessage(AirportView.INPUT_MENU_ITEM);
            sc.next();
        }
        return sc.nextInt();
    }
    public static int inputIntWithScannerBeth(int from, int to) {
        int result = inputIntWithScanner();
        while(result > to || result < from) {
            AirportView.printMessage(AirportView.INT_INPUT_OUT_OF_BOUNDS);
            result = inputIntWithScanner();
        }
        return result;
    }
    public static String inputStringWithScanner(String message) {
        AirportView.printMessage(message);
        return new Scanner(System.in).nextLine();
    }
    public static Day inputDayWithScanner(String message) {
        AirportView.printMessage(message);
        String dayString = new Scanner(System.in).nextLine();
        while(true) {
            if (dayString.equals("MONDAY"))
                return Day.MONDAY;
            if (dayString.equals("TUESDAY"))
                return Day.TUESDAY;
            if (dayString.equals("WEDNESDAY"))
                return Day.WEDNESDAY;
            if (dayString.equals("THURSDAY"))
                return Day.THURSDAY;
            if (dayString.equals("FRIDAY"))
                return Day.FRIDAY;
            if (dayString.equals("SATURDAY"))
                return Day.SATURDAY;
            if (dayString.equals("SUNDAY"))
                return Day.SUNDAY;

            AirportView.printMessage(AirportView.WRONG_DAY_INPUT);
            dayString = new Scanner(System.in).nextLine();
        }
    }
    public static Time inputTimeWithScanner(String message) {
        while(true) {
            AirportView.printMessage(message);
            String timeString = new Scanner(System.in).nextLine();
            if(timeString.length() < 8) {
                AirportView.printMessage(AirportView.WRONG_TIME_INPUT);
                continue;
            }

            int hours = Integer.parseInt(timeString.substring(0, 2));
            int minutes = Integer.parseInt(timeString.substring(3, 5));
            int seconds = Integer.parseInt(timeString.substring(6, 8));

            if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59 && seconds >= 0 && seconds <= 59)
                return new Time(hours, minutes, seconds);
            AirportView.printMessage(AirportView.WRONG_TIME_INPUT);
        }
    }
}
