package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.actionClasses.Closeable;
import sample.actionClasses.Draggable;
import java.net.URL;
import java.util.ResourceBundle;

public class mainPageController implements Initializable {

    @FXML
    private AnchorPane topAnchor;

    @FXML
    private AnchorPane closeButton;

    @FXML
    private AnchorPane minimizeButton;

    @FXML
    private ImageView statusImage;
    @FXML
    private JFXButton firstQuickConnectButton;
    @FXML
    private JFXButton secondQuickConnectButton;
    @FXML
    private Label statusLabel;
    @FXML
    private JFXButton firstServerButton;

    EventHandler eventHandler = new EventHandler() {
        @Override
        public void handle(Event event) {
            statusImage.setImage(new Image("/sample/images/connecting.gif"));
            firstQuickConnectButton.setText("Now Connecting...");
            secondQuickConnectButton.setText("Now Connecting...");
            statusLabel.setText("Now Connecting...");
            firstQuickConnectButton.setStyle("-fx-background-color: #FFFF0D  ; -fx-text-fill: #2A2E37");
            secondQuickConnectButton.setStyle("-fx-background-color: #FFFF0D  ; -fx-text-fill: #2A2E37");
            firstServerButton.setStyle("-fx-background-color: #FFFF0D  ; -fx-text-fill: #2A2E37");
            firstServerButton.setText("Connecting");
            firstQuickConnectButton.setOnAction(event1 -> {
                statusImage.setImage(new Image("/sample/images/disconnected.gif"));
                secondQuickConnectButton.setText("Quick Connect");
                firstQuickConnectButton.setText("Quick Connect");
                statusLabel.setText("You are not connected");
                firstQuickConnectButton.setOnAction(eventHandler);
                secondQuickConnectButton.setOnAction(eventHandler);
                firstQuickConnectButton.setStyle("-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2");
                secondQuickConnectButton.setStyle("-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2");
                firstServerButton.setStyle("-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2");
                firstServerButton.setText("Connect");
            });

            secondQuickConnectButton.setOnAction(event1 -> {
                statusImage.setImage(new Image("/sample/images/disconnected.gif"));
                secondQuickConnectButton.setText("Quick Connect");
                firstQuickConnectButton.setText("Quick Connect");
                statusLabel.setText("You are not connected");
                firstQuickConnectButton.setOnAction(eventHandler);
                secondQuickConnectButton.setOnAction(eventHandler);
                firstQuickConnectButton.setStyle("-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2");
                secondQuickConnectButton.setStyle("-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2");
                firstServerButton.setStyle("-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2");
                firstServerButton.setText("Connect");
            });
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Draggable(topAnchor).draggable();
        new Closeable(closeButton , minimizeButton).closeAble();
        firstQuickConnectButton.setOnAction(eventHandler);
        secondQuickConnectButton.setOnAction(eventHandler);

    }
}
