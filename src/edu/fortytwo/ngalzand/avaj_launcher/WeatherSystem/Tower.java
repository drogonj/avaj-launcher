package edu.fortytwo.ngalzand.avaj_launcher.WeatherSystem;
import edu.fortytwo.ngalzand.avaj_launcher.Aircraft.Flyable;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.AbnormalArgument;
import java.util.List;

public class Tower {
    private final List<Flyable> observers = new java.util.ArrayList<>();

    public Tower () {}

    public List<Flyable> getObservers() {
        return this.observers;
    }

    public void register(Flyable p_flyable) {
        if (p_flyable == null)
            throw new AbnormalArgument("Try to register a null Flyable");
        if (this.observers.contains(p_flyable))
            throw new AbnormalArgument("Try to register an already registered object");
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        if (p_flyable == null)
            throw new AbnormalArgument("Try to unregister null object");
        if (!this.observers.contains(p_flyable))
            return;
        this.observers.remove(p_flyable);
    }

    protected void conditionChanged() throws AbnormalArgument {
        final List<Flyable> s_observers = new java.util.ArrayList<>(this.observers);
        for (Flyable observer : s_observers) {
            observer.updateConditions();
        }
    }
}
