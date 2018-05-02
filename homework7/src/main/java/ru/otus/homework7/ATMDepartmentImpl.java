package ru.otus.homework7;

import ru.otus.homework6.ATMBank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 19.04.2018.
 */
public class ATMDepartmentImpl implements ATMDepartment {
    private Map<Integer, ATMBank> atmBankMap;
    private Integer count = 0;

    public ATMDepartmentImpl() {
        atmBankMap = new HashMap<>();
    }

    public long getSum() {
        long sum = 0;
        for (ATMBank atm : atmBankMap.values()) {
            sum += atm.getSum();
        }
        return sum;
    }

    public Integer getCount() {
        return count;
    }

    public ATMBank getATM(Integer idATM){
        return atmBankMap.get(idATM);
    }

    public long getSum(Integer idATM) {
        return atmBankMap.get(idATM).getSum();
    }

    public void addATM(ATMBank atm) {
        atmBankMap.put(count++, atm);
    }

    public void reestablish(Integer idATM) {
        atmBankMap.get(idATM).reestablish();
    }

    public void reestablishAll() {
        for (ATMBank atmBank : atmBankMap.values()) {
            atmBank.reestablish();
        }
    }


}
