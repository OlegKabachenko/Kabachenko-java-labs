package edu.ntudp.pzks.lab5.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department extends OrganizationalUnit {
    private List<Group> groups = new ArrayList<>();

    public Department(String name, Human head) {
        super(name, head);
    }

    public Department(String name, Human head, List<Group> groups) {
        super(name, head);
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return name +" Head of department: " + head;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }
}
