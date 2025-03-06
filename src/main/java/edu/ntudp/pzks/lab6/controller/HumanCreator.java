package edu.ntudp.pzks.lab6.controller;

import com.github.javafaker.Faker;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

public abstract class HumanCreator {
    public static final Random random = new Random();
    public static final Faker faker = new Faker();

    protected static String[] generateRandomFullName() {
        return new String[]{
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().lastName()
        };
    }

    public static Date createValidBirthDate() {
        Date birthDate = null;
        boolean validBirthDate = false;

        while (!validBirthDate) {
            birthDate = new Date(faker.date().birthday().getTime());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(birthDate);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);

            if (year >= 2002 && month != Calendar.JUNE) {
                validBirthDate = true;
            }
        }

        return birthDate;
    }

}
