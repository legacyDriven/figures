package com.epam.rd.autotasks.figures;

import java.util.Comparator;
import java.util.stream.Stream;

class Quadrilateral extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return new Triangle(a,b,c).area() + new Triangle(a,c,d).area();
    }

    @Override
    public String pointsToString() {
        return String.join("",a.toString(),b.toString(),c.toString(),d.toString());
    }

    @Override
    public Point leftmostPoint() {
        return Stream.of(a,b,c,d)
                .sorted(Comparator.comparingDouble(Point::getX))
                .limit(1)
                .findAny()
                .orElseThrow(AssertionError::new);
    }
}
