package Lesson6.InClass.InClass;
public class Lesson6_Task1{
    public static void main(String[] args) {
        Shape shape1 = new Cylinder();
        Shape shape2 = new Pyramid(15,34);
        System.out.println(shape1.getVolume());
        System.out.println(shape2.getVolume());
        Box box = new Box(400);
        System.out.println(box.add(shape1));
        System.out.println(box.add(shape2));
    }



}



class Shape {

    public double getVolume(){
        return 0;
    }

}

class SolidOfRevolution extends Shape {
    private double radius = 2.0;
    public double getRadius(){
        return this.radius;
    }

}


class Cylinder extends SolidOfRevolution{
    private double height=3.0;
    public double getVolume(){
        return (super.getRadius())*(super.getRadius())*Math.PI*height;
    }

}

class Ball extends SolidOfRevolution{
    public double getVolume(){
        return (super.getRadius())*(super.getRadius())*(super.getRadius())*4/3*Math.PI;
    }
}


class Pyramid extends Shape{

    private double s;
    private double h;
    public Pyramid (double s, double h){
        this.h=h;
        this.s=s;
    }

    public double getVolume(){
        return 1/3D*s*h;
    }
}

class Box extends Shape{
    double volume;
    public Box (double volume){
        this.volume=volume;
    }



    public boolean add (Shape shape){
        if(volume-shape.getVolume()>0){
            volume = volume-shape.getVolume();
            return true;
        }else return false;

    }


}