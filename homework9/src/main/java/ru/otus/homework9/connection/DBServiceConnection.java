package ru.otus.homework9.connection;

import ru.otus.homework9.base.DBService;
import ru.otus.homework9.executor.Executor;
import ru.otus.homework9.executor.ExecutorFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Антон Дементьев on 22.04.2018.
 */
public class DBServiceConnection implements DBService {

    private static final String packageName = "ru.otus.homework9.entity";
    private final Connection connection;

    public DBServiceConnection() {
        connection = ConnectionHelper.getConnection();
    }

    protected Connection getConnection() {
        return connection;
    }

    @Override
    public String getMetaData() {
        try {
            return "Connected to: " + connection.getMetaData().getURL() + "\n" +
                    "DB name: " + connection.getMetaData().getDatabaseProductName() + "\n" +
                    "DB version: " + connection.getMetaData().getDatabaseProductVersion() + "\n" +
                    "Driver: " + connection.getMetaData().getDriverName();
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public void prepareTables() throws SQLException {
        Executor executor = ExecutorFactory.createExecutor();
        TablesBuilder builder = new TablesBuilder(packageName);
        for (String create : builder.createEntities()) {
            executor.executeUpdate(create);
        }

    }

    @Override
    public void deleteTables() throws SQLException {
        Executor executor = ExecutorFactory.createExecutor();
        TablesBuilder builder = new TablesBuilder(packageName);
        for (String remove : builder.removeEntities()) {
            executor.executeUpdate(remove);
        }

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

}
