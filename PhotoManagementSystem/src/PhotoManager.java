import java.time.LocalDate;
import java.util.*;

public class PhotoManager {
    // photo indexes (for fast lookup)
    private final Map<String, Set<Photo>> photosByLocation = new HashMap<>();
    private final Map<String, Set<Photo>> photosByTag = new HashMap<>();
    private final Map<String, Photo> photosById = new HashMap<>();
    private final Map<LocalDate, Set<Photo>> photosByDate = new HashMap<>();
    private final Map<String, Photo> photosByFilename = new HashMap<>();

    public void uploadPhoto(Photo photo) {
        if (photo == null || photo.getId() == null || photo.getFilename() == null) {
            throw new IllegalArgumentException("Photo and its ID and filename cannot be null");
        }

        if (photosById.containsKey(photo.getId())) {
            throw new IllegalArgumentException("Photo with this ID already exists");
        }

        photosById.put(photo.getId(), photo);

        if (photosByFilename.containsKey(photo.getFilename())) {
            throw new IllegalArgumentException("Photo with this filename already exists");
        }

        photosByFilename.put(photo.getFilename(), photo);

        if (photo.getDate() != null) {
            photosByDate.computeIfAbsent(photo.getDate(), k -> new HashSet<>()).add(photo);
        }

        if (photo.getLocation() != null) {
            photosByLocation.computeIfAbsent(photo.getLocation(), k -> new HashSet<>()).add(photo);
        }

        if (photo.getTags() != null) {
            for (String tag : photo.getTags()) {
                photosByTag.computeIfAbsent(tag, k -> new HashSet<>()).add(photo);
            }
        }
    }

    public List<Photo> getPhotos() {
        return new ArrayList<>(photosById.values());
    }

    public List<Photo> searchByTag(String tag) {
        if (tag == null || tag.isEmpty()) {
            throw new IllegalArgumentException("Tag cannot be null or empty");
        }

        return photosByTag.getOrDefault(tag, Collections.emptySet())
                .stream()
                .toList();
    }

    public List<Photo> searchByMultipleTags(Set<String> tags) {
        if (tags == null || tags.isEmpty()) {
            throw new IllegalArgumentException("Tags cannot be null or empty");
        }

        List<Photo> result = new ArrayList<>();
        for (String tag : tags) {
            result.addAll(searchByTag(tag));
        }

        return new ArrayList<>(result);
    }

    public List<Photo> searchByLocation(String location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }

        return photosByLocation.getOrDefault(location, Collections.emptySet())
                .stream()
                .toList();
    }

    public List<Photo> searchByDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        return photosByDate.getOrDefault(date, Collections.emptySet())
                .stream()
                .toList();
    }
}
