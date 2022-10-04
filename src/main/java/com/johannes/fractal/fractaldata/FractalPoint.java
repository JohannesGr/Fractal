/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.fractaldata;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Used for a Point of Fractals in {@code BigDecimal} precision.
 * 
 * @author Johannes
 */
public class FractalPoint {
    static final String CLASS = "FractalPoint: ";
    static final String Y_DARF_NICHT_NULL_SEIN = CLASS + "y darf nicht null sein!";
    static final String X_DARF_NICHT_NULL_SEIN = CLASS + "x darf nicht null sein!";
    static final String OTHER_DARF_NICHT_NULL_SEIN = CLASS + "other darf nicht null sein!";

    BigDecimal x;
    BigDecimal y;
    boolean changed = false;
    
    public FractalPoint(BigDecimal x, BigDecimal y) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        this.x = x;
        this.y = y;
    }

    public FractalPoint(FractalPoint other) {
        Objects.requireNonNull(other, OTHER_DARF_NICHT_NULL_SEIN);
        this.x = other.x;
        this.y = other.y;
    }
    
    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        if (this.x.compareTo(x) == 0) {
            return;
        }
        this.x = x;
        changed = true;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        if (this.y.compareTo(y) == 0) {
            return;
        }
        this.y = y;
        changed = true;
    }
    
    public boolean hasChanged() {
        return this.changed;
    }
    
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
