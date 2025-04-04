package edu.ntudp.pzks.lab4.controller;

import edu.ntudp.pzks.lab4.model.Department;
import edu.ntudp.pzks.lab4.model.Group;
import edu.ntudp.pzks.lab4.model.Human;

import java.util.*;

public class DepartmentCreator {
    private final Random random = new Random();

    private final Map<String, List<String>> departments = Map.of(
            "Department of Software Engineering of Computer Systems", Arrays.asList("122", "121"),
            "Department of Information Technology and Computer Engineering", Arrays.asList("123","126"),
            "Department of Applied Economics, Entrepreneurship, and Public Administration", Arrays.asList("051", "076", "075"),
            "Department of Management", Arrays.asList("073", "072"),
            "Department of Chemistry and Chemical Engineering", Arrays.asList("161", "102"),
            "Department of Oil and Gas Engineering and Drilling", Arrays.asList("185", "015.35", "184"),
            "Department of Systems Analysis and Management", Arrays.asList("124", "125")
    );

    private Map.Entry<String, List<String>> getRandomDepartmentName() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(departments.entrySet());
        return entries.get(random.nextInt(entries.size()));
    }

    public Map.Entry<String, List<String>> getDepartmentDataByName(String departmentName) {
        if (departments.containsKey(departmentName)) {
            return Map.entry(departmentName, departments.get(departmentName));
        } else {
            return null;
        }
    }

    public Department createTypicalDepartment(int groupCnt, boolean iscascadeSubdivisions) {
        return createTypicalDepartment(getRandomDepartmentName(), groupCnt, iscascadeSubdivisions);
    }

    public Department createTypicalDepartment() {
        return createTypicalDepartment(getRandomDepartmentName());
    }

    public Department createTypicalDepartment(Map.Entry<String, List<String>> departmentData) {
        return createTypicalDepartment(departmentData, random.nextInt(3)+1);
    }

    public Department createTypicalDepartment(Map.Entry<String, List<String>> departmentData, int specialtiesCount) {
        return createTypicalDepartment(departmentData, specialtiesCount, false);
    }

    public Department createTypicalDepartment(Map.Entry<String, List<String>> departmentData, int specialtiesCount, boolean iscascadeSubdivisions) {
        String departmentName = departmentData.getKey();
        List<String> specialties = departmentData.getValue();
        HumanCreator humanCreator = new HumanCreator();
        GroupCreator groupCreator = new GroupCreator();

        List<Group> groups = new ArrayList<>();
        Human head = humanCreator.createTypicalHuman();

        specialtiesCount = Math.min(specialties.size(), specialtiesCount);
        List<String> selectedSpecialties = new ArrayList<>();

        Collections.shuffle(specialties);
        for (int i = 0; i < specialtiesCount; i++) {
            selectedSpecialties.add(specialties.get(i));
        }

        int numGroups = 1;
        for (String specialty : selectedSpecialties) {
            if (!iscascadeSubdivisions){
                numGroups = random.nextInt(3) + 1;
            }

            int year = random.nextInt(6) + 20;
            for (int i = 0; i < numGroups; i++) {
                String groupName = (specialty +"-"+year+"-"+(i+1));

                Group group =  groupCreator.createTypicalGroup(groupName);

                if (iscascadeSubdivisions){
                    group =  groupCreator.createTypicalGroup(groupName, specialtiesCount);
                }
                groups.add(group);
            }
        }
        return new Department(departmentName, head, groups);
    }

    public Department createDepartment(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups);
    }

    public Department createEmptyDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
