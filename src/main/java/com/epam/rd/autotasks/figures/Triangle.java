package com.epam.rd.autotasks.figures;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Triangle extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double segmentLengthWithHypot(Point one, Point two){
        double x1 = one.getX();
        double y1 = one.getY();
        double x2 = two.getX();
        double y2 = two.getY();

        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);

        return Math.hypot(ac, cb);
    }

    @Override
    public double area() {
        double sideOne = segmentLengthWithHypot(a,b);
        double sideTwo = segmentLengthWithHypot(a,c);
        double sideThree = segmentLengthWithHypot(b,c);

        double p = (sideOne+sideTwo+sideThree)/2;

        return Math.sqrt(p*(p-sideOne)*(p-sideTwo)*(p-sideThree));
    }

    @Override
    public String pointsToString() {
        return a.toString()+b.toString()+c.toString();
    }

    @Override
    public Point leftmostPoint() {
        return Stream.of(a,b,c)
                .sorted(Comparator.comparingDouble(Point::getX))
                .limit(1)
                .findAny()
                .orElseThrow(AssertionError::new);
    }

   // Comparator<Point> byLeftmostXAxis = Comparator.comparing(Point::getX);
}
