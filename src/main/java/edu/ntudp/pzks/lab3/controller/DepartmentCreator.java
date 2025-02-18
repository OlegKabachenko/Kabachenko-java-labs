package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Department;
import edu.ntudp.pzks.lab3.model.Group;
import edu.ntudp.pzks.lab3.model.Human;

import java.util.*;

public class DepartmentCreator {
    private static final Random random = new Random();

    private static final Map<String, List<String>> departments = Map.of(
            "Department of Software Engineering of Computer Systems", Arrays.asList("122", "121"),
            "Department of Information Technology and Computer Engineering", Arrays.asList("123","126"),
            "Department of Marketing", Arrays.asList("075", "061"),
            "Department of Management", Arrays.asList("073"),
            "Department of Oil and Gas Engineering and Drilling", Arrays.asList("185", "184"),
            "Department of Systems Analysis and Management", Arrays.asList("124")
    );

    private static Map.Entry<String, List<String>> getRandomDepartmentName() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(departments.entrySet());
        return entries.get(random.nextInt(entries.size()));
    }

    public static Map.Entry<String, List<String>> getDepartmentDataByName(String departmentName) {
        if (departments.containsKey(departmentName)) {
            return Map.entry(departmentName, departments.get(departmentName));
        } else {
           return null;
        }
    }

    public static Department createTypicalDepartment() {
        return createTypicalDepartment(getRandomDepartmentName());
    }

    public static Department createTypicalDepartment(Map.Entry<String, List<String>> departmentData) {
        int MAX_SPECIALITIES_CNT = 3;
        String departmentName = departmentData.getKey();
        List<String> specialties = departmentData.getValue();
        int specialtiesCount = random.nextInt(MAX_SPECIALITIES_CNT)+1;
        List<Group> groups = new ArrayList<>();
        Human head = HumanCreator.createTypicalHuman();

        specialtiesCount = Math.min(specialties.size(), specialtiesCount);
        List<String> selectedSpecialties = new ArrayList<>();
        while (selectedSpecialties.size() < specialtiesCount) {
            selectedSpecialties.add(specialties.get(random.nextInt(specialties.size())));
        }

        for (String specialty : selectedSpecialties) {
            int numGroups = random.nextInt(3) + 1;

            int year = random.nextInt(6) + 20;
            for (int i = 0; i < numGroups; i++) {
                String groupName = (specialty +"-"+year+"-"+(i+1));
                groups.add(GroupCreator.createTypicalGroup(groupName));
            }
        }
        return new Department(departmentName, head, groups);
    }

    public static Department createDepartment(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups);
    }

    public static Department createEmptyDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
