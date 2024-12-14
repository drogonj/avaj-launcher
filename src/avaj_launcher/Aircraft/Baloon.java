package avaj_launcher.Aircraft;
import java.util.HashMap;
import java.util.Map;

public class Baloon extends Aircraft {
    final Map<String, int[]> coords_behaviors = new HashMap<>();
    final Map<String, String> msg_behaviors = new HashMap<>();

    public Baloon (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String toString() {
        return "Baloon#" + this.name + "(" + this.id + ")";
    }

    @Override
    public void updateConditions() {
        // Behaviors initialization
        if (this.coords_behaviors.isEmpty() || this.msg_behaviors.isEmpty()) {
            this.coords_behaviors.put("SUN", new int[]{2, 0, 4});
            this.coords_behaviors.put("RAIN", new int[]{0, 0, -5});
            this.coords_behaviors.put("FOG", new int[]{0, 0, -3});
            this.coords_behaviors.put("SNOW", new int[]{0, 0, -15});
            this.msg_behaviors.put("SUN", "Let's enjoy the good weather and take some pics.");
            this.msg_behaviors.put("RAIN", "Damn you rain! You messed up my baloon.");
            this.msg_behaviors.put("FOG", "It's foggy. I can't see anything.");
            this.msg_behaviors.put("SNOW", "It's snowing. We're gonna crash.");
        }

        // Main function
        final String n_weather = this.weatherTower.getWeather(this.coordinates);
        int n_longitude = this.coordinates.getLongitude() + coords_behaviors.get(n_weather)[0];
        int n_latitude = this.coordinates.getLatitude() + coords_behaviors.get(n_weather)[1];
        int n_height = this.coordinates.getHeight() + coords_behaviors.get(n_weather)[2];
        System.out.println("Baloon#" + this.name + "(" + this.id + "): " + msg_behaviors.get(n_weather));
        if (n_height <= 0) {
            this.weatherTower.unregister(this);
            System.out.println("Baloon#" + this.name + "(" + this.id + "): landing.");
            return;
        }
        this.coordinates = new Coordinates(n_longitude, n_latitude, n_height);
    }
}
