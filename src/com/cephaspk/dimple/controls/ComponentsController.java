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
import com.cephaspk.dimple.ui.DimpleComponents;
import com.cephaspk.dimple.ui.DimpleScreen;
import com.cephaspk.dimple.ui.DimpleStage;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;


public class ComponentsController {

    private DimpleScreen mscreen;
    private DimpleComponents mcomps;
    private DimpleProject mproject;
    private PropertiesController mpropsController;
    private double initX=0;
    private double initY=0;
    private Shape shape;
    private DimpleStage mstage;
    private TransitionController mtrans;
    public ComponentsController(TransitionController trans,DimpleStage stage,DimpleProject project,DimpleScreen screen, DimpleComponents comps, PropertiesController propsController) {
        this.mscreen = screen;
        this.mtrans=trans;
        this.mstage=stage;
        this.mcomps = comps;
        this.mproject=project;
        this.mpropsController = propsController;
        mcomps.addOn2DContentMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
               shape = (Shape) t.getSource();
                  mproject.addShape(shape);
                if (shape instanceof DimpleCircle) {
                    DimpleCircle c=new DimpleCircle();
                    setHandlers(c);
                    mscreen.addComponent(c);
                } else if (shape instanceof DimpleTriangle) {
                    DimpleTriangle triangle=new DimpleTriangle();
                    setHandlers(triangle);
                    mscreen.addComponent(triangle);
                } else if (shape instanceof DimpleArc) {
                    DimpleArc arc=new DimpleArc();
                    arc.setCenterX(300);
                    arc.setCenterY(300);
                    setHandlers(arc);
                    mscreen.addComponent(arc);
                } else if (shape instanceof DimpleEllipse) {
                    DimpleEllipse ellipse=new DimpleEllipse();
                    setHandlers(ellipse);
                    mscreen.addComponent(ellipse);
                } else if (shape instanceof DimpleLine) {
                    DimpleLine line=new DimpleLine();
                    setHandlers(line);
                    mscreen.addComponent(line);
                } else if (shape instanceof DimpleText) {
                    DimpleText text=new DimpleText();
                    setHandlers(text);
                    mscreen.addComponent(text);
                } else if (shape instanceof DimplePolygon) {
                    DimplePolygon polygon=new DimplePolygon();
                    setHandlers(polygon);
                    mscreen.addComponent(polygon);
                } else if (shape instanceof DimpleRectangle) {
                    DimpleRectangle rectangle=new DimpleRectangle();
                    setHandlers(rectangle);
                    mscreen.addComponent(rectangle);
                }
            }
            public void setHandlers(final Shape shape){
                
                shape.setOnMousePressed(new EventHandler<MouseEvent>(){
               
                     @Override
                     public void handle(MouseEvent t) {
                        mpropsController.setShape(shape);
                        mtrans.setShape(shape);
                        shape.requestFocus();
                         if(shape instanceof DimplePolygon || shape instanceof DimpleTriangle ){
                         initX = t.getScreenX() - mstage.getX();
                        initY = t.getScreenY() - mstage.getY();
                    }
                     }
                 });
                 shape.setOnMouseDragged(new EventHandler<MouseEvent>(){

                     @Override
                     public void handle(MouseEvent t) {
                    if(shape instanceof DimpleText){
                        DimpleText text=(DimpleText)shape;
                        text.setX(t.getX());
                        text.setY(t.getY());
                    }else if(shape instanceof DimpleCircle){
                        DimpleCircle text=(DimpleCircle)shape;
                        text.setCenterX(t.getX());
                        text.setCenterY(t.getY());
                    }else if(shape instanceof DimpleArc){
                        DimpleArc text=(DimpleArc)shape;
                        text.setCenterX(t.getX());
                        text.setCenterY(t.getY());
                    }else if(shape instanceof DimpleEllipse){
                        DimpleEllipse text=(DimpleEllipse)shape;
                        text.setCenterX(t.getX());
                        text.setCenterY(t.getY());
                    }else if(shape instanceof DimpleRectangle){
                        DimpleRectangle text=(DimpleRectangle)shape;
                        text.setX(t.getX());
                        text.setY(t.getY());
                    }else if(shape instanceof DimpleLine){
                        DimpleLine text=(DimpleLine)shape;
                        text.setStartX(t.getX());
                        text.setStartY(t.getY());
                    }else if(shape instanceof DimplePolygon){
                        DimplePolygon text=(DimplePolygon)shape;
                        text.setTranslateX(t.getScreenX() - initX);
                        text.setTranslateY(t.getScreenY() - initY);
                    }else if(shape instanceof DimpleTriangle){
                        DimpleTriangle text=(DimpleTriangle)shape;
                        text.setTranslateX(t.getScreenX() - initX);
                        text.setTranslateY(t.getScreenY() - initY);
                    }
                    }
                 });
                 shape.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent t) {
                        Shape shape=((Shape)t.getSource());
                       switch(t.getCode()){
                           case DOWN:
                               shape.setLayoutY(shape.getLayoutY()+10);
                               break;
                           case UP:
                               shape.setLayoutY(shape.getLayoutY()-10);
                               break;
                           case LEFT:
                               shape.setLayoutX(shape.getLayoutX()-10);
                               break;
                           case RIGHT:
                               shape.setLayoutX(shape.getLayoutX()+10);
                               break;
                           case BACK_SPACE:
                               mscreen.getContainer().getChildren().remove(shape);
                               mproject.getShapes().remove(shape);
                               break;
                           default:
                               break;
                       }
                    }
                });
                 shape.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>(){

                    @Override
                    public void handle(ContextMenuEvent t) {
                    ContextMenu ctx=new ContextMenu();
                    ctx.getItems().addAll(new MenuItem("Format"));
                    ctx.show(shape,500,500);
                   }
                });
             }
        });
    }
    
}
