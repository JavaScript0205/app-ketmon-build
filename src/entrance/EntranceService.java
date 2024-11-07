package entrance;

import java.util.Scanner;

public class EntranceService {
    private Scanner scanner = new Scanner(System.in);

    private Entrance[] entrances = new Entrance[5];

    public void crud() {
        System.out.println("What do you want to do on the entrance section?");
        System.out.println("""
                1=> Create, 2=> List,
                3=> Update, 4=> Delete
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
        System.out.println("Enter entrance name: ");
        String name = scanner.nextLine();
        Entrance entrance = new Entrance(name);

        boolean full = true;
        for (int i = 0; i < entrances.length; i++) {
            if (entrances[i] == null) {
                entrances[i] = entrance;
                full = false;
                break;
            }
        }

        if (full) {
            Entrance[] newEntrances = new Entrance[entrances.length * 2];
            System.arraycopy(entrances, 0, newEntrances, 0, entrances.length);

            newEntrances[entrances.length] = entrance;
            entrances = newEntrances;
        }
    }

    private void list() {
        for (int i = 0; i < entrances.length; i++) {
            Entrance entrance = entrances[i];
            if (entrance != null)
                System.out.println(i + 1 + ". " + entrance.getName());
        }
    }

    //edge cases -> unique name
    private void update() {
        System.out.println("Choose updating entrance number: ");
        list();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > entrances.length) {
            System.out.println("Incorrect number");
            update();
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Enter new name");
            String newName = scanner.nextLine();
            Entrance entrance = entrances[idx - 1];
            if (entrance == null) {
                System.out.println("Enter correct number");
                update();
            } else {
                entrance.setName(newName);
                System.out.println("Successfully updated");
            }

        }
    }

    private void delete() {
        System.out.println("Choose deleting floor number: ");
        list();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > entrances.length) {
            System.out.println("Incorrect number");
            delete();
        } else {
            for (int i = idx - 1; i < entrances.length - 1; i++) {
                entrances[i] = entrances[i + 1];
            }
            entrances[entrances.length - 1] = null;
        }
    }

}
