/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.johannes.fractal.fractaldata;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Used for Fractalparameters in {@code BigDecimal} precision.
 * @author Johannes
 */
public class FractalRectangle {
    static final String CLASS = "FractalRectangle: ";
    static final String HEIGHT_DARF_NICHT_NULL_SEIN = CLASS + "height darf nicht null sein!";
    static final String WIDTH_DARF_NICHT_NULL_SEIN = CLASS + "width darf nicht null sein!";
    static final String Y_DARF_NICHT_NULL_SEIN = CLASS + "y darf nicht null sein!";
    static final String X_DARF_NICHT_NULL_SEIN = CLASS + "x darf nicht null sein!";
    static final String DY_DARF_NICHT_NULL_SEIN = CLASS + "dy darf nicht null sein!";
    static final String DX_DARF_NICHT_NULL_SEIN = CLASS + "dx darf nicht null sein!";
    static final String D_DARF_NICHT_NULL_SEIN = CLASS + "d darf nicht null sein!";

    BigDecimal x;
    BigDecimal y;
    BigDecimal width;
    BigDecimal height;

    /**
     * Constructs a new {@code FractalRectangle} whose upper-left corner is at
     * (0,&nbsp;0) in the coordinate space, and whose width and height are both
     * zero.
     */
    public FractalRectangle() {
        this(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * Constructs a new {@code FractalRectangle}, initialized to match the values of
     * the specified {@code FractalRectangle}.
     *
     * @param r the {@code FractalRectangle} from which to copy initial values to a
     * newly constructed {@code FractalRectangle}
     * @since 1.1
     */
    public FractalRectangle(FractalRectangle r) {
        this(r.x, r.y, r.width, r.height);
    }

    /**
     * Constructs a new {@code FractalRectangle} whose upper-left corner is specified
     * as {@code (x,y)} and whose width and height are specified by the
     * arguments of the same name.
     *
     * @param x the specified X coordinate
     * @param y the specified Y coordinate
     * @param width the width of the {@code FractalRectangle}
     * @param height the height of the {@code FractalRectangle}
     * @since 1.0
     */
    public FractalRectangle(BigDecimal x, BigDecimal y, BigDecimal width, BigDecimal height) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(width, WIDTH_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(height, HEIGHT_DARF_NICHT_NULL_SEIN);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs a new {@code FractalRectangle} whose upper-left corner is at
     * (0,&nbsp;0) in the coordinate space, and whose width and height are
     * specified by the arguments of the same name.
     *
     * @param width the width of the {@code FractalRectangle}
     * @param height the height of the {@code FractalRectangle}
     */
    public FractalRectangle(BigDecimal width, BigDecimal height) {
        this(BigDecimal.ZERO, BigDecimal.ZERO, width, height);
    }

//    /**
//     * Constructs a new {@code FractalRectangle} whose upper-left corner is
//     * specified by the {@link Point} argument, and
//     * whose width and height are specified by the
//     * {@link Dimension} argument.
//     * @param p a {@code Point} that is the upper-left corner of
//     * the {@code FractalRectangle}
//     * @param d a {@code Dimension}, representing the
//     * width and height of the {@code FractalRectangle}
//     */
    public FractalRectangle(FractalPoint point, FractalDimension dimension) {
        this(point.x, point.y, dimension.width, dimension.height);
    }
    /**
     * Constructs a new {@code FractalRectangle} whose upper-left corner is the
     * specified {@code Point}, and whose width and height are both zero.
     *
     * @param point a {@code Point} that is the top left corner of the
     * {@code FractalRectangle}
     */
    public FractalRectangle(FractalPoint point) {
        this(point.x, point.y, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * Returns the middle point of a {@FractalRectangle}
     * in {@code BigDecimal} precision.
     * 
     * @return the middle point of the {@FractalRectangle}
     */
    public FractalPoint getMiddlePoint() {
        BigDecimal halfWidth = this.width.divide(new BigDecimal("2.0"));
        BigDecimal halfHeight = this.height.divide(new BigDecimal("2.0"));
        return new FractalPoint(this.x.add(halfWidth), this.y.add(halfHeight));        
    }

    /**
     * Returns the X coordinate of the bounding {@code FractalRectangle} in
     * {@code double} precision.
     *
     * @return the X coordinate of the bounding {@code FractalRectangle}.
     */
    public BigDecimal getX() {
        return x;
    }

    /**
     * Returns the Y coordinate of the bounding {@code FractalRectangle} in
     * {@code double} precision.
     *
     * @return the Y coordinate of the bounding {@code FractalRectangle}.
     */
    public BigDecimal getY() {
        return y;
    }

    /**
     * Returns the width of the bounding {@code FractalRectangle} in {@code double}
     * precision.
     *
     * @return the width of the bounding {@code FractalRectangle}.
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Returns the height of the bounding {@code FractalRectangle} in {@code double}
     * precision.
     *
     * @return the height of the bounding {@code FractalRectangle}.
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Gets the bounding {@code FractalRectangle} of this {@code FractalRectangle}.
     * <p>
     * This method is included for completeness, to parallel the
     * {@code getBounds} method of {@link Component}.
     *
     * @return a new {@code FractalRectangle}, equal to the bounding {@code FractalRectangle}
     * for this {@code FractalRectangle}.
     * @see java.awt.Component#getBounds
     * @see #setBounds(Rectangle)
     * @see #setBounds(int, int, int, int)
     * @since 1.1
     */
//    @Transient
    public FractalRectangle getBounds() {
        return new FractalRectangle(x, y, width, height);
    }

    /**
     * Sets the bounding {@code FractalRectangle} of this {@code FractalRectangle} to match
     * the specified {@code FractalRectangle}.
     * <p>
     * This method is included for completeness, to parallel the
     * {@code setBounds} method of {@code Component}.
     *
     * @param r the specified {@code FractalRectangle}
     * @see #getBounds
     * @see java.awt.Component#setBounds(java.awt.Rectangle)
     * @since 1.1
     */
    public void setBounds(FractalRectangle r) {
        Objects.requireNonNull(r, "r darf nicht null sein!");
        setBounds(r.x, r.y, r.width, r.height);
    }

    /**
     * Sets the bounding {@code FractalRectangle} of this {@code FractalRectangle} to the
     * specified {@code x}, {@code y}, {@code width}, and {@code height}.
     * <p>
     * This method is included for completeness, to parallel the
     * {@code setBounds} method of {@code Component}.
     *
     * @param x the new X coordinate for the upper-left corner of this
     * {@code FractalRectangle}
     * @param y the new Y coordinate for the upper-left corner of this
     * {@code FractalRectangle}
     * @param width the new width for this {@code FractalRectangle}
     * @param height the new height for this {@code FractalRectangle}
     * @see #getBounds
     * @see java.awt.Component#setBounds(int, int, int, int)
     * @since 1.1
     */
    public void setBounds(BigDecimal x, BigDecimal y, BigDecimal width, BigDecimal height) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(width, WIDTH_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(height, HEIGHT_DARF_NICHT_NULL_SEIN);

        reshape(x, y, width, height);
    }

    /**
     * Sets the bounds of this {@code FractalRectangle} to the integer bounds which
     * encompass the specified {@code x}, {@code y}, {@code width}, and
     * {@code height}. If the parameters specify a {@code FractalRectangle} that
     * exceeds the maximum range of integers, the result will be the best
     * representation of the specified {@code FractalRectangle} intersected with the
     * maximum integer bounds.
     *
     * @param x the X coordinate of the upper-left corner of the specified
     * rectangle
     * @param y the Y coordinate of the upper-left corner of the specified
     * rectangle
     * @param width the width of the specified rectangle
     * @param height the new height of the specified rectangle
     */
    public void setRect(BigDecimal x, BigDecimal y, BigDecimal width, BigDecimal height) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(width, WIDTH_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(height, HEIGHT_DARF_NICHT_NULL_SEIN);

        reshape(x, y, width, height);
    }

    /**
     * Sets the bounding {@code FractalRectangle} of this {@code FractalRectangle} to the
     * specified {@code x}, {@code y}, {@code width}, and {@code height}.
     *
     * @param x the new X coordinate for the upper-left corner of this
     * {@code FractalRectangle}
     * @param y the new Y coordinate for the upper-left corner of this
     * {@code FractalRectangle}
     * @param width the new width for this {@code FractalRectangle}
     * @param height the new height for this {@code FractalRectangle}
     * @deprecated As of JDK version 1.1, replaced by
     * {@code setBounds(int, int, int, int)}.
     */
    @Deprecated
    public void reshape(BigDecimal x, BigDecimal y, BigDecimal width, BigDecimal height) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(width, WIDTH_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(height, HEIGHT_DARF_NICHT_NULL_SEIN);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the location of this {@code FractalRectangle}.
     * <p>
     * This method is included for completeness, to parallel the
     * {@code getLocation} method of {@code Component}.
     *
     * @return the {@code Point} that is the upper-left corner of this
     * {@code FractalRectangle}.
     * @see java.awt.Component#getLocation
     * @see #setLocation(Point)
     * @see #setLocation(int, int)
     * @since 1.1
     */
    public FractalPoint getLocation() {
        return new FractalPoint(x, y);
    }

    /**
     * Moves this {@code FractalRectangle} to the specified location.
     * <p>
     * This method is included for completeness, to parallel the
     * {@code setLocation} method of {@code Component}.
     *
     * @param p the {@code Point} specifying the new location for this
     * {@code FractalRectangle}
     * @see java.awt.Component#setLocation(java.awt.Point)
     * @see #getLocation
     * @since 1.1
     */
    public void setLocation(FractalPoint p) {
        Objects.requireNonNull(p, "p darf nicht null sein!");
        setLocation(p.x, p.y);
    }

    /**
     * Moves this {@code FractalRectangle} to the specified location.
     * <p>
     * This method is included for completeness, to parallel the
     * {@code setLocation} method of {@code Component}.
     *
     * @param x the X coordinate of the new location
     * @param y the Y coordinate of the new location
     * @see #getLocation
     * @see java.awt.Component#setLocation(int, int)
     * @since 1.1
     */
    public void setLocation(BigDecimal x, BigDecimal y) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        move(x, y);
    }

    /**
     * Moves this {@code FractalRectangle} to the specified location.
     *
     * @param x the X coordinate of the new location
     * @param y the Y coordinate of the new location
     * @deprecated As of JDK version 1.1, replaced by
     * {@code setLocation(int, int)}.
     */
    @Deprecated
    public void move(BigDecimal x, BigDecimal y) {
        Objects.requireNonNull(x, X_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(y, Y_DARF_NICHT_NULL_SEIN);
        this.x = x;
        this.y = y;
    }

    /**
     * Translates this {@code FractalRectangle} the indicated distance, to the right
     * along the X coordinate axis, and downward along the Y coordinate axis.
     *
     * @param dx the distance to move this {@code FractalRectangle} along the X axis
     * @param dy the distance to move this {@code FractalRectangle} along the Y axis
     * @see java.awt.Rectangle#setLocation(int, int)
     * @see java.awt.Rectangle#setLocation(java.awt.Point)
     */
    public void translate(BigDecimal dx, BigDecimal dy) {
        Objects.requireNonNull(dx, DX_DARF_NICHT_NULL_SEIN);
        Objects.requireNonNull(dy, DY_DARF_NICHT_NULL_SEIN);
        this.x = this.x.add(dx);
        this.y = this.y.add(dy);
    }

    /**
     * Gets the size of this {@code FractalRectangle}, represented by the returned
     * {@code Dimension}.
     * <p>
     * This method is included for completeness, to parallel the {@code getSize}
     * method of {@code Component}.
     *
     * @return a {@code Dimension}, representing the size of this
     * {@code FractalRectangle}.
     * @see java.awt.Component#getSize
     * @see #setSize(Dimension)
     * @see #setSize(int, int)
     * @since 1.1
     */
    public FractalDimension getSize() {
        return new FractalDimension(width, height);
    }

    /**
     * Sets the size of this {@code FractalRectangle} to match the specified
     * {@code Dimension}.
     * <p>
     * This method is included for completeness, to parallel the {@code setSize}
     * method of {@code Component}.
     *
     * @param d the new size for the {@code Dimension} object
     * @see java.awt.Component#setSize(java.awt.Dimension)
     * @see #getSize
     * @since 1.1
     */
    public void setSize(FractalDimension d) {
        Objects.requireNonNull(d, D_DARF_NICHT_NULL_SEIN);
        setSize(d.width, d.height);
    }

    /**
     * Sets the size of this {@code FractalRectangle} to the specified width and
     * height.
     * <p>
     * This method is included for completeness, to parallel the {@code setSize}
     * method of {@code Component}.
     *
     * @param width the new width for this {@code FractalRectangle}
     * @param height the new height for this {@code FractalRectangle}
     * @see java.awt.Component#setSize(int, int)
     * @see #getSize
     * @since 1.1
     */
    public void setSize(BigDecimal width, BigDecimal height) {
        resize(width, height);
    }

    /**
     * Sets the size of this {@code FractalRectangle} to the specified width and
     * height.
     *
     * @param width the new width for this {@code FractalRectangle}
     * @param height the new height for this {@code FractalRectangle}
     * @deprecated As of JDK version 1.1, replaced by {@code setSize(int, int)}.
     */
    @Deprecated
    public void resize(BigDecimal width, BigDecimal height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Checks whether or not this {@code FractalRectangle} contains the specified
     * {@code Point}.
     *
     * @param p the {@code Point} to test
     * @return {@code true} if the specified {@code Point} is inside this
     * {@code FractalRectangle}; {@code false} otherwise.
     * @since 1.1
     */
    public boolean contains(FractalPoint p) {
        return contains(p.x, p.y);
    }

    /**
     * Checks whether or not this {@code FractalRectangle} contains the point at the
     * specified location {@code (x,y)}.
     *
     * @param x the specified X coordinate
     * @param y the specified Y coordinate
     * @return {@code true} if the point {@code (x,y)} is inside this
     * {@code FractalRectangle}; {@code false} otherwise.
     * @since 1.1
     */
    public boolean contains(BigDecimal x, BigDecimal y) {
        return inside(x, y);
    }

    /**
     * Checks whether or not this {@code FractalRectangle} entirely contains the
     * specified {@code FractalRectangle}.
     *
     * @param r the specified {@code FractalRectangle}
     * @return {@code true} if the {@code FractalRectangle} is contained entirely
     * inside this {@code FractalRectangle}; {@code false} otherwise
     * @since 1.2
     */
    public boolean contains(FractalRectangle r) {
        return contains(r.x, r.y, r.width, r.height);
    }

    /**
     * Checks whether this {@code FractalRectangle} entirely contains the
     * {@code FractalRectangle} at the specified location {@code (X,Y)} with the
     * specified dimensions {@code (W,H)}.
     *
     * @param X the specified X coordinate
     * @param Y the specified Y coordinate
     * @param W the width of the {@code FractalRectangle}
     * @param H the height of the {@code FractalRectangle}
     * @return {@code true} if the {@code FractalRectangle} specified by
     * {@code (X, Y, W, H)} is entirely enclosed inside this {@code FractalRectangle};
     * {@code false} otherwise.
     * @since 1.1
     */
    public boolean contains(BigDecimal X, BigDecimal Y, BigDecimal W, BigDecimal H) {
        BigDecimal w = this.width;
        BigDecimal h = this.height;
        if (w.compareTo(BigDecimal.ZERO) < 0
                || h.compareTo(BigDecimal.ZERO) < 0
                || W.compareTo(BigDecimal.ZERO) < 0
                || H.compareTo(BigDecimal.ZERO) < 0) {
//        if ((w | h | W | H) < 0) {
            // At least one of the dimensions is negative...
            return false;
        }
        // Note: if any dimension is zero, tests below must return false...
        BigDecimal cx = this.x;
        BigDecimal cy = this.y;
        if (X.compareTo(cx) < 0 || Y.compareTo(cy) < 0) {
//        if (X < x || Y < y) {
            return false;
        }
        w = w.add(cx); // += x;
        W = W.add(cx);
//        W += X;
        if (W.compareTo(cx) <= 0) {
//        if (W <= X) {
            // X+W overflowed or W was zero, return false if...
            // either original w or W was zero or
            // x+w did not overflow or
            // the overflowed x+w is smaller than the overflowed X+W
            if (w.compareTo(cx) >= 0 || W.compareTo(cx) > 0) {
//            if (w >= x || W > w) return false;
                return false;
            }
        } else {
            // X+W did not overflow and W was not zero, return false if...
            // original w was zero or
            // x+w did not overflow and x+w is smaller than X+W
            if (w.compareTo(cx) >= 0 && W.compareTo(w) > 0) {
                return false;
            }
//            if (w >= x && W > w) return false;
        }
        h = h.add(cy);
//        h += y;
        H = H.add(Y);
//        H += Y;
        if (H.compareTo(cy) <= 0) {
//        if (H <= Y) {
            if (h.compareTo(cy) <= 0 || H.compareTo(h) > 0) {
                return false;
            }
//            if (h >= y || H > h) return false;
        } else {
            if (h.compareTo(cy) >= 0 && H.compareTo(h) > 0) {
                return false;
            }
//            if (h >= y && H > h) return false;
        }
        return true;
    }

    /**
     * Checks whether or not this {@code FractalRectangle} contains the point at the
     * specified location {@code (X,Y)}.
     *
     * @param X the specified X coordinate
     * @param Y the specified Y coordinate
     * @return {@code true} if the point {@code (X,Y)} is inside this
     * {@code FractalRectangle}; {@code false} otherwise.
     * @deprecated As of JDK version 1.1, replaced by
     * {@code contains(int, int)}.
     */
    @Deprecated
    public boolean inside(BigDecimal X, BigDecimal Y) {
        BigDecimal w = this.width;
        BigDecimal h = this.height;
        if (w.compareTo(BigDecimal.ZERO) < 0
                || h.compareTo(BigDecimal.ZERO) < 0) {
////        if ((w | h) < 0) {
            // At least one of the dimensions is negative...
            return false;
        }
        // Note: if either dimension is zero, tests below must return false...
        BigDecimal x = this.x;
        BigDecimal y = this.y;
        if (X.compareTo(x) < 0 || Y.compareTo(y) < 0) {
//        if (X < x || Y < y) {
            return false;
        }
        w = w.add(x);
//        w += x;
        h = h.add(y);
//        h += y;
        //    overflow || intersect
//        return ((w < x || w > X) &&
//                (h < y || h > Y));
        return (((w.compareTo(x) < 0 || w.compareTo(X) > 0))
                && ((h.compareTo(y) < 0 || h.compareTo(Y) > 0)));
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.2
     */
    public boolean isEmpty() {
        return (width.compareTo(BigDecimal.ZERO) <= 0) || (height.compareTo(BigDecimal.ZERO) <= 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.x);
        hash = 17 * hash + Objects.hashCode(this.y);
        hash = 17 * hash + Objects.hashCode(this.width);
        hash = 17 * hash + Objects.hashCode(this.height);
        return hash;
    }

    /**
     * Checks whether two rectangles are equal.
     * <p>
     * The result is {@code true} if and only if the argument is not
     * {@code null} and is a {@code FractalRectangle} object that has the same
     * upper-left corner, width, and height as this {@code FractalRectangle}.
     *
     * @param obj the {@code Object} to compare with this {@code FractalRectangle}
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FractalRectangle) {
            FractalRectangle r = (FractalRectangle) obj;
            return ((x.compareTo(r.x) == 0)
                    && (y.compareTo(r.y) == 0)
                    && (width.compareTo(r.width) == 0)
                    && (height.compareTo(r.height) == 0));
//            return ((x == r.x) &&
//                    (y == r.y) &&
//                    (width == r.width) &&
//                    (height == r.height));
        }
        return false;
    }

    /**
     * Returns a {@code String} representing this {@code FractalRectangle} and its
     * values.
     *
     * @return a {@code String} representing this {@code FractalRectangle} object's
     * coordinate and size values.
     */
    @Override
    public String toString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
    }
}
