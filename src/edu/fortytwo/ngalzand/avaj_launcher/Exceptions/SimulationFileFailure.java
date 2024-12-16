package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class SimulationFileFailure extends RuntimeException {
    public SimulationFileFailure(String message) {
        super("Failed to write simulation.txt: " + message);
    }
}
