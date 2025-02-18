package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Faculty;
import edu.ntudp.pzks.lab3.model.University;
import edu.ntudp.pzks.lab3.model.Human;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static edu.ntudp.pzks.lab3.controller.PersonCreator.random;

public class UniversityCreator {
    private static final List<String> universities = Arrays.asList(
            "Harvard University",
            "Stanford University",
            "Dnipro University of Technology",
            "Igor Sikorsky Kyiv Polytechnic Institute",
            "Lviv Polytechnic National University"
    );

    public static University createTypicalUniversity() {
        String university = universities.get(random.nextInt(universities.size()));
        return createTypicalUniversity(university);
    }

    public static University createTypicalUniversity(String universityName) {
        Human head = HumanCreator.createTypicalHuman();
        University university = new University(universityName, head);

        for (Map.Entry<String, List<String>> facultyData : FacultyCreator.faculties.entrySet()) {
            Faculty faculty = FacultyCreator.createTypicalFaculty(facultyData);
            university.addFaculty(faculty);
        }
        return university;
    }

    public static University createUniversity(String name, Human head, List<Faculty> faculties) {
        return new University(name, head, faculties);
    }

    public static University createEmptyUniversity(String name, Human head) {
        return new University(name, head);
    }
}
