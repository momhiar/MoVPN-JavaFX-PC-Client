package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private JFXButton quickConnectButton;


    @FXML
    private ImageView statusImage;

    @FXML
    private JFXButton quickConnectButton1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Draggable(topAnchor).draggable();
        new Closeable(closeButton , minimizeButton).closeAble();
    }
}
