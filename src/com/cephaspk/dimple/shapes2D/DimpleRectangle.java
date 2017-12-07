/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cephaspk.dimple.shapes2D;

import com.cephaspk.dimple.ui.Property;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class DimpleRectangle extends Rectangle {

    private ListView<Property> props;

    public DimpleRectangle() {
        prepareProps(this);
        this.setFill(Color.web("#008080"));
        this.setStroke(Color.web("#008080"));
        this.setHeight(60);
        this.setWidth(90);

    }
    private void prepareProps(final Rectangle shape) {
        props = new ListView<>();
        TextField arcHeight = new TextField(),arcWidth = new TextField();
        TextField locationX = new TextField(), locationY = new TextField();
        ColorPicker fill = new ColorPicker(), stroke = new ColorPicker();
        TextField width = new TextField(), height = new TextField(), strokeW = new TextField();
        final TextField scaleX = new TextField(), scaleY = new TextField();
        
    fill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setFill(((ColorPicker) t.getSource()).getValue());
            }
        });
        stroke.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setStroke(((ColorPicker) t.getSource()).getValue());
            }
        });
        locationX.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setLayoutX(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        locationY.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setLayoutY(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        height.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setHeight(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        width.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setWidth(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        arcHeight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setArcHeight(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        arcWidth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setArcWidth(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        strokeW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setStrokeWidth(Double.parseDouble(((TextField) t.getSource()).getText()));

            }
        });

        scaleX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setScaleX(Double.parseDouble(scaleX.getText()));
            }
        });
        scaleY.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setScaleY(Double.parseDouble(scaleY.getText()));
            }
        });
      
    
    props.getItems().addAll(
                new Property(new Label("Width"), width),
                new Property(new Label("Height"), height),
                new Property(new Label("ArcWidth"), arcWidth),
                new Property(new Label("ArcHeight"), arcHeight),
                new Property(new Label("X          "), locationX),
                new Property(new Label("Y          "), locationY),
                new Property(new Label("Fill       "), fill),
                new Property(new Label("Stroke "), stroke),
                new Property(new Label("Stroke Width"), strokeW),
                new Property(new Label("Scale X  "), scaleX),
                new Property(new Label("Scale Y "), scaleY));
    }
    public ListView<Property> getProps() {
        return props;
    }
}

    


