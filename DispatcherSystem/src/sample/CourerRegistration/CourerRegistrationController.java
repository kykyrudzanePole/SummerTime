package sample.CourerRegistration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DispatcherOffice.DispatcherOfficeController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        registrateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dispatcher dispatcher = new Dispatcher(
                        fullNameField.getText(), pasportCodeField.getText(), adressField.getText(),
                        phoneField.getText(), gmailField1.getText());

                boolean flag = true;

                for(int i = 0; i < 5; i++){
                    flag = errorCheck(i);
                }

                if(flag){

                }
            }
        });
    }
    private boolean errorCheck(int index){
        boolean flag = true;

        TextField[] textFields = {fullNameField, pasportCodeField, adressField, phoneField, gmailField1};
        Label[] errorLabels = {errorFullNameLabel, errorPasportCodeLabel, errorAdressLabel, errorPhoneLabel, errorGmailLabel};

        if(textFields[index].getText().length() == 0){
            flag = false;
            errorLabels[index].setText("plz write");
        }else{
            errorLabels[index].setText("");
        }

        if(index == 3) {
            if (textFields[index].getText().length() != 10) {
                flag = false;
                errorLabels[index].setText("wrong number");
            } else {
                errorLabels[index].setText("");
            }

            Pattern pattern = Pattern.compile("\\D");
            Matcher matcher = pattern.matcher(textFields[index].getText());


            for(int i = 0; i < textFields[index].getText().length(); i++) {
                if(matcher.find()) {
                    flag = false;
                    errorLabels[index].setText("only numbers");
                    break;
                }else{
                    errorLabels[index].setText("");
                }
            }
        }

        if(index == 4){
            int count = 0;

            Pattern pattern = Pattern.compile("@");
            Matcher matcher = pattern.matcher(textFields[index].getText());

            while(matcher.find()){
                count++;
            }

            if(count != 1){
                errorLabels[index].setText("wrong mail");
            }else {
                errorLabels[index].setText("");
            }
        }
        return flag;
    }
}
