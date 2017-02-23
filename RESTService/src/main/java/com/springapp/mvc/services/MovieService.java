package com.springapp.mvc.services;

import com.springapp.mvc.helpers.ConnectionCreator;
import com.springapp.mvc.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieService {

    @Autowired
    ConnectionCreator connectionCreator;

    public List<Movie> processQuery(String query){
        try{
            Connection connection = connectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Movie> movies = new ArrayList<Movie>();

            while (resultSet.next()) {
                int id = resultSet.getInt("movie_id");
                String title = resultSet.getString("movie_title");
                String director = resultSet.getString("movie_director");

                Movie movie = new Movie(id, title, director);
                movies.add(movie);
            }
            return movies;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
