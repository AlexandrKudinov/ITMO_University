package L6_Inheritance.Homework;

/*
Реализовать иерархию классов.
Метод add() принимает на вход Spahe. Нужно добавлять новые фигуры до тех пор,
пока для них хватаем места в Box. Если нет, то нужно вернуть false.

 */

public class Task1 {
    public static void main(String[] args) {
        Cylinder shape1 = new Cylinder(24, 45);
        Ball shape2 = new Ball(34);
        Pyramid shape3 = new Pyramid(34578, 22);
        Box box = new Box(360000);
        System.out.println(box.add(shape1));
        System.out.println(box.add(shape2));
        System.out.println(box.add(shape3));
    }

}

class Shape {
    private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

class SolidOfRevolution extends Shape {
    private double radius;

    public SolidOfRevolution(double radius, double valume) {
        super(valume);
        this.radius = radius;
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius, Math.PI * 4 / 3 * Math.pow(radius, 3));
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius, Math.PI * Math.pow(radius, 2) * height);
        this.height = height;
    }
}

class Pyramid extends Shape {
    private double baseArea;
    private double height;

    public Pyramid(double baseArea, double height) {
        super(baseArea * height/3);
        this.height = height;
        this.baseArea = baseArea;
    }
}

class Box extends Shape {
   // private ArrayList<Shape> shapes = new ArrayList<>();
    private double boxSize;

    public Box(double boxSize) {
        super(boxSize);
        this.boxSize = boxSize;
    }

    public boolean add(Shape shape) {
        if (shape.getVolume() <= boxSize) {
           // shapes.add(shape);
            boxSize -= shape.getVolume();
            System.out.println(boxSize);
            return true;
        } else {return false;}
    }

}