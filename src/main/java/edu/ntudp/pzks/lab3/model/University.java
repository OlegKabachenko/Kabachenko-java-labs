package edu.ntudp.pzks.lab3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University extends OrganizationalUnit {
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name, Human head) {
        super(name, head);
    }

    public University(String name, Human head, List<Faculty> faculties) {
        super(name, head);
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return name + " Rector: " + head;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties);
    }
}
