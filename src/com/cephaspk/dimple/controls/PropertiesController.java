package com.cephaspk.dimple.controls;

import com.cephaspk.dimple.shapes2D.DimpleArc;
import com.cephaspk.dimple.shapes2D.DimpleCircle;
import com.cephaspk.dimple.shapes2D.DimpleEllipse;
import com.cephaspk.dimple.shapes2D.DimpleLine;
import com.cephaspk.dimple.shapes2D.DimplePolygon;
import com.cephaspk.dimple.shapes2D.DimpleRectangle;
import com.cephaspk.dimple.shapes2D.DimpleText;
import com.cephaspk.dimple.shapes2D.DimpleTriangle;
import com.cephaspk.dimple.ui.DimpleProperties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.shape.Shape;

public class PropertiesController {

    private Shape shape;
    private DimpleProperties props;

    public PropertiesController(DimpleProperties Dprops) {
        this.props = Dprops;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {

        if (shape instanceof DimpleCircle) {
            DimpleCircle c=(DimpleCircle)shape;
            props.setProps(c.getProps());
            props.setCurrentNode("Circle");
        } else if (shape instanceof DimpleTriangle) {
            DimpleTriangle tri=(DimpleTriangle)shape;
            props.setProps(tri.getProps());
            props.setCurrentNode("Triangle"); 
        } else if (shape instanceof DimpleArc) {
            DimpleArc ar=(DimpleArc)shape;
            props.setProps(ar.getProps());
            props.setCurrentNode("Arc");
        } else if (shape instanceof DimpleEllipse) {
            DimpleEllipse elli=(DimpleEllipse)shape;
            props.setProps(elli.getProps()); 
            props.setCurrentNode("Ellipse");
        } else if (shape instanceof DimpleLine) {
             DimpleLine line=(DimpleLine)shape;
            props.setProps(line.getProps());   
            props.setCurrentNode("Line");
        }else if(shape instanceof DimpleText) {
            DimpleText txt=(DimpleText)shape;
            props.setProps(txt.getProps()); 
            props.setCurrentNode("Text");
        }else if(shape instanceof DimplePolygon) {
            DimplePolygon polly=(DimplePolygon)shape;
            props.setProps(polly.getProps()); 
            props.setCurrentNode("Polygon");
        }else if(shape instanceof DimpleRectangle) {
            DimpleRectangle rect=(DimpleRectangle)shape;
            props.setProps(rect.getProps()); 
            props.setCurrentNode("Rectangle");
        }
        

        this.shape = shape;
    }
     
}
