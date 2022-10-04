package shapes;

import java.util.ArrayList;

public class Shape1 {
    private double volume;

    public Shape1(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

class SolidOfRevolution extends Shape1 {
    private double radius;

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(Math.PI * Math.pow(radius, 3) * 4 / 3, radius);
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height) {
        super(Math.PI * radius * radius * height, height);
        this.height = height;
    }
}

class Pyramid extends Shape1 {
    private double height;
    private double s;

    public Pyramid(double height, double s) {
        super(height * s * 4 / 3);
        this.height = height;
        this.s = s;
    }
}

class Box extends Shape1 {
    private ArrayList<Shape1> shapes = new ArrayList<>();
    private double available;

    public Box(double available) {
        super(available);
        this.available = available;
    }

    public boolean add(Shape1 shape1) {
        if (available >= shape1.getVolume()) {
            shapes.add(shape1);
            available -= shape1.getVolume();
            return true;
        } else {
            return false;
        }
    }

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