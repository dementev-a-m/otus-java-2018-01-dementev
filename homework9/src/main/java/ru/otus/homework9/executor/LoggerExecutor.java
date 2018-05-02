package ru.otus.homework9.executor;

import ru.otus.homework9.ResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public class LoggerExecutor implements Executor {

    private final Executor executor;

    @Override
    public void executeQuery(String query, ResultHandler handler) throws SQLException {
        System.out.println("Log: " + query);
        executor.executeQuery(query, handler);
    }

    @Override
    public int executeUpdate(String query) throws SQLException {
        System.out.println("Log: " + query);
        return executor.executeUpdate(query);
    }

    LoggerExecutor() {
        executor = new ExecutorImpl();
    }


}
