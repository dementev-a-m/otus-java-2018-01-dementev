package ru.otus.homework6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public class ATMImpl implements ATMClient, ATMBank {
    private Account account = new AccountImpl();
    private Account accountBackUp;
    public ATMImpl() {
    }

    @Override
    public void refillCash(Map<Note, Integer> money) {
        for (Map.Entry<Note, Integer> entry : money.entrySet())
            account.put(entry.getKey(), account.get(entry.getKey()) + entry.getValue());
        System.out.println("Счет пополнен на сумму: " + countSum(money));
    }

    @Override
    public Map<Note, Integer> extraditionCash(int sum) {
        ExtraditionStrategy strategy = new ExtraditionGreedyAlgorithm(account);
        Map<Note, Integer> money = strategy.extradition(sum);
        if (money == null) {
            money = new HashMap<>();
            for (Note note : Note.values())
                money.put(note, 0);
            System.out.println("Невозможно снять данную сумму: " + sum);
        } else
            System.out.println("Снятие наличных на сумму: " + countSum(money));
        return money;
    }

    @Override
    public void addMoney(Map<Note, Integer> money) {
        for (Map.Entry<Note, Integer> entry : money.entrySet())
            account.put(entry.getKey(), entry.getValue());
        accountBackUp = new AccountImpl(account);
        System.out.println("В банокмат загруженны новые кассеты ! ");
    }

    @Override
    public int getSum() {
        int sum = 0;
        for (Note note : Note.values())
            sum += account.get(note) * note.getNote();

        System.out.println("В банкомате осталось: " + sum);
        return sum;
    }

    @Override
    public int getCountNote(Note note) {
        Integer number = account.get(note);
        System.out.println("Купюр номиналом " + note.getNote() + " осталось " + number);
        return number;
    }

    @Override
    public void reestablish() {
        account = new AccountImpl(accountBackUp);
    }

    private int countSum(Map<Note, Integer> money) {
        int sum = 0;
        for (Map.Entry<Note, Integer> entry : money.entrySet())
            sum += entry.getValue() * entry.getKey().getNote();
        return sum;
    }

}
