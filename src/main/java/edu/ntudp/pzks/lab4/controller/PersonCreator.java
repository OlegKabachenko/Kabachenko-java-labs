package edu.ntudp.pzks.lab4.controller;

import com.github.javafaker.Faker;
import edu.ntudp.pzks.lab4.model.Human;
import java.util.Random;

abstract public class PersonCreator {
    public static final Random random = new Random();
    public static final Faker faker = new Faker();

    protected static Human.Sex getRandomGender() {
        return Human.Sex.values()[random.nextInt(Human.Sex.values().length)];
    }

    protected static String[] generateRandomFullName() {
        return new String[]{
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().lastName()
        };
    }
}
