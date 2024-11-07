package entrance;

import java.util.Scanner;

public class EntranceService {
    private Scanner scanner = new Scanner(System.in);
    private static int entranceCount = 0;

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

    private boolean isDuplicate(String name) {
        for (int i = 0; i < entranceCount; i++) {
            if (entrances[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    //edge cases -> unique name
    private void create() {
        System.out.println("Enter entrance name: ");
        String name = scanner.nextLine();
        while (true) {
            if (isDuplicate(name)) {
                System.out.println("This name is already taken. Please enter a unique name.");
            } else {
                entrances[entranceCount++] = new Entrance(name);
                System.out.println("Entrance created with name: " + name);
                break;
            }
        }
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
            for (int i = 0; i < entrances.length; i++)
                newEntrances[i] = entrances[i];

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
            while (true) {
                if (isDuplicate(newName)) {
                    System.out.println("This name is already taken. Please enter a unique name.");
                } else {
                    entrances[entranceCount++] = new Entrance(newName);
                    System.out.println("Entrance created with name: " + newName);
                    break;
                }
            }
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
