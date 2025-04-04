package edu.fortytwo.ngalzand.avaj_launcher.Aircraft;
import edu.fortytwo.ngalzand.avaj_launcher.Exceptions.UndefiniedBehavior;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft (long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() throws UndefiniedBehavior {
        // Can't update conditions for Aircraft object
        throw new UndefiniedBehavior("Aircraft object not supposed to update conditions");
    }
}
