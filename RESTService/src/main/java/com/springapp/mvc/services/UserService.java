package com.springapp.mvc.services;

import com.springapp.mvc.helpers.ConnectionCreator;
import com.springapp.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    @Autowired
    ConnectionCreator connectionCreator;

    public List<User> processQuery(String query){
        try{
            Connection connection = connectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> users = new ArrayList<User>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                User user = new User(id, name);
                users.add(user);
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
