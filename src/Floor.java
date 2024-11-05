public class Floor {
    private final String name;

    public Floor(String name) {
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
