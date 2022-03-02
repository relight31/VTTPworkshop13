package sg.edu.nus.iss.workshop13.model;

import java.io.Serializable;

public class Person implements Serializable{ //allows writing to harddisk and sending through network
    private Integer id;
    private String firstName;
    private String lastName;
    private Character gender;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getGender() {
        return this.gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

}
