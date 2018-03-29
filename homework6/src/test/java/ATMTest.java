
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.homework6.ATMBank;
import ru.otus.homework6.ATMClient;
import ru.otus.homework6.ATMImpl;
import ru.otus.homework6.Note;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public class ATMTest {
    ATMBank bank = new ATMImpl();
    ATMClient client = (ATMClient) bank;

    @Before
    public void precondition() {
        Map<Note, Integer> money = new HashMap<>();
        for (Note note : Note.values())
            money.put(note, 100);
        bank.addMoney(money);
    }

    @Test
    public void getSum() {
        Assert.assertEquals(bank.getSum(), 18800);
    }

    @Test
    public void getCountNote() {
        for (Note note : Note.values())
            Assert.assertEquals(bank.getCountNote(note), 100);
    }

    @Test
    public void extraditionCash() {
        Map<Note, Integer> money = client.extraditionCash(188);
        Integer actual = 1;

        for (Map.Entry<Note, Integer> entry : money.entrySet())
            Assert.assertEquals(entry.getValue(), actual);

        for (Note note : Note.values())
            Assert.assertEquals(bank.getCountNote(note), 99);
    }

    @Test
    public void refill() {
        Map<Note, Integer> money = new HashMap<>();
        money.put(Note.HUNDRED, 15);
        money.put(Note.FIFTY, 14);
        money.put(Note.TWENTY, 11);
        money.put(Note.TEN, 2);
        client.refillCash(money);

        Assert.assertEquals(bank.getSum(), 21240);


    }

    @Test
    public void extraditionCashMoreATM() {
        client.extraditionCash(18899999);
        for (Note note : Note.values())
            Assert.assertEquals(bank.getCountNote(note), 100);
    }

    @Test
    public void extraditionAllCash() {
        client.extraditionCash(18800);
        Assert.assertEquals(bank.getSum(), 0);

    }

}
