package ru.otus.homework8;

/**
 * Created by Антон Дементьев on 21.04.2018.
 */
public class Phone  implements JSONSerializable{
    private String type;
    private String number;

    public Phone() {

    }

    public Phone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (type != null ? !type.equals(phone.type) : phone.type != null) return false;
        return number != null ? number.equals(phone.number) : phone.number == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
