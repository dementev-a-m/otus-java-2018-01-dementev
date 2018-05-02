package ru.otus.homework9;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
@FunctionalInterface
public interface ResultHandler {
    void handler(ResultSet resultSet) throws SQLException;
}
