package shapes;

import java.util.ArrayList;

abstract class Shape2 {
    public abstract double getVolume();
}

abstract class SolidOfRevolution2 extends Shape2 {
    protected double radius;

    public SolidOfRevolution2(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Ball2 extends SolidOfRevolution2 {
    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }

    public Ball2(double radius) {
        super(radius);
    }
}

class Cylinder2 extends SolidOfRevolution2 {
    private double height;

    public Cylinder2(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Pyramid2 extends Shape2 {
    private double height;
    private double s;

    public Pyramid2(double height, double s) {
        this.height = height;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return height * s * 4 / 3;
    }
}

class Box2 extends Shape2 {
    private ArrayList<Shape2> shape2s = new ArrayList<>();
    private double available;
    private double volume;

    public Box2(double available) {
        this.available = available;
        this.volume = available;
    }

    public boolean add(Shape2 shape2) {
        if (available >= shape2.getVolume()) {
            shape2s.add(shape2);
            available -= shape2.getVolume();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVolume() {
        return volume;
    }
}

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100, 100);
        Box box = new Box(1000);
        System.out.println(box.add(ball));//ok
        System.out.println(box.add(cylinder));//ok
        System.out.println(box.add(pyramid));//failed
    }
}