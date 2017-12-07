package com.cephaspk.dimple.controls;

import com.cephaspk.dimple.models.DimpleProject;
import com.cephaspk.dimple.ui.DimpleScreen;
import com.cephaspk.dimple.ui.DimpleStage;
import com.cephaspk.dimple.ui.DimpleVideo;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.SequentialTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

public class VideoController{
    private DimpleProject mproject;
    private DimpleScreen mscreen;
    private DimpleVideo mvideo; 
    
    public VideoController(DimpleStage stage,DimpleVideo video,DimpleProject project, DimpleScreen screen) {
        this.mproject = project;
        this.mscreen = screen;
        this.mvideo=video;
        
        mvideo.addPlayHandler(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
             System.out.println("Video Preparing....");
             SequentialTransition animation=new SequentialTransition();
             animation.getChildren().addAll(mproject.getTransitions());
             double totalD=animation.getTotalDuration().toSeconds();
             int total_no_of_frames=(int) (totalD*30);
                 try {
                     for(int x=1;x<total_no_of_frames;x++){
                     animation.playFrom(Duration.millis(totalD*1000*x/total_no_of_frames));
                     File file=new File("./tmp/"+"frame"+x+".png");
                     System.out.println(file.getPath());
                     WritableImage img=mscreen.snapshot(new SnapshotParameters(),null);
                     ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", file);
                     }
                     Runtime.getRuntime().exec("E:\\Cephaspk Inc\\Dimple\\src\\com\\cephaspk\\dimple\\controls\\ffmpeg.exe -r 30 -i ./tmp/frame%d.png -s 1920x1080 -aspect 1:1 ./tmp/out.mp4");
            } catch (IOException ex) {
                     Logger.getLogger(VideoController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
             }
             
        });
    }
}