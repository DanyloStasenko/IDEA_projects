package database;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;
import java.util.Scanner;


public class Main
{
    private static final String URL = "jdbc:mysql://localhost:3306/botscrew_test"; // database path
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);

        try
        {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            boolean exit = false;
            while(!exit)
            {
                // interface
                System.out.println("Please, choose one:");
                System.out.println("1: ADD book");
                System.out.println("2: SHOW books");
                System.out.println("3: EDIT book");
                System.out.println("4: DELETE book");
                System.out.println("5: EXIT");

                int usersChoice = Integer.parseInt(scanner.next()); // users choice
                switch (usersChoice)
                {
                    case 1:
                    // ADD the book
                        // get data from user
                        System.out.println("Enter book name:");
                        String bookName = scanner.next();
                        System.out.println("Enter book author:");
                        String bookAuthor = scanner.next();

                        // preparing and executing statement with data
                        preparedStatement = connection.prepareStatement("INSERT INTO books VALUES(?,?,?)");
                        preparedStatement.setInt(1, 0);
                        preparedStatement.setString(2, bookName);
                        preparedStatement.setString(3, bookAuthor);
                        preparedStatement.execute();
                        System.out.println("Book added");
                        break;

                    case 2:
                    // SHOW books

                        // get data from database
                        preparedStatement = connection.prepareStatement("SELECT name, author FROM books ORDER BY name");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next())
                        {
                            String name = resultSet.getString("name");
                            String author = resultSet.getString("author");

                            System.out.println(author+"\t"+name);
                        }
                        System.out.println(); // space
                        break;


                    case 3:
                    // EDIT book

                        // get data from user
                        System.out.println("Enter book name:");
                        bookName = scanner.next();

                        // executing statement using users data
                        preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE name = ?");
                        preparedStatement.setString(1, bookName);
                        resultSet = preparedStatement.executeQuery();

                        // get resultSet size
                        int size = 0;
                        int bookID = 0;
                        while (resultSet.next())
                        {
                            bookID = resultSet.getInt(1);
                            size++;
                        }

                        if (size == 0) // no books with this name
                        {
                            System.out.println("no such books!");
                            break;
                        }

                        if (size == 1)
                        {
                            // get data from user
                            System.out.println("Enter new name:");
                            String newName = scanner.next();

                            // prepare and execute statement using users data
                            preparedStatement = connection.prepareStatement("UPDATE books SET name = ? WHERE id = ?");
                            preparedStatement.setString(1, newName);
                            preparedStatement.setInt(2, bookID);
                            preparedStatement.executeUpdate();
                            System.out.println("name changed to: "+newName);
                        }

                        else
                        // there are few books with the same name
                        {
                            preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE name = ?");
                            preparedStatement.setString(1, bookName);
                            resultSet = preparedStatement.executeQuery();

                            while (resultSet.next())
                            {
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("name");
                                String author = resultSet.getString("author");

                                System.out.println(id+") "+name+" "+author);
                            }

                            // get data from user
                            System.out.println("enter ID:");
                            bookID = Integer.parseInt(scanner.next());
                            System.out.println("Enter new name:");
                            String newBookName = scanner.next();

                            // prepare statement with data^
                            preparedStatement = connection.prepareStatement("UPDATE books SET name = ? WHERE id = ?");
                            preparedStatement.setInt(2, bookID);
                            preparedStatement.setString(1, newBookName);
                            preparedStatement.executeUpdate();

                            System.out.println("name changed to"+newBookName);
                        }
                        break;



                    case 4:
                    // DELETE book

                        System.out.println("Enter book name: (deleting)");
                        bookName = scanner.next();

                        // SELECT BY NAME
                        preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE name = ?");
                        preparedStatement.setString(1, bookName);
                        resultSet = preparedStatement.executeQuery();

                        size = 0;
                        while (resultSet.next())
                        {
                           resultSet.getInt(1);
                           size++;
                        }

                        if (size == 0)
                        {
                            System.out.println("no such books!");
                            break;
                        }

                        if (size == 1)
                        {
                            preparedStatement = connection.prepareStatement("DELETE FROM books WHERE name = ?");
                            preparedStatement.setString(1, bookName);
                            preparedStatement.executeUpdate();
                            System.out.println(bookName+" deleted");
                        }

                        else
                        // there are few books with the same name
                        {
                            preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE name = ?");
                            preparedStatement.setString(1, bookName);
                            resultSet = preparedStatement.executeQuery();

                            System.out.println("Select ID: (deleting)");

                            while (resultSet.next())
                            {
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("name");
                                String author = resultSet.getString("author");

                                System.out.println(id+") "+name+" "+author);
                            }
                            System.out.println(" ");


                            bookID = Integer.parseInt(scanner.next());
                            preparedStatement = connection.prepareStatement("DELETE FROM books WHERE id = ?");
                            preparedStatement.setInt(1, bookID);
                            preparedStatement.executeUpdate();

                            System.out.println("book deleted");
                        }
                        break;

                    case 5:
                    // EXIT

                        System.out.println("Goodbye!");
                        exit = true;
                        break;

                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Goodbye!");
            //e.printStackTrace();
        }
    }
}
