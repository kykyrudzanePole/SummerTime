package sample.CallsRegistration;

import sample.DataBaseConnecting;

import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseWriter extends DataBaseConnecting {

    public static final String TABLE = "CallRegistration";
    public static final String FULL_NAME = "fullName";
    public static final String STARTA_DRESS = "startAdress";
    public static final String END_ADRESS = "endAdress";
    public static final String PHONE = "phone";
    public static final String ID = "ID";

    static int IDnumber = 101;
    String fullName;
    String startAdress;
    String phone;
    String endAdress;

    public void setDB(){
        try {
            Statement statement = dbConnecting().createStatement();
            statement.executeUpdate("insert into " + TABLE + "(" +
                    ID + ", " + FULL_NAME + ", " + STARTA_DRESS + ", " + END_ADRESS + ", " + PHONE + ") " +
                    " values('" + IDnumber + "', '" + fullName + "', '" + startAdress + "'," +
                    " '" + endAdress + "' , '" + phone +"')");

            ++IDnumber;

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    DataBaseWriter(String fullName, String startAdress, String endAdress, String phone){

        this.fullName = fullName;
        this.startAdress = startAdress;
        this.phone = phone;
        this.endAdress = endAdress;
    }
}
