package ru.otus.homework6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public class AccountImpl implements Account {
    private Map<Note, Integer> account;
    private Map<Note, Integer> accountBackUp;

    AccountImpl() {
        account = new HashMap<>();
        for (Note note : Note.values())
            account.put(note, 0);
    }

    AccountImpl(Account account) {
        this.account = new HashMap<>();
        for (Note note : Note.values())
            this.account.put(note, account.get(note));
    }

    public void put(Note key, Integer value) {
        account.put(key, value);
    }

    public Integer get(Note key) {
        return account.get(key);
    }

    public void cancel() {
        if (accountBackUp != null)
            account = accountBackUp;
    }

    public void save() {
        accountBackUp = new HashMap<>();
        for (Note note : Note.values())
            accountBackUp.put(note, account.get(note));
    }
}
