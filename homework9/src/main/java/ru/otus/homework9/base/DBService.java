package ru.otus.homework9.base;

import java.sql.SQLException;

/**
 * Created by Антон Дементьев on 22.04.2018.
 */
public interface DBService extends AutoCloseable {

    String getMetaData();

    void prepareTables() throws SQLException;

    void deleteTables() throws SQLException;
}
