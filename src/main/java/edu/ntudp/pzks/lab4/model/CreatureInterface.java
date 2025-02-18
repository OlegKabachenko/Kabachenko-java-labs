package edu.ntudp.pzks.lab4.model;

public interface  CreatureInterface {
    public static enum Sex {
        MALE, FEMALE
    }
    public Sex getGender();
    public String getName();
}
