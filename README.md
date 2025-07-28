# Fawry-Collections
## Description
This is my solution for the Java Collections task in the Fawry Fullstack Internship. 

## Design
- `PhotoManager` stores provides methods for searching and uploading photos.
- Photos are stored in hash maps, which act as indexes, to make photo retrieval more performant.
- `PhotoManager` can lookup photos by id, filename, tag, or date in `O(1)` time complexity because of the way photos are stored inside of it.
- For location-based photo lookup, `PhotoManager` checks if the coordinates the photo was taken at match the coordinates of any city
- City location data is stored inside a hash map in `PhotoManager`, also for fast lookup
- You can tweak the radius of each city in the `City` class (`ZONE_RADIUS`)
- You can also seed more city location data in the `PhotoManager` constructor

## Possible Improvements

- **Use proper geographic distance calculation:**  
  Replace the simplified Euclidean distance in `Coordinates.distanceTo()` with the Haversine formula for more accurate distance calculations between latitude and longitude points.

- **Make zone radius configurable:**  
  Move the hardcoded `ZONE_RADIUS` value from `City` into a configuration file.

## Screenshot
Here's a screenshot of the output of the `Main.main()` method
<img width="1337" height="590" alt="image" src="https://github.com/user-attachments/assets/29de633e-26a1-40ce-94fe-f14689af6261" />
