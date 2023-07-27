package LottoCompany.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations extends CRUD {

    //refers to the connection instance
    //this instance is used in database operations
    private Connection connection;

    public DatabaseOperations() throws SQLException{
        this.connection = DbConnection.getInstance().getConnection();
    }
    @Override
    void create() throws SQLException{
        String query = "INSERT INTO PLAYERS (userID, username) VALUES (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
    }

    @Override
    void read() {

    }

    @Override
    void update() {

    }

    @Override
    void delete() {

    }
}