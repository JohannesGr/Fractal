/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.fractaldata;

import java.math.BigDecimal;

/**
 *
 * @author Johannes
 */
abstract public class AbstractFractalContainer {
    public static final BigDecimal X_START = new BigDecimal("-2.2");
    public static final BigDecimal Y_START = new BigDecimal("-1.2");
    public static final BigDecimal X_END = new BigDecimal("0.6");
    public static final BigDecimal Y_END = new BigDecimal("1.2");
    public static final int IMAGE_X_START = 0;
    public static final int IMAGE_Y_START = 0;
    public static final int IMAGE_WIDTH = 800;
    public static final int IMAGE_HEIGHT = 800;
    
    long maxIterations = 100;
    BigDecimal borderstop = new BigDecimal("2.0");
    FractalRectangle fractalRectangle;
    ImageRectangle imageRectangle;
    
    /**
     * Creates a {@code FractalContainer} class with default Values.
     * The values for {@code FractalRectangle) are in {@code BigDecimal} precision.
     * The values for {@code ImageRectangle) are in {@code Integer} precision.
     * Fractal Defaults are: -2.2,-1.2, 0.6-(-2.2), 1.2-(-1.2)
     * Image Defaults are: 0,0,800,800
     */
    public AbstractFractalContainer() {
        fractalRectangle = new FractalRectangle(X_START, Y_START, X_END.subtract(X_START), Y_END.subtract(Y_START));
        imageRectangle = new ImageRectangle(IMAGE_X_START, IMAGE_Y_START, IMAGE_WIDTH, IMAGE_HEIGHT);
    }

    public long getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(long maxIterations) {
        this.maxIterations = maxIterations;
    }

    /**
     * Provide the factor for the width of the fractal in {@code BigDecimal} precision.
     * @return the factor in {@code BigDecimal} precision.
     */
    public BigDecimal getXStep() {
        int teiler = this.imageRectangle.width - this.imageRectangle.x;
        return fractalRectangle.width.divide(new BigDecimal(String.valueOf(teiler)));
    }

    /**
     * Provide the factor for the height of the fractal in {@code BigDecimal} precision.
     * @return the factor in {@code BigDecimal} precision.
     */    
    public BigDecimal getYStep() {
        int teiler = this.imageRectangle.height - this.imageRectangle.y;
        return fractalRectangle.height.divide(new BigDecimal(String.valueOf(teiler)));
    }
    
    public BigDecimal[] getSteps() {
        BigDecimal [] teiler = {getXStep(), getYStep()};
        return teiler;
    }
    
    /**
     * Delivers a copy of the original {@code ImageRectangle}.
     * 
     * @return the copy of the {@code ImageRectangle}
     */
    public ImageRectangle getImageRectangle() {
        return new ImageRectangle(this.imageRectangle);
    }
    /**
     * Delivers a copy of the original {@code FractalRectangle}.
     * 
     * @return the copy of the {@code FractalRectangle}
     */
    
    public FractalRectangle getFractalRectangle() {
        return new FractalRectangle(this.fractalRectangle);
    }

    public BigDecimal getBorderstop() {
        return borderstop;
    }

    public void setBorderstop(BigDecimal borderstop) {
        this.borderstop = borderstop;
    }
    
    public int getImageX() {
        return imageRectangle.getX();
    }

    public void setImageX(int x) {
        imageRectangle.setX(x);
    }

    public int getImageY() {
        return imageRectangle.getY();
    }

    public void setImageY(int y) {
        imageRectangle.setY(y);
    }

    public int getImageWidth() {
        return imageRectangle.getWidth();
    }

    public void setImageWidth(int width) {
        imageRectangle.setWidth(width);
    }

    public int getImageHeight() {
        return imageRectangle.getHeight();
    }

    public void setImageHeight(int height) {
        imageRectangle.setHeight(height);
    }

    public FractalPoint getFractalMiddlePoint() {
        return fractalRectangle.getMiddlePoint();
    }

    public BigDecimal getFractalX() {
        return fractalRectangle.getX();
    }

    public BigDecimal getFractalY() {
        return fractalRectangle.getY();
    }

    public BigDecimal getFractalWidth() {
        return fractalRectangle.getWidth();
    }

    public BigDecimal getFractalHeight() {
        return fractalRectangle.getHeight();
    }

    public FractalRectangle getFractalBounds() {
        return fractalRectangle.getBounds();
    }

    public void setFractalBounds(FractalRectangle r) {
        fractalRectangle.setBounds(r);
    }

    public void setFractalBounds(BigDecimal x, BigDecimal y, BigDecimal width, BigDecimal height) {
        fractalRectangle.setBounds(x, y, width, height);
    }

    public void setFractalRect(BigDecimal x, BigDecimal y, BigDecimal width, BigDecimal height) {
        fractalRectangle.setRect(x, y, width, height);
    }

    public FractalPoint getFractalLocation() {
        return fractalRectangle.getLocation();
    }

    public void setFractalLocation(FractalPoint p) {
        fractalRectangle.setLocation(p);
    }

    public void setFractalLocation(BigDecimal x, BigDecimal y) {
        fractalRectangle.setLocation(x, y);
    }

    public FractalDimension getFractalSize() {
        return fractalRectangle.getSize();
    }

    public void setFractalSize(FractalDimension d) {
        fractalRectangle.setSize(d);
    }

    public void setFractalSize(BigDecimal width, BigDecimal height) {
        fractalRectangle.setSize(width, height);
    }
}
