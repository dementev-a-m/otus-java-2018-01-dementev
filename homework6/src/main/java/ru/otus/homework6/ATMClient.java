package ru.otus.homework6;

import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public interface ATMClient {

    void refillCash(Map<Note, Integer> money);

    Map<Note, Integer> extraditionCash(int sum);



}
