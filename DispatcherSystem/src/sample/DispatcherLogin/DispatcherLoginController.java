package sample.DispatcherLogin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.DispatcherOffice.DispatcherOfficeController;
import sample.IDCounter;

import java.io.IOException;

public class DispatcherLoginController extends DispatcherOfficeController {     // extends to use method clickButton()

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

        IDCounter idCounter = new IDCounter();
        idCounter.getID();

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(checkDate()){            // using method checkData where we check login and password
                   clickButton(loginButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");      // open office window
                }else{
                    errorLabel.setText("Wrong password or login :( ");      // error
                }
            }
        });
    }

    private boolean checkDate(){

        // take varibles from textfields and set them in constructor
        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();

        DataBaseRequest dataBaseHelper = new DataBaseRequest(login, password);
        return  dataBaseHelper.getDB();

    }
}
