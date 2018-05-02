package ru.otus.homework9.service;

import ru.otus.homework9.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public interface UserService {
    List<User> findAllUser() throws SQLException;

    User findById(long id) throws SQLException;

    List<User> findByName(String name) throws SQLException;

    int addUser(User... users) throws SQLException;

    int remove(long... id) throws SQLException;


}
