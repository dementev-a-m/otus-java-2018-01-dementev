import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.homework6.ATMBank;
import ru.otus.homework6.ATMClient;
import ru.otus.homework6.ATMImpl;
import ru.otus.homework6.Note;
import ru.otus.homework7.ATMDepartment;
import ru.otus.homework7.ATMDepartmentImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 19.04.2018.
 */
public class ATMDepartmentTest {
    private ATMDepartment ATMDepartment;


    @Before
    public void precondition() {
        ATMDepartment = new ATMDepartmentImpl();
        Map<Note, Integer> money = new HashMap<>();
        for (Note note : Note.values())
            money.put(note, 100);

        for (int i = 0; i < 10; i++) {

            ATMBank atm = new ATMImpl();
            atm.addMoney(money);
            ATMDepartment.addATM(atm);
        }
    }

    @Test
    public void getSum() {
        Assert.assertEquals(ATMDepartment.getSum(), 188000);
    }

    @Test
    public void addATM() {
        Map<Note, Integer> money = new HashMap<>();
        for (Note note : Note.values())
            money.put(note, 100);

        ATMBank atm = new ATMImpl();
        atm.addMoney(money);
        ATMDepartment.addATM(atm);
        Assert.assertEquals(ATMDepartment.getCount(),new Integer(11));
    }

    @Test
    public void getSumAfterCut(){
        ATMClient atmClient = (ATMClient) ATMDepartment.getATM(0);

        atmClient.extraditionCash(1000);

        Assert.assertEquals(ATMDepartment.getSum(), 187000);

    }
    @Test
    public void reestablish(){
        ATMClient atmClient = (ATMClient) ATMDepartment.getATM(0);

        atmClient.extraditionCash(1000);

        ATMBank atmBank = ATMDepartment.getATM(0);
        Assert.assertEquals(atmBank.getSum(),17800);
        ATMDepartment.reestablish(0);
        Assert.assertEquals(atmBank.getSum(),18800);
    }

    @Test
    public void reestablishAll() {
        ATMClient atmClient = (ATMClient) ATMDepartment.getATM(0);

        atmClient.extraditionCash(10000);
        ATMClient atmClient1 = (ATMClient) ATMDepartment.getATM(1);
        atmClient1.extraditionCash(10000);
        Assert.assertEquals(ATMDepartment.getSum(),168000);
        ATMDepartment.reestablishAll();
        Assert.assertEquals(ATMDepartment.getSum(),188000);
    }


}
