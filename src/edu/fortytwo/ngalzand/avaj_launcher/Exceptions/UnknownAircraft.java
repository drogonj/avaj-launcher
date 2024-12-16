package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class UnknownAircraft extends RuntimeException {
    public UnknownAircraft(String message) {
        super("Unknown aircraft type: " + message);
    }
}
