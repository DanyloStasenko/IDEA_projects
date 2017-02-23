package com.springapp.mvc.helpers;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionCreator {
    private static final String HOST = "jdbc:mysql://localhost:3306/restserver_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public ConnectionCreator() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
