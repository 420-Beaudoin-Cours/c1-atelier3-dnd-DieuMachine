package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class Controller {


    public void txfSourceDragDetected(MouseEvent mouseEvent) {
        if (!((TextField)mouseEvent.getSource()).getText().isEmpty()){
            Dragboard db = ((TextField)mouseEvent.getSource()).startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(((TextField)mouseEvent.getSource()).getText());
            db.setContent(content);
        }
    }

    public void imgTarget1DragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void imgTarget1DragDrop(DragEvent dragEvent) {
        ((TextField)dragEvent.getGestureSource()).clear();

    }


    public void cmbTargetDragDrop(DragEvent dragEvent) {
        ((ComboBox)dragEvent.getGestureTarget()).getItems().add(((TextField)dragEvent.getGestureSource()).getText());
        ((ComboBox)dragEvent.getGestureTarget()).getSelectionModel().selectLast();
        ((TextField)dragEvent.getGestureSource()).clear();
    }

    public void cmbTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void txfSourceDragDrop(DragEvent dragEvent) {
        ((TextField)dragEvent.getGestureTarget()).setText(((TextField)dragEvent.getGestureSource()).getText());
        ((TextField)dragEvent.getGestureSource()).clear();
        dragEvent.getDragboard().clear();
    }

    public void txfSourceDragOver(DragEvent dragEvent) {
        if(!dragEvent.getGestureSource().equals(dragEvent.getGestureTarget()))
            dragEvent.acceptTransferModes(TransferMode.ANY);
    }
}