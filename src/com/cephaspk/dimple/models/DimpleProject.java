package com.cephaspk.dimple.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;

public class DimpleProject implements Serializable {

    private ArrayList<Node> shapes;
    private ArrayList<Transition> transitions;
    private File storageDirectory;
    
    public DimpleProject() {
        shapes = new ArrayList<>();
        transitions = new ArrayList<>();
       
    }

    public ArrayList<Node> getShapes() {
        return shapes;
    }

    public Node getShape(int index) {
        return shapes.get(index);
    }

    public void setShapes(ArrayList<Node> shapes) {
        this.shapes = shapes;
    }

    public void addShape(Node n) {
        shapes.add(n);
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public Transition getTrasition(int index) {
        return (Transition) transitions.get(index);
    }

    public void setTransitions(ArrayList<Transition> transitions) {
        this.transitions = transitions;
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public void save() {
       ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(this.getStorageDirectory(),true)); 
            out.writeObject(this);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(DimpleProject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(DimpleProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public File getStorageDirectory() {
        return storageDirectory;
    }

    public void setStorageDirectory(File storageDirectory) {
        this.storageDirectory = storageDirectory;
    }

}
