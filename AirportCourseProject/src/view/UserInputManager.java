package view;

import java.util.Scanner;

public class UserInputManager {
    private final Scanner sc;
    private final AirportView view;

    public UserInputManager(AirportView view) {
        sc = new Scanner(System.in);
        this.view = view;
    }

    public String inputWithScanner(String msg) {
        view.printMessage(msg);
        return sc.nextLine();
    }
}
