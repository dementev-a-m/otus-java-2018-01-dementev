package ru.otus.homework1;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.text.StrSubstitutor;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Антон Дементьев on 04.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        DateTime time = new DateTime();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ImmutableSet<DateTime> timeImmutableSet = ImmutableSet.of(time, new DateTime());
        Map<String, DateTime> timeMap = new HashMap<>();
        timeMap.put("time 1", timeImmutableSet.asList().get(0));
        timeMap.put("time 2", timeImmutableSet.asList().get(1));


        String template = "time 1 = ${time 1}\n" +
                "time 2 = ${time 2}";

        String formattedString = StrSubstitutor.replace(template, timeMap);
        System.out.println(formattedString);
    }
}
