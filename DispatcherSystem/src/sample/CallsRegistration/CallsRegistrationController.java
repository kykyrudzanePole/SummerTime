package sample.CallsRegistration;

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

public class CallsRegistrationController extends DispatcherOfficeController {

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
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickButton(backButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
            }
        });
        registrateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean flag = true;

                for(int i = 0; i < 4; i++){
                    flag = errorCheck(i);
                }
                if(flag){
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/sample/CallsRegistration/CheckRegistration.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    diaFullNameLabel.setText(fullNameField.getText());
                    diaStartAdressLabel.setText(startAdressField.getText());
                    diaEndAdressLabel.setText(endAdressField.getText());
                    diaPhoneLabel.setText(phoneField.getText());
                }
            }
        });
    }

    private boolean errorCheck(int index){
        TextField [] fields = {startAdressField, fullNameField, endAdressField, phoneField};
        Label [] errorLabels = {errorStartAdressLabel, errorFullNameLabel, errorEndAdressLabel, errorPhoneLabel};

        boolean flag = true;

        if(fields[index].getText().length() == 0){
            flag = false;
            errorLabels[index].setText("plz write");
        }else{
            errorLabels[index].setText("");
        }
        if(index == 3) {
            if (fields[index].getText().length() != 10) {
                flag = false;
                errorLabels[index].setText("wrong number");
            } else {
                errorLabels[index].setText("");
            }
        }
        return  flag;
    }


}
