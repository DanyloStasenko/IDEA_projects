<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome Page</title>
    <style type="text/css">
        .center {
            margin: 0 auto;
            width: 70%;
        }
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }
        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }
        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>

<body>
<div class="center">
	<h1>${message}</h1>
    <table class="tg">
        <tr>
            <th width="50">Task</th>
            <th width="150">Description</th>
            <th width="200">SQL</th>
        </tr>
        <tr>
            <td>Task 0</td>
            <td>Return all users</td>
            <td> <a href="/task0users" target="_blank">SELECT * FROM user;</a></td>
        </tr>
        <tr>
            <td>Task 0</td>
            <td>Return all movies</td>
            <td> <a href="/task0movies" target="_blank">SELECT * FROM movie;</a></td>
        </tr>
        <tr>
            <td>Task 0</td>
            <td>Return all ratings</td>
            <td> <a href="/task0ratings" target="_blank">SELECT * FROM rating;</a></td>
        </tr>
        <tr>
            <th width="50"></th>
            <th width="150"></th>
            <th width="200"></th>
        </tr>
        <tr>
            <td>Task 1</td>
            <td>Get users with NULL date rating value</td>
            <td> <a href="/task1" target="_blank">UPDATE rating SET rating_date = now() WHERE rating_date IS NULL;</a></td>
        </tr>
        <tr>
            <td>Task 2</td>
            <td>Insert movies</td>
            <td> <a href="/task2" target="_blank">INSERT INTO movie (movie_id,movie_title,movie_director) VALUES (9, 'Deadpool', 'Tim Miller'),(10, 'The 300 spartans', 'Zack Snyder');</a></td>
        </tr>
        <tr>
            <td>Task 3</td>
            <td>Return movies with 4 or 5 rating</td>
            <td> <a href="/task3" target="_blank">SELECT movie_id, rating_date FROM rating WHERE rating IN (4,5) GROUP BY rating_date DESC;</a></td>
        </tr>
        <tr>
            <td>Task 4</td>
            <td>Return movies that have no ratings</td>
            <td> <a href="/task4" target="_blank">SELECT movie_title FROM movie WHERE movie_title NOT IN
                (SELECT movie.movie_title FROM movie INNER JOIN rating
                ON movie.movie_id=rating.movie_id WHERE rating.rating IS NOT NULL)</a></td>
        </tr>
        <tr>
            <td>Task 5</td>
            <td>Delete movies added in task 2</td>
            <td> <a href="/task5" target="_blank">DELETE FROM movie WHERE movie_id IN (9,10);</a></td>
        </tr>
        <tr>
            <td>Task 6</td>
            <td>Return the movie_title, user_name and rating for every rating</td>
            <td> <a href="/task6" target="_blank">SELECT movie.movie_title, user.user_title, rating FROM movie NATURAL JOIN rating NATURAL JOIN user;</a></td>
        </tr>
        <tr>
            <th width="50"></th>
            <th width="150"></th>
            <th width="200"></th>
        </tr>
        <tr>
            <td>Bonus</td>
            <td>Use it to create NULL ratings date</td>
            <td> <a href="/clear" target="_blank">Create ratings with NULL date values (use before task 1)</a></td>
        </tr>
    </table>
</div>
</body>
</html>