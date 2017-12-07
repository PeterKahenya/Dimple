
package com.cephaspk.dimple.controls;

import com.cephaspk.dimple.ui.DimpleStage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.WindowEvent;

public class DimpleController {
    private DimpleStage mstage;
 public DimpleController(DimpleStage stage){
     this.mstage=stage;
     mstage.setOnClose(new EventHandler<WindowEvent>(){

         @Override
         public void handle(WindowEvent t) {
             t.consume();
        Popup p=new Popup();
        StackPane pane=new StackPane();
        pane.setStyle("-fx-background-color:#008080");
        Rectangle r=new Rectangle();
        r.setWidth(350);
        r.setHeight(200);
        r.setFill(Color.web("#008080"));
        pane.getChildren().addAll(r,new Button("You sure?..."));
        p.getContent().add(pane);
        p.setWidth(350);
        p.setHeight(200);
        
        p.setOpacity(0.6f);
        p.centerOnScreen();
        p.show(mstage);
         }
     });
 }   
}
