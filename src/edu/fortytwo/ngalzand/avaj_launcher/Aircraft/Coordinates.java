package edu.fortytwo.ngalzand.avaj_launcher.Aircraft;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.NegativeArgument;

public class Coordinates {
    final private int longitude;
    final private int latitude;
    final private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) throws NegativeArgument {
        if (p_latitude < 0 || p_longitude < 0 || p_height < 0) {
            throw new NegativeArgument("Coordinates");
        }
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = Math.min(p_height, 100);
    }

    public static Coordinates newCoordinates(int p_longitude, int p_latitude, int p_height) throws NegativeArgument {
        return new Coordinates(p_longitude, p_latitude, p_height);
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