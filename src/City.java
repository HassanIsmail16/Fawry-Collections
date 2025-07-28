public class City {
    private String name;
    private Coordinates coordinates;
    private final double ZONE_RADIUS = 40; // default radius q(I just picked an arbitrary value)

    public City(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isWithin(double longitude, double latitude) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        return isWithin(coordinates);
    }

    public boolean isWithin(Coordinates coordinates) {
        return this.coordinates.distanceTo(coordinates) <= ZONE_RADIUS;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + coordinates + "}";
    }
}
