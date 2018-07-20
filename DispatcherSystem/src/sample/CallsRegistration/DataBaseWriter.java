package sample.CallsRegistration;

import sample.DataBaseConnecting;

import java.sql.SQLException;
import java.sql.Statement;

import static sample.CallsRegistration.Const.*;

public class DataBaseWriter extends DataBaseConnecting {
    int IDnumber;
    String fullName;
    String startAdress;
    String phone;
    String endAdress;

    public void setDB(){
        try {
            Statement statement = dbConnecting().createStatement();
            statement.executeUpdate
                    ("insert into " + TABLE + "(" +
                            ID + ", " + FULL_NAME + ", " + STARTA_DRESS + ", " + END_ADRESS + ", " + PHONE + ") " +
                            " values(" + IDnumber + ", " + fullName + ", " + startAdress + ", " + endAdress + ", " + phone + ")");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    DataBaseWriter(int ID, String fullName, String startAdress, String endAdress, String phone){

        this.IDnumber = ID;
        this.fullName = fullName;
        this.startAdress = startAdress;
        this.phone = phone;
        this.endAdress = endAdress;
    }
}
