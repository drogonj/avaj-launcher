package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class TooLongAircraftName extends RuntimeException {
    public TooLongAircraftName(String message) {
        super("Too long Aircraft name: " + message);
    }
}
