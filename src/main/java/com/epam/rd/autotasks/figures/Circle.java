package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private final Point center;

    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public String pointsToString() {
        return center.pointsToString();
    }

    @Override
    public String toString() {
        return "Circle[" + center + radius +
                ']';
    }

    @Override
    public Point leftmostPoint() {
        return new Point(this.center.getX()-radius, this.center.getY());
    }
}
