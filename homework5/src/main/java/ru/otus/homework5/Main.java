package ru.otus.homework5;

import test.TestClass1;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Антон Дементьев on 26.03.2018.
 */
public class Main {



    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("Запуск тестов в классе...");
       TestFramework.test(TestClass1.class);
        System.out.println("Запуск тестов в пакете...");
       TestFramework.test("test");

    }

}
