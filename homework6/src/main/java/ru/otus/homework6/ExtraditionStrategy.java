package ru.otus.homework6;

import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public interface ExtraditionStrategy {

    Map<Note, Integer> extradition(Integer sum);
}
