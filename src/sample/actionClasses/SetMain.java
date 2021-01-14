package sample.actionClasses;

//SetMain is a class that shows Main VPN Page

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SetMain {
    public SetMain(BorderPane mainPane) {
        //PreLoading mainPage via new LoginLoader
        new LoginLoader(mainPane);
    }
    public  void start(Stage primaryStage) {
        //Using Multi threading for running new Stage and close previous page
        //WARNING: using Multi Threading purposed to prevent app freezing
        Platform.runLater(()->{
            beforeStart(primaryStage);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/mainPage/mainPage.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.getIcons().add(new Image("/sample/images/icon.png"));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    // a function that closes primary stage before mainStage
    public void beforeStart(Stage stage) {
            stage.hide();
    }

}
