package ru.otus.homework8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон Дементьев on 21.04.2018.
 */
public class People implements JSONSerializable {
    private String firstName;
    private String lastName;
    private short age;
    private Address address;
    private Set<Phone> phones;

    public People() {
        this.firstName = "Ivan";
        this.lastName = "Ivanov";
        this.age = 22;
        this.address = new Address();
        this.phones = new HashSet<>();
        phones.add(new Phone("Home","916111111"));
        phones.add(new Phone("Job", "495124142"));
    }

    public People(String firstName, String lastName, short age, Address address, Set<Phone> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phones = phones;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
