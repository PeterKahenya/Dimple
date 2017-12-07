package com.cephaspk.dimple.ui;

import java.util.ArrayList;
import javafx.animation.FillTransition;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
public class DimpleSequence extends VBox {
    private TextField locationX=new TextField(),locationY=new TextField();
    private TextField fill=new TextField(),stroke=new TextField();
    private TextField width=new TextField(),height=new TextField();   
 
    private StackPane propsID;
    private ListView<String> props;
    private ArrayList<String> properties;
    private static int i=1;
   
    public DimpleSequence(){
        propsID=setUPPropsID();
        properties=new ArrayList<>();
        props=new ListView<>();
        props.setPrefSize(270,180);
       // props.setStyle("-fx-background-color:#262626;");
        this.getChildren().addAll(propsID,props);
    }
    public void addSequence(String label){
        props.getItems().add(label+i);
        i++;
    }

    private StackPane setUPPropsID() {
        StackPane st=new StackPane();
      //setUp2DID
        final Rectangle labelbg=new Rectangle();
        labelbg.setHeight(30);labelbg.setWidth(270);
        labelbg.setArcHeight(15);labelbg.setArcWidth(15);
        labelbg.setStroke(Color.web("#008080"));labelbg.setFill(Color.TRANSPARENT);labelbg.setStrokeWidth(2);
        final Text label=new Text("Sequence");label.setFill(Color.web("#008080"));
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
}
