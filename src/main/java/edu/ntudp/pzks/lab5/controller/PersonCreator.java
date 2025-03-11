package edu.ntudp.pzks.lab5.controller;

import com.github.javafaker.Faker;
import edu.ntudp.pzks.lab5.model.Human;
import edu.ntudp.pzks.lab5.model.Sex;

import java.util.Random;

abstract public class PersonCreator {
    protected final Random random = new Random();
    protected final Faker faker = new Faker();

    protected Sex getRandomGender() {
        return Sex.values()[random.nextInt(Sex.values().length)];
    }

    protected String[] generateRandomFullName() {
        return new String[]{
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().lastName()
        };
    }
}
