package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class NegativeArgument extends RuntimeException {
    public NegativeArgument(String message) {
        super(message + " must be positive.");
    }
}
