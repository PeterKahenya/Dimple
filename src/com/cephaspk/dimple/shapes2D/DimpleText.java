package com.cephaspk.dimple.shapes2D;

import com.cephaspk.dimple.ui.Property;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DimpleText extends Text{
        private ListView<Property> props;
    public DimpleText(){
                prepareProps(this);
        this.setFill(Color.web("#008080"));
        this.setStroke(Color.web("#008080"));
        this.setText("Tx...");
        this.setFont(Font.font("Courier", FontWeight.EXTRA_BOLD,FontPosture.REGULAR,50));
    }
  private void prepareProps(final Text shape) {
        props = new ListView<>();
        TextField text = new TextField();
        final CheckBox underline=new CheckBox(),strike=new CheckBox(),fontP=new CheckBox() ;
        TextField locationX = new TextField(), locationY = new TextField();
        ColorPicker fill = new ColorPicker(), stroke = new ColorPicker();
        TextField Wrapwidth = new TextField(), strokeW = new TextField();
        final TextField scaleX = new TextField(), scaleY = new TextField(),size=new TextField("50");
        final ComboBox<String> fontF=new ComboBox<>(FXCollections.observableArrayList(Font.getFontNames())),
                fontW=new ComboBox(FXCollections.observableArrayList("BOLD","LIGHT","BLACK","THIN","MEDIUM","NORMAL","EXTRA BOLD","EXTRA THIN","SEMI BOLD"));
        
        fontW.setValue("EXTRA BOLD");       
        fontF.setValue("Courier");
        text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setText(((TextField) t.getSource()).getText());
            }
        });
        underline.setSelected(false);
         underline.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
           if(((CheckBox)t.getSource()).isSelected()){
               shape.setUnderline(true);
            }
            else{
            shape.setUnderline(false);
           }
            }
        }); 
         strike.setSelected(false);
         strike.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
           if(((CheckBox)t.getSource()).isSelected()){
               shape.setStrikethrough(true);
            }
            else{
            shape.setStrikethrough(false);
           }
            }
        });
        fill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setFill(((ColorPicker) t.getSource()).getValue());
            }
        });
        stroke.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setStroke(((ColorPicker) t.getSource()).getValue());
            }
        });
        locationX.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setX(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        locationY.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setY(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
        Wrapwidth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setWrappingWidth(Double.parseDouble(((TextField) t.getSource()).getText()));
            }
        });
          strokeW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setStrokeWidth(Double.parseDouble(((TextField) t.getSource()).getText()));

            }
        });
          size.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                shape.setFont(new Font(Double.parseDouble(((TextField) t.getSource()).getText())));

            }
        });
          scaleX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setScaleX(Double.parseDouble(scaleX.getText()));
            }
        });
        scaleY.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                shape.setScaleY(Double.parseDouble(scaleY.getText()));
            }
        });
        fontF.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
             String family=fontF.getValue();
             shape.setFont(Font.font(family,Double.parseDouble(size.getText())));
            }
        });
         fontW.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
             String weight=fontW.getValue();
             switch(weight){
                case "BLACK":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.BLACK,Double.parseDouble(size.getText())));
                     break;
                case "BOLD":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.BOLD,Double.parseDouble(size.getText())));
                     break;
                case "EXTRA_BOLD":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.EXTRA_BOLD,Double.parseDouble(size.getText())));
                     break;
                case "EXTRA_LIGHT":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.EXTRA_LIGHT,Double.parseDouble(size.getText())));
                     break;
                case "LIGHT":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.LIGHT,Double.parseDouble(size.getText())));
                     break;
                case "MEDIUM":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.MEDIUM,Double.parseDouble(size.getText())));
                     break;
                case "NORMAL":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.NORMAL,Double.parseDouble(size.getText())));
                     break;
                case "SEMI_BOLD":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.SEMI_BOLD,Double.parseDouble(size.getText())));
                     break;
                case "THIN":
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.THIN,Double.parseDouble(size.getText())));
                     break;
                default:
                     shape.setFont(Font.font(fontF.getValue(),FontWeight.NORMAL,Double.parseDouble(size.getText())));
                     break;
             }
            }
        });
         fontP.setSelected(false);
         fontP.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
             if(fontP.isSelected()){
                 shape.setFont(Font.font(fontF.getValue(),FontWeight.findByName(fontW.getValue()),FontPosture.ITALIC,Double.parseDouble(size.getText())));
             }
             else{
                 shape.setFont(Font.font(fontF.getValue(),FontWeight.findByName(fontW.getValue()),FontPosture.REGULAR,Double.parseDouble(size.getText())));
             }
           
            }
        });
         
     props.getItems().addAll(
                new Property(new Label("Text"), text),
                new Property(new Label("Font Family"), fontF),
                new Property(new Label("Font Weight"), fontW),
                new Property(new Label("Font Size"), size),
                new Property(new Label("Italicize"), fontP),
                new Property(new Label("Underline"), underline),
                new Property(new Label("StrikeThrough"), strike),
                new Property(new Label("X          "), locationX),
                new Property(new Label("Y          "), locationY),
                new Property(new Label("Fill       "), fill),
                new Property(new Label("Stroke "), stroke),
                new Property(new Label("Stroke Width"), strokeW),
                new Property(new Label("WrappingWidth"), Wrapwidth),
                new Property(new Label("Scale X  "), scaleX),
                new Property(new Label("Scale Y "), scaleY));
    }
    public ListView<Property> getProps() {
        return props;
    }
}
