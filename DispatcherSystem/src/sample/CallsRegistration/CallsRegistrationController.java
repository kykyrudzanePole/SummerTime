package sample.CallsRegistration;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.DispatcherOffice.DispatcherOfficeController;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallsRegistrationController extends DispatcherOfficeController {       // extends to use method clickButton()

    @FXML
    private TextField startAdressField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField endAdressField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label errorFullNameLabel;

    @FXML
    private Label errorStartAdressLabel;

    @FXML
    private Label errorEndAdressLabel;

    @FXML
    private Label errorPhoneLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button registrateButton;

    @FXML
    void initialize(){
            backButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {         // back to Office window
                    clickButton(backButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
                }
            });
            registrateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    boolean flag = true;        // bool variable for Check on errors in textfields

                    for (int i = 0; i < 4; i++) {       // create circle for easter checking
                        flag = errorCheck(i);       // call method to handled errors and return true or false
                    }
                    if (flag) {     // if after method errorCheck flag true open CheckRegistration.fxml using method clickButton

                        // set values to Dispatcher class
                        Dispatcher.fullName = fullNameField.getText();
                        Dispatcher.startAdress = startAdressField.getText();
                        Dispatcher.endAdress = endAdressField.getText();
                        Dispatcher.phone = phoneField.getText();

                        clickButton(registrateButton, "/sample/CallsRegistration/CheckRegistration.fxml");
                    }
                }
            });
    }
    private boolean errorCheck(int index){
        // create 2 arrays with textfields and errorLabels from window form
        TextField [] fields = {startAdressField, fullNameField, endAdressField, phoneField};
        Label [] errorLabels = {errorStartAdressLabel, errorFullNameLabel, errorEndAdressLabel, errorPhoneLabel};

        boolean flag = true;    // flag for checking

        if(fields[index].getText().length() == 0){      // check on empty rows all textfields
            flag = false;
            errorLabels[index].setText("plz write");
        }else{
            errorLabels[index].setText("");
        }
        if(index == 3) {
            if (fields[index].getText().length() != 10) {       // check phone field on 10 numbers
                flag = false;
                errorLabels[index].setText("wrong number");
            } else {
                errorLabels[index].setText("");
            }

            Pattern pattern = Pattern.compile("\\D");
            Matcher matcher = pattern.matcher(fields[index].getText());


            for (int i = 0; i < fields[index].getText().length(); i++) {    // using regex check on only-number in phone field
                if (matcher.find()) {
                    flag = false;
                    errorLabels[index].setText("only numbers");
                    break;
                } else {
                    errorLabels[index].setText("");
                }
            }
        }
        return  flag;   // return true or false
    }

}
