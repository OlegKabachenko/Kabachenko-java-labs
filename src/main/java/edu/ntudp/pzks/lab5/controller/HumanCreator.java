package edu.ntudp.pzks.lab5.controller;

import edu.ntudp.pzks.lab5.model.Human;
import edu.ntudp.pzks.lab5.model.Sex;

public class HumanCreator extends PersonCreator {
    public Human createTypicalHuman() {
        String[] names = generateRandomFullName();
        Sex gender = getRandomGender();
        return new Human(names[0], names[1], names[2], gender);
    }

    public Human createHuman(String firstName, String middleName, String lastName, Sex gender) {
        return new Human (firstName, middleName, lastName, gender);
    }
}
