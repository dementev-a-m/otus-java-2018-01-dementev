package ru.otus.homework6;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public enum Note {

    HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10),
    FIVE(5),
    TWO(2),
    ONE(1);

    private int note;

    Note(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
    }


}
