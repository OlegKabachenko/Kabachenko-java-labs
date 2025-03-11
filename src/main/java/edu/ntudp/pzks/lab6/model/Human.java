package edu.ntudp.pzks.lab6.model;

import java.sql.Date;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class Human {
    private long id;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected Date birthDate;

    private final int NAME_MAX_LENGTH = 40;

    public Human() {
    }

    public Human(String firstName, String middleName, String lastName, Date birthDate) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);

        this.birthDate = birthDate;
    }

    public boolean isFilled (){
        return firstName != null &&
                middleName != null &&
                lastName != null &&
                birthDate != null;
    }

    private void setNameField(String fieldName, String value, Consumer<String> setter) {
        if (value.length() <= NAME_MAX_LENGTH) {
            setter.accept(value);
        } else {
            throw new IllegalArgumentException("Error: The " + fieldName + " must be shorter than " + (NAME_MAX_LENGTH + 1) + " characters long.");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        setNameField("first name", firstName, value -> this.firstName = value);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        setNameField("middle name", middleName, value -> this.middleName = value);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        setNameField("last name", lastName, value -> this.lastName = value);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(id, human.id) && Objects.equals(firstName, human.firstName) && Objects.equals(middleName, human.middleName) && Objects.equals(lastName, human.lastName) && Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, birthDate);
    }

    @Override
    public String toString() {
        return "Human{" +
                "birthDate=" + birthDate +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

    public int getNAME_MAX_LENGTH() {
        return NAME_MAX_LENGTH;
    }
}
