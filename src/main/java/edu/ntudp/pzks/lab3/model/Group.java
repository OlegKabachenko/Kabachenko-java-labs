package edu.ntudp.pzks.lab3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends OrganizationalUnit {
    private List<Student> students = new ArrayList<>();

    public Group(String name, Human head) {
        super(name, head);
    }

    public Group(String name, Human head, List<Student> students) {
        super(name, head);
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name + " Curator: " + head;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Group that = (Group) o;
        return Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, students);
    }

}
