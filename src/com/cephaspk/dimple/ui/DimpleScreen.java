package com.cephaspk.dimple.ui;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
public class DimpleScreen extends StackPane{
    
    private ImageView bgproper;
    private Pane container;
    private Rectangle whitebg;
    public DimpleScreen(){
    whitebg=new Rectangle();
    whitebg.setFill(Color.web("#FFFFFF"));
    whitebg.setStrokeWidth(0);
    whitebg.setWidth(850);whitebg.setHeight(450);
    bgproper=new ImageView();
     container=new Pane();
    // container.setPrefSize(850, 450);
     this.getChildren().add(0,whitebg);
     this.getChildren().add(1, bgproper);
     this.getChildren().add(2, container);
    }
    
    //THE NODE ARRIVES WITH ITS EVENT HANDLERS
    public void addComponent(Node node){
    this.container.getChildren().add(node);
    }

    public Node getBgproper() {
        return bgproper;
    }

    public void setBgproper(ImageView bgproper) {
        
        this.bgproper = bgproper;
    }

    public Pane getContainer() {
        return container;
    }

    public void setContainer(Pane container) {
        this.container = container;
    }
    
    public void addOnContextRequest(EventHandler<ContextMenuEvent> eh){
       this.setOnContextMenuRequested(eh);
    }
    public void setScreenFill(Color c){
        this.whitebg.setFill(c);
    }
           
}
