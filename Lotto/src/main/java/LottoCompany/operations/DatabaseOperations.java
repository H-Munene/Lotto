package LottoCompany.operations;

import LottoCompany.player.LottoPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations extends CRUD {

    //refers to the Connection instance
    //this instance is used in database operations
    private Connection connection;

    //DatabaseOperations class instance
    private static DatabaseOperations databaseOperationsInstance;

    private LottoPlayer lottoPlayer;

    public void setLottoPlayer(LottoPlayer lottoPlayer) {
        this.lottoPlayer = lottoPlayer;
    }

    private DatabaseOperations() throws SQLException{
        this.connection = DbConnection.getInstance().getConnection();
    }

    //ensures there is only one instance of the class running
    public static DatabaseOperations getInstance() throws SQLException {
        if (databaseOperationsInstance == null) {
            databaseOperationsInstance = new DatabaseOperations();
        }

        return databaseOperationsInstance;
    }

    //overriden methods
    @Override
    public void create() throws SQLException{
        //sql query to insert data
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