package ru.otus.homework6;

/**
 * Created by Антон Дементьев on 27.03.2018.
 */
public interface Account {
    void put(Note key, Integer value);

    Integer get(Note key);

    void cancel();

    void save();
}
