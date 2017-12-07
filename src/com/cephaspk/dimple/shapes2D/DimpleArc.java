package com.cephaspk.dimple.shapes2D;

import com.cephaspk.dimple.ui.Property;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

public class DimpleArc extends Arc {

    private ListView<Property> props;

    public DimpleArc() {
        prepareProps(this);
        this.setRadiusX(100);
        this.setRadiusY(100);
        this.setStartAngle(20);
        this.setLength(90);
        this.setType(ArcType.OPEN);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.web("#008080"));
        this.setStrokeWidth(10);
    }

    private void prepareProps(final Arc shape) {
        props = new ListView<>();
        TextField locationX = new TextField(), locationY = new TextField();
        ColorPicker fill = new ColorPicker(), stroke = new ColorPicker();
        TextField width = new TextField(), height = new TextField(), strokeW = new TextField();
        final TextField centerX = new TextField(), centerY = new TextField(), radiusX = new TextField(), radiusY = new TextField(), startAngle = new TextField(), length = new TextField();
        final ComboBox<String> type = new ComboBox();
        type.getItems().addAll("OPEN", "CHORD", "ROUND");

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
        startAngle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setStartAngle(Double.parseDouble(startAngle.getText()));
            }
        });
        length.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setLength(Double.parseDouble(length.getText()));
            }
        });
        type.setValue("OPEN");
        type.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (type.getValue() == "OPEN") {
                    shape.setType(ArcType.OPEN);
                } else if (type.getValue() == "CHORD") {
                    shape.setType(ArcType.CHORD);
                } else if (type.getValue() == "ROUND") {
                    shape.setType(ArcType.ROUND);
                }

            }
        });
        props.getItems().addAll(new Property(new Label("centerX"), centerX),
                new Property(new Label("centerY"), centerY),
                new Property(new Label("radiusX"), radiusX),
                new Property(new Label("radiusY"), radiusY),
                new Property(new Label("startAngle"), startAngle),
                new Property(new Label("Length"), length),
                new Property(new Label("Arc Type"), type),
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
