/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cephaspk.dimple.ui.transitionProperties;

import com.cephaspk.dimple.ui.Property;
import java.util.ArrayList;
import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class FillTransitionProperties {
    private FillTransition mtransition;
    private Shape mshape;
    private ListView<Property> props;
    
    public FillTransitionProperties(FillTransition transition,Shape shape){
        this.mshape=shape;
        this.mtransition=transition;
        mtransition.setShape(shape);
        setUpProps(mtransition);
    }
    
    public void setUpProps(FillTransition t){
     props=new ListView<>();
    final TextField duration=new TextField(),rate=new TextField(),cycles=new TextField();
    final CheckBox autoreverse=new CheckBox();
    ColorPicker fromValue=new ColorPicker(),toValue=new ColorPicker();
    
    duration.setOnAction(new EventHandler<ActionEvent>(){

         @Override
         public void handle(ActionEvent t) {
        mtransition.setDuration(Duration.millis(Double.parseDouble(duration.getText())));
         }
     });
        rate.setOnAction(new EventHandler<ActionEvent>(){

         @Override
         public void handle(ActionEvent t) {
        mtransition.setRate(Double.parseDouble(rate.getText()));
         }
     });
            cycles.setOnAction(new EventHandler<ActionEvent>(){

         @Override
         public void handle(ActionEvent t) {
           mtransition.setCycleCount(Integer.parseInt(cycles.getText()));
         }
     });
        autoreverse.setSelected(false);
        autoreverse.setOnAction(new EventHandler<ActionEvent>(){

         @Override
         public void handle(ActionEvent t) {
        if(autoreverse.isSelected()){
            mtransition.setAutoReverse(true);
        }else{
             mtransition.setAutoReverse(false);
        }
         }
     });
            fromValue.setOnAction(new EventHandler<ActionEvent>(){

         @Override
         public void handle(ActionEvent t) {
        mtransition.setFromValue(((ColorPicker)t.getSource()).getValue());
         }
     });
                toValue.setOnAction(new EventHandler<ActionEvent>(){

         @Override
         public void handle(ActionEvent t) {
         mtransition.setToValue(((ColorPicker)t.getSource()).getValue());
         }
     });
    
    

        props.getItems().addAll(new Property(new Label("From Value"),fromValue),
                                new Property(new Label("To Value"),toValue),
                                new Property(new Label("duration"),duration),
                                new Property(new Label("rate"),rate),
                                new Property(new Label("cycles       "),cycles),
                                new Property(new Label("autoreverse "),autoreverse));

    }

    public ListView<Property> getProps() {
        return props;
    }
}
