
package com.cephaspk.dimple.ui;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
public class Property extends HBox {
    private Label propName;
    private Control control;
    public Property(Label propName,Control control){
        propName.setFont(Font.font("Courier", FontWeight.NORMAL,FontPosture.ITALIC,18));
        propName.setTextFill(Color.web("#008080"));
        this.getChildren().addAll(propName,control);
        propName.setStyle("-fx-text-color:#008080");
        this.setSpacing(5);
        
    }

    public Label getPropName() {
        return propName;
    }

    public void setPropName(Label propName) {
        this.propName = propName;
    }

    public Node getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }
    
}
