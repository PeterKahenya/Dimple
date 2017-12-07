/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cephaspk.dimple.controls;

import com.cephaspk.dimple.models.DimpleProject;
import com.cephaspk.dimple.shapes2D.DimpleArc;
import com.cephaspk.dimple.shapes2D.DimpleCircle;
import com.cephaspk.dimple.shapes2D.DimpleEllipse;
import com.cephaspk.dimple.shapes2D.DimpleLine;
import com.cephaspk.dimple.shapes2D.DimplePolygon;
import com.cephaspk.dimple.shapes2D.DimpleRectangle;
import com.cephaspk.dimple.shapes2D.DimpleText;
import com.cephaspk.dimple.shapes2D.DimpleTriangle;
import com.cephaspk.dimple.ui.DimpleTransition;
import com.cephaspk.dimple.ui.transitionProperties.FillTransitionProperties;
import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Shape;

/**
 *
 * @author Peter
 */
public class TransitionController {

    private DimpleProject mproject;
    private DimpleTransition mtransition;
    private SequenceController msequence;
    private Shape shape;
    private Animation currentTransition;
    private SequentialTransition animation;
    
    public TransitionController(SequenceController sequence,DimpleProject project,DimpleTransition transition){
      this.msequence=sequence;
      this.mproject=project;
      this.mtransition=transition;
      mtransition.addTransitionHandler(new EventHandler<ActionEvent>(){

          @Override
          public void handle(ActionEvent t) {
          ComboBox<String> combo=(ComboBox)t.getSource();
          String transType=combo.getValue();
          msequence.addSeq(transType);
          switch(transType){
              case "FillTransition":
                  FillTransition   mcurrentTransition=new FillTransition();
                  FillTransitionProperties ft=new FillTransitionProperties(mcurrentTransition,shape);
                  currentTransition=mcurrentTransition;
                  mtransition.addsetProps(ft.getProps());
                  mproject.addTransition(mcurrentTransition);
                  break;
          }
          }
      });
    mtransition.addPreviewHandler(new EventHandler<ActionEvent>(){

          @Override
          public void handle(ActionEvent t) {
         if(!mproject.getTransitions().isEmpty()){
                  animation=new SequentialTransition();
                  animation.getChildren().addAll(mproject.getTransitions());
                  animation.play();
         }
         else{
             System.out.println("No Transitions Available");
         }
          }
      });
    
    }
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
         if (shape instanceof DimpleCircle) {
            mtransition.setCurrentNode("transition:Circle");
        } else if (shape instanceof DimpleTriangle) {
            mtransition.setCurrentNode("transition:Triangle"); 
        } else if (shape instanceof DimpleArc) {
            mtransition.setCurrentNode("transition:Arc");
        } else if (shape instanceof DimpleEllipse) {
            mtransition.setCurrentNode("transition:Ellipse");
        } else if (shape instanceof DimpleLine) {  
            mtransition.setCurrentNode("transition:Line");
        }else if(shape instanceof DimpleText) {
            mtransition.setCurrentNode("transition:Text");
        }else if(shape instanceof DimplePolygon) {
            mtransition.setCurrentNode("transition:Polygon");
        }else if(shape instanceof DimpleRectangle) { 
            mtransition.setCurrentNode("transition:Rectangle");
        }
        this.shape = shape;
    }
    
    
}


