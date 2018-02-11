package ru.otus.homework2;

/**
 * Created by Антон Дементьев on 11.02.2018.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int size = 10_000_000;

        long mem = getMem();
        Object[] array = new Object[size];
        long mem2 = getMem();
        long refSize = (mem2 - mem) / size;

        for (int i = 0; i < array.length; i++)
            array[i] = new Object();
        mem2 = getMem();
        System.out.println("Object size: " + (((mem2 - mem) / size) - refSize) + " bytes");


        for (int i = 0; i < array.length; i++)

            array[i] = new int[0];
        mem2 = getMem();
        System.out.println("Array size: " + (((mem2 - mem) / size) - refSize) + " bytes");

        for (int i = 0; i < array.length; i++)
            array[i] = new String(new char[0]);
        mem2 = getMem();
        System.out.println("Empty String size: " + (((mem2 - mem) / size) - refSize) + " bytes");

    }

    private static long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();

    }

}
