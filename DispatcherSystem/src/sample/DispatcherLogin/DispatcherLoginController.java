package sample.DispatcherLogin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.DispatcherOffice.DispatcherOfficeController;

public class DispatcherLoginController extends DispatcherOfficeController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    void initialize(){
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(checkDate()){
                   clickButton(loginButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
                }else{
                    errorLabel.setText("Wrong password or login :( ");
                }
            }
        });
    }

    private boolean checkDate(){

        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();

        DataBaseRequest dataBaseHelper = new DataBaseRequest(login, password);
        return  dataBaseHelper.getDB();

    }
}
