package sample.CallsRegistration;

/*
     this class save records from CallRegistrationView.fxml,
     to write them in CheckRegistration.fxml for the last checking
 */

public class Dispatcher {

    static String fullName;
    static String startAdress;
    static String endAdress;
    static String phone;


    Dispatcher(String fullName, String startAdress, String endAdress, String phone){

        this.fullName = fullName;
        this.startAdress = startAdress;
        this.endAdress = endAdress;
        this.phone = phone;
    }
}
