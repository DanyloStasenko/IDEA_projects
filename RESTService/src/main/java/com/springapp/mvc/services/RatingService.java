package com.springapp.mvc.services;

import com.springapp.mvc.helpers.ConnectionCreator;
import com.springapp.mvc.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class RatingService {

    @Autowired
    ConnectionCreator connectionCreator;

    public List<Rating> processQuery(String query){
        try{
            Connection connection = connectionCreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Rating> ratings = new ArrayList<Rating>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int userId = resultSet.getInt(2);
                int movieId = resultSet.getInt(3);
                int rate = resultSet.getInt(4);
                Date date = resultSet.getDate(5);

                Rating rating = new Rating(id, userId, movieId, rate, date);
                ratings.add(rating);
            }
            return ratings;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
