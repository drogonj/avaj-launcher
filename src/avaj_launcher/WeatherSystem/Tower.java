package avaj_launcher.WeatherSystem;
import avaj_launcher.Aircraft.Flyable;
import java.util.List;

public class Tower {
    private final List<Flyable> observers = new java.util.ArrayList<Flyable>();

    public Tower () {}

    public List<Flyable> getObservers() {
        return this.observers;
    }

    public void register(Flyable p_flyable) {
        if (p_flyable == null)
            return;
        if (this.observers.contains(p_flyable))
            return;
        this.observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        if (p_flyable == null)
            return;
        if (!this.observers.contains(p_flyable))
            return;
        this.observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
        final List<Flyable> s_observers = new java.util.ArrayList<Flyable>(this.observers);
        for (Flyable observer : s_observers) {
            observer.updateConditions();
        }
    }
}
