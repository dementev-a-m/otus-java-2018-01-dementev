package ru.otus.homework7;

import ru.otus.homework6.ATMBank;

/**
 * Created by Антон Дементьев on 19.04.2018.
 */
public interface ATMDepartment {

    long getSum();

    Integer getCount();

    ATMBank getATM(Integer idATM);

    long getSum(Integer idATM);

    void addATM(ATMBank atm);

    void reestablish(Integer idATM);

    void reestablishAll();

}
