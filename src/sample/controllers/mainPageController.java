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
import javafx.scene.paint.Color;
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
    private  JFXButton firstServerButton;
    @FXML
    private  JFXButton secondServerButton;
    @FXML
    private  JFXButton thirdServerButton;
    @FXML
    private MaterialIconView statusIcon;
    @FXML
    private Label ipLabel;

    @FXML
    private Label topStatusLabel;
    private String status;

    private final String connectingButtonsStyle = "-fx-background-color: #FFFF0D  ; -fx-text-fill: #2A2E37";
    private final String disConnectedButtonsStyle = "";
    private final String connectedButtonsStyle = "-fx-background-color: #03fc07; -fx-border-color: #03fc07; -fx-text-fill: #2A2E37 ";
    private EventHandler setToConnecting(JFXButton chosenServer){
        EventHandler connecting = event -> {
            setToDisconnected().handle(event);
            statusImage.setImage(new Image("/sample/images/connecting.gif"));
            firstQuickConnectButton.setText("Now Connecting...");
            secondQuickConnectButton.setText("Now Connecting...");
            statusLabel.setText("Now Connecting...");
            firstQuickConnectButton.setStyle(connectingButtonsStyle);
            secondQuickConnectButton.setStyle(connectingButtonsStyle);
            chosenServer.setStyle(connectingButtonsStyle);
            chosenServer.setText("Connecting");
            topStatusLabel.setText("You are now Connecting");
            statusIcon.setGlyphName("WARNING");
            statusIcon.setFill(Color.web("#ff0"));

            status = "connecting";

            firstServerButton.setOnAction(null);
            secondServerButton.setOnAction(null);
            thirdServerButton.setOnAction(null);

            chosenServer.setOnAction(setToDisconnected());
            firstQuickConnectButton.setOnAction(setToDisconnected());
            secondQuickConnectButton.setOnAction(setToDisconnected());


            Task setToConnected = new Task() {
                @Override
                protected Object call() throws Exception {


                    Thread.sleep(2000);
                    if (status.equals("connecting")){
                        Platform.runLater(() -> setToConnected(chosenServer));
                    }


                    return null;
                }
            };
            new Thread(setToConnected).start();
        };
        return connecting;

    }
    private void setToConnected(JFXButton chosenServer){

                statusImage.setImage(new Image("/sample/images/connected.gif"));
                chosenServer.setText("Connected");
                firstQuickConnectButton.setText("Connected");
                secondQuickConnectButton.setText("Connected");
                statusLabel.setText("You are now Connected");
                chosenServer.setStyle(connectedButtonsStyle );
                firstQuickConnectButton.setStyle(connectedButtonsStyle);
                secondQuickConnectButton.setStyle(connectedButtonsStyle);
                firstServerButton.setOnAction(setToConnecting(firstServerButton));
                secondServerButton.setOnAction(setToConnecting(secondServerButton));
                thirdServerButton.setOnAction(setToConnecting(thirdServerButton));
                chosenServer.setOnAction(setToDisconnected());
                status = "connected";
                ipLabel.setText("IP: 192.16.1.1");
                topStatusLabel.setText("You are now Connected");
                statusIcon.setGlyphName("CHECK_CIRCLE");
                statusIcon.setFill(Color.web("#03fc07"));
            }

    private EventHandler setToDisconnected(){

        EventHandler setToDisConnected = new EventHandler() {
            @Override
            public void handle(Event event) {
                setDefault();

            }
        };


        return  setToDisConnected;
    }

    private void setDefault(){
        //set image to default
        statusImage.setImage(new Image("/sample/images/disconnected.gif"));
        //set texts
        secondQuickConnectButton.setText("Quick Connect");
        firstQuickConnectButton.setText("Quick Connect");
        statusLabel.setText("You are not connected");
        firstServerButton.setText("Connect");
        secondServerButton.setText("Connect");
        thirdServerButton.setText("Connect");
        status = "disconnected";
        ipLabel.setText("IP:127.0.0.1");
        //reset actions
        firstQuickConnectButton.setOnAction(setToConnecting(firstServerButton));
        secondQuickConnectButton.setOnAction(setToConnecting(firstServerButton));
        firstServerButton.setOnAction(setToConnecting(firstServerButton));
        secondServerButton.setOnAction(setToConnecting(secondServerButton));
        thirdServerButton.setOnAction(setToConnecting(thirdServerButton));

        //reset Buttons styles
        firstQuickConnectButton.setStyle(disConnectedButtonsStyle);
        secondQuickConnectButton.setStyle(disConnectedButtonsStyle);
        firstServerButton.setStyle(disConnectedButtonsStyle);
        secondServerButton.setStyle(disConnectedButtonsStyle);
        thirdServerButton.setStyle(disConnectedButtonsStyle);

        //top status bar
        topStatusLabel.setText("You are not Connected");
        statusIcon.setGlyphName("WARNING");
        statusIcon.setFill(Color.RED);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Draggable(topAnchor).draggable();
        new Closeable(closeButton , minimizeButton).closeAble();

        setDefault();






    }
}
