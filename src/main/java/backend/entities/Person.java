package backend.entities;

import org.springframework.stereotype.Component;

/**
 * Created by Dmitry on 02.09.2016.
 */
@Component("person")
public class Person {
    private String personName;
    private String personLastName;

    public Person() {
    }

    public Person(String personName, String personLastName) {
        this.personName = personName;
        this.personLastName = personLastName;
    }


    public String getPersonName() {
        return personName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }
}
