package com.cephaspk.dimple.controls;

import com.cephaspk.dimple.models.DimpleProject;
import com.cephaspk.dimple.ui.DimpleMenuBar;
import com.cephaspk.dimple.ui.DimpleScreen;
import com.cephaspk.dimple.ui.DimpleStage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ColorPicker;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MenuController {

    private DimpleProject mproject;
    private DimpleScreen mscreen;
    private DimpleMenuBar mmenuBar;
    private DimpleStage mstage;

    public MenuController(DimpleProject project, DimpleScreen screen, DimpleMenuBar menuBar, final DimpleStage stage) {
        this.mproject = project;
        this.mscreen = screen;
        this.mmenuBar = menuBar;
        this.mstage = stage;
        final ColorPicker c=new ColorPicker();
        c.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
             mscreen.setScreenFill(c.getValue());
            }
        });
        mmenuBar.addNewProjHandler(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                DimpleProject dp = new DimpleProject();
                dp.setStorageDirectory(new FileChooser().showSaveDialog(stage));
                mproject = dp;
                dp.save();
            }
        });
        
        mmenuBar.addBgImageHandler(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               
                   List<String> exts=new ArrayList<>();
                   exts.add(".mp4");
                    FileChooser chooseBG=new FileChooser();
                    chooseBG.getExtensionFilters().add(new ExtensionFilter("Images",exts));
                    File file=chooseBG.showOpenDialog(stage);
                    Media img=new Media("file:///"+file.getPath().replace("\\", "/").replace(" ", "%20"));
                    MediaPlayer bg=new MediaPlayer(img);
                    MediaView mv=new MediaView(bg);
                    bg.play();
                    mv.setFitHeight(450);
                    mv.setFitWidth(850);
                    mscreen.getChildren().set(1, mv);
                
            }
        } );
        mmenuBar.addFillHandler(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent t) {
        final ColorPicker c=new ColorPicker();
        mscreen.addComponent(c);
        c.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
             mscreen.setScreenFill(c.getValue());
             mscreen.getContainer().getChildren().remove(c);
            }
        });
        
            }
        });
        mmenuBar.addComponentsHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
            if(((CheckMenuItem)t.getSource()).isSelected()){
                mstage.getMainPane().getChildren().add(mstage.getCmps());
            }
            else{
                mstage.getMainPane().getChildren().remove(mstage.getCmps());
            }
            }
        });
        mmenuBar.addShowScreenHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
            if(((CheckMenuItem)t.getSource()).isSelected()){
                mstage.getMainPane().getChildren().add(mstage.getDscreen());
            }
            else{
                mstage.getMainPane().getChildren().remove(mstage.getDscreen());
            }
            }
        });
        menuBar.addPropertiesHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
             if(((CheckMenuItem)t.getSource()).isSelected()){
                mstage.getMainPane().getChildren().add(mstage.getProps());
            }
            else{
                mstage.getMainPane().getChildren().remove(mstage.getProps());
            }
            }
        });
        mmenuBar.addTransitionsHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
            if(((CheckMenuItem)t.getSource()).isSelected()){
                mstage.getMainPane().getChildren().add(mstage.getTrans());
            }
            else{
                mstage.getMainPane().getChildren().remove(mstage.getTrans());
            }
            }
        });
        mmenuBar.addSequenceHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
            if(((CheckMenuItem)t.getSource()).isSelected()){
                mstage.getMainPane().getChildren().add(mstage.getSeq());
            }
            else{
                mstage.getMainPane().getChildren().remove(mstage.getSeq());
            }
            }
        });
        mmenuBar.addVideoHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
            if(((CheckMenuItem)t.getSource()).isSelected()){
                mstage.getMainPane().getChildren().add(mstage.getVideo());
            }
            else{
                mstage.getMainPane().getChildren().remove(mstage.getVideo());
            }
            }
        });
    }
}
