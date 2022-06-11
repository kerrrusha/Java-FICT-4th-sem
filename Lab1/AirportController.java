public class AirportController {
    private AirportModel model = new AirportModel();

    public void run() {
        model.append(DataList.getData());
        menu();
    }
    public void menu() {
        while(true) {
            AirportView.printMessage(AirportView.MENU_TITLE);
            AirportView.printMessage(AirportView.MENU_ITEMS);
            int answer = InputUtility.inputIntWithScannerBeth(1, AirportView.MENU_ITEMS.length);
            switch (answer) {
                case 1:
                    AirportView.printMessage(model.toString());
                    break;
                case 2:
                    String destination = InputUtility.inputStringWithScanner(AirportView.INPUT_DESTINATION);
                    var selectByDestination = model.selectByDestination(destination);
                    AirportView.printMessage(AirportView.SEARCH_RESULT);
                    if(selectByDestination.length == 0)
                        AirportView.printMessage(AirportView.NOTHINGS_FOUND);
                    else
                        AirportView.printFlightList(selectByDestination);
                    break;
                case 3:
                    Day departureDay = InputUtility.inputDayWithScanner(AirportView.INPUT_DEPARTURE_DAY);
                    var selectByDepartureDay = model.selectByDepartureDay(departureDay);
                    AirportView.printMessage(AirportView.SEARCH_RESULT);
                    if(selectByDepartureDay.length == 0)
                        AirportView.printMessage(AirportView.NOTHINGS_FOUND);
                    else
                        AirportView.printFlightList(selectByDepartureDay);
                    break;
                case 4:
                    Day day = InputUtility.inputDayWithScanner(AirportView.INPUT_DEPARTURE_DAY);
                    Time time = InputUtility.inputTimeWithScanner(AirportView.INPUT_DEPARTURE_TIME);
                    var selectByDepartureDayAndTime = model.selectByDepartureDayAndTime(day, time);
                    AirportView.printMessage(AirportView.SEARCH_RESULT);
                    if(selectByDepartureDayAndTime.length == 0)
                        AirportView.printMessage(AirportView.NOTHINGS_FOUND);
                    else
                        AirportView.printFlightList(selectByDepartureDayAndTime);
                    break;
                case 5:
                    return;
            }
        }
    }
}
