package floor;

import java.util.Scanner;

public class FloorService {
    private Scanner scanner = new Scanner(System.in);

    private Floor[] floors = new Floor[10];

    public void crud() {
        System.out.println("What do you want to do on the floor section?");
        System.out.println("""
                1=> Create,  2=> List,
                3=> Update,  4=> Delete
                """);
        int cmd = scanner.nextInt();
        scanner = new Scanner(System.in);
        switch (cmd) {
            case 1 -> create();
            case 2 -> list();
            case 3 -> update();
            case 4 -> delete();
            default -> {
                System.out.println("Not properly command");
                crud();
            }
        }
    }

    //edge cases -> unique name
    private void create() {
        System.out.println("Enter floor name: ");
        String name = scanner.nextLine();
        Floor floor = new Floor(name);

        boolean full = true;
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] == null) {
                floors[i] = floor;
                full = false;
                break;
            }
        }

        if (full) {
            Floor[] newFloors = new Floor[floors.length * 2];
            System.arraycopy(floors, 0, newFloors, 0, floors.length);

            newFloors[floors.length] = floor;
            floors = newFloors;
        }

    }

    private void list() {
        for (int i = 0; i < floors.length; i++) {
            Floor floor = floors[i];
            if (floor != null)
                System.out.println(i + 1 + ". " + floor.getName());
        }
    }

    //edge case-> unique name
    private void update() {
        System.out.println("Choose updating floor number: ");
        list();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > floors.length) {
            System.out.println("Incorrect number");
            update();
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Enter new name");
            String newName = scanner.nextLine();
            Floor floor = floors[idx - 1];
            if (floor == null) {
                System.out.println("Enter correct number");
                update();
            } else {
                floor.setName(newName);
                System.out.println("Successfully updated");
            }

        }

    }

    private void delete() {
        System.out.println("Choose deleting floor number: ");
        list();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > floors.length) {
            System.out.println("Incorrect number");
            delete();
        } else {
            for (int i = idx - 1; i < floors.length - 1; i++) {
                floors[i] = floors[i + 1];
            }
            floors[floors.length - 1] = null;
        }

    }
}
