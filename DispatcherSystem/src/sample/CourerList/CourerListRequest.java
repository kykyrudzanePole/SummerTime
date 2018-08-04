package sample.CourerList;

import sample.DataBaseConnecting;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourerListRequest extends DataBaseConnecting {

    public static final String  TABLE = "CourerRegistration";
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
