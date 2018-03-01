package ru.otus.homework3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Антон Дементьев on 18.02.2018.
 */

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new MyArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            list.add(i);
            list1.add(random.nextInt(10) + 1);
        }
        System.out.println("Size: " + list.size());

        System.out.println("Get:");
        for (int i = 0; i < 20; i++)
            System.out.print(list.get(i) + " ");
        System.out.println();

        System.out.println("Copy:");
        Collections.copy(list, list1);
        for (Integer integer : list)
            System.out.print(integer + " ");


        System.out.println("\nSort:");
        Collections.sort(list);
        for (Integer integer : list)
            System.out.print(integer + " ");

        System.out.println("\nSize: " + list.size());

        System.out.println("AddAll:");
        list.addAll(list1);
        for (Integer integer : list)
            System.out.print(integer + " ");

        System.out.println("\nSize: " + list.size());

        System.out.println("Remove:");


        for (int i = 39; i >= 0; i--)
            System.out.print(list.remove(i) + " ");

        System.out.println("\nSize: " + list.size());

    }

}

