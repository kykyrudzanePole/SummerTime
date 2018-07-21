package sample.DispatcherOffice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DispatcherOfficeController {

    @FXML
    private Button changeDispatcherButton;

    @FXML
    private Button callsRegistrationButton;

    @FXML
    private Button courerListButton;

    @FXML
    private Button courersRegistrationButton;

    @FXML
    void initialize(){
        changeDispatcherButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {         // back to Login and Password
                clickButton(changeDispatcherButton, "/sample/DispatcherLogin/DispatcherLoginView.fxml");
            }
        });
        callsRegistrationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {         // open Registration calls form-window
                clickButton(callsRegistrationButton, "/sample/CallsRegistration/CallsRegistrationView.fxml");
            }
        });
        courerListButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {         // open Information about all courers
                clickButton(courerListButton, "/sample/CourerList/CourerListView.fxml");
            }
        });
        courersRegistrationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {         // open Registration courer form-window
                clickButton(courersRegistrationButton, "/sample/CourerRegistration/CourerRegistrationView.fxml");
            }
        });
    }

    /* method which take button and fmxl file and due to this,
       hide current window and open mentioned fxml file
     */
    protected void clickButton(Button button, String way){
        button.getScene().getWindow().hide();       // hide window
        try {
            Parent root = FXMLLoader.load(getClass().getResource(way));     // open new window
            Stage stage = new Stage();
            stage.setTitle("DISPATCHER COURIER SYSTEM <3");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}