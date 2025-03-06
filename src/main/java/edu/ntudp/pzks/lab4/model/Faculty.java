package edu.ntudp.pzks.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends OrganizationalUnit {
    private List<Department> departments = new ArrayList<>();

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public Faculty(String name, Human head, List<Department> departments) {
        super(name, head);
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return name +" Dean: " + head;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Faculty that = (Faculty) o;
        return Objects.equals(departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }
}
