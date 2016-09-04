package database;

/**
 * Created by Admin on 02.09.2016.
 */
public class DBController
{
    private static final String URL = "jdbc:mysql://localhost:3306/botscrew_test"; // database path
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    DBController()
    {

    }
    void insert(String bookName, String bookAuthor)
    {
        System.out.println(bookName);
        System.out.println(bookAuthor);
    }
}
