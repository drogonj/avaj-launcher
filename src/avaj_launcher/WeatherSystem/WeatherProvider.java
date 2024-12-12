package avaj_launcher.WeatherSystem;
import avaj_launcher.Aircraft.Coordinates;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider instance;
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static final Random RANDOM = new Random();

    private WeatherProvider () {}

    public static WeatherProvider getInstance() {
        if (instance == null)
            instance = new WeatherProvider();
        return (instance);
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int baseIndex = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();
        int randomFactor = RANDOM.nextInt(4);
        int weatherIndex = (baseIndex + randomFactor) % 4;

        return (weather[weatherIndex]);
    }
}
