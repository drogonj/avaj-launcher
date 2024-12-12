package avaj_launcher.Factory;
import avaj_launcher.Aircraft.*;

public class AircraftFactory {
    private static AircraftFactory instance;
    private static long n;

    private AircraftFactory () {}

    public static AircraftFactory getInstance () {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    // TODO
    // Create Exceptions
    public Flyable newFlyable(String p_type, String p_name, Coordinates p_coordinates) {
        this.n += 1;
        switch (p_type) {
            case "Helicopter" -> {
                return (new Helicopter(this.n, p_name, p_coordinates));
            }
            case "JetPlane" -> {
                return (new JetPlane(this.n, p_name, p_coordinates));
            }
            case "Baloon" -> {
                return (new Baloon(this.n, p_name, p_coordinates));
            }
            default -> {return null;}
        }
    }
}
