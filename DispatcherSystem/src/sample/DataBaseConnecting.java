package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Creating database connecting
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
            exception.printStackTrace();
        }
        return connection;
    }
}
