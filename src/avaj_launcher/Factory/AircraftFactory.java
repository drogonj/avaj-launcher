package avaj_launcher.Factory;
import avaj_launcher.Aircraft.*;

public class AircraftFactory {
    private static AircraftFactory instance;
    private static long n = 0;

    private AircraftFactory () {}

    public static AircraftFactory getInstance () {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    // TODO
    // Create Exceptions
    public Flyable newFlyable(String p_type, String p_name, int longitude, int latitude, int height) {
        Coordinates p_coordinates;
        try {
            p_coordinates = new Coordinates(longitude, latitude, height);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid coordinates: " + e.getMessage());
        }
        n += 1;
        switch (p_type) {
            case "Helicopter" -> {
                return (new Helicopter(n, p_name, p_coordinates));
            }
            case "JetPlane" -> {
                return (new JetPlane(n, p_name, p_coordinates));
            }
            case "Baloon" -> {
                return (new Baloon(n, p_name, p_coordinates));
            }
            default -> {return null;}
        }
    }
}
