package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.CourerRegistration.DataBaseWriter;

public class Main extends Application {

    // program start from  DispatcherLoginView.fxml

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DispatcherLogin/DispatcherLoginView.fxml"));
        primaryStage.setTitle("DISPATCHER LOGIN :P");   // titel
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void stop(){         // method which call when program close
        System.out.println("Stage is closing");
        IDCounter.setId(sample.CourerRegistration.DataBaseWriter.IDnumber,      // call method which save IDnumbers
                sample.CallsRegistration.DataBaseWriter.IDnumber);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
