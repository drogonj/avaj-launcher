package avaj_launcher.Aircraft;

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
    public void updateConditions() {
        // Can't update conditions for Aircraft object
        throw new UnsupportedOperationException("Aircraft object not supposed to update conditions");
    }
}
