package avaj_launcher.WeatherSystem;
import avaj_launcher.Aircraft.Flyable;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public Tower () {}

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
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}
