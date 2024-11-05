public class Entrance {
    private final String name;

    public Entrance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + "'";
    }
}
