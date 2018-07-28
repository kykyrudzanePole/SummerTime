package sample.CallsRegistration;

import sample.DataBaseConnecting;

import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseWriter extends DataBaseConnecting {

    // create constants for table colum
    public static final String TABLE = "CallRegistration";
    public static final String FULL_NAME = "fullName";
    public static final String STARTA_DRESS = "startAdress";
    public static final String END_ADRESS = "endAdress";
    public static final String PHONE = "phone";
    public static final String ID = "ID";
    public static final String STATUS = "statusColum";

    // values for row in database
    static int IDnumber = 101;
    String status;
    String fullName;
    String startAdress;
    String phone;
    String endAdress;

    public void setDB(){
        try {
            Statement statement = dbConnecting().createStatement();
            // create request to database
            statement.executeUpdate("insert into " + TABLE + "(" +
                    ID + ", " + FULL_NAME + ", " + STARTA_DRESS + ", " + END_ADRESS + ", " + PHONE + ", " + STATUS + ") " +
                    " values('" + IDnumber + "', '" + fullName + "', '" + startAdress + "'," +
                    " '" + endAdress + "' , '" + phone +"', '" + status + "')");
            ++IDnumber;     // add one to the id

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    DataBaseWriter(String fullName, String startAdress, String endAdress, String phone, String status){     // take values from
        this.status = status;                                                                               // fxml controller
        this.fullName = fullName;
        this.startAdress = startAdress;
        this.phone = phone;
        this.endAdress = endAdress;
    }
}
