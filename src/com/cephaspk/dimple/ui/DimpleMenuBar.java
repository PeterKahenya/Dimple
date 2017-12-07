package com.cephaspk.dimple.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public final class DimpleMenuBar extends MenuBar {

    private final Menu file, edit, screen, view, about;
    private MenuItem newProj, open, save, saveas, exit;
    private MenuItem undo, redo, cut, copy, paste, delete;
    private CheckMenuItem components, properties, transitions, sequence, video,showscreen;
    private MenuItem fill, size, bgImage,bgVideo;
    private MenuItem update, aboutUs, register, licence;
    
    public DimpleMenuBar() {
        file = setUpFileMenu();
        edit = setUpEditMenu();
        screen = setUpScreenMenu();
        view = setUpViewMenu();
        about = setUpAboutMenu();
        this.getMenus().addAll(file, edit, screen, view, about);
        
    }

    public Menu setUpFileMenu() {
        Menu menu = new Menu("File");
        newProj = new MenuItem("New Project");
       
        open = new MenuItem("Open Project");
        save = new MenuItem("Save");
        saveas = new MenuItem("Save As");
        exit = new MenuItem("Exit");
        menu.getItems().addAll(newProj, open, save, saveas, exit);
        return menu;
    }

    public Menu setUpEditMenu() {
        Menu menu = new Menu("Edit");
        undo = new MenuItem("Undo");
        redo = new MenuItem("Redo");
        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");
        delete = new MenuItem("Delete");
        menu.getItems().addAll(undo, redo, cut, copy, paste, delete);
        return menu;
    }

    public Menu setUpViewMenu() {
        Menu menu = new Menu("View");
        components = new CheckMenuItem("Components");
        components.setSelected(true);
        properties = new CheckMenuItem("Properties");
        properties.setSelected(true);
        transitions = new CheckMenuItem("Transitions");
        transitions.setSelected(true);
        sequence = new CheckMenuItem("Sequence");
        sequence.setSelected(true);
        video = new CheckMenuItem("Video");
        video.setSelected(true);
        showscreen = new CheckMenuItem("Screen");
        showscreen.setSelected(true);
        menu.getItems().addAll(components, properties, transitions, sequence, video, showscreen);
        return menu;
    }

    public Menu setUpScreenMenu() {
        Menu menu = new Menu("Screen");
        fill = new MenuItem("Screen Color");
        size = new MenuItem("Screen Size");
        bgImage = new MenuItem("Background Image");
        bgVideo=new MenuItem("Background Video");
        menu.getItems().addAll(fill, size, bgImage);
        return menu;
    }

    public Menu setUpAboutMenu() {
        Menu menu = new Menu("About");
        update = new MenuItem("Update");
        aboutUs = new MenuItem("About Us");
        register = new MenuItem("Register Dimple");
        licence = new MenuItem("Licence");
        menu.getItems().addAll(update, aboutUs, register, licence);
        return menu;
    }

    public void addNewProjHandler(EventHandler<ActionEvent> ah) {
        newProj.setOnAction(ah);
    }

    public void addOpenHandler(EventHandler<ActionEvent> ah) {
        open.setOnAction(ah);
    }

    public void addSaveHandler(EventHandler<ActionEvent> ah) {
        save.setOnAction(ah);
    }

    public void addSaveasHandler(EventHandler<ActionEvent> ah) {
        saveas.setOnAction(ah);
    }

    public void addExitHandler(EventHandler<ActionEvent> ah) {
        exit.setOnAction(ah);
    }

    public void addUndoHandler(EventHandler<ActionEvent> ah) {
        undo.setOnAction(ah);
    }

    public void addRedoHandler(EventHandler<ActionEvent> ah) {
        redo.setOnAction(ah);
    }

    public void addCutHandler(EventHandler<ActionEvent> ah) {
        cut.setOnAction(ah);
    }

    public void addCopyHandler(EventHandler<ActionEvent> ah) {
        copy.setOnAction(ah);
    }

    public void addPasteHandler(EventHandler<ActionEvent> ah) {
        paste.setOnAction(ah);
    }

    public void addDeleteHandler(EventHandler<ActionEvent> ah) {
        delete.setOnAction(ah);
    }

    public void addComponentsHandler(EventHandler<ActionEvent> ah) {
        components.setOnAction(ah);
    }

    public void addPropertiesHandler(EventHandler<ActionEvent> ah) {
        properties.setOnAction(ah);
    }

    public void addTransitionsHandler(EventHandler<ActionEvent> ah) {
        transitions.setOnAction(ah);
    }

    public void addSequenceHandler(EventHandler<ActionEvent> ah) {
        sequence.setOnAction(ah);
    }

    public void addVideoHandler(EventHandler<ActionEvent> ah) {
        video.setOnAction(ah);
    }

    public void addShowScreenHandler(EventHandler<ActionEvent> ah) {
        showscreen.setOnAction(ah);
    }

    public void addSizeHandler(EventHandler<ActionEvent> ah) {
        size.setOnAction(ah);
    }

    public void addFillHandler(EventHandler<ActionEvent> ah) {
        fill.setOnAction(ah);
    }

    public void addBgImageHandler(EventHandler<ActionEvent> ah) {
        bgImage.setOnAction(ah);
    }

    public void addUpdatesHandler(EventHandler<ActionEvent> ah) {
        update.setOnAction(ah);
    }

    public void addLicenceHandler(EventHandler<ActionEvent> ah) {
        licence.setOnAction(ah);
    }

    public void addAboutusHandler(EventHandler<ActionEvent> ah) {
        aboutUs.setOnAction(ah);
    }

    public void addRegisterHandler(EventHandler<ActionEvent> ah) {
        register.setOnAction(ah);
    }

}
