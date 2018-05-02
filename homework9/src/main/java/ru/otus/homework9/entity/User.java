package ru.otus.homework9.entity;

import ru.otus.homework9.annotation.Column;
import ru.otus.homework9.annotation.Entity;
import ru.otus.homework9.annotation.Id;

/**
 * Created by Антон Дементьев on 22.04.2018.
 */
@Entity
public class User {
    @Id
    @Column
    private long id;
    @Column(size = 256)
    private String name;
    @Column(size = 3)
    private short age;

    public User(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                "} " ;
    }
}
