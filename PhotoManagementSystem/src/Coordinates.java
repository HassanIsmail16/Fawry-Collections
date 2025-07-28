public class Coordinates {
    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double distanceTo(Coordinates other) {
        // simple distance formula (ignore Earth's curvature for simplicity)
        // in a real context, it would be better to use Haversine formula
        // but I did not want to make things too complex
        double latitudeDelta = this.latitude - other.latitude;
        double longitudeDelta  = this.longitude - other.longitude;
        return Math.sqrt(latitudeDelta * latitudeDelta + longitudeDelta * longitudeDelta);
    }

    @Override
    public String toString() {
        return "(latitude: " + latitude + ", longitude: " + longitude + ")";
    }
}
