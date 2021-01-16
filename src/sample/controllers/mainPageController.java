package sample.controllers;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.application.Platform;
import javafx.concurrent.Task;
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
    @FXML
    private JFXButton secondServerButton;
    @FXML
    private JFXButton thirdServerButton;

    private JFXButton chosenServer;
    @FXML
    private MaterialIconView statusIcon;
    @FXML
    private Label ipLabel;

    @FXML
    private Label topStatusLabel;

    private String connectingButtonsStyle = "-fx-background-color: #FFFF0D  ; -fx-text-fill: #2A2E37";
    private String disConnectedButtonsStyle = "-fx-background-color: #2A2E37  ; -fx-text-fill: #B2B2B2";
    private String connectedButtonsStyle = "-fx-background-color: #03fc07; -fx-border-color: #03fc07; -fx-text-fill: #2A2E37 ";
    private void setToConnecting(){
        statusImage.setImage(new Image("/sample/images/connecting.gif"));
        firstQuickConnectButton.setText("Now Connecting...");
        secondQuickConnectButton.setText("Now Connecting...");
        statusLabel.setText("Now Connecting...");
        firstQuickConnectButton.setStyle(connectingButtonsStyle);
        secondQuickConnectButton.setStyle(connectingButtonsStyle);
        chosenServer.setStyle(connectingButtonsStyle);
        chosenServer.setText("Connecting");
    }
    private void setToDisconnected(){
        statusImage.setImage(new Image("/sample/images/disconnected.gif"));
        secondQuickConnectButton.setText("Quick Connect");
        firstQuickConnectButton.setText("Quick Connect");
        statusLabel.setText("You are not connected");
        firstQuickConnectButton.setOnAction(eventHandler);
        secondQuickConnectButton.setOnAction(eventHandler);
        chosenServer.setOnAction(eventHandler);
        firstQuickConnectButton.setStyle(disConnectedButtonsStyle);
        secondQuickConnectButton.setStyle(disConnectedButtonsStyle);
        firstServerButton.setStyle(disConnectedButtonsStyle);
        secondServerButton.setStyle(disConnectedButtonsStyle);
        thirdServerButton.setStyle(disConnectedButtonsStyle);
        firstServerButton.setText("Connect");
        secondServerButton.setText("Connect");
        thirdServerButton.setText("Connect");
        chosenServer = null;

    }

    private void setToConnected(){
        statusImage.setImage(new Image("/sample/images/connected.gif"));
        chosenServer.setText("Connected");
        firstQuickConnectButton.setText("Connected");
        secondQuickConnectButton.setText("Connected");
        statusLabel.setText("You are now Connected");
        chosenServer.setStyle(connectedButtonsStyle );
        firstQuickConnectButton.setStyle(connectedButtonsStyle);
        secondQuickConnectButton.setStyle(connectedButtonsStyle);

    }



    EventHandler eventHandler = new EventHandler() {
        @Override
        public void handle(Event event) {
            setToConnecting();
            firstQuickConnectButton.setOnAction(event1 -> setToDisconnected());
            secondQuickConnectButton.setOnAction(event1 -> setToDisconnected());
            chosenServer.setOnAction(event1 -> setToDisconnected());

            Task getConnected = new Task() {
                @Override
                protected Object call() throws Exception {
                    Thread.sleep(2000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setToConnected();
                        }
                    });

                    return null;
                }

            };
            new Thread(getConnected).start();

        }
    };



    @Override
    public void initialize(URL location, ResourceBundle resources) {



        new Draggable(topAnchor).draggable();
        new Closeable(closeButton , minimizeButton).closeAble();
        firstServerButton.setOnAction(event -> {


            chosenServer = firstServerButton;
            eventHandler.handle(event);
        });
        secondServerButton.setOnAction(event -> {
            setToDisconnected();

            chosenServer=secondServerButton;
            eventHandler.handle(event);
        });
        thirdServerButton.setOnAction(event -> {
            setToDisconnected();

            chosenServer=thirdServerButton;
            eventHandler.handle(event);
        });

        firstQuickConnectButton.setOnAction(event -> {
            chosenServer = firstServerButton;
            eventHandler.handle(event);
        });
        secondQuickConnectButton.setOnAction(event -> {
            chosenServer = firstServerButton;
            eventHandler.handle(event);
        });


    }
}
