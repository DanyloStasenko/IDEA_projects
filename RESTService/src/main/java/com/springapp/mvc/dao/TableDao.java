package com.springapp.mvc.dao;

import com.springapp.mvc.models.TableRow;
import com.springapp.mvc.models.TableHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@Repository
public class TableDao {

    @Autowired
    private DataSource dataSource;

    public int executeUpdate(String sqlQuery){
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            return statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<TableRow> getRows(String sqlQuery){
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)){
            ResultSetMetaData metaData = resultSet.getMetaData();

            ArrayList<String> columns = new ArrayList<>();
            List<TableRow> rows = new ArrayList<>();

            for (int i = 0; i < metaData.getColumnCount() ; i++) {
                columns.add(metaData.getColumnName(i + 1));
            }

            while (resultSet.next()) {
                TableRow row = new TableRow();

                // fill table rows
                if (columns.contains("user_id")){
                    row.setUserId(resultSet.getInt("user_id"));
                }
                if (columns.contains("user_title")){
                    row.setUserName(resultSet.getString("user_title"));
                }
                if (columns.contains("movie_id")){
                    row.setMovieId(resultSet.getInt("movie_id"));
                }
                if (columns.contains("movie_title")){
                    row.setMovieTitle(resultSet.getString("movie_title"));
                }
                if (columns.contains("movie_director")){
                    row.setMovieDirector(resultSet.getString("movie_director"));
                }
                if (columns.contains("rating_id")){
                    row.setRatingId(resultSet.getInt("rating_id"));
                }
                if (columns.contains("rating")){
                    row.setRatingRating(resultSet.getInt("rating"));
                }
                if (columns.contains("rating_date")){
                    row.setRatingDate(resultSet.getDate("rating_date"));
                }
                rows.add(row);
            }
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<TableHeader> getColumnNames(String sqlQuery){
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)){
            ResultSetMetaData metaData = resultSet.getMetaData();

            ArrayList<String> columns = new ArrayList<>();
            List<TableHeader> headers = new ArrayList<>();

            for (int i = 0; i < metaData.getColumnCount() ; i++) {
                columns.add(metaData.getColumnName(i + 1));
            }

            TableHeader tableHeader = new TableHeader();

            // check table columns
            if (columns.contains("user_id")){
                tableHeader.setUserId(true);
            }
            if (columns.contains("user_title")){
                tableHeader.setUserTitle(true);
            }
            if (columns.contains("movie_id")){
                tableHeader.setMovieId(true);
            }
            if (columns.contains("movie_title")){
                tableHeader.setMovieTitle(true);
            }
            if (columns.contains("movie_director")){
                tableHeader.setMovieDirector(true);
            }
            if (columns.contains("rating_id")){
                tableHeader.setRatingId(true);
            }
            if (columns.contains("rating")){
                tableHeader.setRating(true);
            }
            if (columns.contains("rating_date")){
                tableHeader.setRatingDate(true);
            }

            headers.add(tableHeader);
            return headers;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
