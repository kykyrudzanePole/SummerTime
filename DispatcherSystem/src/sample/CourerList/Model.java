package sample.CourerList;

public class Model {

    public String phone;
    public String ID;
    public String fullName;
    public String statusColum;


    Model(String ID, String fullName, String phone, String statusColum) {
        this.statusColum = statusColum;
        this.ID = ID;
        this.fullName = fullName;
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getStatus() {
        return statusColum;
    }

    public void setStatus(String status) {
        this.statusColum = status;
    }
}
