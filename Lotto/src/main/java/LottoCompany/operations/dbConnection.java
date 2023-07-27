package LottoCompany.operations;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:/C:\\sqlite\\databases\\lottoDB.db";

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);

            String query = "SELECT * FROM PLAYERS";
            Statement statement = conn.createStatement();

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()){
                Integer userID = resultset.getInt("userID");
                String username = resultset.getString("username");

                System.out.println(userID + " ---> " + username);
            }

            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}

