package LottoCompany.operations;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    //refers to an instance of dbConnection
    private static DbConnection instance;

    private Connection connection = null;
    String jdbcUrl = "jdbc:sqlite:/C:\\sqlite\\databases\\lottoDB.db";

    //private constructor to prevent direct instantiation
    private DbConnection() throws SQLException {
        try {
            //creates connection
            this.connection = DriverManager.getConnection(jdbcUrl);
            System.out.println("Successful Connection");
        } catch (SQLException ex ){
            System.out.println("Something went wrong!");
            ex.printStackTrace();
        }
    }

    //returns a single dbConnection class instance
    public static DbConnection getInstance() throws SQLException {
        //checks if there is already an instance of the class or not
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
