package sample.DispatcherOffice;

import sample.DataBaseConnecting;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficeRequest extends DataBaseConnecting {

    public static final String  TABLE = "CallRegistration";
    ResultSet rs = null;

    ResultSet dbRequest() {     // request for office TextView
        try {
             rs = dbConnecting().createStatement().executeQuery("select * from " + TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;
    }
}
