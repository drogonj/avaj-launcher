package avaj_launcher.Aircraft;

public class Coordinates {
    final private int longitude;
    final private int latitude;
    final private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        if (p_latitude < 0 || p_longitude < 0 || p_height < 0) {
            throw new IllegalArgumentException("Coordinates must be positive: " + p_longitude + ", " + p_latitude + ", " + p_height);
        }
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = Math.min(p_height, 100);
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}