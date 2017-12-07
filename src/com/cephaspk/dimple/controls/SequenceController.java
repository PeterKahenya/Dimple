
package com.cephaspk.dimple.controls;

import com.cephaspk.dimple.models.DimpleProject;
import com.cephaspk.dimple.ui.DimpleSequence;
import javafx.scene.shape.Shape;

public class SequenceController {
    private DimpleProject mproject;
    private DimpleSequence mseq;
    private Shape shape;
    
    
    public SequenceController(DimpleProject project,DimpleSequence seq){
      this.mseq=seq;
      this.mproject=project;
    }
    public void addSeq(String s){
        mseq.addSequence(s);
    }
    
}
