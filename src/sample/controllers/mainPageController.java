package sample.controllers;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.actionClasses.CloningButtons;
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

    private JFXButton chosenServer;
    @FXML
    private MaterialIconView statusIcon;
    @FXML
    private Label ipLabel;

    @FXML
    private Label topStatusLabel;

    private  CloningButtons clonedButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Draggable(topAnchor).draggable();
        new Closeable(closeButton , minimizeButton).closeAble();





    }
}
