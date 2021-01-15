package sample.actionClasses;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//an easy class to make top bar for close and minimized since our project runs in Undecorated mode

public class Closeable {
    private AnchorPane closeButton;
    private AnchorPane minimizeButton;

    public Closeable(AnchorPane closeButton, AnchorPane minimizeButton) {
        this.closeButton = closeButton;
        this.minimizeButton = minimizeButton;
    }

   public void closeAble(){
        closeButton.setOnMouseClicked(event -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });

        minimizeButton.setOnMouseClicked(event -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.setIconified(true);
        });

   }
}
