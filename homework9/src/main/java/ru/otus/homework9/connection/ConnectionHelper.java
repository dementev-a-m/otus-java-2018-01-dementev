package ru.otus.homework9.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Антон Дементьев on 22.04.2018.
 */
class ConnectionHelper {

    static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            Properties property = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");
            String useSSL = property.getProperty("db.useSSL");

            return DriverManager.getConnection(host, login, password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
