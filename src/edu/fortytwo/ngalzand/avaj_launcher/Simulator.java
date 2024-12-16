package edu.fortytwo.ngalzand.avaj_launcher;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.*;
import edu.fortytwo.ngalzand.avaj_launcher.WeatherSystem.*;
import edu.fortytwo.ngalzand.avaj_launcher.Aircraft.*;
import edu.fortytwo.ngalzand.avaj_launcher.Factory.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Simulator {
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
            // Initialization
            parseScenario(args[0]);
            File f = new File("simulation.txt");
            f.createNewFile();

            // Start Simulation
            for (int i = 0; i < simulationTime; i++) {
                weatherTower.changeWeather();
                if (weatherTower.getObservers().isEmpty()) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void parseScenario(String scenario_filename) {
        // Read scenario file
        try (FileInputStream scenario_file = new FileInputStream(scenario_filename)) {
            String line = getnextLine(scenario_file);
            try {
                simulationTime = Integer.parseInt(line);
                if (simulationTime < 0)
                    throw new NegativeArgument("Simulation time");
            } catch (NumberFormatException e) {
                throw new NotAnInteger("Simulation time");
            }
            while (scenario_file.available() > 0) {
                line = getnextLine(scenario_file);
                if (line.isEmpty())
                    continue;
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    throw new ScenarioWrongFormat();
                }
                if (!List.of(aircraft_types).contains(parts[0])) {
                    throw new UnknownAircraft(parts[0]);
                }
                if (parts[1].length() > 10) {
                    throw new TooLongAircraftName(parts[1]);
                }
                int longitude;
                int latitude;
                int height;
                try {
                    longitude = Integer.parseInt(parts[2]);
                    latitude = Integer.parseInt(parts[3]);
                    height = Integer.parseInt(parts[4]);
                } catch (IllegalArgumentException e) {
                    throw new NotAnInteger("Coordinates");
                }
                Coordinates p_coordinates = Coordinates.newCoordinates(longitude, latitude, height);
                if (height == 0)
                    continue;
                Flyable flyable = AircraftFactory.getInstance().newFlyable(parts[0], parts[1], p_coordinates);
                flyable.registerTower(weatherTower);
            }
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