package sample.actionClasses;

import com.jfoenix.controls.JFXButton;

public class CloningButtons implements Cloneable {
   private  JFXButton chosenButton;

    public JFXButton clone()throws CloneNotSupportedException{
        return (JFXButton) super.clone();
    }
    public  JFXButton getChosenButton() {
        return chosenButton;
    }

    public void setChosenButton(JFXButton chosenButton) {
        this.chosenButton = chosenButton;
    }
}
