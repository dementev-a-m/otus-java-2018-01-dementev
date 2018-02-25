package ru.otus.homework3;


import java.util.*;

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
        System.out.println("list.size(): " + list.size());

        for (int i = 0; i < 20; i++)
            System.out.print(list.get(i) + " ");

        Collections.copy(list, list1);
//        list.addAll(list1);
        System.out.println();
        for (int i = 0; i < 40; i++)
            System.out.print(list.get(i) + " ");

        System.out.println("\nУдаление");

        for (int i = 39; i >= 0; i--)
            System.out.print(list.remove(i) + " ");
        System.out.println("\nlist.size(): " + list.size());


    }


}
