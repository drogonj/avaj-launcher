package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class AbnormalArgument extends RuntimeException {
    public AbnormalArgument(String message) {
        super("Abnormal argument: " + message);
    }
}
