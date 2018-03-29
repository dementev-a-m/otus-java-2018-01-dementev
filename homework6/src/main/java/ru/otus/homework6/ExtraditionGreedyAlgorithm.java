package ru.otus.homework6;

import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public class ExtraditionGreedyAlgorithm implements ExtraditionStrategy {
    private Map<Note, Integer> money;
    private Account account;

    ExtraditionGreedyAlgorithm(Account account) {
        this.account = account;
    }

    @Override
    @Nullable
    public Map<Note, Integer> extradition(Integer sum) {
        money = new HashMap<>();
        account.save();
        for (Note note : Note.values())
            sum = countNote(sum, note);

        if (sum != 0) {
            account.cancel();
            money = null;
        }

        return money;
    }

    private Integer countNote(Integer sum, Note note) {
        Integer count = sum / note.getNote();

        if (count > account.get(note))
            count = account.get(note);

        money.put(note, count);
        account.put(note, account.get(note) - count);
        sum -= count * note.getNote();
        return sum;

    }
}
