package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class NotAnInteger extends RuntimeException {
    public NotAnInteger(String message) {
        super(message + " must be integer.");
    }
}
