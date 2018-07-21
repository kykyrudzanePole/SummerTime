package sample.CourerList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.DispatcherOffice.DispatcherOfficeController;

import java.io.IOException;

public class CourerListController extends DispatcherOfficeController {

    @FXML
    private Button backButton;

    @FXML
    void initialize(){
        backButton.setOnAction(new EventHandler<ActionEvent>() { // back to office
            @Override
            public void handle(ActionEvent event) {
                clickButton(backButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
            }
        });
    }
}
