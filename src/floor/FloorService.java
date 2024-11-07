package floor;

import java.util.Scanner;

public class FloorService {

    private Scanner scanner = new Scanner(System.in);
    private Floor[] floors = new Floor[2];

    public void crud() {
        while (true) {
            System.out.println("What do you want to do on the floor section?");
            System.out.println("""
                    1=> Create,  2=> List,
                    3=> Update,  4=> Delete,
                    0=> Back to main menu
                    """);
            int cmd = scanner.nextInt();
            scanner = new Scanner(System.in);
            switch (cmd) {
                case 1 -> create();
                case 2 -> list();
                case 3 -> update();
                case 4 -> delete();
                case 0 -> {return;}
                default -> {
                    System.out.println("Not properly command");
                    crud();
                }
            }
        }
    }

    private void create() {
        System.out.println("Enter floor name: ");
        String name = scanner.nextLine();
        Floor floor = new Floor(name);

        //if array has empty slot, we will add and return method
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] != null && floors[i].getName().equals(name)) {
                System.out.println("This floor already exists");
                create();
                return;
            }
            if (floors[i] == null) {
                floors[i] = floor;
                System.out.println("Successfully added");
                System.out.println();
                return;
            }
        }

        //we expand array twice and copy old objects to new array
        Floor[] newFloors = new Floor[floors.length * 2];
        System.arraycopy(floors, 0, newFloors, 0, floors.length);

        newFloors[floors.length] = floor;
        floors = newFloors;
        System.out.println("Successfully added");
        System.out.println();
    }

    private void list() {
        System.out.println("List of floors: ");
        printFloors();
        System.out.println();
    }

    private void update() {
        System.out.println("Choose updating floor number: ");
        printFloors();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > floors.length) {
            System.out.println("Incorrect number");
            update();
            return;
        }
        scanner = new Scanner(System.in);
        idx -= 1;
        System.out.println("Enter new name");
        String newName = scanner.nextLine();

        for (int i = 0; i < floors.length; i++) {
            if (floors[i] != null
                    && i != idx
                    && floors[i].getName().equals(newName)) {
                System.out.println("This floor already exists");
                update();
                return;
            }
            Floor floor = floors[idx];
            if (floor == null) {
                System.out.println("Enter correct number");
                update();
                return;
            }
            floor.setName(newName);
            System.out.println("Successfully updated");
            System.out.println();
        }
    }

    private void delete() {
        System.out.println("Choose deleting floor number: ");
        printFloors();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > floors.length) {
            System.out.println("Incorrect number");
            delete();
            return;
        }

        for (int i = idx - 1; i < floors.length - 1; i++)
            floors[i] = floors[i + 1];

        floors[floors.length - 1] = null;
        System.out.println("Successfully deleted");
        System.out.println();
    }

    private void printFloors() {
        for (int i = 0; i < floors.length; i++)
            if (floors[i] != null)
                System.out.println(i + 1 + ". " + floors[i].getName());
    }
}
