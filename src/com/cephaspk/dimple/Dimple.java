package com.cephaspk.dimple;

import com.cephaspk.dimple.controls.ComponentsController;
import com.cephaspk.dimple.controls.DimpleController;
import com.cephaspk.dimple.controls.MenuController;
import com.cephaspk.dimple.controls.PropertiesController;
import com.cephaspk.dimple.controls.SequenceController;
import com.cephaspk.dimple.controls.TransitionController;
import com.cephaspk.dimple.controls.VideoController;
import com.cephaspk.dimple.models.DimpleProject;
import com.cephaspk.dimple.ui.DimpleComponents;
import com.cephaspk.dimple.ui.DimpleMenuBar;
import com.cephaspk.dimple.ui.DimpleProperties;
import com.cephaspk.dimple.ui.DimpleScreen;
import com.cephaspk.dimple.ui.DimpleSequence;
import com.cephaspk.dimple.ui.DimpleStage;
import com.cephaspk.dimple.ui.DimpleTransition;
import com.cephaspk.dimple.ui.DimpleVideo;
import javafx.application.Application;
import javafx.stage.Stage;

public class Dimple  extends Application{
    //Models
    private DimpleProject project;
    
    //views
    private DimpleStage mainStage;
    private DimpleMenuBar mb;
    private DimpleComponents comps;
    private DimpleScreen dscreen;
    private DimpleProperties dmP;
    private DimpleTransition trans;
    private DimpleSequence seq;
    private DimpleVideo video;
    
    //controls
    private MenuController menuController;
    private PropertiesController propertiesController;
    private ComponentsController componentsController;
    private SequenceController sequenceController;
    private TransitionController transitionController;
    private VideoController videoController;
    private DimpleController dimpleController;
    
    @Override
    public void start(Stage stage) throws Exception {
        //models 
        project=new DimpleProject();
         
         //views
         mb=new DimpleMenuBar();
         comps=new DimpleComponents();
         dscreen=new DimpleScreen();
         dmP=new DimpleProperties();
         trans=new DimpleTransition();
         seq=new DimpleSequence();
         video=new DimpleVideo();
         mainStage=new DimpleStage(mb,comps,dscreen,dmP,trans,seq,video);
         
         
         //controls
         menuController=new MenuController(project,dscreen,mb,mainStage);
         propertiesController=new PropertiesController(dmP);
         sequenceController=new SequenceController(project,seq);
         transitionController=new TransitionController(sequenceController,project,trans);
         componentsController=new ComponentsController(transitionController,mainStage,project,dscreen,comps,propertiesController);
         videoController=new VideoController(mainStage,video,project,dscreen);
         dimpleController=new DimpleController(mainStage);
         
         //show main window UI
         mainStage.show();         
    }
    public static void main(String[]args){
        Application.launch(args);
    }
}