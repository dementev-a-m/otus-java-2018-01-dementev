package test;


import ru.otus.homework5.After;
import ru.otus.homework5.Before;
import ru.otus.homework5.Test;


/**
 * Created by Антон Дементьев on 29.03.2018.
 */
public class TestClass1 {
    @Before
    public void precondition(){
        System.out.println("Вызван метод TestClass1.precondition");
    }
    @Test
    public void testing(){
        System.out.println("Вызван метод TestClass1.testing()");
    }

    @Test
    public void testing2(){
        System.out.println("Вызван метод TestClass1.testing2()");
    }


    @After
    public void concluding(){
        System.out.println("Вызван метод TestClass1.concluding()");
    }

}
