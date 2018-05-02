package ru.otus.homework8.sjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.otus.homework8.JSONSerializable;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Антон Дементьев on 20.04.2018.
 */
public class JSONHelper {


    public JSONHelper() {

    }

    public void navigateTree(Object aware, String key) {

        String awareClassName = aware.getClass().getSimpleName();
        switch (awareClassName) {
            case "JSONArray":
                JSONArray array = (JSONArray) aware;
                array.forEach(element -> navigateTree(element, "array_element"));
                break;
            case "JSONObject":
                JSONObject jsonObject = (JSONObject) aware;
                jsonObject.entrySet().forEach(element -> navigateTree(element, "set_element"));
                break;
            case "Node":
                Map.Entry entry = (Map.Entry) aware;
                navigateTree(entry.getValue(), entry.getKey().toString());
                break;
            default:
                System.out.println(key + ": " + aware);

        }

    }

    public JSONObject createTree(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        JSONObject jsonObject = new JSONObject();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object obj = field.get(object);
                if (JSONSerializable.class.isAssignableFrom(field.getType())) {//obj.getClass().getPackage().getName().equals("ru.otus.homework8")
                    jsonObject.put(field.getName(), createTree(obj));
                } else if (Collection.class.isAssignableFrom(field.getType())) {
                    Collection collection = (Collection) obj;
                    JSONArray jsonArray = new JSONArray();
                    for (Object o : collection) {
                        jsonArray.add(createTree(o));
                    }
                    jsonObject.put(field.getName(), jsonArray);
                } else {
                    jsonObject.put(field.getName(), obj);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return jsonObject;
    }
}
