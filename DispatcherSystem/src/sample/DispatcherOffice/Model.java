package sample.DispatcherOffice;

    /*
        Model class for connecting database and TextView
        There are five columns names which we create using constructor
        and theirs get and set method for  ObservableList<Model> in
        DispatcherOfficeController class
     */

public class Model {

    public String phone;
    public String ID;
    public String fullName;
    public String startAdress;
    public String status;


    Model(String ID, String startAdress, String fullName, String phone, String status){
        this.startAdress = startAdress;
        this.ID = ID;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStartAdress() {
        return startAdress;
    }

    public void setStartAdress(String startAdress) {
        this.startAdress = startAdress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}

