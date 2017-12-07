
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
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Peter
 */
public class DimpleEllipse extends Ellipse {
        private ListView<Property> props;
    public DimpleEllipse(){
        prepareProps(this);
        this.setFill(Color.web("#008080"));
        this.setStroke(Color.web("#008080"));
        this.setRadiusX(60);
        this.setRadiusY(40);
        
    }
     private void prepareProps(final Ellipse shape) {
        props = new ListView<>();
        TextField locationX = new TextField(), locationY = new TextField();
        ColorPicker fill = new ColorPicker(), stroke = new ColorPicker();
        TextField width = new TextField(), height = new TextField(), strokeW = new TextField();
        final TextField centerX = new TextField(), centerY = new TextField(), radiusX = new TextField(), radiusY = new TextField();

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
        radiusX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setRadiusX(Double.parseDouble(radiusX.getText()));
            }
        });
        radiusY.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setRadiusY(Double.parseDouble(radiusY.getText()));
            }
        });
      props.getItems().addAll(new Property(new Label("centerX"), centerX),
                new Property(new Label("centerY"), centerY),
                new Property(new Label("radiusX"), radiusX),
                new Property(new Label("radiusY"), radiusY),
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
