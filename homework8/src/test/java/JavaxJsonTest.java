import org.junit.Before;
import org.junit.Test;
import ru.otus.homework8.People;
import ru.otus.homework8.jxjson.JsonHelper;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Антон Дементьев on 20.04.2018.
 */
public class JavaxJsonTest {
    private JsonHelper jsonHelper;

    @Before
    public void precondition() throws FileNotFoundException {

        jsonHelper = new JsonHelper();

    }

    @Test
    public void createTree() {
        JsonObject object = jsonHelper.createTree(new People());
        try (FileWriter file = new FileWriter("test_javax.json")) {

            file.write(jsonHelper.writeToString(object));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void navigateTree() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("jsondata.txt"));
        JsonStructure jsonst = reader.read();

        jsonHelper.navigateTree(jsonst, "base");

    }

}
