package ru.otus.homework8.jxjson;

import ru.otus.homework8.JSONSerializable;

import javax.json.*;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Created by Антон Дементьев on 20.04.2018.
 */
public class JsonHelper {
    private JsonReader reader;

    public JsonHelper() {

    }

    public String writeToString(JsonObject jsonst) {
        StringWriter stWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stWriter)) {
            jsonWriter.writeObject(jsonst);
        }

        return stWriter.toString();
    }

    public void navigateTree(JsonValue tree, String key) {
        if (key != null)
            System.out.print("Key " + key + ": ");
        switch (tree.getValueType()) {
            case OBJECT:
                System.out.println("OBJECT");
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet())
                    navigateTree(object.get(name), name);
                break;
            case ARRAY:
                System.out.println("ARRAY");
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array)
                    navigateTree(val, null);
                break;
            case STRING:
                JsonString st = (JsonString) tree;
                System.out.println("STRING " + st.getString());
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                System.out.println("NUMBER " + num.toString());
                break;
            case TRUE:
            case FALSE:
            case NULL:
                System.out.println(tree.getValueType().toString());
                break;
        }
    }


    public JsonObject createTree(Object object) {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object obj = field.get(object);
                if (JSONSerializable.class.isAssignableFrom(field.getType())) {//obj.getClass().getPackage().getName().equals("ru.otus.homework8")
                    objectBuilder.add(field.getName(), createTree(obj));
                } else if (Collection.class.isAssignableFrom(field.getType())) {
                    Collection collection = (Collection) obj;
                    JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
                    for (Object o : collection) {
                        arrayBuilder.add(createTree(o));
                    }
                    objectBuilder.add(field.getName(), arrayBuilder);
                } else {
                    objectBuilder.add(field.getName(), obj.toString());
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }
        return objectBuilder.build();
    }
}
