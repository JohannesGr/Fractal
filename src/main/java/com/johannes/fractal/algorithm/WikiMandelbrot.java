/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.algorithm;

import com.johannes.fractal.fractaldata.FractalContainerFX;
import java.awt.Dimension;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.DoubleProperty;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Johannes
 */
public class WikiMandelbrot {

    FractalContainerFX fractalContainer;
    
    public WikiMandelbrot(FractalContainerFX fractalContainer) {
        this.fractalContainer = Objects.requireNonNull(fractalContainer, "fractalContainer darf nicht null sein");
        Objects.requireNonNull(fractalContainer.getImage(), "image darf nicht null sein!");
    }

    public void start() throws IllegalArgumentException {
        if (fractalContainer == null) {
            throw new IllegalArgumentException(String.format("%s -> %s fractalContainer fehlt", this.getClass().toString(), "start()"));
        }
//        System.out.println("Image  : " + dimension.imageRectangle.toString());
//        System.out.println("Fractal: " + dimension.fractalRectangle.toString());
//        System.out.println("stepX: " + dimension.stepX + ", stepY: " + dimension.stepY);
//        System.out.println("maxIterations: " + dimension.getMaxIterations() + ", rand: " + dimension.borderStop);
        double stepX = fractalContainer.getXStep().doubleValue();
        double stepY = fractalContainer.getYStep().doubleValue(); //dimension.getStepY();
        double borderStop = fractalContainer.getBorderstop().doubleValue(); //dimension.getBorderStop();
        
        double x = 0;
        double y = 0;
        double x0 = fractalContainer.getFractalX().doubleValue(); //dimension.getFractalRectangle().getX();
        double y0 = fractalContainer.getFractalY().doubleValue(); //dimension.getFractalRectangle().getY();
        double x2 = 0;
        double y2 = 0;
        long iterations = 0;
        long maxIterations = fractalContainer.getMaxIterations(); //dimension.getMaxIterations();
        for (int pX = 0; pX < fractalContainer.getImageWidth(); pX++, x0 += stepX) {
            y0 = fractalContainer.getFractalY().doubleValue(); //.getFractalRectangle().getY();
            for (int pY = 0; pY < fractalContainer.getImageHeight(); pY++, y0 += stepY) {
                x2 = 0.0;
                y2 = 0.0;
                x = 0.0;
                y = 0.0;
                iterations = 0;
//                System.out.println((x2 + y2 <= dimension.borderStop) + " && " + (iterations < maxIterations));
                while (x2 + y2 <= borderStop && iterations < maxIterations) {
                    y = (x + x) * y + y0;
                    x = x2 - y2 + x0;
                    x2 = x * x;
                    y2 = y * y;
                    iterations++;
                }
                super.dimension.addIterValue(new IterValue(pX, pY, x0, y0, iterations, dimension.getMaxIterations()));
            }
        }
    }

    public void  start(DoubleProperty progressProperty, EventHandler<WorkerStateEvent> envenHandler) {
        start();
    }

    @Override
    public List<IterValue> getIterValueList() {
        return super.dimension.getIterValues();
    }

    public void setDimension(Dimension ad) {
           this.dimension = ad;
    }

}
