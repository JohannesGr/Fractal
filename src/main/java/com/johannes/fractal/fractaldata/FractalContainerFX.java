/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.fractaldata;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author Johannes
 */
public class FractalContainerFX extends AbstractFractalContainer {

    ObjectProperty<Canvas> imageProperty;

    public FractalContainerFX() {
        super();
        imageProperty = new SimpleObjectProperty<>(this, "imageProperty", new Canvas(super.getImageWidth(), super.getImageHeight()));
    }
    
    public ObjectProperty<Canvas> getObjectProperty() {
        return this.imageProperty;
    }
    public void setImage(Canvas image) {
        this.imageProperty.setValue(image);
    }
    public Canvas getImage() {
        return this.imageProperty.getValue();
    }
    
}
