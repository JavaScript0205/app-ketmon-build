import entrance.EntranceService;
import floor.FloorService;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FloorService flService = new FloorService();
        EntranceService entService = new EntranceService();

        int command = -1;
        while (command != 0) {
            System.out.println("""
                    Choose one of the commands:
                    0=> Terminate
                    1=> Floor CRUD
                    2=> Entrance CRUD
                    """);
            command = scanner.nextInt();
            switch (command) {
                case 1 -> flService.crud();
                case 2 -> entService.crud();
            }


        }
    }
}