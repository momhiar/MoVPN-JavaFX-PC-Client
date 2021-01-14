package sample.actionClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class LoginLoader implements Runnable {
    BorderPane mainPane;
    public LoginLoader(BorderPane mainPane) {
        this.mainPane = mainPane;
        new Thread(this).run();
    }

    @Override
    public void run() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/loginPage/ajaxLoader.fxml"));
            mainPane.setCenter(root);
            mainPane.getChildren().remove(mainPane.getBottom());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}