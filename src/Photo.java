import java.time.LocalDate;
import java.util.Set;

public class Photo {
    private String id;
    private String filename;
    private LocalDate date;
    private Coordinates coordinates;
    private Set<String> tags;

    public Photo(String id, String filename, LocalDate date, Coordinates coordinates, Set<String> tags) {
        this.id = id;
        this.filename = filename;
        this.date = date;
        this.coordinates = coordinates;
        this.tags = tags;
    }

    public String getId() { return id; }
    public String getFilename() { return filename; }
    public LocalDate getDate() { return date; }
    public Set<String> getTags() { return tags; }
    public Coordinates getCoordinates() { return coordinates; }

    @Override
    public String toString() {
        return "Photo [" + id + "] \"" + filename + "\" taken on " + date +
                " at " + coordinates + " " + tags;
    }
}
