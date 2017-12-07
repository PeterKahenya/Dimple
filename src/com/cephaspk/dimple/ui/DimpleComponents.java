package com.cephaspk.dimple.ui;

import com.cephaspk.dimple.shapes2D.DimpleArc;
import com.cephaspk.dimple.shapes2D.DimpleCircle;
import com.cephaspk.dimple.shapes2D.DimpleEllipse;
import com.cephaspk.dimple.shapes2D.DimpleLine;
import com.cephaspk.dimple.shapes2D.DimplePolygon;
import com.cephaspk.dimple.shapes2D.DimpleRectangle;
import com.cephaspk.dimple.shapes2D.DimpleText;
import com.cephaspk.dimple.shapes2D.DimpleTriangle;
import javafx.animation.FillTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DimpleComponents extends VBox {
    private double Size=350;
    private Pane twoD,threeD,media,canvas;
    private StackPane twoDID,threeDID,mediaID,canvasID;
    private GridPane twoDContent,threeDContent,mediaContent,canvasContent;
    private DimpleCircle circle;
    private DimpleArc arc;
    private DimpleEllipse ellipse;
    private DimpleLine line;
    private DimplePolygon polygon;
    private DimpleRectangle rectangle;
    private DimpleText text;
    private DimpleTriangle triangle;
    
    
    
    
    public DimpleComponents(){
    twoD=setUP2DPane();  
    threeD=setUP3DPane();
    canvas=setUPCanvasPane();
    media=setUPMediaPane();
    
    
    this.getChildren().addAll(twoD,threeD,media,canvas);
    }
    public Pane setUP2DPane(){
        Pane pane=new Pane();
        VBox mainH=new VBox();
        
        twoDID=new StackPane();
        twoDContent=new GridPane();
        twoDContent.setAlignment(Pos.CENTER);
        twoDContent.setPadding(new Insets(2,2,2,2));
        twoDContent.setHgap(2);
        twoDContent.setVgap(2);
        twoDContent.setGridLinesVisible(true);
        
        //setUp2DID
        final Rectangle labelbg=new Rectangle();
        labelbg.setHeight(40);labelbg.setWidth(Size);
        labelbg.setArcHeight(15);labelbg.setArcWidth(15);
        labelbg.setStroke(Color.web("#008080"));labelbg.setFill(Color.TRANSPARENT);labelbg.setStrokeWidth(2);
        final Text label=new Text("Dimple 2D");label.setFill(Color.web("#008080"));
        label.setFont(Font.font("Courier", FontWeight.NORMAL,FontPosture.ITALIC,18));
        labelbg.setOnMouseEntered(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
            FillTransition fillT=new FillTransition();
            fillT.setShape(labelbg);
            fillT.setFromValue(Color.TRANSPARENT);fillT.setToValue(Color.web("#008080"));
            fillT.setDuration(Duration.millis(1000));
            FillTransition fillL=new FillTransition();
            fillL.setShape(label);
            fillL.setFromValue(Color.web("#008080"));fillL.setToValue(Color.web("#ffffff"));
            fillL.setDuration(Duration.millis(1000));
            
            fillT.play();
            fillL.play();
            }
        });
        twoDID.getChildren().addAll(labelbg,label);
        
        //setUP twoDContent
        circle=new DimpleCircle();
        arc=new DimpleArc();
        ellipse=new DimpleEllipse();
        line=new DimpleLine();
        polygon=new DimplePolygon();
        rectangle=new DimpleRectangle();
        text=new DimpleText();
        triangle=new DimpleTriangle();
        twoDContent.add(circle,0,0);
        twoDContent.add(triangle,1,0);
        twoDContent.add(rectangle,2,0);
        twoDContent.add(polygon,0,1);
        twoDContent.add(line,1,1);
        twoDContent.add(ellipse,2,1);
        twoDContent.add(text,0,2);
        twoDContent.add(arc,1,2);
        twoDContent.setStyle("-fx-background-color:#262626;");
        
        
        mainH.getChildren().addAll(twoDID,twoDContent);
        pane.getChildren().add(mainH);
        return pane;
    }
     public Pane setUP3DPane(){
        Pane pane=new Pane();
        HBox mainH=new HBox();
        
        threeDID=new StackPane();
        threeDContent=new GridPane();
        threeDContent.setAlignment(Pos.CENTER);
        threeDContent.setPadding(new Insets(5,5,5,5));
        threeDContent.setHgap(5.5);
        threeDContent.setVgap(5.5);
        
        //setUp3DID
        final Rectangle labelbg=new Rectangle();
        labelbg.setHeight(40);labelbg.setWidth(Size);
        labelbg.setArcHeight(15);labelbg.setArcWidth(15);
        labelbg.setStroke(Color.web("#008080"));labelbg.setFill(Color.TRANSPARENT);labelbg.setStrokeWidth(2);
        final Text label=new Text("Dimple 3D");label.setFill(Color.web("#008080"));
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
        threeDID.getChildren().addAll(labelbg,label);
        
//        //setUP threeDContent
//        twoDContent.add(new DimpleCircle(),0,0);
//        twoDContent.add(new DimpleTriangle(),1,0);
//        twoDContent.add(new DimpleRectangle(),2,0);
//        twoDContent.add(new DimplePolygon(),0,1);
//        twoDContent.add(new DimpleLine(),1,1);
//        twoDContent.add(new DimpleEllipse(),2,1);
//        twoDContent.add(new DimpleText(),0,2);
//        twoDContent.add(new DimpleArc(),1,2);
//        twoDContent.setStyle("-fx-background-color:#262626;");
        
        
        mainH.getChildren().addAll(threeDID);
        pane.getChildren().add(mainH);
        return pane;
    }
     
      public Pane setUPMediaPane(){
        Pane pane=new Pane();
        HBox mainH=new HBox();
        
        mediaID=new StackPane();
        mediaContent=new GridPane();
        mediaContent.setAlignment(Pos.CENTER);
        mediaContent.setPadding(new Insets(5,5,5,5));
        mediaContent.setHgap(5.5);
        mediaContent.setVgap(5.5);
        
        //setUpMediaID
        final Rectangle labelbg=new Rectangle();
        labelbg.setHeight(40);labelbg.setWidth(Size);
        labelbg.setArcHeight(15);labelbg.setArcWidth(15);
        labelbg.setStroke(Color.web("#008080"));labelbg.setFill(Color.TRANSPARENT);labelbg.setStrokeWidth(2);
        final Text label=new Text("Dimple Media");label.setFill(Color.web("#008080"));
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
        mediaID.getChildren().addAll(labelbg,label);
        
//        //setUP threeDContent
//        twoDContent.add(new DimpleCircle(),0,0);
//        twoDContent.add(new DimpleTriangle(),1,0);
//        twoDContent.add(new DimpleRectangle(),2,0);
//        twoDContent.add(new DimplePolygon(),0,1);
//        twoDContent.add(new DimpleLine(),1,1);
//        twoDContent.add(new DimpleEllipse(),2,1);
//        twoDContent.add(new DimpleText(),0,2);
//        twoDContent.add(new DimpleArc(),1,2);
//        twoDContent.setStyle("-fx-background-color:#262626;");
        
        
        mainH.getChildren().addAll(mediaID);
        pane.getChildren().add(mainH);
        return pane;
    }
       public Pane setUPCanvasPane(){
        Pane pane=new Pane();
        HBox mainH=new HBox();
        
        canvasID=new StackPane();
        canvasContent=new GridPane();
        canvasContent.setAlignment(Pos.CENTER);
        canvasContent.setPadding(new Insets(5,5,5,5));
        canvasContent.setHgap(5.5);
        canvasContent.setVgap(5.5);
        
        //setUpCanvasID
        final Rectangle labelbg=new Rectangle();
        labelbg.setHeight(40);labelbg.setWidth(Size);
        labelbg.setArcHeight(15);labelbg.setArcWidth(15);
        labelbg.setStroke(Color.web("#008080"));labelbg.setFill(Color.TRANSPARENT);labelbg.setStrokeWidth(2);
        final Text label=new Text("Dimple Canvas");label.setFill(Color.web("#008080"));
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
        canvasID.getChildren().addAll(labelbg,label);
        
//        //setUP threeDContent
//        twoDContent.add(new DimpleCircle(),0,0);
//        twoDContent.add(new DimpleTriangle(),1,0);
//        twoDContent.add(new DimpleRectangle(),2,0);
//        twoDContent.add(new DimplePolygon(),0,1);
//        twoDContent.add(new DimpleLine(),1,1);
//        twoDContent.add(new DimpleEllipse(),2,1);
//        twoDContent.add(new DimpleText(),0,2);
//        twoDContent.add(new DimpleArc(),1,2);
//        twoDContent.setStyle("-fx-background-color:#262626;");
        
        
        mainH.getChildren().addAll(canvasID);
        pane.getChildren().add(mainH);
        return pane;
    }
    public void addOn2DMousePressed(EventHandler<MouseEvent> eh){
        twoDID.setOnMousePressed(eh);
    }
    public void addOn3DMousePressed(EventHandler<MouseEvent> eh){
        threeDID.setOnMousePressed(eh);
    }
    public void addOnMediaMousePressed(EventHandler<MouseEvent> eh){
        mediaID.setOnMousePressed(eh);
    }
    public void addOnCanvasMousePressed(EventHandler<MouseEvent> eh){
        canvasID.setOnMousePressed(eh);
    }
    public void addOn2DContentMousePressed(EventHandler<MouseEvent> eh){
        arc.setOnMousePressed(eh);
        circle.setOnMousePressed(eh);
        ellipse.setOnMousePressed(eh);
        line.setOnMousePressed(eh);
        polygon.setOnMousePressed(eh);
        rectangle.setOnMousePressed(eh);
        text.setOnMousePressed(eh);
        triangle.setOnMousePressed(eh);
        
    }
}

