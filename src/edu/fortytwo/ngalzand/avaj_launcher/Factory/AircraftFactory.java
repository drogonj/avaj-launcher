package edu.fortytwo.ngalzand.avaj_launcher.Factory;
import edu.fortytwo.ngalzand.avaj_launcher.Aircraft.*;

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

    public Flyable newFlyable(String p_type, String p_name, Coordinates p_coordinates) {
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
