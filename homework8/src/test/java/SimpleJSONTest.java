import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import ru.otus.homework8.People;
import ru.otus.homework8.sjson.JSONHelper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Антон Дементьев on 20.04.2018.
 */
public class SimpleJSONTest {

    private JSONHelper helper;

    @Before
    public void precondition() {
        helper = new JSONHelper();

    }
    @Test
    public void createTree() {
        JSONObject object = helper.createTree(new People());
        try (FileWriter file = new FileWriter("test_simple.json")) {

            file.write(object.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void navigateTree() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse((new FileReader("jsondata.txt")));
        helper.navigateTree(jsonObject,"root");
    }
}
