import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*Floor[] floors = new Floor[10];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor((i + 1) + " - etaj");
        }*/

        /*Entrance[] entrances = new Entrance[4];
        for (int i = 0; i < entrances.length; i++) {
            entrances[i] = new Entrance((i + 1) + " - kirish");
        }*/

        /*House[] houses = new House[10];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = new House((i + 1) + " - dom", createFloor(), createEntrance());
        }*/

        while(true) {
            System.out.print("""
                    0. Exit
                    1. Create Complex
                    2. View Complexes

                    Commandalardan birini tanlang:""");
            int command = sc.nextInt();
            switch (command) {
                case 0 -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                case 1 -> {
                    Complex[] complex = createComplex();
                    viewComplex(complex);
                }
            }
        }
    }

    private static void viewComplex(Complex[] complexes) {
        for (Complex complex : complexes) {
            System.out.println(complex.toString());
        }
    }

    private static Complex[] createComplex() {
        House[] house = createHouse();
        System.out.print("Nechta Complex qurmoqchisiz? : ");
        int complexCount = sc.nextInt();
        Complex[] complexes = new Complex[complexCount];
        for (int i = 0; i < complexes.length; i++) {
            complexes[i] = new Complex((i + 1) + " - complex", house);
        }
        return complexes;
    }

    private static House[] createHouse() {
        Floor[] floor = createFloor();
        Entrance[] entrance = createEntrance();
        System.out.print("Nechta uy qurmoqchisiz? : ");
        int houseCount = sc.nextInt();
        House[] houses = new House[houseCount];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = new House((i + 1) + " - dom", floor, entrance);
        }
        return houses;
    }

    private static Floor[] createFloor() {
        System.out.print("Necha qavatdan bo'lsin? : ");
        int floorCount = sc.nextInt();
        Floor[] floors = new Floor[floorCount];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor((i + 1) + " - etaj");
        }
        return floors;
    }

    private static Entrance[] createEntrance() {
        System.out.print("Nechta kirish bo'lsin? : ");
        int entranceCount = sc.nextInt();
        Entrance[] entrances = new Entrance[entranceCount];
        for (int i = 0; i < entrances.length; i++) {
            entrances[i] = new Entrance((i + 1) + " - kirish");
        }
        return entrances;
    }
}