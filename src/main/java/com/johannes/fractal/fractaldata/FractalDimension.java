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
public class FractalDimension {
    BigDecimal width;
    BigDecimal height;
    
    public FractalDimension(BigDecimal width, BigDecimal height) {
        this.width = width;
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }
}
