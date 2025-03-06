package edu.ntudp.pzks.lab5.controller;

import edu.ntudp.pzks.lab5.model.Faculty;
import edu.ntudp.pzks.lab5.model.University;
import edu.ntudp.pzks.lab5.model.Human;

import java.util.*;

import static edu.ntudp.pzks.lab5.controller.PersonCreator.random;

public class UniversityCreator {
    private static final List<String> universities = Arrays.asList(
            "Harvard University",
            "Stanford University",
            "Dnipro University of Technology",
            "Igor Sikorsky Kyiv Polytechnic Institute",
            "Lviv Polytechnic National University"
    );

    private static String getRandomUniversityName() {
        int index = random.nextInt(universities.size());
        return universities.get(index);
    }

    public static University createTypicalUniversity() {
        return createTypicalUniversity(getRandomUniversityName() );
    }

    public static University createTypicalUniversity(String universityName) {
        return createTypicalUniversity(universityName, random.nextInt(3)+1, false);
    }


    public static University createTypicalUniversity(int facultiesCount, boolean iscascadeSubdivisions) {
        return createTypicalUniversity(getRandomUniversityName(), facultiesCount, iscascadeSubdivisions);
    }


    public static University createTypicalUniversity(String universityName, int facultiesCount, boolean iscascadeSubdivisions) {
        Human head = HumanCreator.createTypicalHuman();
        University university = new University(universityName, head);
        Map<String, List<String>> faculties = FacultyCreator.getFaculties();
        List<Map.Entry<String, List<String>>> facultyList = new ArrayList<>(faculties.entrySet());

        facultiesCount = Math.min(faculties.size(), facultiesCount);

        Collections.shuffle(facultyList);
        for (int i = 0; i < facultiesCount; i++) {
            Faculty faculty = FacultyCreator.createTypicalFaculty(facultyList.get(i));

            if(iscascadeSubdivisions){
                faculty = FacultyCreator.createTypicalFaculty(facultyList.get(i), facultiesCount, iscascadeSubdivisions);
            }
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
