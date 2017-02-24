package com.springapp.mvc.controllers;

import com.springapp.mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    DatabaseService databaseService;

    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!");
        return "hello";
    }

    @RequestMapping("/task0movies")
    public String task0movies(ModelMap model) {
        String query = "SELECT * FROM movie;";

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Task 0: Movies");
        return "result";
    }

    @RequestMapping("/task0ratings")
    public String task0ratings(ModelMap model) {
        String query = "SELECT * FROM rating;";

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Task 0: Ratings");
        return "result";
    }

    @RequestMapping("/task0users")
    public String task0users(ModelMap model) {
        String query = "SELECT * FROM user;";

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Task 0: Users");
        return "result";
    }

    @RequestMapping("/task1")
    public String task1(ModelMap model) {
        String querySelect = "SELECT user_id FROM rating WHERE rating_date IS NULL;";
        String queryUpdate = "UPDATE rating SET rating_date = now() WHERE rating_date IS NULL;";
        String querySelectAll = "SELECT * from rating";

        model.addAttribute("message", "Task 1 <br> Found users: " + databaseService.getRows(querySelect));
        databaseService.executeUpdate(queryUpdate);
        model.addAttribute("rows", databaseService.getRows(querySelectAll));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(querySelectAll));
        return "result";
    }

    @RequestMapping("/task2")
    public String task2(ModelMap model) {
        String querySelectAll = "SELECT * from movie";
        String queryUpdate = "INSERT INTO movie (movie_id,movie_title,movie_director)" +
                             "VALUES (9, 'Deadpool', 'Tim Miller'),(10, 'The 300 spartans', 'Zack Snyder');";
        databaseService.executeUpdate(queryUpdate);

        model.addAttribute("rows", databaseService.getRows(querySelectAll));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(querySelectAll));
        model.addAttribute("message", "Task 2");
        return "result";
    }

    @RequestMapping("/task3")
    public String task3(ModelMap model) {
        String query = "SELECT movie_id, rating_date FROM rating " +
                       "WHERE rating IN (4,5) GROUP BY rating_date DESC;";

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Task 3");
        return "result";
    }

    @RequestMapping("/task4")
    public String task4(ModelMap model) {
        String query = "SELECT movie_title FROM movie WHERE movie_title NOT IN" +
                       "(SELECT movie.movie_title FROM movie INNER JOIN rating" +
                       " ON movie.movie_id=rating.movie_id WHERE rating.rating IS NOT NULL);";

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Task 4");
        return "result";
    }

    @RequestMapping("/task5")
    public String task5(ModelMap model) {
        String queryDelete = "DELETE FROM movie WHERE movie_id IN (9,10);";
        String querySelect = "SELECT * FROM movie";
        databaseService.executeUpdate(queryDelete);

        model.addAttribute("rows", databaseService.getRows(querySelect));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(querySelect));
        model.addAttribute("message", "Task 5");
        return "result";
    }

    @RequestMapping("/task6")
    public String task6(ModelMap model) {
        String query = "SELECT movie.movie_title, user.user_title, rating " +
                       "FROM movie NATURAL JOIN rating NATURAL JOIN user;";

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Task 6");
        return "result";
    }

    @RequestMapping("/clear")
    public String rows(ModelMap model) {
        String query = "SELECT * FROM rating";
        databaseService.executeUpdate("DELETE from rating WHERE rating_id IN (23, 30);");
        databaseService.executeUpdate("INSERT into rating VALUES(30, 15, 8, 4, null);");
        databaseService.executeUpdate("INSERT into rating VALUES(23, 12, 6, 4, null);");

        model.addAttribute("rows", databaseService.getRows(query));
        model.addAttribute("tableHeaders", databaseService.getColumnNames(query));
        model.addAttribute("message", "Defaults Restored");
        return "result";
    }
}