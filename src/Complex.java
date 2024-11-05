import java.util.Arrays;

public class Complex {
    private final String name;
    private final House[] houses;

    public Complex(String name, House[] houses) {
        this.name = name;
        this.houses = houses;
    }

    public String getName() {
        return name;
    }

    public House[] getHouses() {
        return houses;
    }

    @Override
    public String toString() {
        return "\nname='" + name + "'" +
                ", \nhouses=" + Arrays.toString(houses) + "\n";
    }
}
