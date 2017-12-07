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
import javafx.scene.shape.Line;

public class DimpleLine extends Line{
        private ListView<Property> props;
    public DimpleLine(){
                prepareProps(this);
        this.setFill(Color.web("#008080"));
        this.setStroke(Color.web("#008080"));
        this.setStrokeWidth(4);
        this.setStartX(30);
        this.setStartY(15);
        
        this.setEndX(150);
        this.setEndY(100);
        
        
    }
    private void prepareProps(final Line shape) {
        props = new ListView<>();
        TextField locationX = new TextField(), locationY = new TextField();
        ColorPicker fill = new ColorPicker(), stroke = new ColorPicker();
        TextField width = new TextField(), height = new TextField(), strokeW = new TextField();
        final TextField startX = new TextField(), startY = new TextField(), endX = new TextField(), endY = new TextField();

        fill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("Should set fill");
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
                shape.setScaleY(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        width.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setScaleX(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        strokeW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setStrokeWidth(Double.parseDouble(((TextField) t.getSource()).getText()));

            }
        });

        startX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setStartX(Double.parseDouble(startX.getText()));
            }
        });
        startY.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setStartY(Double.parseDouble(startY.getText()));
            }
        });
        endX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setEndX(Double.parseDouble(endX.getText()));
            }
        });
        endY.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setEndY(Double.parseDouble(endY.getText()));
            }
        });
      props.getItems().addAll(new Property(new Label("centerX"), startX),
                new Property(new Label("centerY"), startY),
                new Property(new Label("radiusX"), endX),
                new Property(new Label("radiusY"), endY),
                 new Property(new Label("X          "), locationX),
                new Property(new Label("Y          "), locationY),
                new Property(new Label("Fill       "), fill),
                new Property(new Label("Stroke "), stroke),
                new Property(new Label("Stroke Width"), strokeW),
                new Property(new Label("Scale X  "), width),
                new Property(new Label("Scale Y "), height));
     }
      public ListView<Property> getProps() {
        return props;
    }
   
}
