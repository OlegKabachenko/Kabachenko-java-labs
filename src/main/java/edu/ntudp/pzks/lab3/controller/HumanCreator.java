package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Human;

public class HumanCreator extends PersonCreator {
    public static Human createTypicalHuman() {
        String[] names = generateRandomFullName();
        Human.Sex gender = getRandomGender();
        return new Human(names[0], names[1], names[2], gender);
    }

    public static Human createHuman(String firstName, String middleName, String lastName, Human.Sex gender) {
        return new Human (firstName, middleName, lastName, gender);
    }
}
