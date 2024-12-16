package edu.fortytwo.ngalzand.avaj_launcher.WeatherSystem;
import edu.fortytwo.ngalzand.avaj_launcher.Aircraft.Coordinates;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.AbnormalArgument;

public class WeatherTower extends Tower {
    public WeatherTower () {}

    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
    }

    public void changeWeather() throws AbnormalArgument {
        this.conditionChanged();
    }
}
