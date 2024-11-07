package entrance;

import java.util.Scanner;

public class EntranceService {
    private Scanner scanner = new Scanner(System.in);
    private Entrance[] entrances = new Entrance[5];

    public void crud() {
        while (true) {
            System.out.println("What do you want to do on the entrance section?");
            System.out.println("""
                    1=> Create, 2=> List,
                    3=> Update, 4=> Delete
                    0=> Back to main menu
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
    }

    private void create() {
        System.out.println("Enter entrance name: ");
        String name = scanner.nextLine();
        Entrance entrance = new Entrance(name);

        //if array has empty slot, we will add and return method
        for (int i = 0; i < entrances.length; i++) {
            if (entrances[i] != null && entrances[i].getName().equals(name)) {
                System.out.println("This entrance already exists");
                create();
                return;
            }
            if (entrances[i] == null) {
                entrances[i] = entrance;
                System.out.println("Successfully added");
                System.out.println();
                return;
            }
        }

        //we expand array twice and copy old objects to new array
        Entrance[] newEntrances = new Entrance[entrances.length * 2];
        System.arraycopy(entrances, 0, newEntrances, 0, entrances.length);

        newEntrances[entrances.length] = entrance;
        entrances = newEntrances;
        System.out.println("Successfully added");
        System.out.println();
    }

    private void list() {
        System.out.println("List of floors: ");
        printFloors();
        System.out.println();
    }

    private void update() {
        System.out.println("Choose updating entrance number: ");
        printFloors();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > entrances.length) {
            System.out.println("Incorrect number");
            update();
            return;
        }
        scanner = new Scanner(System.in);
        idx -= 1;
        System.out.println("Enter new name");
        String newName = scanner.nextLine();

        for (int i = 0; i < entrances.length; i++) {
            if (entrances[i] != null
                    && i != idx
                    && entrances[i].getName().equals(newName)) {
                System.out.println("This floor already exists");
                update();
                return;
            }
            Entrance entrance = entrances[idx];
            if (entrance == null) {
                System.out.println("Enter correct number");
                update();
                return;
            }
            entrance.setName(newName);
            System.out.println("Successfully updated");
            System.out.println();
        }
    }

    private void delete() {
        System.out.println("Choose deleting floor number: ");
        printFloors();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > entrances.length) {
            System.out.println("Incorrect number");
            delete();
            return;
        }
        for (int i = idx - 1; i < entrances.length - 1; i++)
            entrances[i] = entrances[i + 1];

        entrances[entrances.length - 1] = null;
        System.out.println("Successfully deleted");
        System.out.println();
    }

    private void printFloors() {
        for (int i = 0; i < entrances.length; i++) {
            Entrance entrance = entrances[i];
            if (entrance != null)
                System.out.println(i + 1 + ". " + entrance.getName());
        }
    }
}
