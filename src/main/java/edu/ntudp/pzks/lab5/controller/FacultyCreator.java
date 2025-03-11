package edu.ntudp.pzks.lab5.controller;

import edu.ntudp.pzks.lab5.model.Department;
import edu.ntudp.pzks.lab5.model.Faculty;
import edu.ntudp.pzks.lab5.model.Human;

import java.util.*;

public class FacultyCreator {
    private final Random random = new Random();

    private final Map<String, List<String>> faculties = Map.of(
            "Faculty of Information Technologies", Arrays.asList("Department of Software Engineering of Computer Systems", "Department of Information Technology and Computer Engineering", "Department of Systems Analysis and Management"),
            "Faculty of Management", Arrays.asList("Department of Management", "Department of Applied Economics, Entrepreneurship, and Public Administration"),
            "Faculty of Natural Sciences and Technologies", Arrays.asList("Department of Oil and Gas Engineering and Drilling", "Department of Chemistry and Chemical Engineering")
    );

    private Map.Entry<String, List<String>> getRandomFacultyName() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(faculties.entrySet());
        return entries.get(random.nextInt(entries.size()));
    }

    public Faculty createTypicalFaculty() {
        return createTypicalFaculty(getRandomFacultyName());
    }

    public Faculty createTypicalFaculty(Map.Entry<String, List<String>> facultyData) {
        return createTypicalFaculty(facultyData, random.nextInt(3)+1, false);
    }

    public Faculty createTypicalFaculty(int departmentsCount, boolean iscascadeSubdivisions) {
        return createTypicalFaculty(getRandomFacultyName(), departmentsCount, iscascadeSubdivisions);
    }

    public Faculty createTypicalFaculty(Map.Entry<String, List<String>> facultyData, int departmentsCount, boolean iscascadeSubdivisions) {
        String facultyName = facultyData.getKey();
        List<String> departments = facultyData.getValue();
        HumanCreator humanCreator = new HumanCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Human head = humanCreator.createTypicalHuman();
        Faculty faculty = new Faculty(facultyName, head);

        departmentsCount = Math.min(departments.size(), departmentsCount);

        Collections.shuffle(departments);
        for (int i = 0; i < departmentsCount; i++) {
            String departmentName = departments.get(i);

            Map.Entry<String, List<String>> departmentData = departmentCreator.getDepartmentDataByName(departmentName);
            if (departmentData != null) {
                Department  department = departmentCreator.createTypicalDepartment(departmentData);

                if (iscascadeSubdivisions) {
                    department = departmentCreator.createTypicalDepartment(departmentData, departmentsCount, iscascadeSubdivisions);
                }
                faculty.addDepartment(department);
            }
        }
        return faculty;
    }

    public Faculty createFaculty(String name, Human head, List<Department> departments) {
        return new Faculty(name, head, departments);
    }

    public Faculty createEmptyFaculty(String name, Human head) {
        return new Faculty(name, head);
    }

    public Map<String, List<String>> getFaculties(){
        return faculties;
    }
}
