package avaj_launcher.Aircraft;
import java.util.EnumMap;
import java.util.Map;
import java.util.EnumMap;

public class Baloon extends Aircraft {
    private static final Map<String, int[]> behaviors = new EnumMap<>(String.class);

    public Baloon (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        behaviors.put("SUN", new int[]{2, 0, 4});
        behaviors.put("RAIN", new int[]{0, 0, -5});
        behaviors.put("FOG", new int[]{0, 0, -3});
        behaviors.put("SNOW", new int[]{0, 0, -15});
    }

    @Override
    public void updateConditions() {
        this.weatherTower.getWeather(this.coordinates);
    }
}
