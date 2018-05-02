package ru.otus.homework8;

/**
 * Created by Антон Дементьев on 21.04.2018.
 */
public class Address implements JSONSerializable{
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;

    public Address() {
        this.streetAddress = "New Street";
        this.city = "Moscow";
        this.state = state = "MG";
        this.postalCode = "123456";
    }

    public Address(String streetAddress, String city, String state, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
