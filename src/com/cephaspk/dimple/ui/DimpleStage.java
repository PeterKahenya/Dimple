
package com.cephaspk.dimple.ui;

import java.awt.Toolkit;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


public class DimpleStage extends Stage{
   private Scene scene;
   private Pane mainPane;
   private DimpleMenuBar menuBar;
   private DimpleComponents mcmps;
   private DimpleProperties mprops;
   private DimpleTransition mtrans;
   private DimpleScreen dscreen;
   private DimpleSequence mseq;
   private DimpleVideo mvideo;
    public DimpleStage(DimpleMenuBar mb,DimpleComponents dc,DimpleScreen dscr,DimpleProperties props,
            DimpleTransition trans,DimpleSequence seq,DimpleVideo video){
       this.initStyle(StageStyle.UNDECORATED);
       this.setWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
       this.centerOnScreen();
       this.setHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
       this.initStyle(StageStyle.UNDECORATED);
        
        //set Location of MenuBar
        menuBar=mb;
        menuBar.setLayoutX(0);
        menuBar.setLayoutY(0);

        
        //set Location of Components
        mcmps=dc;
        mcmps.setLayoutX(20);
        mcmps.setLayoutY(30);
        
        //set Location of Screen
        dscreen=dscr;
        dscreen.setLayoutX(450);
        dscreen.setLayoutY(30);
        
        //set Location of Properties
        this.mprops=props;
        this.mprops.setLayoutX(60);
        this.mprops.setLayoutY(500);
        
        //set Location of Transitions
        this.mtrans=trans;
        this.mtrans.setLayoutX(390);
        this.mtrans.setLayoutY(500);
        
        //set Location of Sequence
        this.mseq=seq;
        this.mseq.setLayoutX(720);
        this.mseq.setLayoutY(500);
        
        //set Location of Video
        this.mvideo=video;
        this.mvideo.setLayoutX(1050);
        this.mvideo.setLayoutY(500);
        
        //add them to layout
        mainPane=new Pane();
        mainPane.getChildren().addAll(menuBar,mcmps,dscreen,mseq,mtrans,mvideo,mprops);
        
      
        //Add layout to Scene
        scene=new Scene(mainPane);
        scene.setFill(Color.web("#333333"));
        
         //add Scene to Stage
        this.setScene(scene);

    }

    public Pane getMainPane() {
        return mainPane;
    }

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

    public DimpleComponents getCmps() {
        return mcmps;
    }

    public void setCmps(DimpleComponents cmps) {
        this.mcmps = cmps;
    }

    public DimpleProperties getProps() {
        return mprops;
    }

    public void setProps(DimpleProperties props) {
        this.mprops = props;
    }

    public DimpleTransition getTrans() {
        return mtrans;
    }

    public void setTrans(DimpleTransition trans) {
        this.mtrans = trans;
    }

    public DimpleScreen getDscreen() {
        return dscreen;
    }

    public void setDscreen(DimpleScreen dscreen) {
        this.dscreen = dscreen;
    }

    public DimpleSequence getSeq() {
        return mseq;
    }

    public void setSeq(DimpleSequence seq) {
        this.mseq = seq;
    }

    public DimpleVideo getVideo() {
        return mvideo;
    }

    public void setVideo(DimpleVideo video) {
        this.mvideo = video;
    }
    public void setOnClose(EventHandler<WindowEvent> weh){
        this.setOnCloseRequest(weh);
    }
    
}
