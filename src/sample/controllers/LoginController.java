package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.actionClasses.Closeable;
import sample.actionClasses.Draggable;
import sample.actionClasses.SetMain;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane topAnchor;

    @FXML
    private AnchorPane closeButton;

    @FXML
    private AnchorPane minimizeButton;
    @FXML
    private BorderPane mainPane;
    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton registerButton;
    @FXML
    private JFXTextField unameField;

    @FXML
    private JFXPasswordField pwdField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //User Friendly !!!!!!!!!!!!!
        loginButton.setDefaultButton(true);
        unameField.requestFocus();


        //configure the top tape
        new Closeable(closeButton, minimizeButton).closeAble();
        new Draggable(topAnchor).draggable();

        //configure the login button
        loginButton.setOnAction(event -> {
            //TODO: we need to make login controls

            // by Constructing new SetMain , Preloader runs
           SetMain setMain= new SetMain(mainPane);

           //This task and thread used to make 3Sec delay for showing preloader in this static sample
            //TODO: we will edit this task , so maybe we won't need Thread.sleep if we connect to server
            Task task = new Task() {
                //TODO: we need Configuration for loginPage
                @Override
                protected Object call() throws Exception {
                    Thread.sleep(3000);
                    setMain.start((Stage) mainPane.getScene().getWindow());
                    return null;
                }
            };
            new Thread(task).start();



        });
        //TODO:Configure register Button
        registerButton.setOnAction(event -> {
            //TODO: we need to make a register page and make this button activate





        });


    }







}

