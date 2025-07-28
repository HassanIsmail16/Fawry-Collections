import java.time.LocalDate;
import java.util.Set;

public class Photo {
    private String id;
    private String filename;
    private LocalDate date;
    private String Location;
    private Set<String> tags;

    public Photo(String id, String filename, LocalDate date, String location, Set<String> tags) {
        this.id = id;
        this.filename = filename;
        this.date = date;
        this.Location = location;
        this.tags = tags;
    }

    public String getId() { return id; }
    public String getFilename() { return filename; }
    public LocalDate getDate() { return date; }
    public String getLocation() { return Location; }
    public Set<String> getTags() { return tags; }

    @Override
    public String toString() {
        return "Photo [" + id + "] \"" + filename + "\" taken on " + date +
                " at " + Location + " " + tags;
    }
}
