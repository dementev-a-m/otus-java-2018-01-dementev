package ru.otus.homework6;

import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public interface ATMBank {

    void addMoney(Map<Note, Integer> money);

    int getSum();

    int getCountNote(Note note);

    void reestablish();

}
