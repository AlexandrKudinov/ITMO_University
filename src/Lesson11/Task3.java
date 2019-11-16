package Lesson11;

public class Task3 {
    public static void main(String[] args) {
        Shape[] shapes = {new Cylinder(33, 44), new Ball(44), new Pyramid(33, 44)};
        Space space = new Space(shapes);
        System.out.println(space.getTotalVolume());
    }
}

class Space<T extends Shape> {
    private T[] shapes;

    public Space(T[] shapes) {
        this.shapes = shapes;
    }

    public double getTotalVolume() {
        double totalVolume = 0;
        for (Shape shape : shapes) {
            totalVolume += shape.volume();
        }
        return totalVolume;
    }
}