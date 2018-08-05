package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
   Simple database connecting
 */

public class DataBaseConnecting {
    Connection connection;

    String url = "jdbc:mysql://localhost:3306/DispatcherSystem?useSSL=false";
    String username = "root";
    String password = "zakhar99";

    protected Connection dbConnecting() {
        System.out.println("Connecting to the database..... ");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException exception) {
            password = "orest28";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch(SQLException exception1){
                exception1.printStackTrace();
            }
        }
        return connection;
    }
}
