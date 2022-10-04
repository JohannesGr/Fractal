/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.fractaldata;

/**
 *
 * @author Johannes
 */
public class ImageRectangle {
    int x;
    int y;
    int width;
    int height;
    boolean changed = false;
    
    public ImageRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public ImageRectangle(java.awt.geom.Point2D point) {
        this.x = (int) point.getX();
        this.y = (int) point.getY();
        this.width = 0;
        this.height = 0;
    }
    
    public ImageRectangle(java.awt.geom.Dimension2D dimension) {
        this.x = 0;
        this.y = 0;
        this.width = (int)dimension.getWidth();
        this.height = (int) dimension.getHeight();
    }

    public ImageRectangle(ImageRectangle other) {
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.height = other.height;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (this.x == x) {
            return;
        }
        this.x = x;
        this.changed = true;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (this.y == y) {
            return;
        }
        this.y = y;
        this.changed = true;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (this.width == width) {
            return;
        }
        this.width = width;
        this.changed = true;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (this.height == height) {
            return;
        }
        this.height = height;
        this.changed = true;
    }

    public int getX1() {
        double x1 = (double)this.x + (double)this.width;
        if (x1 < (double)Integer.MAX_VALUE) { 
            return this.x + this.width;
        }
        return 0;
    }
    public boolean isHasChanged() {
        return changed;
    }

    public void setHasChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        hash = 19 * hash + this.width;
        hash = 19 * hash + this.height;
        hash = 19 * hash + (this.changed ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImageRectangle other = (ImageRectangle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        return this.changed == other.changed;
    }

    @Override
    public String toString() {
        return "ImageRectangle{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + '}';
    }
    
}
