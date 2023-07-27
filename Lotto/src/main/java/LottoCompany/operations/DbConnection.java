package LottoCompany.operations;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    SQLite
 */
public class DbConnection {

    //refers to an instance of DbConnection class
    private static DbConnection instance;

    //refers to instance of connection to database
    private Connection connection = null;


    String jdbcUrl = "jdbc:sqlite:/C:\\sqlite\\databases\\lottoDB.db";

    //private constructor to prevent direct instantiation
    private DbConnection() throws SQLException {
        try {
            //creates connection
            this.connection = DriverManager.getConnection(jdbcUrl);

        } catch (SQLException ex ){
            //if connection fails
            System.out.println("Something went wrong!");
            ex.printStackTrace();
        }
    }

    //returns a single DbConnection class instance
    public static DbConnection getInstance() throws SQLException {
        //checks for DbConnection instance
        if (instance == null) {
            instance = new DbConnection();
        } else if (instance.getConnection().isClosed()){
            instance = new DbConnection();
        }

        return instance;
    }

    //returns instance created in the dbConnection constructor
    //refers to instance of database connection
    public Connection getConnection() {
        return connection;
    }
}
