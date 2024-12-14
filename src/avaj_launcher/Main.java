package avaj_launcher;
import avaj_launcher.WeatherSystem.*;
import avaj_launcher.Aircraft.*;
import avaj_launcher.Factory.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static int simulationTime = -1;
    private final static WeatherTower weatherTower = new WeatherTower();
    private final static String[] aircraft_types = {"Baloon", "JetPlane", "Helicopter"};

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
            for (int i = 0; i < simulationTime; i++) {
                weatherTower.changeWeather();
                if (weatherTower.getObservers().isEmpty()) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void parseScenario(String scenario_filename) throws IOException {
        // Read scenario file
        try (FileInputStream scenario_file = new FileInputStream(scenario_filename)) {
            String line = getnextLine(scenario_file);
            try {
                simulationTime = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Simulation time must be an integer");
            }
            while (scenario_file.available() > 0) {
                line = getnextLine(scenario_file);
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    throw new IllegalArgumentException("Wrong Format: " + line);
                }
                if (!List.of(aircraft_types).contains(parts[0])) {
                    throw new IllegalArgumentException("Unknown aircraft type: " + parts[0]);
                }
                String type = parts[0];
                if (parts[1].length() > 10) {
                    throw new IllegalArgumentException("Aircraft name is too long: " + parts[1]);
                }
                String name = parts[1];
                int longitude;
                try {
                    longitude = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Longitude must be an integer: " + parts[2]);
                }
                int latitude;
                try {
                    latitude = Integer.parseInt(parts[3]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Latitude must be an integer: " + parts[3]);
                }
                int height;
                try {
                    height = Integer.parseInt(parts[4]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Height must be an integer: " + parts[4]);
                }
                Flyable flyable = AircraftFactory.getInstance().newFlyable(type, name, longitude, latitude, height);
                if (flyable != null) {
                    flyable.registerTower(weatherTower);
                }
            }
            scenario_file.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read scenario file: " + e.getMessage());
        }
    }

    private static String getnextLine(FileInputStream scenario_file) throws IOException {
        StringBuilder line = new StringBuilder();
        int c;
        while ((c = scenario_file.read()) != -1 && c != '\n') {
            line.append((char) c);
        }
        return line.toString().trim();
    }
}