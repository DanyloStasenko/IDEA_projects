package com.springapp.mvc.controllers;

import com.springapp.mvc.models.Movie;
import com.springapp.mvc.models.Rating;
import com.springapp.mvc.models.User;
import com.springapp.mvc.services.MovieService;
import com.springapp.mvc.services.QueryService;
import com.springapp.mvc.services.RatingService;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MovieService movieService;

    @Autowired
    RatingService ratingService;

    @Autowired
    UserService userService;

    @Autowired
    QueryService queryService;

    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome!");
        return "hello";
    }

    @RequestMapping("/movies")
     public String getMovies(ModelMap model) {
        List<Movie> movies = movieService.processQuery("SELECT * FROM movie;");
        model.addAttribute("movies", movies);
        return "movies";
    }

    @RequestMapping("/task0movies")
    public String task0movies(ModelMap model) {
        List<Movie> movies = movieService.processQuery("SELECT * FROM movie;");
        model.addAttribute("movies", movies);
        return "task0movies";
    }

    @RequestMapping("/task0ratings")
    public String task0ratings(ModelMap model) {
        List<Rating> ratings = ratingService.processQuery("SELECT * FROM rating;");
        model.addAttribute("ratings", ratings);
        return "task0ratings";
    }

    @RequestMapping("/task0users")
    public String task0users(ModelMap model) {
        List<User> users = userService.processQuery("SELECT * FROM user;");
        model.addAttribute("users", users);
        return "task0users";
    }

    @RequestMapping("/task1")
    public String task1(ModelMap model) {

        String querySelect = "SELECT user_id FROM rating WHERE rating_date IS NULL;";
        String queryUpdate = "UPDATE rating SET rating_date = now() WHERE rating_date IS NULL;";
        String querySelectAll = "SELECT * from rating";

        model.addAttribute("selectedResult", queryService.processQueryAndGetResult(querySelect));
        model.addAttribute("selectedColumns", queryService.getColumns(querySelect));

        queryService.queryUpdate(queryUpdate);

        model.addAttribute("updatedResult", queryService.processQueryAndGetResult(querySelectAll));
        model.addAttribute("updatedColumns", queryService.getColumns(querySelectAll));

        model.addAttribute("taskHeader", "Task 1:");
        model.addAttribute("task", "Some date in rating is lost. <br>" +
                "Find the userId of all users who have ratings with a NULL\n" +
                "value for the date. <br> Set it to today's date in database.\n" +
                "Return all ratings.");

        model.addAttribute("querySelect", "query select: " + querySelect);
        model.addAttribute("queryUpdate", "query update: " + queryUpdate);

        return "task1";
    }

    @RequestMapping("/task2")
    public String task2(ModelMap model) {

        String querySelectAll = "SELECT * from movie";
        String queryUpdate = "INSERT INTO movie (movie_id,movie_title,movie_director)" +
                    "VALUES (9, 'Deadpool', 'Tim Miller'),(10, 'The 300 spartans', 'Zack Snyder');";

        queryService.queryUpdate(queryUpdate);

        List<String> columns = queryService.getColumns(querySelectAll);
        List<Object> result = queryService.processQueryAndGetResult(querySelectAll);

        String message = "Task 2. <br>" +
                "Insert two movies into the Movie table <br>" +
                "<br> SQL: " + queryUpdate;

        model.addAttribute("message", message);
        model.addAttribute("result", result);
        model.addAttribute("columns", columns);

        return "result";
    }

    @RequestMapping("/task3")
    public String task3(ModelMap model) {
        String query = "SELECT movie_id, rating_date FROM rating WHERE rating IN (4,5) GROUP BY rating_date DESC;";

        String message = "Task 3. <br>" +
                "Return the movieID, ratingDate of all movies that received a rating of 4 or 5 <br>" +
                " and sort them in increasing order by ratingDate. <br>" +
                "<br> SQL: " + query;

        List<String> columns = queryService.getColumns(query);
        List<Object> result = queryService.processQueryAndGetResult(query);

        model.addAttribute("message", message);
        model.addAttribute("result", result);
        model.addAttribute("columns", columns);

        return "result";
    }

    @RequestMapping("/task4")
    public String task4(ModelMap model) {
        String query = "SELECT movie_title FROM movie WHERE movie_title NOT IN ( SELECT movie.movie_title" +
                "        FROM movie\n" +
                "        INNER JOIN rating\n" +
                "        ON movie.movie_id=rating.movie_id\n" +
                "        WHERE rating.rating IS NOT NULL);";

        String message = "Task 4. <br>" +
                "Return the titles of all movies that have no ratings <br>" +
                "<br> SQL: " + query;

        List<String> columns = queryService.getColumns(query);
        List<Object> result = queryService.processQueryAndGetResult(query);

        model.addAttribute("result", result);
        model.addAttribute("columns", columns);
        model.addAttribute("message", message);

        return "result";
    }

    @RequestMapping("/task5")
    public String task5(ModelMap model) {
        String queryDelete = "DELETE FROM movie WHERE movie_id IN (9,10);";
        String querySelect = "select * from movie";

        String message = "Task 5. <br>" +
                "Delete the movies you added in task 2 (by id 9 and 10). Return all movies <br>" +
                "<br> SQL: " + queryDelete;

        queryService.queryUpdate(queryDelete);

        List<String> columns = queryService.getColumns(querySelect);
        List<Object> result = queryService.processQueryAndGetResult(querySelect);

        model.addAttribute("message", message);
        model.addAttribute("result", result);
        model.addAttribute("columns", columns);

        return "result";
    }

    @RequestMapping("/task6")
    public String task6(ModelMap model) {
        String query = "select movie.movie_title, user.user_title, rating from movie natural join rating natural join user;";

        String message = "Task 6." +
                "Return the title of the movie, user name and rating for every rating. <br>" +
                "<br> SQL: " + query;

        List<String> columns = queryService.getColumns(query);
        List<Object> result = queryService.processQueryAndGetResult(query);

        model.addAttribute("result", result);
        model.addAttribute("columns", columns);
        model.addAttribute("message", message);

        return "result";
    }
}
