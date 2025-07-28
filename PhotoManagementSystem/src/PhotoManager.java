import java.time.LocalDate;
import java.util.*;

public class PhotoManager {
    private final List<Photo> photos = new ArrayList<>();

    public void uploadPhoto(Photo photo) {
        if (photo == null) {
            throw new IllegalArgumentException("Photo cannot be null");
        }

        if (photo.getId() == null || photo.getId().isEmpty()) {
            throw new IllegalArgumentException("Photo ID cannot be null or empty");
        }

        if (photo.getFilename() == null || photo.getFilename().isEmpty()) {
            throw new IllegalArgumentException("Photo filename cannot be null or empty");
        }

        photos.add(photo);
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public List<Photo> searchByTag(String tag) {
        if (tag == null || tag.isEmpty()) {
            throw new IllegalArgumentException("Tag cannot be null or empty");
        }

        return photos.stream().filter(photo -> photo.getTags().contains(tag))
                .toList();
    }

    public List<Photo> searchByMultipleTags(Set<String> tags) {
        if (tags == null || tags.isEmpty()) {
            throw new IllegalArgumentException("Tags cannot be null or empty");
        }

        return photos.stream()
                .filter(p -> p.getTags().containsAll(tags))
                .toList();
    }

    public List<Photo> searchByLocation(String location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }

        return photos.stream().filter(photo -> photo.getLocation().equalsIgnoreCase(location))
                .toList();
    }

    public List<Photo> searchByDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        return photos.stream().filter(photo -> photo.getDate().equals(date))
                .toList();
    }
}
