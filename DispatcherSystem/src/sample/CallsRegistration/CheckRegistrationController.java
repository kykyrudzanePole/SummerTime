package sample.CallsRegistration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.DispatcherOffice.DispatcherOfficeController;

public class CheckRegistrationController extends DispatcherOfficeController {

    @FXML
    private Label diaFullNameLabel;

    @FXML
    private Label diaStartAdressLabel;

    @FXML
    private Label diaEndAdressLabel;

    @FXML
    private Label diaPhoneLabel;

    @FXML
    private Button diaRegistrateButton;

    @FXML
    private Button diaResrtButton;

    @FXML
    void initialize(){

        diaFullNameLabel.setText(Dispatcher.fullName);
        diaStartAdressLabel.setText(Dispatcher.startAdress);
        diaEndAdressLabel.setText(Dispatcher.endAdress);
        diaPhoneLabel.setText(Dispatcher.phone);

        diaResrtButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                diaResrtButton.getScene().getWindow().hide();
            }
        });
        diaRegistrateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ID = 100;

                DataBaseWriter dataBaseWriter = new DataBaseWriter(
                        ID, diaFullNameLabel.getText(), diaStartAdressLabel.getText(), diaEndAdressLabel.getText(), diaPhoneLabel.getText());
                dataBaseWriter.setDB();
                ID++;

                clickButton(diaRegistrateButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
            }
        });
    }
}


