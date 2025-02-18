package edu.ntudp.pzks.lab3.model;

import java.util.Objects;

abstract public class OrganizationalUnit {
    protected String name;
    protected Human head;

    public OrganizationalUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return name + " Head: " + head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationalUnit that = (OrganizationalUnit) o;
        return Objects.equals(name, that.name) && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }
}
