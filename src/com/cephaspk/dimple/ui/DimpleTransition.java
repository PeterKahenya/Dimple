package com.cephaspk.dimple.ui;

import java.util.ArrayList;
import javafx.animation.FillTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
public class DimpleTransition extends VBox {   
 
    private StackPane propsID;
    private Node props;
    private ComboBox<String> transitions;
    public Button prev;
    private Text label=new Text("Transitions");
    
    public DimpleTransition(){
        prev=new Button("Preview");
        propsID=setUPPropsID();
        String[] trans={"ScaleTransition",
                        "FadeTransition",
                        "FillTransition",
                        "PathTransition",
                        "ParallelTransition",
                        "PauseTransition",
                        "RotateTransition",
                        "StrokeTransition",
                        "TranslateTransition",
                        "CustomTransition"};
        transitions=new ComboBox<>(FXCollections.observableArrayList(trans));
        transitions.setStyle("-fx-color:#008080");
        transitions.setValue("Choose Transition");
        transitions.setPrefWidth(270);
        Text t=new Text("No shape Selected");
        t.setFill(Color.web("#008080"));
        t.setRotate(45);
        this.setPrefSize(270,180);
        this.getChildren().addAll(propsID,transitions,t,prev);
    }
    public void addsetProps(Node n){
        this.getChildren().remove(2);
        this.getChildren().add(2, n);
    }


    private StackPane setUPPropsID() {
        StackPane st=new StackPane();
      //setUp2DID
        final Rectangle labelbg=new Rectangle();
        labelbg.setHeight(30);labelbg.setWidth(270);
        labelbg.setArcHeight(15);labelbg.setArcWidth(15);
        labelbg.setStroke(Color.web("#008080"));labelbg.setFill(Color.TRANSPARENT);labelbg.setStrokeWidth(2);
        label.setFill(Color.web("#008080"));
        label.setFont(Font.font("Courier", FontWeight.NORMAL,FontPosture.ITALIC,18));
        labelbg.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
            FillTransition fillT=new FillTransition();
            fillT.setShape(labelbg);
            fillT.setFromValue(Color.TRANSPARENT);fillT.setToValue(Color.web("#008080"));
            fillT.setDuration(Duration.millis(3000));
            FillTransition fillL=new FillTransition();
            fillL.setShape(label);
            fillL.setFromValue(Color.web("#008080"));fillL.setToValue(Color.web("#ffffff"));
            fillL.setDuration(Duration.millis(3000));
            
            fillT.play();
            fillL.play();
            }
        });
        st.getChildren().addAll(labelbg,label);
    return st;
    }
   public void addPreviewHandler(EventHandler<ActionEvent> ah){
       prev.setOnAction(ah);
    }
public void setCurrentNode(String name){
        label.setText(name);
    }
public void addTransitionHandler(EventHandler<ActionEvent> ah){
       transitions.setOnAction(ah);
    }
}
