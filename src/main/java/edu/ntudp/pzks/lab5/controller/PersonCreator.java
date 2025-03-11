package edu.ntudp.pzks.lab5.controller;

import com.github.javafaker.Faker;
import edu.ntudp.pzks.lab5.model.Human;
import edu.ntudp.pzks.lab5.model.Sex;

import java.util.Random;

abstract public class PersonCreator {
    public static final Random random = new Random();
    public static final Faker faker = new Faker();

    protected static Sex getRandomGender() {
        return Sex.values()[random.nextInt(Sex.values().length)];
    }

    protected static String[] generateRandomFullName() {
        return new String[]{
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().lastName()
        };
    }
}
