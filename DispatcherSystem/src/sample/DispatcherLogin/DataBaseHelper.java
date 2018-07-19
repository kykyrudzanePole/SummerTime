package sample.DispatcherLogin;

import sample.DataBaseConnecting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static sample.DispatcherLogin.Const.*;

public class DataBaseHelper extends DataBaseConnecting {

    String login;
    String password;

    public boolean getDB(){
        boolean flag = false;
        ResultSet resultSet = null;

        try {
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
    DataBaseHelper(String login, String password){
        this.login = login;
        this.password = password;
    }
}
