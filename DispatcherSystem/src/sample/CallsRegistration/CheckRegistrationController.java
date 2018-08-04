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
        diaResrtButton.setOnAction(new EventHandler<ActionEvent>() {       // wrong records, back to Registration.fxml
            @Override
            public void handle(ActionEvent event) {
                diaResrtButton.getScene().getWindow().hide();
                clickButton(diaResrtButton, "/sample/CallsRegistration/CallsRegistrationView.fxml");
            }
        });
        // using records from Dispatcher class
        diaFullNameLabel.setText(Dispatcher.fullName);
        diaStartAdressLabel.setText(Dispatcher.startAdress);
        diaEndAdressLabel.setText(Dispatcher.endAdress);
        diaPhoneLabel.setText(Dispatcher.phone);

        diaRegistrateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // create object send records to the DataBaseWriter class which write them to database
                DataBaseWriter dataBaseWriter = new DataBaseWriter(
                        diaFullNameLabel.getText(), diaStartAdressLabel.getText(),
                        diaEndAdressLabel.getText(), diaPhoneLabel.getText(), "free");
                dataBaseWriter.setDB();     // call method which write records to database
                clickButton(diaRegistrateButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");     // back to Office window
            }
        });
    }
}



