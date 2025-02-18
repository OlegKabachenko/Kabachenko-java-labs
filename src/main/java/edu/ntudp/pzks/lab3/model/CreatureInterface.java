package edu.ntudp.pzks.lab3.model;

public interface  CreatureInterface {
    public static enum Sex {
        MALE, FEMALE
    }
    public Sex getGender();
    public String getName();
}
