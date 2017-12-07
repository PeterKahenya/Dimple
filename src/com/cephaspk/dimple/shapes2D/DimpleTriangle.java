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
import javafx.scene.shape.Polygon;

public class DimpleTriangle extends Polygon{
    private double size=100;
    private final int numSides=3;
    private double centerX,centerY;
    private double radius;
    private ListView<Property> props;
    public DimpleTriangle(){


        prepareProps(this);
        this.setFill(Color.web("#008080"));
        this.setStroke(Color.web("#008080"));
        centerX = size / 2; centerY = size /2;
        radius = Math.min(size, size) * 0.4;
        for(int i=0;i<numSides;i++){
            this.getPoints().add(centerX + radius * Math.cos(2 * i * Math.PI / numSides));
            this.getPoints().add(centerY - radius * Math.sin(2 * i * Math.PI / numSides));
        
        }
        
       
    }
    
     private void prepareProps(final DimpleTriangle shape) {
        props = new ListView<>();
        TextField locationX = new TextField(), locationY = new TextField();
        ColorPicker fill = new ColorPicker(), stroke = new ColorPicker();
        TextField width = new TextField(), height = new TextField(), strokeW = new TextField();
        final TextField centerX = new TextField(),numSides=new TextField(), centerY = new TextField(), radius = new TextField();
    
     fill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setFill(((ColorPicker) t.getSource()).getValue());
            }
        });
      numSides.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               shape.setSize(Integer.parseInt(((TextField) t.getSource()).getText()));
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

        centerX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setCenterX(Double.parseDouble(centerX.getText()));
            }
        });
        centerY.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setCenterY(Double.parseDouble(centerY.getText()));
            }
        });
        radius.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setRadius(Double.parseDouble(radius.getText()));
            }
        });
         props.getItems().addAll(
                new Property(new Label("Size"), numSides),
                new Property(new Label("centerX"), centerX),
                new Property(new Label("centerY"), centerY),
                new Property(new Label("radiusX"), radius),
                new Property(new Label("X          "), locationX),
                new Property(new Label("Y          "), locationY),
                new Property(new Label("Fill       "), fill),
                new Property(new Label("Stroke "), stroke),
                new Property(new Label("Stroke Width"), strokeW),
                new Property(new Label("Scale X  "), width),
                new Property(new Label("Scale Y "), height));
     }

    public int getNumSides() {
        return numSides;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }
     public ListView<Property> getProps() {
        return props;
    }
}
