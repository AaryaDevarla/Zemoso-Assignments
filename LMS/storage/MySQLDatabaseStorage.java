package LMS.storage;

import LMS.Book;
import LMS.logger.*;

import java.sql.*;
import java.util.*;

interface MySQLProperties
{
    String DRIVER = "com.mysql.jdbc.Driver";

    String HOST = "localhost";
    String PORT = "3306";

    String USER = "root";
    String PASS = "";

    String DATABASE = "librarymanagementdb";

    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
}

interface MySQLQueries
{
    String FETCH_QUERY = "select * from `Book`";
    String STORE_QUERY = "insert into `Book` values(?, ?)";
}

public class MySQLDatabaseStorage implements IStorage, MySQLProperties{

    ILogger logger;
    private Connection connection;

    MySQLDatabaseStorage(ILogger logger)
    {
        this.logger = logger;
        try{
            Class.forName(MySQLProperties.DRIVER);
            connection = DriverManager.getConnection(MySQLProperties.URL, MySQLProperties.USER, MySQLProperties.PASS);
        }
        catch(Exception e)
        {
            this.logger.log(e.toString());
        }
    }

    public List<Book> fetch()
    {
        List<Book> listOfBooks = new ArrayList<>();

        try{
            
            PreparedStatement fetchStatement = connection.prepareStatement(MySQLQueries.FETCH_QUERY);
            ResultSet rs = fetchStatement.executeQuery();

            while(rs.next())
                listOfBooks.add(new Book(rs.getString(1), rs.getString(2)));
        }

        catch(Exception e)
        {
            this.logger.log(e.getMessage());
        }

        return listOfBooks;
    }

    public void store(List<Book> listOfBooks)
    {
        try{
            
            PreparedStatement storeStatement = connection.prepareStatement(MySQLQueries.STORE_QUERY);
            
            for(Book book : listOfBooks)
                {
                    storeStatement.setString(1, book.getName());
                    storeStatement.setString(2, book.getAuthor());

                    storeStatement.execute();
                }
        }

        catch(Exception e)
        {
            this.logger.log(e.getMessage());
        }
    }   

    protected void finalize() throws Throwable {
        if(connection != null)
            connection.close();
    }
}