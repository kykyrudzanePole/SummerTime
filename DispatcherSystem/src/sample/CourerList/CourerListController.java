package sample.CourerList;

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
import sample.DispatcherOffice.DispatcherOfficeController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

public class CourerListController extends DispatcherOfficeController {

    @FXML
    private TableView<Model> courerTextView;

    @FXML
    private TableColumn<Model, String> IDColumn;

    @FXML
    private TableColumn<Model, String> fullNameColumn;

    @FXML
    private TableColumn<Model, String> phoneColumn;

    @FXML
    private TableColumn<Model, String> statusColumn;

    @FXML
    private Button backButton;
    private ObservableList<Model> observableList = FXCollections.observableArrayList();     // using this reference we can populate TableView
    @FXML
    void initialize(){

        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        try{
            ResultSet resultSet = new CourerListRequest().dbRequest();
            while (resultSet.next()){
                observableList.add(new Model(resultSet.getString("ID"),
                        resultSet.getString("fullName"),
                        resultSet.getString("phone"),
                        resultSet.getString("statusColum")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
            courerTextView.setItems(observableList);
        backButton.setOnAction(new EventHandler<ActionEvent>() { // back to office
            @Override
            public void handle(ActionEvent event) {
                clickButton(backButton, "/sample/DispatcherOffice/DispatcherOfficeView.fxml");
            }
        });
    }
}
