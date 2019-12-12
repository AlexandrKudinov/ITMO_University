package L7_StringBuilder;
/*
Изменить иерархию spahes (использовать абстрактные классы, где это возможно)
*/
public class Task1 {
    public static void main(String[] args) {
        Shape shape1 = new Ball(22);
        Shape shape2 = new Cylinder(33,44);
        Shape shape3 = new Pyramid(44,33);
        System.out.println(shape1.volume());
        System.out.println(shape2.volume());
        System.out.println(shape3.volume());

    }
}

abstract class Shape{
public abstract double volume();
}

abstract class SidesOfRevolution extends Shape{
    private double radius;
    public SidesOfRevolution(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }

}

class Ball extends SidesOfRevolution{
    public Ball(double radius){
        super(radius);

    }
    @Override
    public double volume (){
     return Math.PI*4/3*Math.pow(getRadius(),3);
    }
}

class Cylinder extends SidesOfRevolution{
    private double height;
    public Cylinder(double radius, double height){
        super(radius);
        this.height=height;
    }
    @Override
    public double volume(){
        return Math.PI/2*Math.pow(getRadius(),2);
    }
}

class Pyramid extends Shape{
    private double baseArea;
    private  double height;
    public Pyramid(double baseArea,double height){
       this.baseArea=baseArea;
       this.height=height;
    }
    @Override
    public double volume(){
        return baseArea*height/3;
    }
}

class Box extends Shape{
    private double boxSize;
    public Box(double boxSize){
        this.boxSize=boxSize;
    }
    public double volume(){
        return boxSize;
    }

    public boolean add(Shape shape){
        if(shape.volume()<=boxSize){
            boxSize-=shape.volume();
            System.out.println(boxSize);
            return true;
        }else {return false;}

    }
}






