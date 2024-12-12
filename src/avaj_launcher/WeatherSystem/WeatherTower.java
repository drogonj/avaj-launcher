package avaj_launcher.WeatherSystem;
import avaj_launcher.Aircraft.Coordinates;

public class WeatherTower extends Tower {
    public WeatherTower () {}

    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}
