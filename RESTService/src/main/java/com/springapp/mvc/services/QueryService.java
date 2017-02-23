package com.springapp.mvc.services;

import com.springapp.mvc.helpers.ConnectionCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class QueryService {

    @Autowired
    ConnectionCreator connectionCreator;

    public void queryUpdate(String query){
        try{
            Connection connection = connectionCreator.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Object> processQueryAndGetResult(String query){
        try{
            Connection connection = connectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<Object> result = new ArrayList<Object>();
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    result.add(resultSet.getObject(i + 1));
                }
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getColumns(String query){
        try{
            Connection connection = connectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<String> columnNames = new ArrayList<String>();

            for (int i = 0; i < columnCount; i++) {
                String columnName = metaData.getColumnName(i+1);
                columnNames.add(columnName);
            }
            return columnNames;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
