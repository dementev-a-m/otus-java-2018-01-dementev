package ru.otus.homework9;

import ru.otus.homework9.base.DBService;
import ru.otus.homework9.connection.DBServiceConnection;
import ru.otus.homework9.entity.User;
import ru.otus.homework9.service.UserService;
import ru.otus.homework9.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Антон Дементьев on 22.04.2018.
 */
public class MyORM {

    public static void main(String[] args) throws Exception {
        try (DBService connection = new DBServiceConnection()) {
            String metaData = connection.getMetaData();
            System.out.println(metaData);
            connection.prepareTables();

        }

        User[] users = {
                new User("USER1", (short) 21),
                new User("USER2", (short) 43),
                new User("USER3", (short) 21),
                new User("USER4", (short) 43),
                new User("ROOT", (short) 43)};

        UserService userService = new UserServiceImpl();
        userService.addUser(users);
        System.out.println(userService.findById(3));
        List<User> list = userService.findAllUser();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
