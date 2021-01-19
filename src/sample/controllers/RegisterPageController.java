package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sample.actionClasses.Closeable;
import sample.actionClasses.Draggable;

import java.net.URL;
import java.util.ResourceBundle;


public class RegisterPageController implements Initializable {

    @FXML
    private AnchorPane closeButton;

    @FXML
    private AnchorPane minimizeButton;

    @FXML
    private AnchorPane topAnchor;

    @FXML
    private JFXTextField fnameField;

    @FXML
    private JFXTextField lnameField;

    @FXML
    private JFXTextField emailField;

    @FXML
    private JFXTextField unameField;

    @FXML
    private JFXPasswordField pwdField;

    @FXML
    private JFXPasswordField rpwdField;

    @FXML
    private JFXCheckBox termsCheckBox;

    @FXML
    private JFXButton registerButton;

    @FXML
    private JFXButton cancelButton;

    void setCancelButtonAction(EventHandler eventHandler){
        cancelButton.setOnAction(eventHandler);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Draggable(topAnchor).draggable();
        new Closeable(closeButton, minimizeButton).closeAble();

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
