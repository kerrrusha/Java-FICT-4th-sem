package view;

import java.util.Scanner;

public class UserInputManager {
    private final Scanner sc;

    public UserInputManager() {
        sc = new Scanner(System.in);
    }

    public String inputWithScanner(String msg) {
        AirportView.printMessage(msg);
        return sc.nextLine();
    }
}
