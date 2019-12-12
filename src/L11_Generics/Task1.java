package L11_Generics;


/*
Заменить класс Shape на интерфейс Shape (или Volume ).

Shape должен наследоваться от Comparable . То есть, shapes должно быть
сравнимы по объему.
Можно воспользоваться методом Arrays.sort() , чтобы убедится, что массив фигур
сортируется верно.

*/

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Ball(33),
                new Pyramid(22,44),
                new Cylinder(33,33),
                new Ball(455),
                new Pyramid(2334,2311)};

        Arrays.sort(shapes);

        System.out.println(Arrays.toString(shapes));
    }
}

interface Shape extends Comparable <Shape> {
    double volume();
    default int compareTo(Shape o){
        Shape shape = o;
        return Double.compare(volume(),shape.volume());
    };
}

abstract class SidesOfRevolution {
    private double radius;

    public SidesOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

}

class Ball extends SidesOfRevolution implements Shape {
    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double volume() {
        return Math.PI * 4 / 3 * Math.pow(getRadius(), 3);
    }


    public String toString(){
        return "Ball's volume = "+ volume();
    }


}

class Cylinder extends SidesOfRevolution implements Shape{
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI / 2 * Math.pow(getRadius(), 2);
    }

    public String toString(){
        return "Cylinder's volume = "+ volume();
    }


}

class Pyramid implements Shape {
    private double baseArea;
    private double height;

    public Pyramid(double baseArea, double height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    @Override
    public double volume() {
        return baseArea * height / 3;
    }

    public String toString(){
        return "Pyramid volume = " + volume();
    }

}

class Box implements Shape {
    private double boxSize;

    public Box(double boxSize) {
        this.boxSize = boxSize;
    }

    public double volume() {
        return boxSize;
    }

    public boolean add(Shape shape) {
        if (shape.volume() <= boxSize) {
            boxSize -= shape.volume();
            System.out.println(boxSize);
            return true;
        } else {
            return false;
        }
    }
}
