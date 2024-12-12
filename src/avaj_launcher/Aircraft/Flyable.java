package avaj_launcher.Aircraft;
import avaj_launcher.WeatherSystem.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public Flyable () {}

    public abstract void updateConditions();

    public void registerTower(WeatherTower weatherTower) {
        if (weatherTower == null) {
            return;
        }
        this.weatherTower = weatherTower;
    }
}
