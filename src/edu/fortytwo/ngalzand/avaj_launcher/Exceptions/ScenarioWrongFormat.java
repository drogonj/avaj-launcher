package edu.fortytwo.ngalzand.avaj_launcher.Exceptions;

public class ScenarioWrongFormat extends RuntimeException {
    public ScenarioWrongFormat() {
      super("Wrong scenario format. Required:\nTYPE NAME LONGITUDE LATITUDE HEIGHT");
    }
}
