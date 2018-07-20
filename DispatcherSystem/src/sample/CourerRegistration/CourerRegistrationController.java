package sample.CourerRegistration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DispatcherOffice.DispatcherOfficeController;

public class CourerRegistrationController extends DispatcherOfficeController {

    @FXML
    private TextField pasportCodeField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField adressField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label errorFullNameLabel;

    @FXML
    private Label errorPasportCodeLabel;

    @FXML
    private Label errorAdressLabel;

    @FXML
    private Label errorPhoneLabel;

    @FXML
    private TextField gmailField1;

    @FXML
    private Label errorGmailLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button registrateButton;

    @FXML
    void initialize(){
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickButton(backButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
            }
        });
    }
}
