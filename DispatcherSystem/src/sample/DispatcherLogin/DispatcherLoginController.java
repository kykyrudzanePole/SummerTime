package sample.DispatcherLogin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DispatcherLoginController  {

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
                    loginButton.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/sample/DispatcherOffice/DispatcherOfficeView.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }else{
                    errorLabel.setText("Wrong password or login :( ");
                }
            }
        });
    }

    private boolean checkDate(){

        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(login, password);
        return  dataBaseHelper.getDB();

    }
}
