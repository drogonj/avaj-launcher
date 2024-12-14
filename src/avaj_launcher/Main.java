package avaj_launcher;
import avaj_launcher.WeatherSystem.*;
import avaj_launcher.Aircraft.*;
import avaj_launcher.Factory.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private final static int simulationTime = 0;
    private final static WeatherTower weatherTower = null;
    private final List<Flyable> flyables = null;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    """
                            Need scenario file as argument.
                            Scenario file template is as follows:
                            
                            SIMULATION_TIME
                            Baloon NAME LONGITUDE LATITUDE HEIGHT
                            JetPlane NAME LONGITUDE LATITUDE HEIGHT
                            Helicopter NAME LONGITUDE LATITUDE HEIGHT
                            """
            );
            System.exit(1);
        }

        try {
            parseScenario(args[0]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void parseScenario(String scenario_filename) {

    }
}