package LottoCompany.operations;


import LottoCompany.player.LottoPlayer;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations extends CRUD {

    //refers to the connection instance
    //this instance is used in database operations
    private Connection connection;
    private LottoPlayer lottoPlayer;

    private static DatabaseOperations databaseOperationsInstance;

    public void setLottoPlayer(LottoPlayer lottoPlayer) {
        this.lottoPlayer = lottoPlayer;
    }

    private DatabaseOperations() throws SQLException{
        this.connection = DbConnection.getInstance().getConnection();
    }
    public static DatabaseOperations getInstance() throws SQLException {
        if (databaseOperationsInstance == null) {
            databaseOperationsInstance = new DatabaseOperations();
        }

        return databaseOperationsInstance;
    }

    @Override
    public void create() throws SQLException{
        //created a prepared statement
        String query = "INSERT INTO PLAYERS (userID, username) VALUES (?,?)";

        //enclose in  a try catch
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            //set parameters
            preparedStatement.setInt(1,lottoPlayer.getID());
            preparedStatement.setString(2,lottoPlayer.getName());

            //Execute query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0){
                System.out.println("Successful Insertion to DB");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void read() throws SQLException{

    }

    @Override
    public void update() throws SQLException{

    }

    @Override
    public void delete() throws SQLException {

    }



}