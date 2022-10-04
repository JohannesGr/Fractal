/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.fractaldata;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Used for the Dimension of a Fractal in {@code BigDecimal} pecision.
 * 
 * @author Johannes
 */
public class FractalDimension {
    static final String CLASS = "FractalDimension: ";
    static final String HEIGHT_DARF_NICHT_NULL_SEIN = CLASS + "height darf nicht null sein!";
    static final String WIDTH_DARF_NICHT_NULL_SEIN = CLASS + "width darf nicht null sein!";
    static final String OTHER_DARF_NICHT_NULL_SEIN = CLASS + "other darf nicht null sein!";

    BigDecimal width;
    BigDecimal height;
    boolean changed = false;
    
    public FractalDimension(BigDecimal width, BigDecimal height) {
        Objects.requireNonNull(width, WIDTH_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(height, HEIGHT_DARF_NICHT_NULL_SEIN);
        this.width = width;
        this.height = height;
    }

    public FractalDimension(FractalDimension other) {
        Objects.requireNonNull(other, OTHER_DARF_NICHT_NULL_SEIN);
        this.width = other.width;
        this.height = other.height;
    }
    
    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        Objects.requireNonNull(width, WIDTH_DARF_NICHT_NULL_SEIN);
        if (this.width.compareTo(width) == 0) {
            return;
        }
        this.width = width;
        this.changed = true;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        Objects.requireNonNull(height, HEIGHT_DARF_NICHT_NULL_SEIN);
        if (this.height.compareTo(height) == 0) {
            return;
        }
        this.height = height;
        this.changed = true;
    }
    
    public boolean hasChanged() {
        return this.changed;
    }
    
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
