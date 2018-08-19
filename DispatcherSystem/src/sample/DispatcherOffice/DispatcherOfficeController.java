package sample.DispatcherOffice;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.DataBaseConnecting;
import sample.DispatcherLogin.DataBaseRequest;
import sample.IDCounter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DispatcherOfficeController {

    @FXML
    private TableView<Model> officeTable;

    @FXML
    private TableColumn<Model, String> IDColum;

    @FXML
    private TableColumn<Model, String> fullNameColum;

    @FXML
    private TableColumn<Model, String> phoneColum;

    @FXML
    private TableColumn<Model, String> statusColum;

    @FXML
    private TableColumn<Model, String> fullAdressColum;

    @FXML
    private Button changeDispatcherButton;

    @FXML
    private Button callsRegistrationButton;

    @FXML
    private Button courerListButton;

    @FXML
    private Button courersRegistrationButton;

    public DispatcherOfficeController() {
    }
    private ObservableList<Model> observableList = FXCollections.observableArrayList();     // using this reference we can populate TableView
    @FXML
    void initialize(){

        // connect TableView columns with columns from database
        IDColum.setCellValueFactory(new PropertyValueFactory<>("ID"));
        fullNameColum.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneColum.setCellValueFactory(new PropertyValueFactory<>("phone"));
        statusColum.setCellValueFactory(new PropertyValueFactory<>("status"));
        fullAdressColum.setCellValueFactory(new PropertyValueFactory<>("startAdress"));

        try {
            ResultSet resultSet = new OfficeRequest().dbRequest();
            while (resultSet.next()) {
                observableList.add(new Model(resultSet.getString("ID"),
                        resultSet.getString("startAdress"),
                        resultSet.getString("fullName"),
                        resultSet.getString("phone"),
                        resultSet.getString("statusColum")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        officeTable.setItems(observableList);

        changeDispatcherButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {         // back to Login and Password
                IDCounter.setId(sample.CourerRegistration.DataBaseWriter.IDnumber,
                        sample.CallsRegistration.DataBaseWriter.IDnumber);
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