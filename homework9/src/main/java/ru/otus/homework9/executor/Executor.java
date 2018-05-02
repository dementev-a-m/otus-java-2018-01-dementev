package ru.otus.homework9.executor;

import ru.otus.homework9.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public interface Executor {
    void executeQuery(String query, ResultHandler handler) throws SQLException;
    int executeUpdate(String query) throws SQLException;

}
