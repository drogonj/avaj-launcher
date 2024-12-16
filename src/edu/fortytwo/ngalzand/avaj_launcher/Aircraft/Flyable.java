package edu.fortytwo.ngalzand.avaj_launcher.Aircraft;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.AbnormalArgument;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.SimulationFileFailure;
import edu.fortytwo.ngalzand.avaj_launcher.WeatherSystem.WeatherTower;
import java.io.FileWriter;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public Flyable () {}

    public abstract void updateConditions();

    public void registerTower(WeatherTower weatherTower) throws AbnormalArgument {
        if (weatherTower == null) {
            throw new AbnormalArgument("Weather tower is null");
        }
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        writef("Tower says: " + this + " registered to weather tower.");
    }

    protected static void writef(String string) throws SimulationFileFailure {
        try {
            FileWriter w = new FileWriter("simulation.txt", true); // true: Ouvrir en mode "concatenation"
            w.write(string + "\n");
            w.close();
        } catch (Exception e) {
            throw new SimulationFileFailure(e.getMessage());
        }
    }
}
