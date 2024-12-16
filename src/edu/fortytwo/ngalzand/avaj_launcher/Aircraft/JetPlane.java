package edu.fortytwo.ngalzand.avaj_launcher.Aircraft;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.SimulationFileFailure;
import java.util.HashMap;
import java.util.Map;

public class JetPlane extends Aircraft {
    final Map<String, int[]> coords_behaviors = new HashMap<>();
    final Map<String, String> msg_behaviors = new HashMap<>();

    public JetPlane (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String toString() {
        return "\033[1mJetPlane#" + this.name + "(" + this.id + ")\033[22m";
    }

    @Override
    public void updateConditions() throws SimulationFileFailure {
        // Behaviors initialization
        if (this.coords_behaviors.isEmpty() || this.msg_behaviors.isEmpty()) {
            this.coords_behaviors.put("SUN", new int[]{0, 10, 2});
            this.coords_behaviors.put("RAIN", new int[]{0, 5, 0});
            this.coords_behaviors.put("FOG", new int[]{0, 1, 0});
            this.coords_behaviors.put("SNOW", new int[]{0, 0, -7});
            this.msg_behaviors.put("SUN", "Let's enjoy the good weather and take some pics.");
            this.msg_behaviors.put("RAIN", "It's raining. Better watch out for lightings.");
            this.msg_behaviors.put("FOG", "It's foggy. I can't see anything.");
            this.msg_behaviors.put("SNOW", "OMG! Winter is coming!");
        }

        // Main function
        final String n_weather = this.weatherTower.getWeather(this.coordinates);
        int n_longitude = this.coordinates.getLongitude() + coords_behaviors.get(n_weather)[0];
        int n_latitude = this.coordinates.getLatitude() + coords_behaviors.get(n_weather)[1];
        int n_height = this.coordinates.getHeight() + coords_behaviors.get(n_weather)[2];
        writef(this + ": " + msg_behaviors.get(n_weather));
        if (n_height <= 0) {
            this.weatherTower.unregister(this);
            writef(this + ": landing.");
            writef("Tower says: " + this + " unregistered from weather tower.");
            return;
        }
        this.coordinates = new Coordinates(n_longitude, n_latitude, n_height);
    }
}
