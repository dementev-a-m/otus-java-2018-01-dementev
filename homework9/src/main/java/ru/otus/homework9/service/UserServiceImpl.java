package ru.otus.homework9.service;

import ru.otus.homework9.entity.User;
import ru.otus.homework9.executor.Executor;
import ru.otus.homework9.executor.ExecutorFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public class UserServiceImpl implements UserService {

    private static final String INSERT_USER = "insert into user (name, age) values ('%s','%d')";
    private static final String UPDATE_USER = "update user set name = '%s',age = '%d' where id = '%d' ";
    private static final String FIND_BY_ID_USER = "select * from user where id = '%d'";
    private static final String FIND_BY_NAME_USER = "select * from user where name = '%s'";
    private static final String FIND_ALL_USER = "select * from user";
    private static final String REMOVE_BY_ID_USER = "delete from user where id in (%s)";


    public UserServiceImpl() {

    }

    @Override
    public List<User> findAllUser() throws SQLException {
        return getUser(FIND_ALL_USER);
    }

    @Override
    public User findById(long id) throws SQLException {
        String query = String.format(FIND_BY_ID_USER, id);
        Executor executor = ExecutorFactory.createExecutor();
        User user = new User();
        executor.executeQuery(query, (resultSet) -> {
            resultSet.next();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getShort("age"));
        });
        return user;

    }

    @Override
    public List<User> findByName(String name) throws SQLException {
        String query = String.format(FIND_BY_NAME_USER, name);
        return getUser(query);
    }

    @Override
    public int addUser(User... users) throws SQLException {
        Executor executor = ExecutorFactory.createExecutor();
        int count = 0;
        String query = null;
        for (User user : users) {
            if (user.getId() != 0) {
                if (findById(user.getId()).getId() != 0) {
                    query = String.format(UPDATE_USER, user.getName(), user.getAge(), user.getId());
                }
            } else {
                query = String.format(INSERT_USER, user.getName(), user.getAge());
            }
            count += executor.executeUpdate(query);
        }
        return count;
    }

    @Override
    public int remove(long... id) throws SQLException {
        Executor executor = ExecutorFactory.createExecutor();
        StringBuilder builder = new StringBuilder();
        for (long l : id) {
            builder.append("'" + l + "',");
        }

        String remove = String.format(REMOVE_BY_ID_USER, builder.toString());

        return executor.executeUpdate(remove);


    }

    private List<User> getUser(String query) throws SQLException {
        List<User> users = new ArrayList<>();
        Executor executor = ExecutorFactory.createExecutor();
        executor.executeQuery(query, (resultSet) -> {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getShort("age"));
                users.add(user);
            }
        });
        return users;

    }
}
