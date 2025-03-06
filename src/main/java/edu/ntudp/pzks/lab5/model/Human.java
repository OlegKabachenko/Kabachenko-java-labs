package edu.ntudp.pzks.lab5.model;
import java.util.UUID;
import java.util.Objects;

public class Human implements CreatureInterface{
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected Sex gender;
    protected final UUID id;

    public Human(String firstName, String middleName, String lastName, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.id = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return middleName + " " + firstName + " " + lastName;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return middleName + " " + firstName + " " + lastName + " (" + gender + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName) && Objects.equals(middleName, human.middleName) && Objects.equals(id, human.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, id);
    }
}
