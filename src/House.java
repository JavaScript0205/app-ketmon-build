import java.util.Arrays;

public class House {
    private final String name;
    private final Floor[] floors;
    private final Entrance[] entrances;

    public House(String name, Floor[] floors, Entrance[] entrances) {
        this.name = name;
        this.floors = floors;
        this.entrances = entrances;
    }

    public String getName() {
        return name;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public Entrance[] getEntrances() {
        return entrances;
    }

    @Override
    public String toString() {
        return "\nname='" + name + '\'' +
                ", \nfloors=" + Arrays.toString(floors) +
                ", \nentrances=" + Arrays.toString(entrances) + "\n";
    }
}
