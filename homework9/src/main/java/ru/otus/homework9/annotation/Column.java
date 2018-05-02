package ru.otus.homework9.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Антон Дементьев on 02.05.2018.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name() default "";
    int size() default -1;
}
