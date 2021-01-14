package sample.actionClasses;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


//Draggable is an Class to make our UNDECORATED Styled Stages Drag and droppable by an AnchorPane
public class Draggable {
    @FXML
    private final AnchorPane anchorPane;
    private double xOffset = 0;
    private double yOffset = 0;
    //Constructing Draggable
    public Draggable(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    //Get Action Offset
    public void draggable(){
        anchorPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX() ;
            yOffset = event.getSceneY() ;
        });

        //Initializing draggability
        anchorPane.setOnMouseDragged(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }


}
