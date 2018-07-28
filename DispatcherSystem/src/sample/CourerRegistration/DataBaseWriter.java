package sample.CourerRegistration;

import sample.DataBaseConnecting;

import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseWriter extends DataBaseConnecting {

    public static final String TABLE = "CourerRegistration";
    public static final String FULL_NAME = "fullName";
    public static final String ADRESS = "Adress";
    public static final String PASPORT_NUMBER = "pasportNumber";
    public static final String PHONE = "phone";
    public static final String ID = "ID";
    public static final String GMAIL = "gmail";
    public static final String STATUS = "statusColum";

    static int IDnumber = 101;
    String status = "free";
    String fullName;
    String Adress;
    String phone;
    String gmail;
    String pasportNumber;

    public void setDB(){
        try {
            Statement statement = dbConnecting().createStatement();
            statement.executeUpdate(   "insert into " + TABLE + "(" +
                    ID + ", " + FULL_NAME + ", " + ADRESS + ", " + PASPORT_NUMBER + ", " + PHONE + ", " + GMAIL + ", " + STATUS + ") " +
                    " values('" + IDnumber + "', '" + fullName + "', '" + Adress + "'," +
                    " '" + pasportNumber + "' , '" + phone +"' , '" + gmail + "' , '" + status + "')");

            ++IDnumber;

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    DataBaseWriter(String fullName, String Adress, String pasportNumber, String phone, String gmail){

        this.pasportNumber = pasportNumber;
        this.fullName = fullName;
        this.Adress = Adress;
        this.phone = phone;
        this.gmail = gmail;
    }
}
