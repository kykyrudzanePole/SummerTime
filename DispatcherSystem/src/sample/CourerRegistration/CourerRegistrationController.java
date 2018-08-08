package sample.CourerRegistration;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DispatcherOffice.DispatcherOfficeController;
import sample.CourerRegistration.DataBaseWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourerRegistrationController extends DispatcherOfficeController {      // extends to use method clickButton()

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
            public void handle(ActionEvent event) {         // back to Office window
                clickButton(backButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
            }
        });
        registrateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean flag = true;        // bool variable for Check on errors in textfields

                for(int i = 0; i < 5; i++){     // create circle for easter checking
                    flag = errorCheck(i);       // call method to handled errors and return true or false
                }

                if(flag){
                    /*
                         if flag is true after method errorCheck
                         set records to DataBaseWriter class and
                         call method which write records to database
                     */
                    DataBaseWriter dataBaseWriter = new DataBaseWriter(
                            fullNameField.getText(), adressField.getText(), pasportCodeField.getText(),
                            phoneField.getText(), gmailField1.getText());
                    dataBaseWriter.setDB();
                    // open CourerList.fxml to see changes
                    clickButton(registrateButton, "/sample/CourerList/CourerListView.fxml");
                }
            }
        });
    }

    private boolean errorCheck(int index){
        boolean flag = true;        // flag for checking

        // create 2 arrays with textfields and errorLabels from window form
        TextField[] textFields = {fullNameField, pasportCodeField, adressField, phoneField, gmailField1};
        Label[] errorLabels = {errorFullNameLabel, errorPasportCodeLabel, errorAdressLabel, errorPhoneLabel, errorGmailLabel};

        if(textFields[index].getText().length() == 0){      // check on empty rows all textfields
            flag = false;
            errorLabels[index].setText("plz write");
        }else{
            errorLabels[index].setText("");
        }

        if(index == 3) {
            if (textFields[index].getText().length() != 10) {       // check phone field on 10 numbers
                flag = false;
                errorLabels[index].setText("wrong number");
            } else {
                errorLabels[index].setText("");
            }

            Pattern pattern = Pattern.compile("\\D");
            Matcher matcher = pattern.matcher(textFields[index].getText());


            for(int i = 0; i < textFields[index].getText().length(); i++) {     // using regex check on only-number in phone field
                if(matcher.find()) {
                    flag = false;
                    errorLabels[index].setText("only numbers");
                    break;
                }else{
                    errorLabels[index].setText("");
                }
            }
        }

        if(index == 4){             // check gmail field to use '@'
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
