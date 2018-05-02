package ru.otus.homework9.executor;

import ru.otus.homework9.ResultHandler;
import ru.otus.homework9.connection.DBServiceConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public class ExecutorImpl extends DBServiceConnection implements Executor {

    private final Connection connection;

    ExecutorImpl() {
        this.connection = super.getConnection();
    }

    public void executeQuery(String query, ResultHandler handler) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            handler.handler(statement.getResultSet());
        }
    }

    public int executeUpdate(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            return statement.getUpdateCount();
        }
    }
}
