package sample.DispatcherLogin;

import sample.DataBaseConnecting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static sample.DispatcherLogin.Const.*;

public class DataBaseRequest extends DataBaseConnecting {            // extends in order to take access to the database

    // standart assign from constructor
    String login;
    String password;

    public boolean getDB(){

        boolean flag = false;               // bool changes which check valid login and password
        ResultSet resultSet = null;

        try {
            // Standart request using PreparedStatement and method executeQuery
            Statement statement = dbConnecting().createStatement();
            String select = "SELECT * FROM " + TABLE + " WHERE " + LOGIN + "=? AND " + PASSWORD + "=?";
            PreparedStatement preparedStatement = dbConnecting().prepareStatement(select); // using request
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                flag = true;
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return flag;
    }
    DataBaseRequest(String login, String password){  // take login and password from fxml controller
        this.login = login;
        this.password = password;
    }
}
